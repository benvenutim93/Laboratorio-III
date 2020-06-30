package Comidas;

import Interfaces.IPrecio;

import java.io.Serializable;

public class Bebida extends Comida implements IPrecio, Serializable {

    private static final long serialVersionUID = 4l;
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
        return super.getNombre()+" -> [Temperatura: "+getTemperatura()+"] - [Tiene gas: "+isTieneGas()+"]";
    }

    @Override
    public double getPrecio() {
        return super.getPrecio();
    }
}
