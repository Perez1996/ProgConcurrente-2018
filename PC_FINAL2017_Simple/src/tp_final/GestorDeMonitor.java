package tp_final;

import java.io.FileNotFoundException;
//import java.util.concurrent.locks.Condition;
import java.util.concurrent.Semaphore;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorDeMonitor 
{
	private Semaphore mutex;
	private RdP rdp;
	private ColaDeSemaforos cola;
	private Politicas politica;
	private boolean k;
	private boolean mIgualA1;
	private int[] Vs;
	private int[] Vc;
	private int[] m;
	private final static Logger LogGestor = Logger.getLogger("loger.clases.GestorDeMonitor");
	
	public GestorDeMonitor() throws FileNotFoundException
	{
		mutex = new Semaphore(1,true);
		rdp = new RdP();
		cola = new ColaDeSemaforos(RdP.getColumna());
		politica = new Politicas();
		k = false;
		mIgualA1 = false;
		Vs = new int[RdP.getColumna()];
		Vc = new int[RdP.getColumna()];
		m = new int[RdP.getColumna()];
		
		for(int i=0;i<RdP.getColumna();i++)
		{
			Vs[i] = 0;
			Vc[i] = 0;
			m[i] = 0;
		}
		LogGestorInicio("\n"+rdp.MostrarVe()+"\n"+rdp.MostrarVs());
	}
	
	public RdP getRdP()
	{
		return rdp;
	}
	
	public void dispararTransicion(int[] vectorDeDisparo, String nameT, String nameH)
	{
		try 
		{
			mutex.acquire();
			LogGestorMutex(".acquire-> Hilo: "+ nameH + " - Transicion: "+ nameT);
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		System.out.println("Cola de monitor: " + mutex.getQueueLength());
		k=true;
		
		while(k)
		{
			mIgualA1 = false;
			
			if(rdp.disparar(vectorDeDisparo))
			{
				MostrarInformacion(true, vectorDeDisparo, nameT, nameH);
				LogGestorInfo();
				
				Vs = rdp.sensibilizadas();
				Vc = cola.quienesEstan();
				
				for(int i=0;i<m.length;i++)
				{
					m[i] = Vs[i] * Vc[i];
					
					if(m[i] == 1)
					{
						mIgualA1 = true;
					}
				}
				
				if(mIgualA1)
				{
					cola.Release(politica.cual(m, rdp.getVectorDeEstado()[10],rdp.getVectorDeEstado()[13]));
					LogGestorColas(".DESPIERTO -> TRANSICION: T"+ politica.cual(m, rdp.getVectorDeEstado()[10],rdp.getVectorDeEstado()[13]) + "\n");
					mutex.release();
					LogGestorMutex(".release -> HILO: "+ nameH + " - TRANSICION: "+ nameT + "\n");
					return;
				}
				else
				{
					this.k = false;
				}
			}
			else
			{
				LogGestorInfo2();
				MostrarInformacion(false, vectorDeDisparo, nameT, nameH);
				
				System.out.println("");
				
				mutex.release();				
				LogGestorMutex(".release -> Hilo: "+ nameH + " - Transicion: "+ nameT);
				
				System.out.println("Libero el monitor. Permisos del monitor: " + mutex.availablePermits());
				System.out.println("");
				
				LogGestorColas(".encolo -> HILO: "+ nameH + " - TRANSICION: "+ nameT + "\n");				
				cola.Acquire(vectorDeDisparo, nameH);//Accion bloqueante.
				
				try 
				{
					mutex.acquire();
					LogGestorMutex(".acquire Hilo liberado: "+ nameH + "-Trans.: "+ nameT);
					cola.quitar(vectorDeDisparo);
				}
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
		}
		mutex.release();
		LogGestorMutex(".releaseFINAL -> Hilo: "+ nameH + " - Transicion: "+ nameT + "\n");
	}
	
	public synchronized int PosicionTransicion(int[] transicion)
	{
		int posicionTransicion = 0;
		
		for(int i=0; i<transicion.length; i++)
		{
			if(transicion[i]==1)
			{
				posicionTransicion = i;
				break;
			}
		}
		return posicionTransicion;
	}
	
	public synchronized void MostrarInformacion(boolean opcion, int[] transicion, String NombreTransicion, String NombreHilo)
	{
		if(opcion==true)
		{
			System.out.println("TRANSICION DISPARADA: "+NombreTransicion +" =) =) =) =) =) =)");
			System.out.println("HILO: "+NombreHilo);
			rdp.MostrarVectores();
			cola.MostrarVector();
			System.out.println("");
		}
		if(opcion==false)
		{
			System.out.println("TRANSICION NO DISPARADA: "+NombreTransicion+" :( :( :( :( :( :( :(");
			System.out.println("HILO: "+NombreHilo);
			rdp.MostrarVectores();
			cola.agregar(transicion);
			cola.MostrarVector();
			System.out.println("");
		}
	}
	
	public synchronized void LogGestorMutex(String accion) 
	{
		LogGestor.log(Level.INFO,"MUTEX " + accion);     
	}
	
	public synchronized void LogGestorColas(String accion)
	{
		  LogGestor.log(Level.INFO,"COLA " + accion);
	}
	
	public synchronized void LogGestorInfo()
	{
		  LogGestor.log(Level.INFO,"TRANSICION DISPARADA\n"+ this.rdp.MostrarVe() +"\n"+ this.rdp.MostrarVs() +"\n"+ this.cola.MostrarVc());
	}
	
	public synchronized void LogGestorInicio(String accion)
	{
		  LogGestor.log(Level.INFO,"INICIO" + accion);
	}
	
	public synchronized void LogGestorInfo2()
	{
		LogGestor.log(Level.INFO,"DISPARO IMPOSIBLE\n");
	}
}