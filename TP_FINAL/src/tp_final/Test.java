package tp_final;

public class Test 
{
	//INVARIANTE DE AUTOS QUE CRUZAN EL PASO NIVEL
	private int[] INV1 = {0,0};			
	private int[] INV2 = {0,0};
	
	//INVARIANTES DEL RECORRIDO DEL TREN
	private int[] INV3 = {0,0,0,0};		
	private int[] INV4 = {0,0,0,0};		
	private int[] INV5 = {0,0,0,0};
	private int[] INV6 = {0,0,0,0};
	private int[] INV7 = {0,0,0,0};
	private int[] INV8 = {0,0,0,0};
	private int[] INV9 = {0,0,0,0};
	private int[] INV10 = {0,0,0,0};
	private int[] INV11 = {0,0,0,0};
	private int[] INV12 = {0,0,0,0};
	private int[] INV13 = {0,0,0,0};
	private int[] INV14 = {0,0,0,0};
	private int[] INV15 = {0,0,0,0};
	private int[] INV16 = {0,0,0,0};
	private int[] INV17 = {0,0,0,0};
	private int[] INV18 = {0,0,0,0};
	
	//INVARIANTES DE SUBIDA Y BAJADA ESTACION A
	private int[] INV19 = {0,0,0,0};
	private int[] INV20 = {0,0,0,0};

	
	//INVARIANTES DE SUBIDA Y BAJADA ESTACION B
	private int[] INV27 = {0,0,0,0};
	private int[] INV28 = {0,0,0,0};

	
	//INVARIANTES DE SUBIDA Y BAJADA ESTACION C
	private int[] INV33 = {0,0,0,0};
	private int[] INV34 = {0,0,0,0};

	
	//INVARIANTES DE SUBIDA Y BAJADA ESTACION D
	private int[] INV37 = {0,0,0,0};
	private int[] INV38 = {0,0,0,0};
	
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
		
		//PRUEBA INVARIANTE AUTOS 
		if(id==2) // 10
		{
			INV1[0]++;
			return;
		}else if(id == 3) // 11
		{
			INV1[1]++;
			return;
		}else if(id == 40) // 8
		{
			INV2[0]++;
			return;
		}else if(id == 41) // 9
		{
			INV2[1]++;
			return;
		}
		
		//INVARIANTES DE SUBIDAS Y BAJADAS DE PASAJEROS
		//ESTACION A
		/*
		T12	T13	T14	T15
		4	5	6	7
		 * */
		if(id == 24) // T30
		{
			INV19[0]++;
			INV20[0]++; 
		}
		if(id == 4) // T12
		{
			INV19[1]++;
		}
		if(id == 6) // T14
		{
			INV20[1]++;

		}
		if(id == 5) // T13
		{
			INV19[3]++;
		}
		if(id == 7) // 15
		{
			INV20[3]++;
		}		
		//ESTACION B
		/*
		T16	T17	T18	T19
		8	9	10	11
		 * */
		if(id == 25) // T31
		{
			INV27[0]++;
			INV28[0]++;
		}
		if(id == 8) // T16
		{
			INV27[1]++;
		}
		if(id == 10) // T18
		{
			INV28[1]++;
		}
		if(id == 9) // T17
		{
			INV27[3]++;
		}
		if(id == 11) // T19
		{
			INV28[3]++;
		}		
		//ESTACION C
		/*
		T20	T21	T22	T23
		13	14	15	16
		 * */
		if(id == 26) // T32
		{
			INV33[0]++;
			INV34[0]++;
		}
		if(id == 13) // T20
		{
			INV33[1]++;
		}
		if(id == 15) // T22
		{
			INV34[1]++;
		}
		if(id == 14) // T21
		{
			INV33[3]++;
		}
		if(id == 16) // T23
		{
			INV34[3]++;
		}
		//ESTACION D
		/*
		T24	T25	T26	T27
		17	18	19	20
		 * */
		if(id == 27) // T33
		{
			INV37[0]++;
			INV38[0]++;
		}
		if(id == 17) // T24
		{
			INV37[1]++;
		}
		if(id == 19) // T26
		{
			INV38[1]++;
		}
		if(id == 18) // T25
		{
			INV37[3]++;
		}
		if(id == 20) // T27
		{
			INV38[3]++;
		}
		//TRANSICIONES COMPARTIDAS
		if(id == 22) // T29
		{
			INV19[2]++;
			INV27[2]++;
			INV33[2]++;
			INV37[2]++;
		}
		if(id == 21) // T28
		{
			INV20[2]++;
			INV28[2]++;
			INV34[2]++;
			INV38[2]++;
		}
		
