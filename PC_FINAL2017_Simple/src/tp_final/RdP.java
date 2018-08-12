package tp_final;

import java.util.*;
import java.io.*;

public class RdP 
{
	private static int fila;
	private static int columna;
	int[] multp;
	private int[][] I;
    private int[][] H;
	private int[] vectorDeEstado;
	private int[] transicionesSesibilizadas;
	private String[] Plazas = {"P0","P1","P2","P3","P4","P5","P6","P7","P8","P9",
							   "P10","P11","P12","P13","P14","P15","P16"};
	private String[] Transiciones = {"T0","T1","T2","T3","T4","T5","T6","T7","T8","T9",
									 "T10","T11","T12"};
	private Test test;
	private VentanaDeTiempo vdt;
	private long[] alfa = {0,0,0,0,0,0,0,0,0,0,0,0,0};
	private long[] beta = {0,0,0,0,0,0,0,0,0,0,0,0,0};
	private long[] marcaDeTiempo = {0,0,0,0,0,0,0,0,0,System.currentTimeMillis(),0,0,System.currentTimeMillis()};
	private boolean inhibida = false;
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
	
	public RdP() throws FileNotFoundException
	{
		// Importamos la matriz de Ifile y el vector de marcado incial de sus respectivos archivos.
		Scanner Ifile = new Scanner (new File("C:/Users/Danilo/Workspace/PC_FINAL2017_Simple/src/tp_final/I"));
		Scanner Hfile = new Scanner (new File("C:/Users/Danilo/Workspace/PC_FINAL2017_Simple/src/tp_final/H"));
	    Scanner m0file = new Scanner (new File("C:/Users/Danilo/Workspace/PC_FINAL2017_Simple/src/tp_final/m0"));
	    Scanner t0file = new Scanner(new File("C:/Users/Danilo/Workspace/PC_FINAL2017_Simple/src/tp_final/Tsens"));
	    
	    //Extramos los primeros dos valores de la matriz de Ifile que son el nuermo de filas y el numero de columnas respectivamente.
	    fila=Ifile.nextInt();
        columna=Ifile.nextInt();    
        multp = new int[fila];
        
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
	
	public synchronized boolean disparar(int[] disparo)
	{
		this.posible = true;
		this.inhibida = false;
		int suma = 0;
		int idShot = 0;
		
		
		for (int i = 0; i<fila; ++i)
	    {
	    	this.multp[i]=0;
	    }
		
		for(int i=0; i<disparo.length; i++)
		{
			if(disparo[i]==1)
			{
				idShot = i;
				break;
			}
		}
		
		//*************************************************************************************
		//Pruebo si la transicion contenida en el vector disparo, que es pasado como paramentro,
		//esta inhibida.
	    inhibida = estaInhibida(idShot);
	    
	    //Si esta inhibida el disparo no es posible. Se retorna false.
	    if(inhibida)
	    {
	    	return false;
	    }		
		
		if(beta[idShot] == -1)
		{
			esTemporal = false;
		}
		else
		{
			esTemporal = true;
			//Si es temporal, como sabemos que al sensibilizarce se empezo a contar un tiempo,
			//se marca el tiempo en que llego el hilo y luego se hace una diferencia con el tiempo anterior. 
			//Esto se hace con el fin de probar que el tiempo resultado caiga dentro de la ventana de tiempo.
			System.out.println("TIEMPO DE CONTEO: " + marcaDeTiempo[idShot] + "\n");
			System.out.println("NUEVA MARCA: " + System.currentTimeMillis() + "\n");
			llegadaTime(idShot);
			System.out.println("Marca de tiempo: " + marcaDeTiempo[idShot] + "\n");
		}
		
		estaSensibilizada(suma, disparo);
		
		//Si el disparo es posible.
		if(posible)
		{
			//Se verifica si la transicion temporal se sensibilizo dentro del rango del tiempo.
			if(esTemporal)
			{
				aTiempo = vdt.testVentanaTiempo(marcaDeTiempo[idShot], idShot);
				while(aTiempo == false)
				{
					try 
					{
						System.out.println("TIENE QUE DORMIR: " + (alfa[idShot]-marcaDeTiempo[idShot]) + "\n");
						Thread.sleep((alfa[idShot]-marcaDeTiempo[idShot]));
					} 
					catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
					marcaDeTiempo[idShot] += (alfa[idShot]-marcaDeTiempo[idShot]);
					System.out.println("Marca de tiempo luego de dormir: " + marcaDeTiempo[idShot] + "\n");
					System.out.println("Afa: " + alfa[idShot] + "\n");
					aTiempo = vdt.testVentanaTiempo(marcaDeTiempo[idShot], idShot);
					System.out.println("testVDT: " + aTiempo + "\n");
				}
			}

			datosUpdate();
			
			//Se realiza el test de invariantes de plazas.
			test.testIDP(vectorDeEstado);

			return true;
		}
		else 
		{
			return false;
		}
	}

	public synchronized boolean estaInhibida(int test)
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

	public synchronized void llegadaTime(int idShot)
	{
		marcaDeTiempo[idShot] = System.currentTimeMillis() - marcaDeTiempo[idShot];
	}
	
	public synchronized void estaSensibilizada(int suma, int[] disparo)
	{
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
			this.multp[i] = suma;
			suma=0;
		}
		
		//Verificamos si es posible el disparo.
		for(int i=0; i<fila; i++)
		{
			// Si algun elemento de la suma entre el marcado y la multp es -1, el disparo no es posible.
			if(this.vectorDeEstado[i] + this.multp[i] == -1)
			{
				this.posible = false;
			}
		}
	}
	
