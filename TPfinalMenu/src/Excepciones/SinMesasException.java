package Excepciones;

/**
 * Esta Excepcion se lanza cuando un cliente llega al Restaurant y no hay mesas disponibles para asignarle.
 */
public class SinMesasException extends Exception{
    public SinMesasException (String s)
    {
        super (s);
    }
}
