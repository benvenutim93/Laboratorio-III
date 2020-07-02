package Excepciones;

/**
 * Esta excepcion se lanza, cuando se quiere buscar una Mesa con un ID que no existe.
 */
public class IdInexistenteMesaException extends Exception{

    public IdInexistenteMesaException(String s)
    {
        super ("\033[31m"+s+"\u001B[0m");
    }
}
