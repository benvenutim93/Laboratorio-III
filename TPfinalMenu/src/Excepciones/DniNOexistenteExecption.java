package Excepciones;

/**
 * Se usa cuando se intenta buscar un cliente por dni, y este no se encuentra
 */
public class DniNOexistenteExecption extends  Exception{

    public DniNOexistenteExecption(){
        super("\033[31m"+"EL DNI no corresponde a ningun cliente"+"\u001B[0m");
    }
}
