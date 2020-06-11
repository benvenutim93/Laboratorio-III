package Colecciones;



import Comidas.Combo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashSet;
import java.util.Iterator;
import Excepciones.PrecioNegativoException;

public class CartaComidas {
    static final String CLAVE_PRECIO ="precio";
    static final String CLAVE_NOMBRE ="nombre";
    static final String CLAVE_DESCRIPCION ="descripcion";
    static final String CLAVE_ID ="id";
    private HashSet<Combo> carta;


    public CartaComidas() {
        this.carta =new HashSet<Combo>();
    }
///-------------------------------- [M E T O D O S] --------------------------------
    public HashSet<Combo>getCarta(){
        return carta;
    }
    /**
     * Agrega un combo a la carta (criterio de comparacion  ID )
     * @param agregar (Combo)
     * @return TRUE si fue agregado con exito
     */
    public boolean agregarCombo(Combo agregar){
        boolean rta=false;
        rta =carta.add(agregar);
        return rta;
    }
    /**
     * Lista el menu
     * @return Carta Completa con todos sus combos
     */
    public String listarCarta(){
        StringBuilder builder = new StringBuilder();
        Iterator<Combo> it = carta.iterator();
        while (it.hasNext()){
            Combo entrada= (Combo) it.next();
            builder.append(entrada.toString());
            builder.append("\n");
        }

        return builder.toString();
    }

    /**
     * Cambia el precio de un producto en particular (CRITERIO para cambiar NOMBRE).
     * @param aCambiar (Combo)
     * @param nuevoPrecio (Integer)
     * @return TRUE si se pudo cambiar el nombre - FALSE sino se pudo cambiar
     *
     *
     *
     */
    public boolean actualizarPrecioParticular(Combo aCambiar, int nuevoPrecio) throws PrecioNegativoException{
        boolean rta =false;

        Iterator<Combo> it = carta.iterator();
        while (it.hasNext()){
            Combo entrada= (Combo) it.next();
            if(entrada.getId()==(aCambiar.getId())){
                aCambiar.cambiarPrecio(nuevoPrecio);
                rta=true;
            }

        }
        return rta;
    }






}
