package tp_final;

public class ProcesoFerrocarril extends Thread
{
	private GestorDeMonitor monitor;
	private String nombreHilo;
	
	private int[] t0 = {1,0,0,0,0,0,0,0,0,0,0,0,0};
	private int[] t1 = {0,1,0,0,0,0,0,0,0,0,0,0,0};
	private int[] t2 = {0,0,1,0,0,0,0,0,0,0,0,0,0};
	private int[] t3 = {0,0,0,1,0,0,0,0,0,0,0,0,0};
	private int[] t4 = {0,0,0,0,1,0,0,0,0,0,0,0,0};
	private int[] t5 = {0,0,0,0,0,1,0,0,0,0,0,0,0};
	private int[] t6 = {0,0,0,0,0,0,1,0,0,0,0,0,0};
	private int[] t7 = {0,0,0,0,0,0,0,1,0,0,0,0,0};
	private int[] t8 = {0,0,0,0,0,0,0,0,1,0,0,0,0};
	private int[] t9 = {0,0,0,0,0,0,0,0,0,1,0,0,0};
	private int[] t10 = {0,0,0,0,0,0,0,0,0,0,1,0,0};
	private int[] t11 = {0,0,0,0,0,0,0,0,0,0,0,1,0};
	private int[] t12 = {0,0,0,0,0,0,0,0,0,0,0,0,1};

	public ProcesoFerrocarril(GestorDeMonitor monitor, String nombreHilo)
	{
		this.monitor = monitor;
		this.nombreHilo = nombreHilo;
	}
	
	public void run()
	{
		while(true)
		{
			
			if(nombreHilo == "H_Suben")
			{
				monitor.dispararTransicion(t9, "T9", "H_Suben");
				monitor.dispararTransicion(t6, "T6", "H_Suben");
				monitor.dispararTransicion(t8, "T8", "H_Suben");
			}
			
			if(nombreHilo == "H_Tren1")
			{
				monitor.dispararTransicion(t3, "T3", "H_Tren1");
				monitor.dispararTransicion(t0, "T0", "H_Tren1");
				monitor.dispararTransicion(t1, "T1", "H_Tren1");
			}
			
			if(nombreHilo == "H_Tren2")
			{
				monitor.dispararTransicion(t4, "T4", "H_Tren2");
				monitor.dispararTransicion(t0, "T0", "H_Tren2");
				monitor.dispararTransicion(t1, "T1", "H_Tren2");
			}
			
			if(nombreHilo == "H_Bajan")
			{
				monitor.dispararTransicion(t10, "T10", "H_Bajan");
				monitor.dispararTransicion(t5, "T5", "H_Bajan");
				monitor.dispararTransicion(t11, "T11", "H_Bajan");
				monitor.dispararTransicion(t7, "T7", "H_Bajan");
			}
			
			if(nombreHilo == "H_Auto")
			{
				monitor.dispararTransicion(t12, "T12", "H_Auto");
				monitor.dispararTransicion(t2, "T2", "H_Auto");
			}
		}
	}
}