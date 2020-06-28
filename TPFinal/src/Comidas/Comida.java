package Comidas;

import Excepciones.PrecioNegativoException;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public abstract class Comida implements Serializable {

    static final String K_NOMBRE = "Nombre";
    static final String K_PRECIO = "Precio";

    private double precio;
    private  String nombre;
    ///-------------------------------- [C O N S T R U C T O R E S ] --------------------------------
    public Comida(double precio, String nombre) {
        this.precio = precio;
        this.nombre = nombre;
    }

    public JSONObject code() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(K_NOMBRE, nombre);
        jsonObject.put(K_PRECIO, precio);
        return jsonObject;
    }

    ///-------------------------------- [S E T T E R S /\ G E T T E R S] --------------------------------

    public void cambiarPrecio(double precio) throws PrecioNegativoException  {
        if(precio >= 0 ) {
            this.precio = precio;
        }else {
            throw new PrecioNegativoException("Error : Precio Negativo");
        }
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }
    ///-------------------------------- [M E T O D O S] --------------------------------

    @Override
    public String toString() {
        return "["+nombre+"]"+ "Precio=$ " + precio;



    }
}

