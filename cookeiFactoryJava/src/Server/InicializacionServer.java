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
        
        //Creamos el almacen
        Almacen almacen = new Almacen();
        
        //Creamos los empaquetadores
        for (int i = 1; i <= 3; i++)
        {
            //Creamos el empaquetador
            Empaquetador empaquetador = new Empaquetador(i,almacen);
            //Lo añadimos a la lista para posteriormente referenciarlo en los hornos y al RMI
            listaEmpaquetadores.add(empaquetador);

            
        }
        
        //Creamos los hornos
        for (int i = 1; i <= 3; i++)
        {
            //Creamo el horno
            Horno horno = new Horno(i,listaEmpaquetadores.get(i-1));
            //Inicializamos el hilo
            horno.start();
            //Lo añadimos a la lista para posteriormente referenciarlo en los reposteros y al RMI
            listaHornos.add(horno);
            
        }
        
        
        //Creamos los reposteros
        for (int i = 1; i <= 5; i++)
        {
            //Creamos al repostero
            Repostero repostero = new Repostero(i, listaHornos,cafeteria);
            //Inicializamos el hilo
            repostero.start();
            //Lo añadimos a la lista para referenciarlo al RMI
            listaReposteros.add(repostero);
            
        }
        
        
        
        
        
        
        
        
        
         /**********************************
         *   INICIALIZACIÓN DE INTERFAZ   *
         **********************************/
        
        
        //Inicializamos la interfaz del servidor
        PanelSCM interfazServer = new PanelSCM(listaReposteros, listaHornos, listaEmpaquetadores, cafeteria,almacen);
        interfazServer.setVisible(true);
        Thread hiloInterfazServidor = new Thread(interfazServer);
        hiloInterfazServidor.start();
        
       
        
        
        
        
        
        
        
        
        /**********************************
         *   INICIALIZACIÓN DE SERVIDOR   *
         **********************************/
        try
        {
            MetodosParaCliente objetoTraspasable = new MetodosParaCliente(listaReposteros, listaHornos, listaEmpaquetadores, cafeteria,almacen);
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
