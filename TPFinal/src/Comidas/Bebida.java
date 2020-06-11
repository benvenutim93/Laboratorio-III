package Comidas;

public class Bebida extends  Comida {

    private boolean tieneGas;
    private  String temperatura;

    ///-------------------------------- [C O N S T R U C T O R E S ] --------------------------------

    public Bebida(double precio, String nombre, boolean tieneGas, String temperatura) {
        super(precio, nombre);
        this.tieneGas = tieneGas;
        this.temperatura = temperatura;
    }
    ///-------------------------------- [S E T T E R S /\ G E T T E R S] --------------------------------

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public void setTieneGas(boolean tieneGas) {
        this.tieneGas = tieneGas;
    }

    public boolean isTieneGas() {
        return tieneGas;
    }

    public String getTemperatura() {
        return temperatura;
    }

    ///-------------------------------- [M E T O D O S] --------------------------------

    public String datos(){
        return  "\n***********\n"+"Nombre: "+super.getNombre()+"\n"+"Temperatura: "+getTemperatura()+"\n"+"Tiene gas: "+isTieneGas()+"\n***********\n";
    }

}
