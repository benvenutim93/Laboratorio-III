package Excepciones;

/**
 * Se usa cuando se intenta buscar un cliente por dni, y este no se encuentra
 */
public class DniNOexistenteExecption extends  Exception{

    public DniNOexistenteExecption(){
        super("EL DNI no corresponde a ningun cliente");
    }
}
