package Excepciones;

/**
 * @author Nicolas
 * Esta excepcion se lanza cuando le pasamos un precio negativo para cambiar
 */
public class PrecioNegativoException extends  Exception{
    public PrecioNegativoException (String s){
        super("\033[31m"+s+"\u001B[0m");
    }
}
