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




//CLASE
public class Horno extends Thread implements Serializable
{
    //Contantes de la clase (Bloqueamos la variable con la sentencia final)
    private final int capacidadMaxima = 200;


    //Atributos de la clase
    private Empaquetador empaquetador;          //Su empaquetador asociado
    private int identificador;
    private int cantidadGalletas = 0;           //Por defecto cuando se cree el horno siempre estara vacio
    private int totalGalletasHorneadas = 0;     //Por defecto cuando se cree el horno no llevara ninguna galleta horneada
    private boolean estaHorneando = false;      //Por defecto cuando se cree el horno no estara en proceso de horneado hasta que no se llene
    private boolean estaEmpaquetando = false;
    private String accion;
    
    //Para los logs
    private Logger log = Logger.getInstance();
    
    
    
    //Contructor
    public Horno(int _identificador, Empaquetador _empaquetador)
    {
        this.identificador = _identificador;
        this.empaquetador = _empaquetador;
    }
    //Contructor vacio
    //Contructores alternativos o sobrecargados
    
    
    //Getters
    public int getIdentificador(){return identificador;}
    public int getCantidadGalletas(){return cantidadGalletas;}
    public int getCapacidadMaxima(){return capacidadMaxima;}
    public int getTotalGalletasHorneadas(){return totalGalletasHorneadas;}
    public boolean getEstaHorneando(){return estaHorneando;}
    public boolean getEstaEmpaquetando(){return estaEmpaquetando;}
    public String getAccion(){return accion;}
    public int contadorLog = 0;
    
    
    //Setters
    public void setCantidadGalletas(int _cantidadGalletas){this.cantidadGalletas = _cantidadGalletas;}
    public void setAccion(String _accion){this.accion = _accion;}

    
    //To String (Solo si es necesario)
    public String toStringIdentificador()
    {
        return "Horno ["+identificador+"]";
    } 
    
    //Metodos de la clase
    public int añadirGalletas(int galletas)
    {
        //Una vez que entran aqui significa que hay huecos disponibles
        
        int galletasDesperdiciadas = 0;
        
        if((cantidadGalletas+galletas) <= capacidadMaxima)
        {
            cantidadGalletas += galletas;
        }
        else
        {
            galletasDesperdiciadas = (cantidadGalletas+galletas)-capacidadMaxima;
            cantidadGalletas = capacidadMaxima;
        }
            
            
            
        return galletasDesperdiciadas;
    }
    
    @Override
    public void run()
    {
        try
        {
            //Un horno nunca va a parar de trabajar
            while(true)
            {
                //Solo lo escribimos una vez en el log cada vez que se empieza a llenar
                if(contadorLog == 0)
                {
                    //Si esta aqui significa que esta en estado de llenado
                    accion = "LLENANDOSE";
                    log.log("Horno["+identificador+"] -->"+accion);
                    contadorLog++;
                }
                
                if(cantidadGalletas == capacidadMaxima && !estaHorneando)
                {
                    //Comienza el horneado
                    accion = "HORNEANDO";
                    log.log("Horno["+identificador+"] -->"+accion);
                    estaHorneando = true;
                    Thread.sleep(8000);             //Tardan en hornear la tanda 8000 milisegundos (8 segundos)
                    
                    //Anotamos que las galletas ya estan horneadas
                    totalGalletasHorneadas += capacidadMaxima;
                    
                    //Termina el horneado
                    estaHorneando = false;
                    
                    //Empieza empaquetado, es decir, se empieza a vaciar
                    accion = "VACIANDOSE";
                    log.log("Horno["+identificador+"] -->"+accion);
                    estaEmpaquetando = true;
                    
                    //Avisamos al empaquetador para que vacie el horno
                    empaquetador.vaciarHorno(this);
                    //Ahora esperamos a que se vacie el horno
                    
                    
                    //Termina empaquetado
                    estaEmpaquetando = false;
                    
                    
                    //Cuando termina todo el proceso significa que ya esta vacio por lo que cambiamos el contador del log
                    contadorLog = 0;    
                }
                else
                {
                    //Pequeña espera hasta que vuelva a comprobar si ya esta lleno
                    Thread.sleep(500);
                }
            }
        }
        catch(InterruptedException error)
        {
            System.out.println("Se ha producido un error mientras se ejecutaba el Horno["+identificador+"] --> " + error);
        }
    }
    
    
    public int sacarHorneadoGalletas(int numeroGalletasSacar)
    {
        cantidadGalletas -= numeroGalletasSacar;
       
        return numeroGalletasSacar;
    }

}
