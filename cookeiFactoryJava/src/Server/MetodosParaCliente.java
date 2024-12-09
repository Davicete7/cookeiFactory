/**
 * version 1.0
 * contacto --> https://www.linkedin.com/in/david-sanchez-1366b1253/
 * @author David Sánchez
 */

//Paquete al que pertenece la clase
package Server;


//Importes
import SharedZone.InterfazImplementacionRMI;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;


//CLASE
public class MetodosParaCliente extends UnicastRemoteObject implements InterfazImplementacionRMI
{
    private List<Repostero> listaReposteros = new ArrayList<>();
    private List<Horno> listaHornos = new ArrayList<>();
    private List<Empaquetador> listaEmpaquetadores = new ArrayList<>();
    private Cafeteria cafeteria;
    private Almacen almacen;
    
    
    
    //Contructor
    public MetodosParaCliente (List<Repostero> _listaReposteros, List<Horno> _listaHornos, List<Empaquetador> _listaEmpaquetadores, Cafeteria _cafeteria, Almacen _almacen) throws RemoteException
    {
        this.listaReposteros = _listaReposteros;
        this.listaHornos = _listaHornos;
        this.listaEmpaquetadores = _listaEmpaquetadores;
        this.cafeteria = _cafeteria;
        this.almacen = _almacen;
    }
    
    
 
       
    //GETTERS (ESENCIALES)
    public int getTotalGalletasProducidas(int indiceRepostero){return listaReposteros.get(indiceRepostero).getTotalGalletas();}
    public int getTotalGalletasDesperdiciadas(int indiceRepostero){return listaReposteros.get(indiceRepostero).getTotalGalletasDesperdiciadas();}
    public List<Repostero> getListaReposteros(){return listaReposteros;}
    public List<Horno> getListaHornos(){return listaHornos;}
    public List<Empaquetador> getListaEmpaquetadores(){return listaEmpaquetadores;}  
    public Almacen getAlmacen(){return almacen;}
}
