package tp_final;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;


@SuppressWarnings("unused")
public class Main 
{
	private final static Logger LOGGER = Logger.getLogger("loger.clases.GestorDeMonitor");
	private final static Logger LOGGERC = Logger.getLogger("loger.clases.ColaDeSemaforos");
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		System.out.println("------------------------------------------------------");
		System.out.println("TRABAJO PRACTICO INTEGRADO DE PROGRAMACION CONCURRENTE");
		System.out.println("TP FINAL 1 ESTACION");
		System.out.println("INTEGRANTES: COLAZO DANILO JOSE _ PEREZ ESTEBAN ANDRES");
		System.out.println("------------------------------------------------------");
		System.out.println("");
		try 
		{
            // Los handler (manejadores) indican a donde mandar la salida ya sea consola o archivo
			// En este caso ConsoleHandler envia los logs a la consola
//            Handler consoleHandler = new ConsoleHandler();
            // Con el manejador de archivo, indicamos el archivo donde se mandaran los logs
            // El segundo argumento controla si se sobre escribe el archivo o se agregan los logs al final
            // Para sobre escribir pase un true para agregar al final, false para sobre escribir
            // todo el archivo
            Handler fileHandler = new FileHandler("./loger.log", false);

            // El formateador indica como presentar los datos, en este caso usaremos el formaro sencillo
            // el cual es mas facil de leer, si no usamos esto el log estara en formato xml por defecto
            MyFormatter simpleFormatter = new MyFormatter();

            // Se especifica que formateador usara el manejador (handler) de archivo
            fileHandler.setFormatter(simpleFormatter);

            // Asignamos los handles previamente declarados al log *raiz* esto es muy importante ya que
            // permitira que los logs de todas y cada una de las clases del programa que esten en ese paquete
            // o sus subpaquetes se almacenen en el archivo y aparescan en consola
//            LOGGER.addHandler(consoleHandler);
            LOGGER.addHandler(fileHandler);
            LOGGERC.addHandler(fileHandler);

            // Indicamos a partir de que nivel deseamos mostrar los logs, podemos especificar un nivel en especifico
            // para ignorar informacion que no necesitemos
//            consoleHandler.setLevel(Level.ALL);
            fileHandler.setLevel(Level.ALL);
            
            GestorDeMonitor monitor = new GestorDeMonitor();
            
            ProcesoFerrocarril h1 = new ProcesoFerrocarril(monitor, "Personas_EST_A");                   
            ProcesoFerrocarril h2 = new ProcesoFerrocarril(monitor, "suben_EST_A");
            ProcesoFerrocarril h3 = new ProcesoFerrocarril(monitor, "bajan_EST_A");
            ProcesoFerrocarril h5 = new ProcesoFerrocarril(monitor, "NoGente_EST_A");
            ProcesoFerrocarril h4 = new ProcesoFerrocarril(monitor, "Tren");
            ProcesoFerrocarril h6 = new ProcesoFerrocarril(monitor, "NoLugar_EST_A");
            ProcesoFerrocarril h7 = new ProcesoFerrocarril(monitor, "Autos_AB");
            ProcesoFerrocarril h8 = new ProcesoFerrocarril(monitor, "Personas_EST_B");                   
            ProcesoFerrocarril h9 = new ProcesoFerrocarril(monitor, "suben_EST_B");
            ProcesoFerrocarril h10 = new ProcesoFerrocarril(monitor, "bajan_EST_B");
            ProcesoFerrocarril h11 = new ProcesoFerrocarril(monitor, "NoGente_EST_B");
            ProcesoFerrocarril h12 = new ProcesoFerrocarril(monitor, "NoLugar_EST_B");
            ProcesoFerrocarril h13 = new ProcesoFerrocarril(monitor, "Personas_EST_C");                   
            ProcesoFerrocarril h14 = new ProcesoFerrocarril(monitor, "suben_EST_C");
            ProcesoFerrocarril h15 = new ProcesoFerrocarril(monitor, "bajan_EST_C");
            ProcesoFerrocarril h16 = new ProcesoFerrocarril(monitor, "NoGente_EST_C");
            ProcesoFerrocarril h17 = new ProcesoFerrocarril(monitor, "NoLugar_EST_C");
            ProcesoFerrocarril h18 = new ProcesoFerrocarril(monitor, "Autos_CD");
            ProcesoFerrocarril h19 = new ProcesoFerrocarril(monitor, "Personas_EST_D");                   
            ProcesoFerrocarril h20 = new ProcesoFerrocarril(monitor, "suben_EST_D");
            ProcesoFerrocarril h21 = new ProcesoFerrocarril(monitor, "bajan_EST_D");
            ProcesoFerrocarril h22 = new ProcesoFerrocarril(monitor, "NoGente_EST_D");
            ProcesoFerrocarril h23 = new ProcesoFerrocarril(monitor, "NoLugar_EST_D");
            
            h1.start();
            h2.start();
            h3.start();
            h4.start();
            h5.start();
            h6.start();
            h7.start();
            h8.start();
            h9.start();
            h10.start();
            h11.start();
            h12.start();
            h13.start();
            h14.start();
            h15.start();
            h16.start();
            h17.start();
            h18.start();
            h19.start();
            h20.start();
            h21.start();
            h22.start();
            h23.start();
		} 
		catch (IOException ex) 
		{
            LOGGER.log(Level.SEVERE, "Error de IO");
            LOGGERC.log(Level.SEVERE, "Error de IO");
		}
		catch (SecurityException ex) 
		{
            LOGGER.log(Level.SEVERE, "Error de Seguridad");
            LOGGERC.log(Level.SEVERE, "Error de Seguridad");
		}
	}
}
