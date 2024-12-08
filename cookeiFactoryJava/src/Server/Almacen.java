/**
 * version 1.0
 * contacto --> https://www.linkedin.com/in/david-sanchez-1366b1253/
 * @author David Sánchez
 */


//Paquete al que pertenece la clase
package Server;


//Importes
import java.util.concurrent.locks.ReentrantLock;




public class Almacen 
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
    }
    
}
