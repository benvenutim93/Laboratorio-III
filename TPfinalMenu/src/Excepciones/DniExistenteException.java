package Excepciones;

/**
 * Se usa cuando queres crear un cliente, con un dni que ya esta en uso
 */
public class DniExistenteException extends Exception {


    public DniExistenteException(){
        super("\033[31m"+"Ya existe un cliente con ese DNI"+"\u001B[0m");
    }
}
