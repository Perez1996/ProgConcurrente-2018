package tp_final;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
*
* @author David
*/
@SuppressWarnings("unused")
public class loger 
{

    // Preparamos el log para cada paquete del proyecto, esto con el fin de capturar cada log
	// que se genere e irlo pasando al nivel superior hasta que encuentren un handler que los
    // maneje
    private final static Logger LOG_RAIZ = Logger.getLogger("loger");

    // El log para ESTA clase en particular
    public static void main(String[] args) 
    {
        try 
        {
            // Los handler (manejadores) indican a donde mandar la salida ya sea consola o archivo
        	// En este caso ConsoleHandler envia los logs a la consola
//            Handler consoleHandler = new ConsoleHandler();
            // Con el manejador de archivo, indicamos el archivo donde se mandaran los logs
            // El segundo argumento controla si se sobre escribe el archivo o se agregan los logs al final
            // Para sobre escribir pase un true para agregar al final, false para sobre escribir
            // todo el archivo
            Handler fileHandler = new FileHandler("./loger.log, false");

            // El formateador indica como presentar los datos, en este caso usaremos el formaro sencillo
            // el cual es mas facil de leer, si no usamos esto el log estara en formato xml por defecto
            MyFormatter simpleFormatter = new MyFormatter();
            

            // Se especifica que formateador usara el manejador (handler) de archivo
            fileHandler.setFormatter(simpleFormatter);

            // Asignamos los handles previamente declarados al log *raiz* esto es muy importante ya que
            // permitira que los logs de todas y cada una de las clases del programa que esten en ese paquete
            // o sus subpaquetes se almacenen en el archivo y aparescan en consola
//            LOG_RAIZ.addHandler(consoleHandler);
            LOG_RAIZ.addHandler(fileHandler);

            // Indicamos a partir de que nivel deseamos mostrar los logs, podemos especificar un nivel en especifico
            // para ignorar informacion que no necesitemos
//            consoleHandler.setLevel(Level.ALL);
            fileHandler.setLevel(Level.ALL);

            try
            {
            	throw new Exception("ERROR DE CONTROL DE FLUJO DE PROGRAMA"); 
            }
            catch(Exception e)
            {
            // Mediante el metodo getStack obtenemos el stackTrace de la excepcion en forma de un objecto String
            // de modo que podamos almacenarlo en bitacora para su analisis posterior
            }
        } 
        catch (IOException ex) {}
        catch (SecurityException ex) {}
    }

    /**
     * Esta funcion nos permite convertir el stackTrace en un String, necesario para poder imprimirlos al log debido a
     * cambios en como Java los maneja internamente
     * @param e Excepcion de la que queremos el StackTrace
     * @return StackTrace de la excepcion en forma de String
	*/
    public static String getStackTrace(Exception e) 
    {
    	StringWriter sWriter = new StringWriter();
    	PrintWriter pWriter = new PrintWriter(sWriter);
    	e.printStackTrace(pWriter);
    	return sWriter.toString();
    }
}