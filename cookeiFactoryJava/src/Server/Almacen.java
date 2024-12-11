/**
 * version 1.0
 * contacto --> https://www.linkedin.com/in/david-sanchez-1366b1253/
 * @author David Sánchez
 */


//Paquete al que pertenece la clase
package Server;


//Importes
import java.io.Serializable;





public class Almacen implements Serializable
{
    //Constantes de la clase
    private final int capacidadMaxima = 1000;
    private final int cantidadGalletasConsumidas = 100;

    //Atributos de la clase
    private int galletasTotal = 0;
    private int galletasTotalConsumidas = 0;
    private int galletasTotalAlmacenadas = 0;
    


    
    //Contructor vacio
    public Almacen(){};
    //Contructores alternativos o sobrecargados
    
    
    //Getters
    public int getCapacidadMaxima(){return capacidadMaxima;}
    public int getGalletasTotal(){return galletasTotal;}
    public int getCantidadGalletasConsumidas() {return cantidadGalletasConsumidas;}
    public int getGalletasTotalConsumidas(){return galletasTotalConsumidas;}
    public int getGalletasTotalAlmacenadas(){return galletasTotalAlmacenadas;}
    //Setters
    
    
    //To String (Solo si es necesario)
    
    
    
    //Metodos de la clase
    public synchronized void añadirGalletas(int galletas)
    {
 
        //Revisamos si el almacen esta lleno
        while(galletasTotal == capacidadMaxima)
        {
            //Espera activa
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException error)
            {
                System.out.println("Se ha producido un error mientras se realizaba una espera activa para poder añadir galletas al almacen --> " + error);
            }
        }


        galletasTotal += galletas;

        //Log de almacenamiento total
        galletasTotalAlmacenadas += galletas;



        
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
            galletasTotalConsumidas += cantidadGalletasConsumir;
        }        
    }
    
}
