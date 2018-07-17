package clases;

public class Productor extends Thread 
{
	private GestorDeMonitor monitor;
	private String nombre;
	private Contenedor contenedor;
	private int[] t0 = {1,0,0,0};
	private int[] t1 = {0,1,0,0};
	
	public Productor(GestorDeMonitor monitor, Contenedor contenedor, String nombre)
	{
		this.monitor = monitor;
		this.nombre = nombre;
		this.contenedor = contenedor;
	}
	

	public void run() 
	{
		while(true)
		{
			monitor.dispararTransicion(t0,nombre,"T0");
			contenedor.tomarLugar(nombre);
			monitor.dispararTransicion(t1,nombre,"T1");
			contenedor.producir(nombre);
			//System.out.println("Hay: "+contenedor.cuantosHay(false)+" Lugar/es.");
		}
	}
}
