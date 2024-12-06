/**
 * version 1.0
 * contacto --> https://www.linkedin.com/in/david-sanchez-1366b1253/
 * @author David Sánchez
 */


//Paquete al que pertenece la clase
package Server;


//Importes
import java.io.Serializable;



//CLASE
public class Horno extends Thread implements Serializable
{
    //Contantes de la clase (Bloqueamos la variable con la sentencia final)
    private final int capacidadMaxima = 200;


    //Atributos de la clase
    private int identificador;
    private int cantidadGalletas = 0;           //Por defecto cuando se cree el horno siempre estara vacio
    private boolean hornoCompleto = false;      //Por defecto cuando se cree el horno nunca estara lleno 
    private boolean hornoVacio = true;          //Por defecto cuando se cree el hotno siempre estara vacio
    
    //Contructor
    //Contructor vacio
    //Contructores alternativos o sobrecargados
    
    
    //Getters
    public int getIdentificador(){return identificador;}
    public int getCantidadGalletas(){return cantidadGalletas;}
    public boolean getHornoCompleto(){return hornoCompleto;}
    public boolean getHornoVacio(){return hornoVacio;}
    
    
    //Setters
    public void setCantidadGalletas(int _cantidadGalletas){this.cantidadGalletas = _cantidadGalletas;}
    public void setHornoCompleto(boolean _hornoCompleto){this.hornoCompleto = _hornoCompleto;}
    public void setHornoVacio(boolean _hornoVacio){this.hornoVacio = _hornoVacio;}
    
    //To String (Solo si es necesario)
    public String toStringIdentificador()
    {
        return "Horno ["+identificador+"]";
    }
    
    
    
    
    //Metodos de la clase

}
