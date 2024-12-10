/**
 * version 1.0
 * contacto --> https://www.linkedin.com/in/david-sanchez-1366b1253/
 * @author David Sánchez
 */


//Paquete al que pertenece la clase
package Logger;

//Importes
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger 
{
    private static final String NOMBRE_ARCHIVO = "evolucionGalletas.txt";
    private static Logger instance; 

    private Logger() 
    {
        //Crear el archivo si no existe (opcional, para asegurar su existencia al inicio)
        try (BufferedWriter salida = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true))) 
        {
            salida.write("=== Inicio de Logs: " + getCurrentTimestamp() + " ===\n");
        } 
        catch (IOException error) 
        {
            System.out.println("Error al inicializar el log --> " + error);
        }
    }

    //Método para obtener la instancia única
    public static synchronized Logger getInstance() 
    {
        if (instance == null) 
        {
            instance = new Logger();
        }
        return instance;
    }

    //Método para registrar un mensaje en el log
    public synchronized void log(String mensaje) 
    {
        String mensajeLog = "[" + getCurrentTimestamp() + "] " + mensaje;
        
        //Mostrar el mensaje en consola
        System.out.println(mensajeLog);

        //Guardar el mensaje en el archivo
        try (BufferedWriter salida = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true))) 
        {
            salida.write(mensajeLog + "\n");
        } 
        catch (IOException error) 
        {
            System.out.println("Error al escribir en el log -->" + error);
        }
    }

    //Método para obtener la marca de tiempo actual
    private String getCurrentTimestamp() 
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }
}
