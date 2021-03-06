package Excepciones;

/**
 * Esta Excepcion se lanza cuando los integrantes que ingresan al restaurant, superan la capacidad de las mesas
 * que puede proporcionar.
 */
public class CapacidadMaximaException extends Exception {

    public CapacidadMaximaException (String s)
    {
        super ("\033[31m"+s+"\u001B[0m");
    }
}
