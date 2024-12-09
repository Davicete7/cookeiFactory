/**
 * version 1.0
 * contacto --> https://www.linkedin.com/in/david-sanchez-1366b1253/
 * @author David Sánchez
 */


//Paquete al que pertenece la clase
package Server;


//Importes
import java.io.Serializable;
import java.time.Duration;
import java.util.Random;


//CLASE
public class Empaquetador extends Thread implements Serializable
{
    //Constantes de la clase
    private final int cantidadRecogidaGalletas = 20;
    private final int cantidadEmpaquetadoGalletas = 100;
    
    
    //Atributos de la clase
    private int identificador;
    private int galletasRecogidas = 0;
    private int tandasGalletasRecogidas = 0; 
    private Horno horno;                        //Los empaquetadores tienen un horno asociado a el
    private Almacen almacen;
    private String accion = "ESPERANDO";        //Por defecto cuando se cree el objeto estara esperando
    
    
        //Con esta semilla generaremos la aleatoriedad
    Random aleatorio = new Random();
    
    //Contructor
    public Empaquetador(int _identificador, Almacen _almacen)
    {
        this.identificador = _identificador;
        this.almacen = _almacen;
    }
    //Contructor vacio
    //Contructores alternativos o sobrecargados
    
    
    //Getters
    public int getIdentificador(){return identificador;}
    public String getAccion(){return accion;}
    //Setters
    //To String (Solo si es necesario)
    public String toStringIdentificador()
    {
        return "Empaquetador ["+identificador+"]";
    }
    
    
    
    
    //Metodos de la clase
    public void vaciarHorno(Horno horno)
    {
        boolean hornoVaciado = false;
        
        while(!hornoVaciado)
        {
            try
            {
                accion = "EMPAQUETANDO";
                //Realizamos las tandas de 5 en 5 para que las empaquetemos siempre de 100 en 100
                for(tandasGalletasRecogidas = 0; tandasGalletasRecogidas < 5; tandasGalletasRecogidas++)
                {
                    //Tanda de recogida galletas
                    galletasRecogidas += horno.sacarHorneadoGalletas(cantidadRecogidaGalletas);
                    Thread.sleep(500 + aleatorio.nextInt(1000));
                }
                
                //Empaquetamos las galletas para llevarlas al almacen
                accion = "TRANSPORTANDO";
                Thread.sleep(2000 + aleatorio.nextInt(4000));
                almacen.añadirGalletas(cantidadEmpaquetadoGalletas);
                
                
                
                //Comprobamos si ha terminado de vaciar el horno
                if(galletasRecogidas == horno.getCapacidadMaxima())
                {
                    hornoVaciado = true;
                }
            }
            catch(InterruptedException error)
            {
                System.out.println("Se ha generado un error mientras el empaquetador["+identificador+"] estaba vaciando el Horno["+horno.getIdentificador()+"] --> " + error);
            }
        }
        
        //Como ya ha terminado su vaciado de horno, restauramos las galletas recogidas a 0
        galletasRecogidas = 0;
        accion = "ESPERANDO";
    }
    
}
