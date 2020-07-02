package Excepciones;

/**
 * Esta excepcion se lanza cuando le pasamos una combos que no existe
 */
public class ComboNoExistenteException extends Exception{
    public ComboNoExistenteException(String s)
    { super("\033[31m"+s+"\u001B[0m");
    }
}
