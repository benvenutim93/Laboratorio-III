package Comidas;

import Interfaces.IPrecio;

import java.io.Serializable;

/**
 * @author Nicolas
 */
public class Guarnicion extends Comida implements IPrecio, Serializable
{
    private static final long serialVersionUID = 7l;

    private boolean tieneSal;
    ///-------------------------------- [C O N S T R U C T O R E S ] --------------------------------

    public Guarnicion(double precio, String nombre, boolean tieneSal) {
        super(precio, nombre);
        this.tieneSal = tieneSal;
    }
    ///-------------------------------- [S E T T E R S /\ G E T T E R S] --------------------------------

    /**
     * Le saca la Sal a la comida
     */
    public void sinSal() {
        this.tieneSal = !tieneSal;
    }

    /**
     * Devuelve si tiene sal
     * @return TRUE si tiene
     */
    public boolean isTieneSal() {
        return tieneSal;
    }

    ///-------------------------------- [M E T O D O S] --------------------------------

    /**
     * Devuele los datos de la comida
     * @return String
     */
    public String datos(){
        return super.getNombre()+(" -> [Tiene sal: "+isTieneSal()+"]");
    }

    @Override
    public double getPrecio() {
        return super.getPrecio();
    }
}
