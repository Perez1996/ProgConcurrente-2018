package clases;

public class VentanaDeTiempo 
{
	private long[] alfa = {0,1000,0,1000};
	private long[] beta = {-1,1000000000,-1,1000000000};
	
	public synchronized boolean testVentanaTiempo(long TimeStamp, int posicionDisparo)
	{
		if(alfa[posicionDisparo]<=(TimeStamp))// && (marca-TimeStamp)<=beta[posicionDisparo])
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public synchronized long setNuevoTimeStamp()
	{
		return System.currentTimeMillis();
	}
	
	public synchronized long[] VectorAlfa()
	{
		return alfa;
	}
	
	public synchronized long[] VectorBeta()
	{
		return beta;
	}
}
