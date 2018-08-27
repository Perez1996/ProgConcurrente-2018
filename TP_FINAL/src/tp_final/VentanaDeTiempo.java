package tp_final;

public class VentanaDeTiempo 
{						//T0 T1, T10,T11 T12 T13 T14 T15 T16 T17 T18 T19 T2	T20	T21	T22	T23 T24 T25 T26 T27 T28 T29 T3  T30 T31 T32 T33 T34 T35 T36 T37 T38 T39 T4 T40 T41 T5  T6 T7  T8  T9
	private long[] alfa = {0,200,100,0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  200,100,100,100,100,0,  0,  0,  0,  0,  0,  0, 0,  0,  200,0, 200,100,0};
						// T0 T1,    T10,   T11 T12 T13 T14 T15 T16 T17 T18 T19 T2	T20	T21	T22	T23 T24 T25 T26 T27 T28 T29 T3     T30    T31    T32    T33    T34 T35 T36 T37 T38 T39 T4 T40 T41 T5     T6 T7     T8     T9
	private long[] beta = {-1,100000,100000,-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100000,100000,100000,100000,100000,-1, -1, -1, -1, -1, -1, -1,-1, -1, 100000,-1,100000,100000,-1};
	
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
