package tp_final;

public class VentanaDeTiempo 
{						//T0 T1    T2 T3 T4 T5 T6 T7 T8 T9    T10T11T12 
	private long[] alfa = {0,100, 0, 0, 0, 0, 0, 0, 0, 100, 0, 0, 100};
	private long[] beta = {-1,1000000000, -1, -1, -1, -1, -1, -1, -1, 1000000000, -1, -1, 1000000000};
	
	public synchronized boolean testVentanaTiempo(long TimeStamp, int posicionDisparo)
	{
		if(alfa[posicionDisparo]<=(System.currentTimeMillis()-TimeStamp))
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