	public synchronized void datosUpdate()
	{
		//Se actualiza el marcado.
		for(int i=0; i<fila; i++)
		{
			this.vectorDeEstado[i] = this.vectorDeEstado[i] + this.multp[i];
		}
		
		//Se actualiza el vector de transiciones.
		for(int j=0; j<columna; j++)
		{
			for(int i=0; i<fila; i++)
			{
				if(I[i][j]==-1)
				{
					this.transicionesSesibilizadas[j] = 1;
					
					if(this.vectorDeEstado[i]==0) //Si una plaza no tiene un token entonces no esta sensibilizada
					{
						this.transicionesSesibilizadas[j] = 0;
						break;
					}
				}
			}
		}
		
		//Se fija que las nuevas transiciones sensibilizadas no esten inhibidas.
		for(int q=0; q<transicionesSesibilizadas.length; q++)
		{
			if(transicionesSesibilizadas[q] == 1)
			{
				if(estaInhibida(q))
				{
					this.transicionesSesibilizadas[q] = 0;
				}
			}
		}
		
		//Seteamos nuevas marcas de tiempos para transiciones temporales sensibilizadas.
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
	}
	
	public synchronized void MostrarVectores()
	{
		System.out.println("VECTOR DE ESTADO:");
		
		for(int i=0; i<Plazas.length; i++)
		{
			System.out.print(Plazas[i]+"   ");
		}
		System.out.println("");
		
		for(int i=0; i<vectorDeEstado.length; i++)
		{
			System.out.print(" "+vectorDeEstado[i]+"   ");
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
		
		vector1+="VECTOR DE ESTADO: \n";
		
		for(int i=0; i<Plazas.length; i++)
		{
			vector1+= Plazas[i]+":"+vectorDeEstado[i]+" - ";
		}
		vector1+="\n";
		
		return vector1;
	}
	
	public synchronized String MostrarVs()
	{
		vector2 = "";
		vector3 = "";
		
		vector2+="VECTOR DE TRANSICIONES SENSIBILIZADAS: \n";
		
		for(int i=0; i<Transiciones.length; i++)
		{
			vector2+=Transiciones[i]+"  ";
		}
		vector2+="\n";
		
		for(int i=0; i<transicionesSesibilizadas.length; i++)
		{
			vector3+= transicionesSesibilizadas[i]+"   ";
		}
		vector2+= vector3 +="\n";
		vector2 += "------------------------ \n";

	return vector2;
	}
}
