package Excepciones;

public class ClienteInexistenteException extends Exception {

    private  String dni;

    public ClienteInexistenteException(String dni){
        super("Cliente inexistente");
        this.dni=dni;

    }

    public String getDni() {
        return dni;
    }
}
