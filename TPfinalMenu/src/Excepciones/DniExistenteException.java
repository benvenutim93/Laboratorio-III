package Excepciones;

public class DniExistenteException extends Exception {
    public DniExistenteException(){
        super("\033[31m"+"Ya existe un cliente con ese DNI"+"\u001B[0m");
    }
}
