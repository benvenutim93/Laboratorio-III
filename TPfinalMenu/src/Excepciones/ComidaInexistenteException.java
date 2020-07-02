package Excepciones;

/**
 * Esta excepcion se lanza cuando le pasamos una comida que no existe
 */
public class ComidaInexistenteException extends Exception{
    public ComidaInexistenteException(String a)
    {
        super("\033[31m"+a+"\u001B[0m");
    }
}
