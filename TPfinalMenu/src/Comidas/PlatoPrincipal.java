package Comidas;

import Interfaces.IPrecio;

import java.io.Serializable;

/**
 * @author  Nicolas
 */
public class PlatoPrincipal extends  Comida implements IPrecio, Serializable
{
    private static final long serialVersionUID = 8l;

    private boolean aptoTacc;
    ///-------------------------------- [C O N S T R U C T O R E S ] --------------------------------

    public PlatoPrincipal(double precio, String nombre, boolean aptoTacc) {
        super(precio, nombre);
        this.aptoTacc = aptoTacc;
    }
    ///-------------------------------- [S E T T E R S /\ G E T T E R S] --------------------------------

    public void setAptoTacc(boolean aptoTacc) {
        this.aptoTacc = aptoTacc;
    }

    public boolean isAptoTacc() {
        return aptoTacc;
    }

    ///-------------------------------- [M E T O D O S] --------------------------------

    /**
     * Devuelve los datos de la comida
     * @return String
     */
    public String datos(){
        return super.getNombre()+(" -> [Libre de TACC: "+isAptoTacc()+ "]");
    }

    @Override
    public double getPrecio() {
        return super.getPrecio();
    }
}
