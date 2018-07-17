package clases;

public class Consumidor extends Thread
{
	private GestorDeMonitor monitor;
	private String nombre;
	private Contenedor contenedor;
	private int[] t2 = {0,0,1,0};
	private int[] t3 = {0,0,0,1};
	
	public Consumidor(GestorDeMonitor monitor, Contenedor contenedor, String nombre)
	{
		this.monitor = monitor;
		this.nombre = nombre;
		this.contenedor = contenedor;
	}

	public void run() 
	{
		while(true)
		{	
			monitor.dispararTransicion(t2,nombre,"T2");
			contenedor.tomarElemento(nombre);
			monitor.dispararTransicion(t3,nombre,"T3");
			contenedor.consumir(nombre);
			//System.out.println("Hay: "+contenedor.cuantosHay(true)+" Elementos en el buffer.");
		}
	}
}
