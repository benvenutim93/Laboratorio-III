package Excepciones;

/**
 * Se usa cuando queres comprobar la existencia de un cliente, y este no es encontrado
 */
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
