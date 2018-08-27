package tp_final;

public class Politicas 				    //    t                                                                                     t  t   t   t   t                                       t     t  t  
{							            // T0 T1 T10 T11 T12 T13 T14 T15 T16 T17 T18 T19 T2 T20 T21 T22 T23 T24 T25 T26 T27 T28 T29 T3 T30 T31 T32 T33 T34 T35 T36 T37 T38 T39 T4  T40 T41 T5 T6 T7 T8 T9     
	private int[] prioridadSubir  =       {2, 1, 2,  2,  4,  3,  4,  3,  4,  3,  4,  3,  2, 4,  3,  4,  3,  4,  3,  4,  3,  2,  2,  1, 1,  1,  1,  1,  2,  2,  2,  2,  2,  2,  2,  2,  2,  1, 2, 1, 1, 2};
	private int[] prioridadBajar =        {2, 1, 2,  2,  3,  4,  3,  4,  3,  4,  3,  4,  2, 3,  4,  3,  4,  3,  4,  3,  4,  2,  2,  1, 1,  1,  1,  1,  2,  2,  2,  2,  2,  2,  2,  2,  2,  1, 2, 1, 1, 2};
	private int[] prioridadIgualada   =   {2, 1, 2,  2,  3,  3,  3,  3,  3,  3,  3,  3,  2, 3,  3,  3,  3,  3,  3,  3,  3,  2,  2,  1, 1,  1,  1,  1,  2,  2,  2,  2,  2,  2,  2,  2,  2,  1, 2, 1, 1, 2};
	private int[] prioridadElejida    =   {0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0, 0, 0, 0};

	public synchronized int cual(int[] m, int trenL, int vagonL)
	{
		int candidato = -1;
		int posicion = 0;		

		if((trenL+vagonL) >=5 && (trenL+vagonL) <=10) 
		{
			llenarVector(prioridadIgualada); 
		}

		if((trenL+vagonL)<5) 
		{
			llenarVector(prioridadBajar); 
		}
		
		if((trenL+vagonL)>10) 
		{ 
			llenarVector(prioridadSubir); 
		}
		
		for(int i = 0; i<m.length; i++)
		{
			if(m[i]>0)
			{
				if(prioridadElejida[i]>candidato)
				{
					candidato = prioridadElejida[i];
					posicion = i;
				}
			}
		}
		return posicion;
	}
	
	public void llenarVector(int [] entrada)
	{
		for(int i = 0; i<prioridadElejida.length; i++)
		{
			prioridadElejida[i] = entrada[i];
		}
	}
}