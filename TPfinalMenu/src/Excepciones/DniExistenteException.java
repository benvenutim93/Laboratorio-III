package Excepciones;

/**
 * Se usa cuando queres crear un cliente, con un dni que ya esta en uso
 */
public class DniExistenteException extends Exception {


    public DniExistenteException(){
        super("Ya existe un cliente con ese DNI");
    }
}
