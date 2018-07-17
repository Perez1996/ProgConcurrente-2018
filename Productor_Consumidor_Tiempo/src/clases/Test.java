package clases;

public class Test 
{
	public void testIDP(int[] M)
	{
		boolean condicion = true;
		
		if(M[0] + M[1] != 1)
		{
			condicion = false;
		}
		else if(M[2] + M[3] != 1)
		{
			condicion = false;
		}
		else if(M[1] + M[3] + M[4] != 1)
		{
			condicion = false;
		}
		else if(M[1] + M[3] + M[5] + M[6] != 10)
		{
			condicion = false;
		}

		assert condicion : "ERROR INVARIANTE DE PLAZAS";
	}
}
