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
			
			if(nombreHilo == "Personas")
			{
				monitor.dispararTransicion(t9, "T9", "Personas");
			}
			
			if(nombreHilo == "CabinaTren")
			{
				monitor.dispararTransicion(t6, "T6", "CabinaTren");
				monitor.dispararTransicion(t10, "T10", "CabinaTren");
				monitor.dispararTransicion(t5, "T5", "CabinaTren");
			}
			
			if(nombreHilo == "Vagon")
			{
				monitor.dispararTransicion(t8, "T8", "Vagon");
				monitor.dispararTransicion(t11, "T11", "Vagon");
				monitor.dispararTransicion(t7, "T7", "Vagon");
			}
			
			if(nombreHilo == "NoGente")
			{
				monitor.dispararTransicion(t4, "T4", "NoGente");
			}
			
			if(nombreHilo == "Arranque")
			{
				monitor.dispararTransicion(t0, "T0", "Arranque");
				monitor.dispararTransicion(t1, "T1", "Arranque");
			}
			
			if(nombreHilo == "NoLugar")
			{
				monitor.dispararTransicion(t3, "T3", "NoLugar");
			}
			
			if(nombreHilo == "Autos")
			{
				monitor.dispararTransicion(t12, "T12", "Autos");
				monitor.dispararTransicion(t2, "T2", "Autos");
			}
		}
	}
}