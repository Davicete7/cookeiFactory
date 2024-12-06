/**
 * version 1.0
 * contacto --> https://www.linkedin.com/in/david-sanchez-1366b1253/
 * @author David Sánchez
 */


//Paquete al que pertenece la clase
package Server;


//Importes
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.Semaphore;
import ServerInterface.PanelSCM;
import java.io.Serializable;



//CLASE
public class Cafeteria implements Serializable
{
    //Atributos
    private List<Repostero> colaCafeteria = new ArrayList<>();      //La cola en la creacion del objeto estara vacia por defecto
    private ReentrantLock lockColaCafeteria = new ReentrantLock();  
    private Semaphore semaforoClienteAtendido = new Semaphore(1, true);     //Generamos que se atienda solo y solo a un Repostero y que se les atienda en funcion del orden de llegada
    private String reposteroAtendido;
    private String colaReposterosCafeteria;
    
    
    
    //Contructor vacio
    public Cafeteria(){}
    //Contructores alternativos o sobrecargados
    
    
    
    //Getters
    public String getReposteroAtendido(){return reposteroAtendido;}
    public String getColaReposterosCafeteria(){return colaReposterosCafeteria;}
    
    //Setters
    
    //ToString
    public String toStringColaCafeteria()
    {
        String cadena = "";
        for (int indice = 0; indice < colaCafeteria.size(); indice++)
        {
            cadena += colaCafeteria.get(indice).toString() + " --> ";
        }
        
        return cadena;
        
    }
    
    
    //Metodos de la clase
    public void tomarCafe(Repostero repostero)
    {
        //Sacamos el identificador del repostero para usarlo a la hora de cambiar el texto en la interfaz
        int identificadorRepostero = repostero.getIdentificador();
        
        
        //Marcamos como que el repostero acaba de entrar en la cafeteria
        repostero.setAccion("CAFETERÍA");

        
        //Primero nos aseguramos de que la cola sea escrita correctamente
        try
        {
            
            lockColaCafeteria.lock();
            colaCafeteria.add(repostero);
            colaReposterosCafeteria = toStringColaCafeteria();
     
        }
        catch(Error error)
        {
            System.out.println("Se ha producido un error mientras el repostero["+repostero.toStringIdentificador()+"] estaba añadiendose a la cola de la cafeteria --> " + error);
        }
        finally
        {
            //Nos aseguramos de liberar el cerrojo siempre
            lockColaCafeteria.unlock();
        }
        
        //Una vez nos hemos añadido a la cola de la cafeteria adquirimos nuestro Ticket
        //Pidiendo aqui el Ticket nos aseguramos de que no se cuele nadie y el orden se mantenga segun lo imprimimos en el JTextField de la cola de la cafeteria
        try
        {
            semaforoClienteAtendido.acquire();
            //Cuando entro aqui significa que estoy siendo atendido, entonces me quito de la cola y actualizo el texto
            try 
            {
                lockColaCafeteria.lock();
                colaCafeteria.remove(repostero);
                colaReposterosCafeteria = toStringColaCafeteria();
            } 
            catch(Error error)
            {
                System.out.println("Se ha producido un error mientras el repostero["+repostero.toStringIdentificador()+"] estaba quitandose de la cola de la cafeteria --> " + error);
            }
            finally 
            {
                lockColaCafeteria.unlock();
            }
            
            //Estando aqui ya se que puedo marcarme como que estoy siendo atendido
            reposteroAtendido = repostero.toString();
            //Me preparo el cafe
            Thread.sleep(2000);
        }
        catch(InterruptedException error)
        {
            System.out.println("Se ha producido un error mientras el repostero["+repostero.toStringIdentificador()+"] estaba cogiendo un ticket para la cafeteria y preparandose el cafe --> " + error);
        }
        finally
        {
            //Si ocurriese un error muy inesperado nos aseguramos de unlockear el candado
            if(lockColaCafeteria.isLocked()){lockColaCafeteria.unlock();}
            
            //Una vez tengo mi cafe preparado salgo de la cafeteria
            reposteroAtendido = "";
            //Nos aseguramos de confirmar que hemos sido atentidos siempre
            semaforoClienteAtendido.release();  
        }
        
        
        
        
        

    }
}
