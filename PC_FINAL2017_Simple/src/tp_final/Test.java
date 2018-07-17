package tp_final;

public class Test 
{
	public void testIDP(int[] M)
	{
		boolean condicion = true;
		
		if(M[0] + M[1] != 1)
		{
			condicion = false;
		}
		else if(M[2] + M[3] + M[8] != 10)
		{
			condicion = false;
		}
		else if(M[3] + M[4] != 1)
		{
			condicion = false;
		}
		else if(M[0] + M[5] != 1)
		{
			condicion = false;
		}
		else if(M[7] + M[13] + M[14] + M[16] + M[17] + M[18] != 10)
		{
			condicion = false;
		}
		else if(M[9] + M[10] != 1)
		{
			condicion = false;
		}
		else if(M[0] + M[11] != 1)
		{
			condicion = false;
		}
		else if(M[12] + M[13] + M[14] != 5)
		{
			condicion = false;
		}
		else if(M[15] + M[16] + M[17] != 5)
		{
			condicion = false;
		}
		else if(M[1] + M[6] != 1)
		{
			condicion = false;
		}
		else if(M[5] + M[6] != 1)
		{
			condicion = false;
		}
		else if(M[6] + M[11] != 1)
		{
			condicion = false;
		}

		assert condicion : "ERROR INVARIANTE DE PLAZAS";
	}
}
