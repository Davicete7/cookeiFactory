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
import Logger.Logger;

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
    private Random aleatorio = new Random();
    
    
        //Para los logs
    private Logger log = Logger.getInstance();
    
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
    public int getTandasGalletasRecogidas(){return tandasGalletasRecogidas;}
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
                //Antes de empezar a empaquetar no habra recogido ninguna tanda aun
                tandasGalletasRecogidas = 0;
                accion = "EMPAQUETANDO";
                log.log("Empaquetador["+identificador+"] -->"+accion);
                //Realizamos las tandas de 5 en 5 para que las empaquetemos siempre de 100 en 100
                for(tandasGalletasRecogidas = 1; tandasGalletasRecogidas < 6; tandasGalletasRecogidas++)
                {
                    //Tanda de recogida galletas
                    galletasRecogidas += horno.sacarHorneadoGalletas(cantidadRecogidaGalletas);
                    log.log("Empaquetador["+identificador+"] =========> Ha sacado "+cantidadRecogidaGalletas+" galletas del Horno["+horno.getIdentificador()+"]");
                    Thread.sleep(500 + aleatorio.nextInt(1000));
                }
                
                
                //Empaquetamos las galletas para llevarlas al almacen
                accion = "TRANSPORTANDO";
                log.log("Empaquetador["+identificador+"] -->"+accion);
                //Cuando termina de transportar, las tandas recogidas vuelve a ser 0
                tandasGalletasRecogidas = 0;
                Thread.sleep(2000 + aleatorio.nextInt(4000));
                almacen.añadirGalletas(cantidadEmpaquetadoGalletas);
                log.log("Empaquetador["+identificador+"] =========> Ha transportado "+cantidadEmpaquetadoGalletas+" galletas  al almacen");
                    
                
                
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
        log.log("Empaquetador["+identificador+"] -->"+accion);
    }
    
}


