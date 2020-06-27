package Excepciones;

public class DniNOexistenteExecption extends  Exception{
    public DniNOexistenteExecption(){
        super("EL DNI no corresponde a ningun cliente");
    }
}
