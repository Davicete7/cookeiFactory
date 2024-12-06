/**
 * version 1.0
 * contacto --> https://www.linkedin.com/in/david-sanchez-1366b1253/
 * @author David Sánchez
 */


//Paquete al que pertenece la clase
package Client;

//Importes
import ClientInterface.PanelCliente;
import SharedZone.InterfazImplementacionRMI;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.Naming;
import java.rmi.NotBoundException;




//CLASE
public class InicializacionCliente 
{
    public static void main(String[] args) 
    {
        /**********************************
         *   INICIALIZACIÓN DE CLIENTE    *
         **********************************/
        try
        {
            InterfazImplementacionRMI metodosServer = (InterfazImplementacionRMI) Naming.lookup("//localhost/objetoTraspasable");
            
            
            /**********************************
            *   INICIALIZACIÓN DE INTERFAZ   *
            **********************************/


            //Inicializamos la interfaz del servidor
            PanelCliente interfazCliente = new PanelCliente(metodosServer);
            interfazCliente.setVisible(true);
            Thread hiloInterfazCliente = new Thread(interfazCliente);
            hiloInterfazCliente.start();
            
        }
        catch (MalformedURLException error)
        {
            System.out.println("Se ha producido un error de MalformedURLException cuando se importaba un objeto del Servidor en el cliente --> " + error );
        }
        catch (NotBoundException error)
        {
            System.out.println("Se ha producido un error de NotBoundException cuando se importaba un objeto del Servidor en el cliente --> " + error );
        }
        catch (RemoteException error)
        {
            System.out.println("Se ha producido un error de RemoteException cuando se importaba un objeto del Servidor en el cliente --> " + error );
        }
    }
}
