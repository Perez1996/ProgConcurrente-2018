package clases;

import interfaces.Buffer;

public class Contenedor implements Buffer 
{
	private RdP petri;
	public Contenedor(RdP petri)
	{
		this.petri = petri;
	}

	public synchronized void tomarElemento(String name) 
	{
		try
		{
			//System.out.println("El consumidor(" + name + "), está tomando un elemento para consumir...");
			Thread.sleep(250);
		}
		catch(Exception e){}
	}

	public synchronized void tomarLugar(String name) 
	{
		try
		{
			//System.out.println("El productor(" + name + "), está tomando un lugar para producir...");
			Thread.sleep(250);
		}
		catch(Exception e){}
	}

	public synchronized void consumir(String name) 
	{	
		try
		{
			//System.out.println("El consumidor(" + name + "), está consumiendo...");
			Thread.sleep(500);
			//System.out.println("El consumidor(" + name + "), termino de consumir...");
		}
		catch(Exception e){}	
	}

	public synchronized void producir(String name) 
	{
		try
		{
			//System.out.println("El productor(" + name + "), está produciendo...");
			Thread.sleep(500);
			//System.out.println("El productor(" + name + "), finalizo su tarea...");
		}
		catch(Exception e){}
	}

	public synchronized int cuantosHay(boolean opcion) 
	{
		if(opcion == true)
		{
			return petri.getVectorDeEstado()[5];//Buffer
		}
		else
		{
			return petri.getVectorDeEstado()[6];//Limite o Lugares 	
		}
	}
}
