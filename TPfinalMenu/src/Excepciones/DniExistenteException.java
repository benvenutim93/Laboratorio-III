package Excepciones;

public class DniExistenteException extends Exception {
    public DniExistenteException(){
        super("Ya existe un cliente con ese DNI");
    }
}
