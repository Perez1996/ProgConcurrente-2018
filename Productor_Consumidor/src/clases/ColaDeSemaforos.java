
package clases;

import java.util.concurrent.Semaphore;

public class ColaDeSemaforos 
{
	private String[] T = {"T0","T1","T2","T3"},
					 vecName = {"","","",""};	
	private Semaphore[] colaDeSemaforos;
	private int[] Vc, colaDeTransiciones;
	private String vector1 = "",
				   vector2 = "";
	
	public ColaDeSemaforos(int numeroDeTransiciones)
	{
		colaDeSemaforos = new Semaphore[numeroDeTransiciones];
		Vc = new int[numeroDeTransiciones];
		colaDeTransiciones = new int[numeroDeTransiciones];
		
		for(int i=0;i<numeroDeTransiciones;i++)
		{
			colaDeSemaforos[i] = new Semaphore(0, true);
			Vc[i] = 0;
			colaDeTransiciones[i] = 0;
		}
	}
	
	public Semaphore[] getColaSemaforo()
	{
		return colaDeSemaforos;
	}
	
	public String getVecName(int posicion)
	{
		return vecName[posicion];
	}
	
	public synchronized void agregar(int[] t)
	{
		for(int i=0;i<t.length;i++)
		{
			if(t[i]==1)
			{
				colaDeTransiciones[i]++;
				break;
			}
		}
	}
	
	public synchronized void quitar(int[] t)
	{
		for(int i=0;i<t.length;i++)
		{
			if(t[i]==1)
			{
				colaDeTransiciones[i]--;
				break;
			}
		}		
	}
	
	public void Acquire(int[] vectorDeDisparo, String n)
	{
		for(int i=0;i<vectorDeDisparo.length;i++)
		{
			if(vectorDeDisparo[i]==1)
			{
				vecName[i]=n;
				try 
				{
					colaDeSemaforos[i].acquire();
				}
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
				break;
			}
		}
	}
	
	public synchronized void Release(int posicion)
	{
		colaDeSemaforos[posicion].release();
	}
	
	public synchronized int[] quienesEstan()
	{
		for(int i=0;i<colaDeTransiciones.length;i++)
		{
			if(colaDeTransiciones[i]>=1)
			{
				Vc[i] = 1;
			}
			else
			{
				Vc[i] = 0;
			}
		}
		return Vc;
	}
	
	public synchronized void MostrarVector()
	{
		System.out.println("VECTOR DE COLA:");
		
		for(int i=0; i<T.length; i++)
		{
			System.out.print(T[i]+" ");
		}
		System.out.println("");
		
		for(int i=0; i<colaDeTransiciones.length; i++)
		{
			System.out.print(""+colaDeTransiciones[i]+"  ");
		}
		System.out.println("");
	}
	
	public synchronized String MostrarVc()//Necesaria para el log.
	{
		vector1 = "";
		vector2 = "";
		
		vector1+="VECTOR DE COLA: \n";
		
		for(int i=0; i<T.length; i++)
		{
			vector1+= T[i]+"  ";
		}
		vector1+="\n";
	 

		for(int i=0; i<colaDeTransiciones.length; i++)
		{
			vector2+= colaDeTransiciones[i]+"   ";
		}
		vector1 += vector2 += "\n";
		vector1 += "------------------------";
		return vector1 ;
	}
}
