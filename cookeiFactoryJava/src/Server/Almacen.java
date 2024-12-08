/**
 * version 1.0
 * contacto --> https://www.linkedin.com/in/david-sanchez-1366b1253/
 * @author David Sánchez
 */


//Paquete al que pertenece la clase
package Server;


//Importes
import java.io.Serializable;
import java.util.concurrent.locks.ReentrantLock;




public class Almacen implements Serializable
{
    //Constantes de la clase
    private final int capacidadMaxima = 1000;
    private final int cantidadGalletasConsumidas = 100;

    //Atributos de la clase
    private int galletasTotal = 0;
    
    
        //Lo usaremos para gestionar la cantidad de galletas que van al almacen
    private ReentrantLock lockAlmacen = new ReentrantLock();

    
    //Contructor vacio
    public Almacen(){};
    //Contructores alternativos o sobrecargados
    
    
    //Getters
    public int getCapacidadMaxima(){return capacidadMaxima;}
    public int getGalletasTotal(){return galletasTotal;}
    
    //Setters
    
    
    //To String (Solo si es necesario)
    
    
    
    //Metodos de la clase
    public void añadirGalletas(int galletas)
    {
        try
        {
            lockAlmacen.lock();
            //Revisamos si el almacen esta lleno
            if(galletasTotal == capacidadMaxima)
            {
                lockAlmacen.wait();
            }
            
            //Revisamos si con las galletas que vamos a depositar, el almacen supera su capacidad maxima
            if((galletasTotal + galletas) > capacidadMaxima)
            {
                //Sacamos la cantidad exacta a depositar para que el almacen este lleno, y dejamos la otra parte para cuando no lo este
                int parteDepositada = (galletasTotal + galletas) - capacidadMaxima;
                galletasTotal += parteDepositada;
                int parteEspera = galletas - parteDepositada;
                
                //Esperamos a que nos avisen de que el almacen ya no esta tan lleno
                lockAlmacen.wait();
                
                //No hace falta comprobar de nuevo si el alamcen superara la capacidad maxima con este deposito ya que sabemos que se consumiran 100 galletas
                galletasTotal += parteEspera;
            }
            else
            {
                galletasTotal += galletas;
            }
            
        }
        catch(InterruptedException error)
        {
            System.out.println("Se ha producido un error mientras se añadian galletas al almacen --> " + error);
        }
        finally
        {
            //Siempre desbloqueamos el lock
            lockAlmacen.unlock();
        }
        
    }
    
    public void consumirGalletas(int cantidadGalletasConsumir)
    {
        int galletasRestantes = galletasTotal - cantidadGalletasConsumir;
        
        //Comprobamos que si es inferior a 0, se establezca en 0
        if (galletasRestantes < 0)
        {
            galletasTotal = 0;
        }
        else
        {
            galletasTotal = galletasRestantes;
        }
        
        //Como aqui ya se han consumido las galletas, notificamos por si el lock estuviese esperando
        lockAlmacen.notifyAll();
    }
    
}
