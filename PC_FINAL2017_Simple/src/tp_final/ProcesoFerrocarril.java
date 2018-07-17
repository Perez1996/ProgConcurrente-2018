package tp_final;

public class ProcesoFerrocarril extends Thread
{
	private GestorDeMonitor monitor;
	private String nombreHilo;
	
	private int[] t0 = {1,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private int[] t1 = {0,1,0,0,0,0,0,0,0,0,0,0,0,0};
	private int[] t2 = {0,0,1,0,0,0,0,0,0,0,0,0,0,0};
	private int[] t3 = {0,0,0,1,0,0,0,0,0,0,0,0,0,0};
	private int[] t4 = {0,0,0,0,1,0,0,0,0,0,0,0,0,0};
	private int[] t5 = {0,0,0,0,0,1,0,0,0,0,0,0,0,0};
	private int[] t6 = {0,0,0,0,0,0,1,0,0,0,0,0,0,0};
	private int[] t7 = {0,0,0,0,0,0,0,1,0,0,0,0,0,0};
	private int[] t8 = {0,0,0,0,0,0,0,0,1,0,0,0,0,0};
	private int[] t9 = {0,0,0,0,0,0,0,0,0,1,0,0,0,0};
	private int[] t10 = {0,0,0,0,0,0,0,0,0,0,1,0,0,0};
	private int[] t11 = {0,0,0,0,0,0,0,0,0,0,0,1,0,0};
	private int[] t12 = {0,0,0,0,0,0,0,0,0,0,0,0,1,0};
	private int[] t13 = {0,0,0,0,0,0,0,0,0,0,0,0,0,1};

	public ProcesoFerrocarril(GestorDeMonitor monitor, String nombreHilo)
	{
		this.monitor = monitor;
		this.nombreHilo = nombreHilo;
	}
	
	public void run()
	{
		while(true)
		{
			if(nombreHilo == "TREN")
			{
				monitor.dispararTransicion(t0, "T0", "TREN");
				monitor.dispararTransicion(t1, "T1", "TREN");
			}
			
			if(nombreHilo == "CAR")
			{
				monitor.dispararTransicion(t13, "T13", "CAR");
				monitor.dispararTransicion(t2, "T2", "CAR");
				monitor.dispararTransicion(t3, "T3", "CAR");
			}
			
			if(nombreHilo == "GenV")
			{
				monitor.dispararTransicion(t10, "T10", "GenV");
				monitor.dispararTransicion(t5, "T5", "GenV");
				monitor.dispararTransicion(t9, "T9", "GenV");
				monitor.dispararTransicion(t12, "T12", "GenV");
				monitor.dispararTransicion(t8, "T8", "GenV");
				monitor.dispararTransicion(t4, "T4", "GenV");
			}
			
			if(nombreHilo == "GenT")
			{
				monitor.dispararTransicion(t10, "T10", "GenT");
				monitor.dispararTransicion(t7, "T7", "GenT");
				monitor.dispararTransicion(t11, "T11", "GenT");
				monitor.dispararTransicion(t6, "T6", "GenT");
				monitor.dispararTransicion(t4, "T4", "GenT");
			}
		}
	}
}