package Excepciones;

/**
 * Se usa cuando el usuario ingresa una opcion erronea desde el teclado
 */
public class IngresoInvalidoException extends Exception{

    public IngresoInvalidoException(String a)
    {
        super("\033[31m"+a+"\u001B[0m");
    }
}
