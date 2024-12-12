/**
 * version 1.0
 * contacto --> https://www.linkedin.com/in/david-sanchez-1366b1253/
 * @author David Sánchez
 */


//Paquete al que pertenece la clase
package Server;





//Importes
import Logger.Logger;
import java.io.Serializable;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;
import Logger.Logger;



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
    private ReentrantLock lockHorno = new ReentrantLock();
    
    


    
    
        //Usaremos este objeto para la aletoridad 
    private Random aleatorio = new Random();
    
    
        //Usaremos este objeto para los logs del sistema
    private Logger log = Logger.getInstance();
    private int contadorLog = 0;
    
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
                    
                //Realizaran esta secuencia entre 3 y 5 veces
                for (int i=0; i <= (3 + aleatorio.nextInt(3)); i++)
                {
                    //Comprobamos si hay paradaManual
                    comprobamosParadaManual();

                    //Producción de la tanda de galletas
                    accion = "PRODUCIENDO";
                    log.log("Repostero["+identificador+"] -->"+accion);
                    Thread.sleep(2000 + aleatorio.nextInt(2001));
                    tandaGalletas = 37 + aleatorio.nextInt(9);
                    totalGalletas += tandaGalletas;
                    log.log("Repostero["+identificador+"] =========> Ha producido "+tandaGalletas+" galletas");

                    //Comprobamos si hay parada manual
                    comprobamosParadaManual();

                    //Depositamos las galletas en cualquier horno disponible
                    accion = "DEPOSITANDO";
                    log.log("Repostero["+identificador+"] -->"+accion);
                    tandaGalletasDesperdiciadas = depositarGalletas(tandaGalletas);
                    
                    //Si se han desperdiciado galletas se registrara en el log
                    if(tandaGalletasDesperdiciadas > 0)
                    {
                        log.log("Repostero["+identificador+"] =========> Ha desperdiciado "+tandaGalletasDesperdiciadas+" galletas");
                    }
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
                log.log("Repostero["+identificador+"] -->"+accion);
                Thread.sleep(3000 + aleatorio.nextInt(3001));
            }
            catch (InterruptedException error)
            {
                System.out.println("Durante la ejecucion del Repostero["+identificador+"] --> " + error);
            }
        }
    }
    
    
    //El metodo implica synchronized para evitar que dos reposteros metan a la vez galletas en el mismo horno
    public int depositarGalletas(int _tandaGalletas)
    {
        //Aqui depositaremos las galletas que se desperdicien
        int _tandaGalletasDesperdiciadas = 0;   //Por defecto ninguna
        
        //Para indicar que ya hemos depositado las galletas en el horno
        boolean depositoTerminado = false;
        
        try
        {
            lockHorno.lock();
            //Antes de elegir el horno en al que vamos a depositar las galletas
            while (!depositoTerminado)
            {
                for(int indexHornos = 0; indexHornos < listaHornos.size(); indexHornos++)
                {
                    if(listaHornos.get(indexHornos).getCantidadGalletas() < listaHornos.get(indexHornos).getCapacidadMaxima() && !listaHornos.get(indexHornos).getEstaHorneando() && !listaHornos.get(indexHornos).getEstaEmpaquetando())
                    {
                        _tandaGalletasDesperdiciadas = listaHornos.get(indexHornos).añadirGalletas(_tandaGalletas);
                        //Registramos cuantas galletas se han depositado en el horno
                        int galletasDepositadasHorno = _tandaGalletas - _tandaGalletasDesperdiciadas;
                        log.log("Repostero["+identificador+"] =========> Ha depositado "+galletasDepositadasHorno+" galletas en el Horno["+listaHornos.get(indexHornos).getIdentificador()+"]");
                        depositoTerminado = true;
                        break;  //Break del bucle for
                    }
                    else
                    {
                        try
                        {
                            Thread.sleep(100);
                        }
                        catch(InterruptedException error)
                        {
                            System.out.println("Durante una espera de seguridad para liberar memoria a la hora de encontrar un horno que no este lleno se a interrumpido la ejecucion de codigo generando el siguiente error --> " + error);
                        }
                    }
                }
            }
        }
        catch (Error error)
        {
            System.out.println("Se ha producido un error en el repostero ["+identificador+"] mientras e le asignaba un horno al que transportar las galletas producidas --> ) + error");
        }
        finally
        {
            //Siempre desbloqueamos el lock de los hornos
            lockHorno.unlock();
        }
        
        return _tandaGalletasDesperdiciadas;
    }
    
    
    
    
    public void comprobamosParadaManual()
    {
        try
        {
            while(paradaManual)
            {
                //Espera activa
                
                //Solo mostramos una vez en el log que esta bloqueado
                if(contadorLog == 0)
                {
                    accion = "BLOQUEADO";
                    log.log("Repostero["+identificador+"] -->"+accion);
                    contadorLog++;
                }
                Thread.sleep(1000);
            }
            //Si pasa por aqui significa que puede escribir el log de que esta bloqueado, entonces
            contadorLog = 0;
        }
        catch(InterruptedException error)
        {
            System.out.println("Se ha producido un error mientras se hacia la espera activa para reanudar el repostero["+identificador+"] --> " + error);
        }
    }
    
}
