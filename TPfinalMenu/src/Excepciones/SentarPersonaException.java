package Excepciones;

/**
 * Se usa para cuando a un cliente presencial le queres tomar el pedido, pero este todavia
 * no esta asignado a ninguna mesa
 */

public class SentarPersonaException extends Exception{

    public SentarPersonaException()
        {
            super("\033[31m"+"Necesita ubicar al cliente en una mesa primero"+"\u001B[0m");
        }
}

