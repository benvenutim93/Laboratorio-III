package Comidas;

import Excepciones.PrecioNegativoException;
import Interfaces.IPrecio;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * @author Nicolas
 */
public class Combo implements IPrecio, Serializable {

    private static final long serialVersionUID = 5l;
    static final String K_PLATOPRINCIPAL = "Plato Principal";
    static final String K_BEBIDA = "Bebida";
    static final String K_POSTRE = "Postre";
    static final String K_GUARNICION = "Guarnicion";
    static final String K_PRECIO = "Precio";

    private PlatoPrincipal plato;
    private Bebida bebida;
    private Postre postre;
    private Guarnicion guarnicion;
    private double precio;
    private int id;

    public static int idAutoincremental = 0;
    ///-------------------------------- [C O N S T R U C T O R E S ] --------------------------------

    public Combo(PlatoPrincipal plato, Bebida bebida, Postre postre, Guarnicion guarnicion) {
        this.plato = plato;
        this.bebida = bebida;
        this.postre = postre;
        this.guarnicion = guarnicion;
        ponerPrecio();
        this.id = ++idAutoincremental;
    }

    public Combo(PlatoPrincipal plato, Bebida bebida, Postre postre) {
        this.plato = plato;
        this.bebida = bebida;
        this.postre = postre;
        ponerPrecio();
        this.id = ++idAutoincremental;
    }

    public Combo(PlatoPrincipal plato, Bebida bebida, Guarnicion guarnicion) {
        this.plato = plato;
        this.bebida = bebida;
        this.guarnicion = guarnicion;
        ponerPrecio();
        this.id = ++idAutoincremental;
    }
    public Combo(PlatoPrincipal plato, Bebida bebida) {
        this.plato = plato;
        this.bebida = bebida;
        ponerPrecio();
        this.id = ++idAutoincremental;
    }

    public JSONObject code() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(K_PLATOPRINCIPAL, plato.getNombre());
        jsonObject.put(K_BEBIDA, bebida.getNombre());
        jsonObject.put(K_GUARNICION, guarnicion.getNombre());
        jsonObject.put(K_POSTRE, postre.getNombre());
        return jsonObject;
    }

    /**
     * Pone el precio del combo dependiedno de lo que se cargue4.
     */
    private void ponerPrecio() {

        double acum = 0;
        if (plato != null) {
            acum += plato.getPrecio();
        }
        if (bebida != null) {
            acum += bebida.getPrecio();
        }
        if (postre != null) {
            acum += postre.getPrecio();
        }
        if (guarnicion != null) {
            acum += guarnicion.getPrecio();
        }

        this.precio = acum;
    }
    ///-------------------------------- [S E T T E R S /\ G E T T E R S] --------------------------------


    @Override
    public double getPrecio() {
        return precio;
    }

    public int getId() {
        return id;
    }

    ///-------------------------------- [M E T O D O S] --------------------------------
    /**
     * Informacion del combo, como esta compuesto .
     * @return String
     */
    public String getCombo(){
        StringBuilder builder = new StringBuilder();
        builder.append("| -- [ Combo "+this.id+" ]  >> Precio: $"+this.precio+" << -- |\n");

        if(plato != null){
            builder.append("| Plato Principal: "+plato.getNombre()+"\n");
        }
        if(bebida !=null){
            builder.append("| Bebida: "+bebida.getNombre()+"\n");
        }
        if(postre != null){
            builder.append("| Postre: "+postre.getNombre()+"\n");
        }
        if(guarnicion != null){
            builder.append("| Guarnicion: "+guarnicion.getNombre()+"\n");
        }

        return builder.toString();
    }

    /**
     * Muestra todos los datos del combo , si tiene sal,libre de TACC.
     * @return String
     */
    public String getDatosCombo(){
        StringBuilder builder = new StringBuilder();
        builder.append("| -- [ Combo "+this.id+" ]  >> Precio: $"+this.precio+" << -- |\n");

        if(plato != null){
            builder.append("| Plato Principal: "+plato.datos()+"\n");
        }
        if(bebida !=null){
            builder.append("| Bebida: "+bebida.datos()+"\n");
        }
        if(postre != null){
            builder.append("| Postre: "+postre.datos()+"\n");
        }
        if(guarnicion != null){
            builder.append("| Guarnicion"+guarnicion.datos()+"\n");
        }
        return builder.toString();
    }
        //guarnicion

    /**
     * le saca la sal a la comida.
     */
        public void sinSal(){
          guarnicion.sinSal();
        }
        //platoprincipal

    /**
     * Para pooner una comida si es apto para tacc
     * @param b
     */
        public void setAptoTACC(boolean b){
        plato.setAptoTacc(b);
        }
        //postre

    /**
     * Saca el topping del postre
     */
        public void sacarTopping(){
        postre.sinTopping();
        }
        //bebida

    /**
     * Pone el gas de la bebida
     * @param b
     */
        public void ponerGas(boolean b){
        bebida.setTieneGas(b);
        }

    /**
     * pone la temperatura de la bebida
     * @param b
     */
    public void ponerTemperatura(String b){
            bebida.setTemperatura(b);
        }

    /**
     * Cambia el Precio de un combo, tira una excepcion solo si se ingresa un precio negativo o == 0
     * @param precio
     * @throws PrecioNegativoException
     */
    public void cambiarPrecio(double precio) throws PrecioNegativoException {
        if(precio >= 0 ) {
            this.precio = precio;
        }else {
            throw new PrecioNegativoException("Error : Precio Negativo");
        }
    }

    /**
     * Compara el ID del combo
     * @param o
     * @return True si es el mismo combo (ID)
     */
    @Override
    public boolean equals(Object o) {
        boolean rta=false;
        if(o instanceof Combo){
            Combo aux= (Combo)o;
            if(this.id == aux.getId()){
                rta=true;
            }
        }
        return rta;
    }
    @Override
    public int hashCode() {
        return 1;
    }


    /**
     * Devuelve el combo
     * @return Combo
     */
    public Combo getComboComida() {
        return this;
    }
}
