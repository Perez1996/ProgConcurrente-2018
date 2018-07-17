package clases;

import java.util.*;
import java.io.*;

public class RdP 
{
	private static int fila;
	private static int columna;
	private int[][] I;
	private int[] vectorDeEstado;
	private int[] transicionesSesibilizadas;
	private String[] Plazas = {"P0","P1","P2","P3","Mx","Bf","Lm"};
	private String[] Transiciones = {"T0","T1","T2","T3"};
	private Test test;
	
	private boolean posible;
	private String vector1 = "";
	private String vector2 = "";
	private String vector3 = "";
	private String vector4 = "";
	
	public RdP() throws FileNotFoundException
	{
		// Importamos la matriz de incidencia y el vector de marcado incial de sus respectivos archivos.
		Scanner incidencia = new Scanner (new File("C:/Users/Danilo/Workspace/Productor_Consumidor/src/I.txt"));
	    Scanner marcado = new Scanner (new File("C:/Users/Danilo/Workspace/Productor_Consumidor/src/m0.txt"));
	    Scanner sensibilizadas = new Scanner(new File("C:/Users/Danilo/Workspace/Productor_Consumidor/src/t0.txt"));
	    
	    //Extramos los primeros dos valores de la matriz de incidencia que son el nuermo de filas y el numero de columnas respectivamente.
	    fila=incidencia.nextInt();
        columna=incidencia.nextInt();    
        
        //Creamo la matriz de incidencia con sus respectivas dimensiones.
        I = new int[fila][columna];
        vectorDeEstado = new int[fila];
        transicionesSesibilizadas = new int[columna];
        test = new Test();
        
        //Cargamos la matriz de incidencia I.
	    for(int i = 0; i < fila; i++)
	    {
    	    for(int j = 0; j < columna; j++)
    	    {
    	        if(incidencia.hasNextInt())// El siguiente valor, es un entero valido?
    	        {
    	            I[i][j] = incidencia.nextInt(); //Se carga la matriz de incidenicia con los valores importados de I.txt.
    	        }
    	    }
	    }
	    
	    for(int i=0; i<fila; i++)
	    {
	    	if(marcado.hasNextInt())
	    	{
	    		vectorDeEstado[i] = marcado.nextInt();
	    	}
	    }
	    
	    for(int j=0; j<columna; j++)
	    {
	    	if(sensibilizadas.hasNextInt())
	    	{
	    		transicionesSesibilizadas[j] = sensibilizadas.nextInt();
	    	}
	    }
	    	    
	    //Cerramos los scanners.
	    incidencia.close();
	    marcado.close();
	    sensibilizadas.close();
	    
        posible = true;
	}
	
	//Devuelve la dimension de la Fila de la matriz I.
	public static int getFila()
	{
		return fila;
	}
	
	//Devuelve la dimension de la Columna de la matriz I.
	public static int getColumna()
	{
		return columna;
	}
	
	public synchronized int[] sensibilizadas()
	{
		return transicionesSesibilizadas;
	}
	
	public synchronized int[] getVectorDeEstado()
	{
		return vectorDeEstado;
	}
	
	synchronized public boolean disparar(int[] disparo)
	{
		posible = true;
		int suma = 0;
		int multiplicacion[] = new int [fila]; // getFila() = 7
		
		//Multiplicamos la matriz por el vector de disparo.
		for(int i=0; i<fila; i++)// 7
		{
			for(int k=0;k<columna; k++)// 4
			{
				suma = suma + (I[i][k] * disparo[k]);
				//System.out.println("I"+"["+i+"]"+"["+k+"]: "+I[i][k]);
				//System.out.println("disparo"+"["+k+"]: "+disparo[k]);
				//System.out.println("suma: " + suma);
			}
			multiplicacion[i] = suma;
			suma=0;
		}
		
		//Verificamos si es posible el disparo.
		for(int i=0; i<fila; i++)
		{
			// Si algun elemento de la suma entre el marcado y la multiplicacion es -1, el disparo no es posible.
			if(this.vectorDeEstado[i] + multiplicacion[i] == -1)
			{
				this.posible = false;
			}
		}
		
		//Si el disparo es posible.
		if(posible)
		{
			//Se actualiza el marcado.
			for(int i=0; i<fila; i++)
			{
				this.vectorDeEstado[i] = this.vectorDeEstado[i] + multiplicacion[i];
			}
			test.testIDP(vectorDeEstado);
			//Se llena un vector con todas las transiciones sensibilizadas.
			for(int j=0; j<columna; j++)
			{
				for(int i=0; i<fila; i++)
				{
					if(I[i][j]==-1)
					{
						this.transicionesSesibilizadas[j] = 1;

						if(this.vectorDeEstado[i]==0)
						{
							this.transicionesSesibilizadas[j] = 0;
							break;
						}
					}
				}
			}
			
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public synchronized void MostrarVectores()
	{
		System.out.println("VECTOR DE ESTADO:");
		
		for(int i=0; i<Plazas.length; i++)
		{
			System.out.print(Plazas[i]+"  ");
		}
		System.out.println("");
		
		for(int i=0; i<vectorDeEstado.length; i++)
		{
			System.out.print(" "+vectorDeEstado[i]+"  ");
		}
		System.out.println("");
		
		System.out.println("VECTOR DE TRANSICIONES SENSIBILIZADAS:");
		
		for(int i=0; i<Transiciones.length; i++)
		{
			System.out.print(Transiciones[i]+" ");
		}
		System.out.println("");
		
		for(int i=0; i<transicionesSesibilizadas.length; i++)
		{
			System.out.print(" "+transicionesSesibilizadas[i]+" ");
		}
		System.out.println("");
	}
	
	public synchronized String MostrarVe()
	{
		vector1 = "";
		vector2 = "";
		
		vector1+="VECTOR DE ESTADO: \n";
		
		for(int i=0; i<Plazas.length; i++)
		{
			vector1+= Plazas[i]+"  ";
		}
		vector1+="\n";
	 

		for(int i=0; i<vectorDeEstado.length; i++)
		{
			vector2+= vectorDeEstado[i]+"   ";
		}
		vector1 += vector2 += "\n";
		vector1 += "------------------------ \n";
		return vector1 ;
	}
	
	public synchronized String MostrarVs()
	{
		vector3 = "";
		vector4 = "";
		
		vector3+="VECTOR DE TRANSICIONES SENSIBILIZADAS: \n";
		
		for(int i=0; i<Transiciones.length; i++)
		{
			vector3+=Transiciones[i]+"  ";
		}
		vector3+="\n";
		
		for(int i=0; i<transicionesSesibilizadas.length; i++)
		{
			vector4+= transicionesSesibilizadas[i]+"   ";
		}
		vector3+= vector4 +="\n";
		vector3 += "------------------------ \n";

	return vector3;
	
	}
}
