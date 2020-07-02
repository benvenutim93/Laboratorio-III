package Excepciones;

public class SinMesasException extends Exception{
    public SinMesasException (String s)
    {
        super ("\033[31m"+s+"\u001B[0m");
    }
}
