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
		else if(M[2] + M[6] != 15)
		{
			condicion = false;
		}
		else if(M[0] + M[3] != 1)
		{
			condicion = false;
		}
		else if(M[5] + M[11] + M[12] + M[14] + M[15] + M[16] != 15)
		{
			condicion = false;
		}
		else if(M[7] + M[8] != 1)
		{
			condicion = false;
		}
		else if(M[0] + M[9] != 1)
		{
			condicion = false;
		}
		else if(M[10] + M[11] + M[12] != 5)
		{
			condicion = false;
		}
		else if(M[13] + M[14] + M[15] != 5)
		{
			condicion = false;
		}
		else if(M[1] + M[4] != 1)
		{
			condicion = false;
		}
		else if(M[3] + M[4] != 1)
		{
			condicion = false;
		}
		else if(M[4] + M[9] != 1)
		{
			condicion = false;
		}

		assert condicion : "ERROR INVARIANTE DE PLAZAS";
	}
}