		//INVARIANTES DE RECORRIDOS DEL TREN Y SU MOTIVO DE PARTIDA (SIN GENTE ESPERANDO || SIN LUGAR EN TREN NI EN VAGON)
		/*
		 	T34	T35	T36	T37	T38	T39	T4	T40	T41
			28	29	30	31	32	33	34	35	36
		 */
		if(id == 28) // T34
		{
			INV11[0]++;
			INV12[0]++;
			INV13[0]++;
			INV14[0]++;
			INV15[0]++;
			INV16[0]++;
			INV17[0]++;
			INV18[0]++;
		}
		if(id == 29) // T35
		{
			INV3[0]++;
			INV4[0]++;
			INV5[0]++;
			INV6[0]++;
			INV7[0]++;
			INV8[0]++;
			INV9[0]++;
			INV10[0]++;
		}
		if(id == 30) // T36
		{
			INV3[1]++;
			INV4[1]++;
			INV5[1]++;
			INV6[1]++;
			INV11[1]++;
			INV12[1]++;
			INV13[1]++;
			INV14[1]++;
		}
		if(id == 31) // T37
		{
			INV7[1]++;
			INV8[1]++;
			INV9[1]++;
			INV10[1]++;
			INV15[1]++;
			INV16[1]++;
			INV17[1]++;
			INV18[1]++;
		}
		if(id == 32) // T38
		{
			INV3[2]++;
			INV4[2]++;
			INV7[2]++;
			INV8[2]++;
			INV11[2]++;
			INV12[2]++;
			INV15[2]++;
			INV16[2]++;
		}
		if(id == 33) // T39
		{
			INV5[2]++;
			INV6[2]++;
			INV9[2]++;
			INV10[2]++;
			INV13[2]++;
			INV14[2]++;
			INV17[2]++;
			INV18[2]++;
		}
		if(id == 34) // T40
		{
			INV3[3]++;
			INV5[3]++;
			INV7[3]++;
			INV9[3]++;
			INV11[3]++;
			INV13[3]++;
			INV15[3]++;
			INV17[3]++;
		}
		if(id == 35) // T41
		{
			INV4[3]++;
			INV6[3]++;
			INV8[3]++;
			INV10[3]++;
			INV12[3]++;
			INV14[3]++;
			INV16[3]++;
			INV18[3]++;
		}
	}
	
	public void cantidad_INV_T()
	{		
		//CONTADORES DE INVARIANTES DE AUTOS QUE CRUZAN EL PASO NIVEL
		int cantidad_INV1 = 0;
		int cantidad_INV2 = 0;
		
		//CONTADORES DE INVARIANTES DEL RECORRIDO DEL TREN
		int cantidad_INV3 = 0;
		int cantidad_INV4 = 0;
		int cantidad_INV5 = 0;
		int cantidad_INV6 = 0;
		int cantidad_INV7 = 0;
		int cantidad_INV8 = 0;
		int cantidad_INV9 = 0;
		int cantidad_INV10 = 0;
		int cantidad_INV11 = 0;
		int cantidad_INV12 = 0;
		int cantidad_INV13 = 0;
		int cantidad_INV14 = 0;
		int cantidad_INV15 = 0;
		int cantidad_INV16 = 0;
		int cantidad_INV17 = 0;
		int cantidad_INV18 = 0;
		
		//CONTADORES DE INVARIANTES DE SUBIDA Y BAJADA ESTACION A
		int cantidad_INV19 = 0;
		int cantidad_INV20 = 0;
				
		//CONTADORES DE INVARIANTES DE SUBIDA Y BAJADA ESTACION B
		int cantidad_INV27 = 0;
		int cantidad_INV28 = 0;
		
		//CONTADORES DE INVARIANTES DE SUBIDA Y BAJADA ESTACION C
		int cantidad_INV33 = 0;
		int cantidad_INV34 = 0;
		
		//CONTADORES DE INVARIANTES DE SUBIDA Y BAJADA ESTACION D
		int cantidad_INV37 = 0;
		int cantidad_INV38 = 0;		
		
		//VARIABLE ENCARGADA DE ALMACENAR EL VALOR MAS CHICO
		int candidato = 0;
		
		int TOTAL_PERSONAS = 0;
		int TOTAL_VIAJES = 0;
		
		
		//INICIO DE LA FUNCION
		if(INV1[0]<=INV1[1])
		{
			cantidad_INV1 = INV1[0];
		}else
		{
			cantidad_INV1 = INV1[1];
		}
		System.out.println("Cantidad de veces que se cumple el invariante: AUTOS CRUZAN PASO NIVEL_AB = "+cantidad_INV1+"\n");
		
		if(INV2[0]<=INV2[1])
		{
			cantidad_INV2 = INV2[0];
		}else
		{
			cantidad_INV2 = INV2[1];
		}
		System.out.println("Cantidad de veces que se cumple el invariante: AUTOS CRUZAN PASO NIVEL_CD =  "+cantidad_INV2+"\n");
		
		candidato = INV3[0];
		for(int i = 0; i<INV3.length; i++)
		{
			if(INV3[i]<candidato)
			{
				candidato = INV3[i];
			}
		}
		cantidad_INV3 = candidato;
		TOTAL_VIAJES += cantidad_INV3;
		System.out.println("Cantidad de veces que se cumple el invariante 1: RECORRIDO DEL TREN = "+cantidad_INV3+"\n");

		candidato = INV4[0];
		for(int i = 0; i<INV4.length; i++)
		{
			if(INV4[i]<candidato)
			{
				candidato = INV4[i];
			}
		}
		cantidad_INV4 = candidato;
		TOTAL_VIAJES += cantidad_INV4;
		System.out.println("Cantidad de veces que se cumple el invariante 2: RECORRIDO DEL TREN = "+cantidad_INV4+"\n");
		
		candidato = INV5[0];
		for(int i = 0; i<INV5.length; i++)
		{
			if(INV5[i]<candidato)
			{
				candidato = INV5[i];
			}
		}
		cantidad_INV5 = candidato;
		TOTAL_VIAJES += cantidad_INV5;
		System.out.println("Cantidad de veces que se cumple el invariante 3: RECORRIDO DEL TREN = "+cantidad_INV5+"\n");
		
		candidato = INV6[0];
		for(int i = 0; i<INV6.length; i++)
		{
			if(INV6[i]<candidato)
			{
				candidato = INV6[i];
			}
		}
		cantidad_INV6 = candidato;
		TOTAL_VIAJES += cantidad_INV6;
		System.out.println("Cantidad de veces que se cumple el invariante 4: RECORRIDO DEL TREN = "+cantidad_INV6+"\n");
		
		candidato = INV7[0];
		for(int i = 0; i<INV7.length; i++)
		{
			if(INV7[i]<candidato)
			{
				candidato = INV7[i];
			}
		}
		cantidad_INV7 = candidato;
		TOTAL_VIAJES += cantidad_INV7;
		System.out.println("Cantidad de veces que se cumple el invariante 5: RECORRIDO DEL TREN = "+cantidad_INV7+"\n");
		
		candidato = INV8[0];
		for(int i = 0; i<INV8.length; i++)
		{
			if(INV8[i]<candidato)
			{
				candidato = INV8[i];
			}
		}
		cantidad_INV8 = candidato;
		TOTAL_VIAJES += cantidad_INV8;
		System.out.println("Cantidad de veces que se cumple el invariante 6: RECORRIDO DEL TREN = "+cantidad_INV8+"\n");
		
		candidato = INV9[0];
		for(int i = 0; i<INV9.length; i++)
		{
			if(INV9[i]<candidato)
			{
				candidato = INV9[i];
			}
		}
		cantidad_INV9 = candidato;
		TOTAL_VIAJES += cantidad_INV8;
		System.out.println("Cantidad de veces que se cumple el invariante 7: RECORRIDO DEL TREN = "+cantidad_INV9+"\n");
		
		candidato = INV10[0];
		for(int i = 0; i<INV10.length; i++)
		{
			if(INV10[i]<candidato)
			{
				candidato = INV10[i];
			}
		}
		cantidad_INV10 = candidato;
		TOTAL_VIAJES += cantidad_INV10;
		System.out.println("Cantidad de veces que se cumple el invariante 8: RECORRIDO DEL TREN = "+cantidad_INV10+"\n");
		
		candidato = INV11[0];
		for(int i = 0; i<INV11.length; i++)
		{
			if(INV11[i]<candidato)
			{
				candidato = INV11[i];
			}
		}
		cantidad_INV11 = candidato;
		TOTAL_VIAJES += cantidad_INV11;
		System.out.println("Cantidad de veces que se cumple el invariante 9: RECORRIDO DEL TREN = "+cantidad_INV11+"\n");
		
		candidato = INV12[0];
		for(int i = 0; i<INV12.length; i++)
		{
			if(INV12[i]<candidato)
			{
				candidato = INV12[i];
			}
		}
		cantidad_INV12 = candidato;
		TOTAL_VIAJES += cantidad_INV12;
		System.out.println("Cantidad de veces que se cumple el invariante 10: RECORRIDO DEL TREN = "+cantidad_INV12+"\n");
		
		candidato = INV13[0];
		for(int i = 0; i<INV13.length; i++)
		{
			if(INV13[i]<candidato)
			{
				candidato = INV13[i];
			}
		}
		cantidad_INV13 = candidato;
		TOTAL_VIAJES += cantidad_INV13;
		System.out.println("Cantidad de veces que se cumple el invariante 11: RECORRIDO DEL TREN = "+cantidad_INV13+"\n");
		
		candidato = INV14[0];
		for(int i = 0; i<INV14.length; i++)
		{
			if(INV14[i]<candidato)
			{
				candidato = INV14[i];
			}
		}
		cantidad_INV14 = candidato;
		TOTAL_VIAJES += cantidad_INV14;
		System.out.println("Cantidad de veces que se cumple el invariante 12: RECORRIDO DEL TREN = "+cantidad_INV14+"\n");
		
		candidato = INV15[0];
		for(int i = 0; i<INV15.length; i++)
		{
			if(INV15[i]<candidato)
			{
				candidato = INV15[i];
			}
		}
		cantidad_INV15 = candidato;
		TOTAL_VIAJES += cantidad_INV15;
		System.out.println("Cantidad de veces que se cumple el invariante 13: RECORRIDO DEL TREN = "+cantidad_INV15+"\n");
		
		candidato = INV16[0];
		for(int i = 0; i<INV16.length; i++)
		{
			if(INV16[i]<candidato)
			{
				candidato = INV16[i];
			}
		}
		cantidad_INV16 = candidato;
		TOTAL_VIAJES += cantidad_INV16;
		System.out.println("Cantidad de veces que se cumple el invariante 14: RECORRIDO DEL TREN = "+cantidad_INV16+"\n");
		
		candidato = INV17[0];
		for(int i = 0; i<INV17.length; i++)
		{
			if(INV17[i]<candidato)
			{
				candidato = INV17[i];
			}
		}
		cantidad_INV17 = candidato;
		System.out.println("Cantidad de veces que se cumple el invariante 15: RECORRIDO DEL TREN = "+cantidad_INV17+"\n");
		
		candidato = INV18[0];
		for(int i = 0; i<INV18.length; i++)
		{
			if(INV18[i]<candidato)
			{
				candidato = INV18[i];
			}
		}
		cantidad_INV18 = candidato;
		TOTAL_VIAJES += cantidad_INV18;
		System.out.println("Cantidad de veces que se cumple el invariante 16: RECORRIDO DEL TREN = "+cantidad_INV18+"\n");
		System.out.println("\nCantidad de RECORRIDOS TOTALES = "+TOTAL_VIAJES+"\n");
		
		candidato = INV19[0];
		for(int i = 0; i<INV19.length; i++)
		{
			if(INV19[i]<candidato)
			{
				candidato = INV19[i];
			}
		}
		cantidad_INV19 = candidato;
		TOTAL_PERSONAS += cantidad_INV19; 
		System.out.println("\nCantidad de veces que se cumple el invariante: BAJA DEL TREN EN ESTACION A = "+cantidad_INV19+"\n");
		
		candidato = INV20[0];
		for(int i = 0; i<INV20.length; i++)
		{
			if(INV20[i]<candidato)
			{
				candidato = INV20[i];
			}
		}
		cantidad_INV20 = candidato;
		TOTAL_PERSONAS += cantidad_INV20;
		System.out.println("Cantidad de veces que se cumple el invariante: BAJA DEL VAGON EN ESTACION A = "+cantidad_INV20+"\n");
		
		candidato = INV27[0];
		for(int i = 0; i<INV27.length; i++)
		{
			if(INV27[i]<candidato)
			{
				candidato = INV27[i];
			}
		}
		cantidad_INV27 = candidato;
		TOTAL_PERSONAS += cantidad_INV27;
		System.out.println("Cantidad de veces que se cumple el invariante: BAJA DEL TREN EN ESTACION B = "+cantidad_INV27+"\n");
		
		candidato = INV28[0];
		for(int i = 0; i<INV28.length; i++)
		{
			if(INV28[i]<candidato)
			{
				candidato = INV28[i];
			}
		}
		cantidad_INV28 = candidato;
		TOTAL_PERSONAS += cantidad_INV28;
		System.out.println("Cantidad de veces que se cumple el invariante: BAJA DEL VAGON EN ESTACION B = "+cantidad_INV28+"\n");
		
		candidato = INV33[0];
		for(int i = 0; i<INV33.length; i++)
		{
			if(INV33[i]<candidato)
			{
				candidato = INV33[i];
			}
		}
		cantidad_INV33 = candidato;
		TOTAL_PERSONAS += cantidad_INV33;
		System.out.println("Cantidad de veces que se cumple el invariante: BAJA DEL TREN EN ESTACION C = "+cantidad_INV33+"\n");
		
		candidato = INV34[0];
		for(int i = 0; i<INV34.length; i++)
		{
			if(INV34[i]<candidato)
			{
				candidato = INV34[i];
			}
		}
		cantidad_INV34 = candidato;
		TOTAL_PERSONAS += cantidad_INV34;
		System.out.println("Cantidad de veces que se cumple el invariante: BAJA DEL VAGON EN ESTACION C = "+cantidad_INV34+"\n");
		
		candidato = INV37[0];
		for(int i = 0; i<INV37.length; i++)
		{
			if(INV37[i]<candidato)
			{
				candidato = INV37[i];
			}
		}
		cantidad_INV37 = candidato;
		TOTAL_PERSONAS += cantidad_INV37;
		System.out.println("Cantidad de veces que se cumple el invariante: BAJA DEL TREN EN ESTACION D = "+cantidad_INV37+"\n");
		
		candidato = INV38[0];
		for(int i = 0; i<INV38.length; i++)
		{
			if(INV38[i]<candidato)
			{
				candidato = INV38[i];
			}
		}
		cantidad_INV38 = candidato;
		TOTAL_PERSONAS += cantidad_INV38;
		System.out.println("Cantidad de veces que se cumple el invariante: BAJA DEL VAGON EN ESTACION D = "+cantidad_INV38+"\n");
		System.out.println("\nCantidad TOTAL de PERSONAS QUE REALIZARON UN VIAJE = "+TOTAL_PERSONAS+"\n\n");
	}
}
