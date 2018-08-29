package tp_final;

public class ProcesoFerrocarril extends Thread
{
	private GestorDeMonitor monitor;
	private String nombreHilo;
	private boolean sleep = false;
	
	private int[] t0 =  {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private int[] t1 =  {0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private int[] t10 =  {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private int[] t11 =  {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private int[] t12 =  {0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private int[] t13 =  {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private int[] t14 =  {0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private int[] t15 =  {0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private int[] t16 =  {0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private int[] t17 =  {0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private int[] t18 = {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private int[] t19 = {0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private int[] t2 = {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private int[] t20 = {0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private int[] t21 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private int[] t22 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private int[] t23 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private int[] t24 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private int[] t25 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private int[] t26 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private int[] t27 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private int[] t28 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private int[] t29 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private int[] t3 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private int[] t30 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private int[] t31 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private int[] t32 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private int[] t33 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private int[] t34 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private int[] t35 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0};
	private int[] t36 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0};
	private int[] t37 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0};
	private int[] t38 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0};
	private int[] t39 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0};
	private int[] t4 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0};
	private int[] t40 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0};
	private int[] t41 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0};
	private int[] t5 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0};
	private int[] t6 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0};
	private int[] t7 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0};
	private int[] t8 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0};
	private int[] t9 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
	
	
	public ProcesoFerrocarril(GestorDeMonitor monitor, String nombreHilo)
	{
		this.monitor = monitor;
		this.nombreHilo = nombreHilo;
	}
	
	public void run()
	{
		while(monitor.getPersonasQueViajaron()<120)
		{
			if(nombreHilo == "Personas_EST_A") //HILO 1
			{
				monitor.dispararTransicion(t30, "T30", "Personas_EST_A", sleep);
			}
			
			if(nombreHilo == "subenTren_EST_A") //HILO 2
			{
				monitor.dispararTransicion(t12, "T12", "subenTren_EST_A", sleep);
			}
			
			if(nombreHilo == "subenVagon_EST_A") //HILO 3
			{
				monitor.dispararTransicion(t14, "T14", "subenVagon_EST_A", sleep);
			}
			
			if(nombreHilo == "bajanTren_EST_A") //HILO 4
			{
				monitor.dispararTransicion(t29, "T29", "bajanTren_EST_A", sleep);
				monitor.dispararTransicion(t13, "T13", "bajanTren_EST_A", sleep); 
			}
			
			if(nombreHilo == "bajanVagon_EST_A") //HILO 5
			{
				monitor.dispararTransicion(t28, "T28", "bajanVagon_EST_A", sleep); 
				monitor.dispararTransicion(t15, "T15", "bajanVagon_EST_A", sleep); 
			}
			
			if(nombreHilo == "NoGente_EST_A") //HILO 6
			{
				monitor.dispararTransicion(t35, "T35", "NoGente_EST_A", sleep);
			}
			
			if(nombreHilo == "Tren") //HILO 7
			{
				monitor.dispararTransicion(t0, "T0", "Tren", sleep);
				monitor.dispararTransicion(t1, "T1", "Tren", sleep);
				monitor.dispararTransicion(t2, "T2", "Tren", sleep);
				monitor.dispararTransicion(t3, "T3", "Tren", sleep);
				monitor.dispararTransicion(t4, "T4", "Tren", sleep);
				monitor.dispararTransicion(t5, "T5", "Tren", sleep);
				monitor.dispararTransicion(t6, "T6", "Tren", sleep);
				monitor.dispararTransicion(t7, "T7", "Tren", sleep);
			}
			
			if(nombreHilo == "NoLugar_EST_A") //HILO 8
			{
				monitor.dispararTransicion(t34, "T34", "NoLugar_EST_A", sleep);
			}
			
			if(nombreHilo == "Autos_AB") //HILO 9
			{
				monitor.dispararTransicion(t8, "T8", "Autos_AB", sleep); 
				monitor.dispararTransicion(t9, "T9", "Autos_AB", sleep); 
			}
			
			if(nombreHilo == "Personas_EST_B") //HILO 10
			{
				monitor.dispararTransicion(t31, "T31", "Personas_EST_B", sleep);
			}
			
			if(nombreHilo == "subenTren_EST_B") //HILO 11
			{
				monitor.dispararTransicion(t16, "T16", "suben_EST_B", sleep);
			}
			
			if(nombreHilo == "subenVagon_EST_B") //HILO 12
			{
				monitor.dispararTransicion(t18, "T18", "subenVagon_EST_B", sleep);
			}
			
			if(nombreHilo == "bajanTren_EST_B") // HILO 13
			{
				monitor.dispararTransicion(t29, "T29", "bajanTren_EST_B", sleep);
				monitor.dispararTransicion(t17, "T17", "bajanTren_EST_B", sleep); 
			}

			if(nombreHilo == "bajanVagon_EST_B") // HILO 14
			{
				monitor.dispararTransicion(t28, "T28", "bajanVagon_EST_B", sleep); 
				monitor.dispararTransicion(t19, "T19", "bajanVagon_EST_B", sleep); 
			}

			
			if(nombreHilo == "NoGente_EST_B") //HILO 15
			{
				monitor.dispararTransicion(t37, "T37", "NoGente_EST_B", sleep);
			}
			
			if(nombreHilo == "NoLugar_EST_B") //HILO 16
			{
				monitor.dispararTransicion(t36, "T36", "NoLugar_EST_B", sleep);
			}
			
			if(nombreHilo == "Personas_EST_C") //HILO 17
			{
				monitor.dispararTransicion(t32, "T32", "Personas_EST_C", sleep);
			}
			
			if(nombreHilo == "subenTren_EST_C") //HILO 18
			{
				monitor.dispararTransicion(t20, "T20", "subenTren_EST_C", sleep);
			}
			
			if(nombreHilo == "subenVagon_EST_C") //HILO 19
			{
				monitor.dispararTransicion(t22, "T22", "subenVagon_EST_C", sleep);
			}
			
			if(nombreHilo == "bajanTren_EST_C") //HILO 20
			{
				monitor.dispararTransicion(t29, "T29", "bajanTren_EST_C", sleep);
				monitor.dispararTransicion(t21, "T21", "bajanTren_EST_C", sleep); 
			}
			
			if(nombreHilo == "bajanVagon_EST_C") //HILO 21
			{
				monitor.dispararTransicion(t28, "T28", "bajanVagon_EST_C", sleep); 
				monitor.dispararTransicion(t23, "T23", "bajanVagon_EST_C", sleep); 
			}
			
			if(nombreHilo == "NoGente_EST_C") //HILO 22
			{
				monitor.dispararTransicion(t39, "T39", "NoGente_EST_C", sleep);
			}
			
			
			if(nombreHilo == "NoLugar_EST_C") //HILO 23
			{
				monitor.dispararTransicion(t38, "T38", "NoLugar_EST_C", sleep);
			}
			
			if(nombreHilo == "Autos_CD") //HILO 24
			{
				monitor.dispararTransicion(t10, "T10", "Autos_CD", sleep); 
				monitor.dispararTransicion(t11, "T11", "Autos_CD", sleep); 
			}
			
			if(nombreHilo == "Personas_EST_D") //HILO 25
			{
				monitor.dispararTransicion(t33, "T33", "Personas_EST_D", sleep);
			}
			
			if(nombreHilo == "subenTren_EST_D") //HILO 26
			{
				monitor.dispararTransicion(t24, "T24", "subenTren_EST_D", sleep);
			}
			
			if(nombreHilo == "subenVagon_EST_D") //HILO 27
			{
				monitor.dispararTransicion(t26, "T26", "subenVagon_EST_D", sleep);
			}
			
			if(nombreHilo == "bajanTren_EST_D") //HILO 28
			{
				monitor.dispararTransicion(t29, "T29", "bajanTren_EST_D", sleep);
				monitor.dispararTransicion(t25, "T25", "bajanTren_EST_D", sleep); 
			}
			
			if(nombreHilo == "bajanVagon_EST_D") //HILO 29
			{
				monitor.dispararTransicion(t28, "T28", "bajanVagon_EST_D", sleep); 
				monitor.dispararTransicion(t27, "T27", "bajanVagon_EST_D", sleep); 
			}
			
			if(nombreHilo == "NoGente_EST_D") //HILO 30
			{
				monitor.dispararTransicion(t40, "T40", "NoGente_EST_D", sleep);
			}
			
			if(nombreHilo == "NoLugar_EST_D") //HILO 31
			{
				monitor.dispararTransicion(t41, "T41", "NoLugar_EST_D", sleep);
			}
		}
		System.out.println("EJECUCION FINALIZADA! \n\n PERSONAS QUE VIAJARON = "+monitor.getPersonasQueViajaron()+"\n\n");
		monitor.getTest().cantidad_INV_T();
		System.exit(0);
	}
}