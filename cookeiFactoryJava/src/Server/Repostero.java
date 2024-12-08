/**
 * version 1.0
 * contacto --> https://www.linkedin.com/in/david-sanchez-1366b1253/
 * @author David Sánchez
 */


//Paquete al que pertenece la clase
package Server;





//Importes
import java.io.Serializable;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;



//CLASE
public class Repostero extends Thread implements Serializable
{
    //Atributos de la clase
    private int identificador;
    
        //Con este jTextField podremos mostrar en la interfaz diferentes textos sobre los reposteros    
        //En esta ArrayList almacenaremos los horno de manera ordenada
    private List<Horno> listaHornos;

    
        //Este stributo se utilizara para mandar la accion que esta realizando el repostero a la interfaz a la interfaz
    private String accion;
    
    
        //Atributos de producción
    private int totalGalletas = 0;                  //Cuando se crea el repostero aun no ha creado ninguna galleta
    private int totalGalletasDesperdiciadas = 0;    //Cuando se crea el repostero aun no ha desperdiciado ninguna galleta
    private int tandaGalletas;
    private int tandaGalletasDesperdiciadas;
    private boolean pausaCafe = false;              //Por defecto al crearse el repostero primero debera de hacer una tanda de galletas antes de descansar
    
        //Para la cafeteria
    private Cafeteria cafeteria;
    
        //Usamos estos atributos para generar la pausa del hilo
    private boolean paradaManual = false;       //Por defecto la parada manual se pondra a true despues de crear el hilo
    private ReentrantLock lock = new ReentrantLock();
    
    //Contructor 
    public Repostero(int _identificador, List<Horno> _listaHornos,Cafeteria _cafeteria)
    {
        this.identificador = _identificador;
        this.listaHornos = _listaHornos;
        this.cafeteria = _cafeteria;
    }
    
    //Contructor vacio [NO HAREMOS USO DE ESTE]
    //Contructores alternativos o sobrecargados [NO HAREMOS USO DE ESTOS]
    
    
    //Getters
    public int getTotalGalletas(){return totalGalletas;}
    public int getTotalGalletasDesperdiciadas(){return totalGalletasDesperdiciadas;}
    public int getIdentificador(){return identificador;}
    public boolean getParadaManual(){return paradaManual;}
    public ReentrantLock getLock(){return lock;}
    public String getAccion(){return accion;}
    

    //Setters
    public void setParadaManual(boolean _paradaManual){this.paradaManual = _paradaManual;}
    public void setAccion(String _accion){this.accion = _accion;}
    
    
    
    //To String (Solo si es necesario)
    public String toStringIdentificador()
    {
        return String.valueOf(identificador);
    }
    
    @Override
    public String toString()
    {
        return "Repostero ["+identificador+"]";
    }
    
    
    
    //Metodos de la clase
    @Override
    public void run()
    {
        //Los reposteros nunca dejaran de trabajar
        while (true)
        {
            try{
                //Usaremos este objeto para la aletoridad de las esperas 
                    Random aleatorio = new Random();
                    
                //Realizaran esta secuencia entre 3 y 5 veces
                for (int i=0; i <= (3 + aleatorio.nextInt(3)); i++)
                {
                    //Comprobamos si hay paradaManual
                    comprobamosParadaManual();

                    //Producción de la tanda de galletas
                    accion = "PRODUCIENDO";
                    Thread.sleep(2000 + aleatorio.nextInt(2001));
                    tandaGalletas = 37 + aleatorio.nextInt(9);
                    totalGalletas += tandaGalletas;

                    //Comprobamos si hay parada manual
                    comprobamosParadaManual();

                    //Depositamos las galletas en cualquier horno disponible
                    accion = "DEPOSITANDO";
                    tandaGalletasDesperdiciadas = 0;//Aqui devolveriamos con el metodo de llamada a dejar las galletas en el horno las galletas que se han desperdiciado
                    totalGalletasDesperdiciadas += tandaGalletasDesperdiciadas;

                    
                    
                }
                
                //Comprobamos si hay parada manual
                comprobamosParadaManual();
                
                //Parada para el cafe
                cafeteria.tomarCafe(this);              //Le pasamos el propio hilo a la cafeteria
                
                
                
                //Comprobamos si hay parada manual
                comprobamosParadaManual();
                
                //Descanso hasta que vuelvan a generar más tandas de galletas
                accion = "DESCANSANDO";
                Thread.sleep(3000 + aleatorio.nextInt(3001));
            }
            catch (InterruptedException error)
            {
                System.out.println("Durante la ejecucion del Repostero["+identificador+"] --> " + error);
            }
        }
    }
    
    
    
    
    public void comprobamosParadaManual()
    {
        try
        {
            lock.lock();
            if (paradaManual)
            {
                accion = "BLOQUEADO";
                lock.wait();
            }
        }
        catch(InterruptedException error)
        {
            System.out.println("Ha ocurrido un error mientas se paraba manualmente el Repostero["+identificador+"] -->" + error);
        }
        finally
        {
            //Nos aseguramos de que siempre de desbloque el candado aunque ocurra un error
            lock.unlock();
        }
            
        //Si no se mete en el condicional entonces no se ha solicitado la parada manual
    }
    
}
