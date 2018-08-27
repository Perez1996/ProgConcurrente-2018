package tp_final;

public class Test 
{
	private int[] INV1 = {0,0};			//T12, T2
	private int[] INV2 = {0,0,0};		//T3, T0, T1
	private int[] INV3 = {0,0,0};		//T4, T0, T1
	private int[] INV4 = {0,0,0,0};		//T9, T6, T10, T5
	private int[] INV5 = {0,0,0,0};		//T9, T8, T11, T7
	
	int esT3 = 0;	// Si la variable T3 se disparo entonces la variable es igual a uno, si por lo tanto T4 se dispara la variable sera igual a cero
	int aux = 0;
	/*
	 *
	 * */
	public void testIDP(int[] M)
	{
		boolean condicion = true;
		//p10 p11 (5)
		if(M[2] + M[3] != 5)
		{
			condicion = false;
		}//p17 p18 p19 (10)
		else if(M[9] + M[10] + M[11] != 10)
		{
			condicion = false;
		}//p18 p19 p20 p21 p22 p23 p24 p25 p26 p27 p28 p29 (40)
		else if(M[10] + M[11] + M[13] + M[14] + M[15] + M[16] + M[17] + M[18] + M[19] + M[20] + M[21] + M[22] != 40)
		{
			condicion = false;
		}//p16 p20 p21 (5)
		else if(M[8] + M[13] + M[14] != 5)
		{
			condicion = false;
		}//p8 p9 (5)
		else if(M[40] + M[41] != 5)
		{
			condicion = false;
		}//p12 p34 p35 (1)
		else if(M[4] + M[28] + M[29] != 1)
		{
			condicion = false;
		}//p12 p30 (1)
		else if(M[4] + M[24] != 1)
		{
			condicion = false;
		}//p0 p12 (1)
		else if(M[0] + M[4] != 1)
		{
			condicion = false;
		}//p14 p38 p39 (1)
		else if(M[6] + M[32] + M[33] != 1)
		{
			condicion = false;
		}//p14 p4 (1)
		else if(M[6] + M[34] != 1)
		{
			condicion = false;
		}//p14 p32 (1)
		else if(M[6] + M[26] != 1)
		{
			condicion = false;
		}//p15 p40 p41 (1)
		else if(M[7] + M[35] + M[36] != 1)
		{
			condicion = false;
		}//p15 p6 (1)
		else if(M[7] + M[38] != 1)
		{
			condicion = false;
		}//p15 p33 (1)
		else if(M[7] + M[27] != 1)
		{
			condicion = false;
		}//p13 p36 p37 (1)
		else if(M[5] + M[30] + M[31] != 1)
		{
			condicion = false;
		}//p13 p31 (1)
		else if(M[5] + M[25] != 1)
		{
			condicion = false;
		}//p13 p2 (1)
		else if(M[5] + M[12] != 1)
		{
			condicion = false;
		}//p1 p3 p34 p35 p36 p37 p38 p39 p40 p41 p5 p7 (1)
		else if(M[1] + M[23] + M[28] + M[29] + M[30] + M[31] + M[32] + M[33] + M[35] + M[36] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p1 p3 p30 p36 p37 p38 p39 p40 p41 p5 p7 (1)
		else if(M[1] + M[23] + M[24] + M[30] + M[31] + M[32] + M[33] + M[35] + M[36] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p0 p1 p3 p36 p37 p38 p39 p40 p41 p5 p7 (1)
		else if(M[0] + M[1] + M[23] + M[30] + M[31] + M[32] + M[33] + M[35] + M[36] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p1 p3 p31 p34 p35 p38 p39 p40 p41 p5 p7 (1)
		else if(M[1] + M[23] + M[25] + M[28] + M[29] + M[32] + M[33] + M[35] + M[36] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p1 p3 p30 p31 p38 p39 p40 p41 p5 p7 (1)
		else if(M[1] + M[23] + M[24] + M[25] + M[32] + M[33] + M[35] + M[36] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p0 p1 p3 p31 p38 p39 p40 p41 p5 p7 (1)
		else if(M[0] + M[1] + M[23] + M[25] + M[32] + M[33] + M[35] + M[36] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p1 p2 p3 p34 p35 p38 p39 p40 p41 p5 p7 (1)
		else if(M[1] + M[12] + M[23] + M[28] + M[29] + M[32] + M[33] + M[35] + M[36] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p1 p2 p3 p30 p38 p39 p40 p41 p5 p7 (1)
		else if(M[1] + M[12] + M[23] + M[24] + M[32] + M[33] + M[35] + M[36] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p0 p1 p2 p3 p38 p39 p40 p41 p5 p7 (1)
		else if(M[0] + M[1] + M[12] + M[23] + M[32] + M[33] + M[35] + M[36] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p1 p3 p34 p35 p36 p37 p4 p40 p41 p5 p7 (1)
		else if(M[1] + M[23] + M[28] + M[29] + M[30] + M[31] + M[34] + M[35] + M[36] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p1 p3 p30 p36 p37 p4 p40 p41 p5 p7 (1)
		else if(M[1] + M[23] + M[24] + M[30] + M[31] + M[34] + M[35] + M[36] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p0 p1 p3 p36 p37 p4 p40 p41 p5 p7 (1)
		else if(M[0] + M[1] + M[23] + M[30] + M[31] + M[34] + M[35] + M[36] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p1 p3 p31 p34 p35 p4 p40 p41 p5 p7 (1)
		else if(M[1] + M[23] + M[25] + M[28] + M[29] + M[34] + M[35] + M[36] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p1 p3 p30 p31 p4 p40 p41 p5 p7 (1)
		else if(M[1] + M[23] + M[24] + M[25] + M[34] + M[35] + M[36] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p0 p1 p3 p31 p4 p40 p41 p5 p7 (1)
		else if(M[0] + M[1] + M[23] + M[25] + M[34] + M[35] + M[36] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p1 p2 p3 p34 p35 p4 p40 p41 p5 p7 (1)
		else if(M[1] + M[12] + M[23] + M[28] + M[29] + M[34] + M[35] + M[36] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p1 p2 p3 p30 p4 p40 p41 p5 p7 (1)
		else if(M[1] + M[12] + M[23] + M[24] + M[34] + M[35] + M[36] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p0 p1 p2 p3 p4 p40 p41 p5 p7 (1)
		else if(M[0] + M[1] + M[12] + M[23] + M[34] + M[35] + M[36] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p1 p3 p32 p34 p35 p36 p37 p40 p41 p5 p7 (1)
		else if(M[1] + M[23] + M[26] + M[28] + M[29] + M[30] + M[31] + M[35] + M[36] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p1 p3 p30 p32 p36 p37 p40 p41 p5 p7 (1)
		else if(M[1] + M[23] + M[24] + M[26] + M[30] + M[31] + M[35] + M[36] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p0 p1 p3 p32 p36 p37 p40 p41 p5 p7 (1)
		else if(M[0] + M[1] + M[23] + M[26] + M[30] + M[31] + M[35] + M[36] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p1 p3 p31 p32 p34 p35 p40 p41 p5 p7 (1)
		else if(M[1] + M[23] + M[25] + M[26] + M[28] + M[29] + M[35] + M[36] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p1 p3 p30 p31 p32 p40 p41 p5 p7 (1)
		else if(M[1] + M[23] + M[24] + M[25] + M[26] + M[35] + M[36] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p0 p1 p3 p31 p32 p40 p41 p5 p7 (1)
		else if(M[0] + M[1] + M[23] + M[25] + M[26] + M[35] + M[36] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p1 p2 p3 p32 p34 p35 p40 p41 p5 p7 (1)
		else if(M[1] + M[12] + M[23] + M[26] + M[28] + M[29] + M[35] + M[36] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p1 p2 p3 p30 p32 p40 p41 p5 p7 (1)
		else if(M[1] + M[12] + M[23] + M[24] + M[26] + M[35] + M[36] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p0 p1 p2 p3 p32 p40 p41 p5 p7 (1)
		else if(M[0] + M[1] + M[12] + M[23] + M[26] + M[35] + M[36] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p1 p3 p34 p35 p36 p37 p38 p39 p5 p6 p7 (1)
		else if(M[1] + M[23] + M[28] + M[29] + M[30] + M[31] + M[32] + M[33] + M[37] + M[38] + M[39] != 1)
		{
			condicion = false;
		}// p1 p3 p30 p36 p37 p38 p39 p5 p6 p7 (1)
		else if(M[1] + M[23] + M[24] + M[30] + M[31] + M[32] + M[33] + M[37] + M[38] + M[39] != 1)
		{
			condicion = false;
		}// p0 p1 p3 p36 p37 p38 p39 p5 p6 p7 (1)
		else if(M[0] + M[1] + M[23] + M[30] + M[31] + M[32] + M[33] + M[37] + M[38] + M[39] != 1)
		{
			condicion = false;
		}// p1 p3 p31 p34 p35 p38 p39 p5 p6 p7 (1)
		else if(M[1] + M[23] + M[25] + M[28] + M[29] + M[32] + M[33] + M[37] + M[38] + M[39] != 1)
		{
			condicion = false;
		}// p1 p3 p30 p31 p38 p39 p5 p6 p7 (1)
		else if(M[1] + M[23] + M[24] + M[25] + M[32] + M[33] + M[37] + M[38] + M[39] != 1)
		{
			condicion = false;
		}// p0 p1 p3 p31 p38 p39 p5 p6 p7 (1)
		else if(M[0] + M[1] + M[23] + M[25] + M[32] + M[33] + M[37] + M[38] + M[39] != 1)
		{
			condicion = false;
		}// p1 p2 p3 p34 p35 p38 p39 p5 p6 p7 (1)
		else if(M[1] + M[12] + M[23] + M[28] + M[29] + M[32] + M[33] + M[37] + M[38] + M[39] != 1)
		{
			condicion = false;
		}// p1 p2 p3 p30 p38 p39 p5 p6 p7 (1)
		else if(M[1] + M[12] + M[23] + M[24] + M[32] + M[33] + M[37] + M[38] + M[39] != 1)
		{
			condicion = false;
		}// p0 p1 p2 p3 p38 p39 p5 p6 p7 (1)
		else if(M[0] + M[1] + M[12] + M[23] + M[32] + M[33] + M[37] + M[38] + M[39] != 1)
		{
			condicion = false;
		}// p1 p3 p34 p35 p36 p37 p4 p5 p6 p7 (1)
		else if(M[1] + M[23] + M[28] + M[29] + M[30] + M[31] + M[34] + M[37] + M[38] + M[39] != 1)
		{
			condicion = false;
		}// p1 p3 p30 p36 p37 p4 p5 p6 p7 (1)
		else if(M[1] + M[23] + M[24] + M[30] + M[31] + M[34] + M[37] + M[38] + M[39] != 1)
		{
			condicion = false;
		}// p0 p1 p3 p36 p37 p4 p5 p6 p7 (1)
		else if(M[0] + M[1] + M[23] + M[30] + M[31] + M[34] + M[37] + M[38] + M[39] != 1)
		{
			condicion = false;
		}// p1 p3 p31 p34 p35 p4 p5 p6 p7 (1)
		else if(M[1] + M[23] + M[25] + M[28] + M[29] + M[34] + M[37] + M[38] + M[39] != 1)
		{
			condicion = false;
		}// p1 p3 p30 p31 p4 p5 p6 p7 (1)
		else if(M[1] + M[23] + M[24] + M[25] + M[34] + M[37] + M[38] + M[39] != 1)
		{
			condicion = false;
		}// p0 p1 p3 p31 p4 p5 p6 p7 (1)
		else if(M[0] + M[1] + M[23] + M[25] + M[34] + M[37] + M[38] + M[39] != 1)
		{
			condicion = false;
		}// p1 p2 p3 p34 p35 p4 p5 p6 p7 (1)
		else if(M[1] + M[12] + M[23] + M[28] + M[29] + M[34] + M[37] + M[38] + M[39] != 1)
		{
			condicion = false;
		}// p1 p2 p3 p30 p4 p5 p6 p7 (1)
		else if(M[1] + M[12] + M[23] + M[24] + M[34] + M[37] + M[38] + M[39] != 1)
		{
			condicion = false;
		}// p0 p1 p2 p3 p4 p5 p6 p7 (1)
		else if(M[0] + M[1] + M[12] + M[23] + M[34] + M[37] + M[38] + M[39] != 1)
		{
			condicion = false;
		}// p1 p3 p32 p34 p35 p36 p37 p5 p6 p7 (1)
		else if(M[1] + M[23] + M[26] + M[28] + M[29] + M[30] + M[31] + M[37] + M[38] + M[39] != 1)
		{
			condicion = false;
		}// p1 p3 p30 p32 p36 p37 p5 p6 p7 (1)
		else if(M[1] + M[23] + M[24] + M[26] + M[30] + M[31] + M[37] + M[38] + M[39] != 1)
		{
			condicion = false;
		}// p0 p1 p3 p32 p36 p37 p5 p6 p7 (1)
		else if(M[0] + M[1] + M[23] + M[26] + M[30] + M[31] + M[37] + M[38] + M[39] != 1)
		{
			condicion = false;
		}// p1 p3 p31 p32 p34 p35 p5 p6 p7 (1)
		else if(M[1] + M[23] + M[25] + M[26] + M[28] + M[29] + M[37] + M[38] + M[39] != 1)
		{
			condicion = false;
		}// p1 p3 p30 p31 p32 p5 p6 p7 (1)
		else if(M[1] + M[23] + M[24] + M[25] + M[26] + M[37] + M[38] + M[39] != 1)
		{
			condicion = false;
		}// p0 p1 p3 p31 p32 p5 p6 p7 (1)
		else if(M[0] + M[1] + M[23] + M[25] + M[26] + M[37] + M[38] + M[39] != 1)
		{
			condicion = false;
		}// p1 p2 p3 p32 p34 p35 p5 p6 p7 (1)
		else if(M[1] + M[12] + M[23] + M[26] + M[28] + M[29] + M[37] + M[38] + M[39] != 1)
		{
			condicion = false;
		}// p1 p2 p3 p30 p32 p5 p6 p7 (1)
		else if(M[1] + M[12] + M[23] + M[24] + M[26] + M[37] + M[38] + M[39] != 1)
		{
			condicion = false;
		}// p0 p1 p2 p3 p32 p5 p6 p7 (1)
		else if(M[0] + M[1] + M[12] + M[23] + M[26] + M[37] + M[38] + M[39] != 1)
		{
			condicion = false;
		}// p1 p3 p33 p34 p35 p36 p37 p38 p39 p5 p7 (1)
		else if(M[1] + M[23] + M[27] + M[28] + M[29] + M[30] + M[31] + M[32] + M[33] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p1 p3 p30 p33 p36 p37 p38 p39 p5 p7 (1)
		else if(M[1] + M[23] + M[24] + M[27] + M[30] + M[31] + M[32] + M[33] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p0 p1 p3 p33 p36 p37 p38 p39 p5 p7 (1)
		else if(M[0] + M[1] + M[23] + M[27] + M[30] + M[31] + M[32] + M[33] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p1 p3 p31 p33 p34 p35 p38 p39 p5 p7 (1)
		else if(M[1] + M[23] + M[25] + M[27] + M[28] + M[29] + M[32] + M[33] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p1 p3 p30 p31 p33 p38 p39 p5 p7 (1)
		else if(M[1] + M[23] + M[24] + M[25] + M[27] + M[32] + M[33] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p0 p1 p3 p31 p33 p38 p39 p5 p7 (1)
		else if(M[0] + M[1] + M[23] + M[25] + M[27] + M[32] + M[33] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p1 p2 p3 p33 p34 p35 p38 p39 p5 p7 (1)
		else if(M[1] + M[12] + M[23] + M[27] + M[28] + M[29] + M[32] + M[33] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p1 p2 p3 p30 p33 p38 p39 p5 p7 (1)
		else if(M[1] + M[12] + M[23] + M[24] + M[27] + M[32] + M[33] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p0 p1 p2 p3 p33 p38 p39 p5 p7 (1)
		else if(M[0] + M[1] + M[12] + M[23] + M[27] + M[32] + M[33] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p1 p3 p33 p34 p35 p36 p37 p4 p5 p7 (1)
		else if(M[1] + M[23] + M[27] + M[28] + M[29] + M[30] + M[31] + M[34] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p1 p3 p30 p33 p36 p37 p4 p5 p7 (1)
		else if(M[1] + M[23] + M[24] + M[27] + M[30] + M[31] + M[34] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p0 p1 p3 p33 p36 p37 p4 p5 p7 (1)
		else if(M[0] + M[1] + M[23] + M[27] + M[30] + M[31] + M[34] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p1 p3 p31 p33 p34 p35 p4 p5 p7 (1)
		else if(M[1] + M[23] + M[25] + M[27] + M[28] + M[29] + M[34] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p1 p3 p30 p31 p33 p4 p5 p7 (1)
		else if(M[1] + M[23] + M[24] + M[25] + M[27] + M[34] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p0 p1 p3 p31 p33 p4 p5 p7 (1)
		else if(M[0] + M[1] + M[23] + M[25] + M[27] + M[34] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p1 p2 p3 p33 p34 p35 p4 p5 p7 (1)
		else if(M[1] + M[12] + M[23] + M[27] + M[28] + M[29] + M[34] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p1 p2 p3 p30 p33 p4 p5 p7 (1)
		else if(M[1] + M[12] + M[23] + M[24] + M[27] + M[34] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p0 p1 p2 p3 p33 p4 p5 p7 (1)
		else if(M[0] + M[1] + M[12] + M[23] + M[27] + M[34] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p1 p3 p32 p33 p34 p35 p36 p37 p5 p7 (1)
		else if(M[1] + M[23] + M[26] + M[27] + M[28] + M[29] + M[30] + M[31] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p1 p3 p30 p32 p33 p36 p37 p5 p7 (1)
		else if(M[1] + M[23] + M[24] + M[26] + M[27] + M[30] + M[31] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p0 p1 p3 p32 p33 p36 p37 p5 p7 (1)
		else if(M[0] + M[1] + M[23] + M[26] + M[27] + M[30] + M[31] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p1 p3 p31 p32 p33 p34 p35 p5 p7 (1)
		else if(M[1] + M[23] + M[25] + M[26] + M[27] + M[28] + M[29] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p1 p3 p30 p31 p32 p33 p5 p7 (1)
		else if(M[1] + M[23] + M[24] + M[25] + M[26] + M[27] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p0 p1 p3 p31 p32 p33 p5 p7 (1)
		else if(M[0] + M[1] + M[23] + M[25] + M[26] + M[27] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p1 p2 p3 p32 p33 p34 p35 p5 p7 (1)
		else if(M[1] + M[12] + M[23] + M[26] + M[27] + M[28] + M[29] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p1 p2 p3 p30 p32 p33 p5 p7 (1)
		else if(M[1] + M[12] + M[23] + M[24] + M[26] + M[27] + M[37] + M[39] != 1)
		{
			condicion = false;
		}// p0 p1 p2 p3 p32 p33 p5 p7 (1)
		else if(M[0] + M[1] + M[12] + M[23] + M[26] + M[27] + M[37] + M[39] != 1)
		{
			condicion = false;
		}
		assert condicion : "ERROR INVARIANTE DE PLAZAS";
	}
	
	//T12, T2
	//T3, T0, T1
	//T4, T0, T1
	//T9, T6, T10, T5
	//T9, T8, T11, T7
	public void testInvTransicion(int[] vectorDisparo)
	{	
		int id = 0;
		for(int i=0; i<vectorDisparo.length; i++)
		{
			if(vectorDisparo[i]==1)
			{
				id = i;
				break;
			}
		}
		
		//PRUEBA INVARIANTE 1
		if(id==12)
		{
			INV1[0]++;
			return;
		}else if(id == 2)
		{
			INV1[1]++;
			return;
		}
		
		//PRUEBA INVARIANTE 2 Y 3
		if(id == 3)
		{
			INV2[0]++;
			esT3 = 1;
			return;
		}else if(id == 4)
		{
			INV3[0]++;
			esT3 = 0;
			return;
		}
		if(id == 0 && esT3 == 1)
		{
			INV2[1]++;
			return;
		}else if(id == 0 && esT3 == 0)
		{
			INV3[1]++;
			return;
		}
		if(id == 1 && esT3 == 1)
		{
			INV2[2]++;
			return;
		}else if(id == 1 && esT3 == 0)
		{
			INV3[2]++;
			return;
		}
		
		//PRUEBA DE INVARIANTE 4 Y 5
		if(id == 9)
		{
			aux++;
			return;
		}
		if(id == 6)
		{
			INV4[0]++;
			aux--;
			INV4[1]++;
			return;
		}else if(id == 10)
		{
			INV4[2]++;
			return;
		}else if(id == 5)
		{
			INV4[3]++;
			return;
		}else if(id == 8)
		{
			INV5[0]++;
			aux--;
			INV5[1]++;
			return;
		}else if(id == 11)
		{
			INV5[2]++;
			return;
		}else if(id == 7)
		{
			INV5[3]++;
			return;
		}
	}
	
	public void cantidad_INV_T()
	{
		int cantidad_INV1 = 0;
		int cantidad_INV2 = 0;
		int cantidad_INV3 = 0;
		int cantidad_INV4 = 0;
		int cantidad_INV5 = 0;
		
		int candidato = 0;
		if(INV1[0]<=INV1[1])
		{
			cantidad_INV1 = INV1[0];
		}else
		{
			cantidad_INV1 = INV1[1];
		}
		System.out.println("\nCantidad de veces que se cumple el invariante de transicion 1 = "+cantidad_INV1+"\n");
		
		candidato = INV2[0];
		for(int i = 0; i<INV2.length; i++)
		{
			if(INV2[i]<candidato)
			{
				candidato = INV2[i];
			}
		}
		cantidad_INV2 = candidato;
		System.out.println("\nCantidad de veces que se cumple el invariante de transicion 2 = "+cantidad_INV2+"\n");

		candidato = INV3[0];
		for(int i = 0; i<INV3.length; i++)
		{
			if(INV3[i]<candidato)
			{
				candidato = INV3[i];
			}
		}
		cantidad_INV3 = candidato;
		System.out.println("\nCantidad de veces que se cumple el invariante de transicion 3 = "+cantidad_INV3+"\n");
		
		candidato = INV4[0];
		for(int i = 0; i<INV4.length; i++)
		{
			if(INV4[i]<candidato)
			{
				candidato = INV4[i];
			}
		}
		cantidad_INV4 = candidato;
		System.out.println("\nCantidad de veces que se cumple el invariante de transicion 4 = "+cantidad_INV4+"\n");
		
		candidato = INV5[0];
		for(int i = 0; i<INV5.length; i++)
		{
			if(INV5[i]<candidato)
			{
				candidato = INV5[i];
			}
		}
		cantidad_INV5 = candidato;
		System.out.println("\nCantidad de veces que se cumple el invariante de transicion 5 = "+cantidad_INV5+"\n");
	}
			
}
