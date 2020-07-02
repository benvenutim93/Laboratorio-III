package Excepciones;

/**
 * La Excepcion se lanza cuando se quiere liberar una mesa, estando todas estas disponibles (desocupadas)
 */
public class MesasLibresException extends Exception{

    public MesasLibresException(String a)
    {
        super(a);
    }
}
