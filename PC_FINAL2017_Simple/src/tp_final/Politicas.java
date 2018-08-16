package tp_final;

public class Politicas 				//    T                       T         T
{							        // T0 T1 T2 T3 T4 T5 T6 T7 T8 T9 T10T11T12
	private int[] prioridadSubir  =   {2, 1, 2, 2, 2, 3, 5, 3, 5, 1, 2, 2, 1};
	private int[] prioridadBajar =    {2, 1, 2, 2, 2, 5, 3, 5, 3, 1, 2, 2, 1};
	private int[] prioridadIgualada   =   {2, 1, 2, 2, 3, 3, 3, 3, 1, 2, 2, 2, 1};
	private int[] prioridadElejida    =   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

	public synchronized int cual(int[] m, int trenL, int vagonL)
	{
		int candidato = -1;
		int posicion = 0;		

		if((trenL+vagonL) >=4 && (trenL+vagonL) <=6) 
		{
			llenarVector(prioridadIgualada); 
		}

		if((trenL+vagonL)<4) 
		{
			llenarVector(prioridadBajar); 
		}
		
		if((trenL+vagonL)>6) 
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