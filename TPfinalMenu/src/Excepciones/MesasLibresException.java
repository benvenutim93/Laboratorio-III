package Excepciones;

public class MesasLibresException extends Exception{

    public MesasLibresException(String a)
    {
        super("\033[31m"+a+"\u001B[0m");
    }
}
