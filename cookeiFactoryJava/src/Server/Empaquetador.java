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
public class Empaquetador extends Thread implements Serializable
{
    //Constantes de la clase
    private final int cantidadRecogidaGalletas = 20;
    private final int cantidadEmpaquetadoGalletas = 100;
    
    
    //Atributos de la clase
    private int identificador;
    private Horno horno;        //Los empaquetadores tienen un horno asociado a el
    
    //Contructor
    //Contructor vacio
    //Contructores alternativos o sobrecargados
    
    
    //Getters
    public int getIdentificador(){return identificador;}
    //Setters
    //To String (Solo si es necesario)
    public String toStringIdentificador()
    {
        return "Empaquetador ["+identificador+"]";
    }
    
    
    
    
    //Metodos de la clase
    
}
