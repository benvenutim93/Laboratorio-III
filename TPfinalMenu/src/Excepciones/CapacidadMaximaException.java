package Excepciones;

public class CapacidadMaximaException extends Exception {

    public CapacidadMaximaException (String s)
    {
        super ("\033[31m"+s+"\u001B[0m");
    }
}
