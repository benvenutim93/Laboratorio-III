package Excepciones;

public class IngresoInvalidoException extends Exception{

    public IngresoInvalidoException(String a)
    {
        super("\033[31m"+a+"\u001B[0m");
    }
}
