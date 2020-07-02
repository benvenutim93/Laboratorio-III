package Excepciones;


public class SentarPersonaException extends Exception{

    public SentarPersonaException()
        {
            super("\033[31m"+"Necesita ubicar al cliente en una mesa primero"+"\u001B[0m");
        }
}

