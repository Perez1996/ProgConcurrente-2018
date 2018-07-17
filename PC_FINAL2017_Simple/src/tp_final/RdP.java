package tp_final;

import java.util.*;
import java.io.*;

public class RdP 
{
	private static int fila;
	private static int columna;
	private int[][] I;
    private int[][] H;
	private int[] vectorDeEstado;
	private int[] transicionesSesibilizadas;
	private String[] Plazas = {"P0","P1","P2","P3","P4","P5","P6","P7","P8","P9",
							   "P10","P11","P12","P13","P14","P15","P16","P17","P18"};
	private String[] Transiciones = {"T0","T1","T2","T3","T4","T5","T6","T7","T8","T9",
									 "T10","T11","T12","T13"};
	private Test test;
	private VentanaDeTiempo vdt;
	private long[] alfa = {0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private long[] beta = {0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private long[] marcaDeTiempo = {0,0,0,0,0,0,0,0,0,0,System.currentTimeMillis(),0,0,System.currentTimeMillis()};
/*
 * Transiciones temporales
 * 
 * */
	private boolean posible;
	private boolean esTemporal;
	private boolean aTiempo;
	private String vector1 = "";
	private String vector2 = "";
	private String vector3 = "";
	private String vector4 = "";
	
	public RdP() throws FileNotFoundException
	{
		// Importamos la matriz de Ifile y el vector de marcado incial de sus respectivos archivos.
		Scanner Ifile = new Scanner (new File("C:/Users/Danilo/Workspace/PC_FINAL2017_Simple/src/tp_final/I"));
		Scanner Hfile = new Scanner (new File("C:/Users/Danilo/Workspace/PC_FINAL2017_Simple/src/tp_final/I"));
	    Scanner m0file = new Scanner (new File("C:/Users/Danilo/Workspace/PC_FINAL2017_Simple/src/tp_final/m0"));
	    Scanner t0file = new Scanner(new File("C:/Users/Danilo/Workspace/PC_FINAL2017_Simple/src/tp_final/Tsens"));
	    
	    //Extramos los primeros dos valores de la matriz de Ifile que son el nuermo de filas y el numero de columnas respectivamente.
	    fila=Ifile.nextInt();
        columna=Ifile.nextInt();    
        
        //Creamo la matriz de Ifile con sus respectivas dimensiones.
        I = new int[fila][columna];
        H = new int[fila][columna];
        vectorDeEstado = new int[fila];
        transicionesSesibilizadas = new int[columna];
        test = new Test();
        
        //Cargamos la matriz de Ifile I.
	    for(int i = 0; i < fila; i++)
	    {
    	    for(int j = 0; j < columna; j++)
    	    {
    	        if(Ifile.hasNextInt())// El siguiente valor, es un entero valido?
    	        {
    	            I[i][j] = Ifile.nextInt(); //Se carga la matriz de incidenicia con los valores importados de I.txt.
    	        }
    	    }
	    }
	    
        //Cargamos la matriz de inhibicion H.
	    for(int i = 0; i < fila; i++)
	    {
    	    for(int j = 0; j < columna; j++)
    	    {
    	        if(Hfile.hasNextInt())// El siguiente valor, es un entero valido?
    	        {
    	            H[i][j] = Hfile.nextInt(); //Se carga la matriz de incidenicia con los valores importados de I.txt.
    	        }
    	    }
	    }
	    
	    //Cargamos el vector de marcado inicial.
	    for(int i=0; i<fila; i++)
	    {
	    	if(m0file.hasNextInt())
	    	{
	    		vectorDeEstado[i] = m0file.nextInt();
	    	}
	    }
	    
	    //Cargamos el vector de transiciones sensibilizadas inicial.
	    for(int j=0; j<columna; j++)
	    {
	    	if(t0file.hasNextInt())
	    	{
	    		transicionesSesibilizadas[j] = t0file.nextInt();
	    	}
	    }
	    	    
	    //Cerramos los scanners.
	    Ifile.close();
	    Hfile.close();
	    m0file.close();
	    t0file.close();
	    
	    vdt = new VentanaDeTiempo();
	    alfa = vdt.VectorAlfa();
	    beta = vdt.VectorBeta();
	    
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
		int posicionDeDisparo = 0;
		posible = true;
		int suma = 0;
		int multiplicacion[] = new int [fila]; // getFila() = 7
		
		for(int i=0; i<disparo.length; i++)
		{
			if(disparo[i]==1)
			{
				posicionDeDisparo = i;
				break;
			}
		}
		
		if(beta[posicionDeDisparo] == -1)
		{
			esTemporal = false;
		}
		else
		{
			esTemporal = true;
			//Si es temporal, como sabemos que al sensibilizarce se empezo a contar un tiempo,
			//se marca el tiempo en que llego el hilo y luego se hace una diferencia con el tiempo anterior. 
			//Esto se hace con el fin de probar que el tiempo resultado caiga dentro de la ventana de tiempo.
			System.out.println("TIEMPO DE CONTEO: " + marcaDeTiempo[posicionDeDisparo] + "\n");
			System.out.println("NUEVA MARCA: " + System.currentTimeMillis() + "\n");
			marcaDeTiempo[posicionDeDisparo] = System.currentTimeMillis() - marcaDeTiempo[posicionDeDisparo];
			System.out.println("Marca de tiempo: " + marcaDeTiempo[posicionDeDisparo] + "\n");
		}
		
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
			if(esTemporal)
			{
				aTiempo = vdt.testVentanaTiempo(marcaDeTiempo[posicionDeDisparo], posicionDeDisparo);
				while(aTiempo == false)
				{
					try 
					{
						System.out.println("TIENE QUE DORMIR: " + (alfa[posicionDeDisparo]-marcaDeTiempo[posicionDeDisparo]) + "\n");
						Thread.sleep((alfa[posicionDeDisparo]-marcaDeTiempo[posicionDeDisparo]));
					} 
					catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
					marcaDeTiempo[posicionDeDisparo] += (alfa[posicionDeDisparo]-marcaDeTiempo[posicionDeDisparo]);
					System.out.println("Marca de tiempo luego de dormir: " + marcaDeTiempo[posicionDeDisparo] + "\n");
					System.out.println("Afa: " + alfa[posicionDeDisparo] + "\n");
					aTiempo = vdt.testVentanaTiempo(marcaDeTiempo[posicionDeDisparo], posicionDeDisparo);
					System.out.println("testVDT: " + aTiempo + "\n");
				}
			}
			//Se actualiza el marcado.
			for(int i=0; i<fila; i++)
			{
				this.vectorDeEstado[i] = this.vectorDeEstado[i] + multiplicacion[i];
			}
			test.testIDP(vectorDeEstado);
			
			boolean aux = false;
			for(int j=0; j<columna; j++)
			{
				for(int i=0; i<fila; i++)
				{
					if(I[i][j]==-1)
					{
						this.transicionesSesibilizadas[j] = 1;
						aux =  verSiEstaInhibida(j);
						if(this.vectorDeEstado[i]==0 || aux == true)
						{
							this.transicionesSesibilizadas[j] = 0;
							break;
						}
					}
				}
			}
			
			for(int c = 0; c<transicionesSesibilizadas.length;c++)
			{
				if(transicionesSesibilizadas[c] == 1) //Si esta sensibilizada
				{
					if(beta[c] != -1)// Si es temporal.
					{
						marcaDeTiempo[c] = vdt.setNuevoTimeStamp(); //Establece una marca de tiempo.
						System.out.println("INICIO DE CONTEO: " + marcaDeTiempo[c] +"\n");
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

	public synchronized boolean verSiEstaInhibida(int test)
	{
	    boolean valorRetornado = false;
	    for (int p=0; p<fila; p++) //Recorre las Filas(Plazas)
	    {
	        for (int t=0; t<columna; t++) //Recorre las Columnas(Transiciones)
	        {
	        	if(H[p][t] == 1)
	        	{
	        		if(this.vectorDeEstado[p] >= 1 && test == t)
	        		{
	        			valorRetornado = true;
	        			break;
	        		}
	        	}
	        }
	        if(valorRetornado)
	        {
	        	break;
	        }
	    }
		return valorRetornado;
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
