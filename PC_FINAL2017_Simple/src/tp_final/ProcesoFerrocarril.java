package tp_final;

public class ProcesoFerrocarril extends Thread
{
	private GestorDeMonitor monitor;
	private String nombreHilo;
	private boolean sleep = false;
	
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
		while(monitor.getPersonasQueViajaron()<30)
		{
			if(nombreHilo == "Personas")
			{
				monitor.dispararTransicion(t9, "T9", "Personas", sleep);
			}
			
			if(nombreHilo == "SUBEN")
			{
				monitor.dispararTransicion(t6, "T6", "SUBEN", sleep);
				monitor.dispararTransicion(t8, "T8", "SUBEN", sleep);
			}
			
			if(nombreHilo == "BAJAN")
			{
				monitor.dispararTransicion(t10, "T10", "BAJAN", sleep);
				monitor.dispararTransicion(t5, "T5", "BAJAN", sleep); 
				monitor.dispararTransicion(t11, "T11", "BAJAN", sleep); 
				monitor.dispararTransicion(t7, "T7", "BAJAN", sleep); 
			}
			
			if(nombreHilo == "NoGente")
			{
				monitor.dispararTransicion(t4, "T4", "NoGente", sleep);
			}
			
			if(nombreHilo == "Arranque")
			{
				monitor.dispararTransicion(t0, "T0", "Arranque", sleep);
				monitor.dispararTransicion(t1, "T1", "Arranque", sleep); 
			}
			
			if(nombreHilo == "NoLugar")
			{
				monitor.dispararTransicion(t3, "T3", "NoLugar", sleep);
			}
			
			if(nombreHilo == "Autos")
			{
				monitor.dispararTransicion(t12, "T12", "Autos", sleep); 
				monitor.dispararTransicion(t2, "T2", "Autos", sleep); 
			}
		}
		System.out.println("EJECUCION FINALIZADA! \n\n PERSONAS QUE VIAJARON = "+monitor.getPersonasQueViajaron()+"\n\n");
		monitor.getTest().cantidad_INV_T();
		System.exit(0);
	}
}