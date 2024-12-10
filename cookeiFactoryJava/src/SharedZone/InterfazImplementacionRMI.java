/**
 * version 1.0
 * contacto --> https://www.linkedin.com/in/david-sanchez-1366b1253/
 * @author David Sánchez
 */

//Paquete al que pertenece la clase
package SharedZone;

//Importes
import Server.Almacen;
import java.rmi.Remote;
import java.rmi.RemoteException;
import Server.Repostero;
import Server.Horno;
import Server.Empaquetador;
import java.util.List;

//CLASE
public interface InterfazImplementacionRMI extends Remote 
{
    
    //TODOS LOS METODOS AÑADIDOS TENDRAN UN --> throws RemoteExecption
    public int getTotalGalletasProducidas(int indiceRepostero) throws RemoteException;
    public int getTotalGalletasDesperdiciadas(int indiceRepostero) throws RemoteException;
    public List<Repostero> getListaReposteros() throws RemoteException;
    public List<Horno> getListaHornos() throws RemoteException;
    public List<Empaquetador> getListaEmpaquetadores() throws RemoteException;
    public Almacen getAlmacen()throws RemoteException;
    public void setParadaManualDesdeCliente(boolean _paradaManual, int indexRepostero) throws RemoteException;
    
}
