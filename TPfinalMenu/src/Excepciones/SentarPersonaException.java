package Excepciones;


public class SentarPersonaException extends Exception{

    public SentarPersonaException()
        {
            super("Necesita ubicar al cliente en una mesa primero");
        }
}

