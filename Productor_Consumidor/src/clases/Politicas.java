package clases;

public class Politicas 
{							     //       T0  T1 T2 T3
	private int[] prioridadProductor  =   {2, 2, 1, 1};
	private int[] prioridadConsumidor =   {1, 1, 2, 2};
	private int[] prioridadIgualada   =   {1, 1, 1, 1};
	private int[] prioridadElejida    =   {0, 0, 0, 0};

	public synchronized int cual(int[] m, int espacio)
	{
		int candidato = -1;
		int posicion = 0;		

		if(espacio >=4 && espacio <=6) 
		{
			llenarVector(prioridadIgualada); 
		}

		if(espacio<4) 
		{
			llenarVector(prioridadConsumidor); 
		}
		
		if(espacio>6) 
		{ 
			llenarVector(prioridadProductor); 
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