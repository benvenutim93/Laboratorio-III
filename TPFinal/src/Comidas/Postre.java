package Comidas;

import java.io.Serializable;

public class Postre extends  Comida implements Serializable {
    private boolean topping;
    ///-------------------------------- [C O N S T R U C T O R E S ] --------------------------------

    public Postre(double precio, String nombre, boolean topping) {
        super(precio, nombre);
        this.topping = topping;
    }
    ///-------------------------------- [S E T T E R S /\ G E T T E R S] --------------------------------

    public void sinTopping() {
        this.topping = !topping;
    }

    public boolean isTopping() {
        return topping;
    }

    ///-------------------------------- [M E T O D O S] --------------------------------
    public String datos(){
        return super.getNombre()+"-> [Tiene topping: "+isTopping()+"]";
    }

    @Override
    public double getPrecio() {
        return super.getPrecio();
    }
}
