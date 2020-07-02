package Excepciones;

public class IdInexistenteMesaException extends Exception{

    public IdInexistenteMesaException(String s)
    {
        super ("\033[31m"+s+"\u001B[0m");
    }
}
