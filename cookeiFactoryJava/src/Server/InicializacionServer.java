/**
 * version 1.0
 * contacto --> https://www.linkedin.com/in/david-sanchez-1366b1253/
 * @author David Sánchez
 */


//Paquete al que pertenece la clase
package Server;

import ServerInterface.PanelSCM;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JTextField;
import SharedZone.InterfazImplementacionRMI;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;


//Importes





public class InicializacionServer 
{
    public static void main(String[] args) 
    {
        //Siempre agruparemos en listas los reposteros,horno y empaquetadores.
        List<Repostero> listaReposteros = new ArrayList<>();
        List<Horno> listaHornos = new ArrayList<>();
        List<Empaquetador> listaEmpaquetadores = new ArrayList<>();
        
        
        
        
        
        
        
        
        /**********************************
         *    INICIALIZACIÓN DE CLASES    *
         **********************************/
        
        //Creamos la cafeteria
        Cafeteria cafeteria = new Cafeteria();
        
        
        //Creamos los hornos
        for (int i = 1; i <= 3; i++)
        {
            Horno horno = new Horno();
            //Lo añadimos a la lista para posteriormente referenciarlo en los reposteros
            listaHornos.add(horno);
            //Inicializamos el hilo
            horno.start();
        }
        
        
        //Creamos los reposteros
        for (int i = 1; i <= 5; i++)
        {
            //Creamos al repostero
            Repostero repostero = new Repostero(i, listaHornos,cafeteria);
            //Lo añadimos a si lista
            listaReposteros.add(repostero);
            //Ponemos al repostero a crear galletas
            repostero.start();
        }
        
        
        
        
        
        
        
        
        
         /**********************************
         *   INICIALIZACIÓN DE INTERFAZ   *
         **********************************/
        
        
        //Inicializamos la interfaz del servidor
        PanelSCM interfazServer = new PanelSCM(listaReposteros, listaHornos, listaEmpaquetadores, cafeteria);
        interfazServer.setVisible(true);
        Thread hiloInterfazServidor = new Thread(interfazServer);
        hiloInterfazServidor.start();
        
       
        
        
        
        
        
        
        
        
        /**********************************
         *   INICIALIZACIÓN DE SERVIDOR   *
         **********************************/
        try
        {
            MetodosParaCliente objetoTraspasable = new MetodosParaCliente(listaReposteros, listaHornos, listaEmpaquetadores, cafeteria);
            LocateRegistry.createRegistry(1099);
            
            //Le pasamos los objetos al "Server"
            Naming.rebind("//localhost/objetoTraspasable", objetoTraspasable);
        }
        catch (RemoteException error)
        {
            System.out.println("Se ha producido un error mientras se levantaba el servidor en el Server --> " + error);
        }
        catch (MalformedURLException error)
        {
            System.out.println("Se ha producido un error mientras se subia delsde el Servidor el Objeto Traspasable --> " + error);
        }
        
        
        
    }
    
}
