package Colecciones;

import Comidas.Combo;
import Excepciones.PrecioNegativoException;
import Interfaces.IOpBasicas;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author Nicolas
 */
public class SetCombo implements IOpBasicas<Combo>, Serializable {

    private static final long serialVersionUID = 12l;

    static final String K_LISTADOCOMBOS= "Listado Combos";

    private HashSet<Combo> setCombo;


    /**
     * CONSTRUCTOR
     */
    public SetCombo() {
        this.setCombo = new HashSet<Combo>();
    }

///-------------------------------- [M E T O D O S] --------------------------------


    /**
     * Crea un json array con los combos que existen
     * @return JSONArray
     * @throws JSONException
     */
    public JSONArray codeSetCombos() throws JSONException {
        JSONArray jsonArray = new JSONArray();
        for (Combo aux : setCombo)
            jsonArray.put(aux.code());
        return jsonArray;
    }

    /**
     * Cambia el precio de un producto en particular (CRITERIO para cambiar NOMBRE).
     *
     * @param aCambiar    (Combo)
     * @param nuevoPrecio (Integer)
     * @return TRUE si se pudo cambiar el nombre - FALSE sino se pudo cambiar
     */
    public boolean actualizarPrecioCombo(Combo aCambiar, double nuevoPrecio) throws PrecioNegativoException {
        boolean rta = false;

        Iterator<Combo> it = setCombo.iterator();
        while (it.hasNext()) {
            Combo entrada = (Combo) it.next();
            if (entrada.getId() == (aCambiar.getId())) {
                aCambiar.cambiarPrecio(nuevoPrecio);
                rta = true;
            }
        }
        return rta;
    }

    /**
     * Devuelve el combo con la Id pasada por parametro
     * @param pos (int)
     * @return
     */
    public Combo getComboPos(int pos) {
     Combo rta=null;
        Iterator<Combo> it = setCombo.iterator();
        while (it.hasNext()) {
            Combo entrada = (Combo) it.next();
            if (entrada.getId() == pos) {
               rta=entrada.getComboComida();

            }
        }
        return rta;
    }

    /**
     * Devuelve el HashSet cargado hasta el momento
     * @return SetCombo(combos)
     *
     */
    public HashSet<Combo> getSetCombo() {
        return setCombo;
    }

    public int getCantidad() {
        return setCombo.size();
    }

    //------------------------------------------listar---------------------

    @Override
    /**
     * Lista el menu
     * @return Carta Completa con todos sus combos
     */
    public String listar() {
        StringBuilder builder = new StringBuilder();
        Iterator<Combo> it = setCombo.iterator();
        while (it.hasNext()) {
            Combo entrada = (Combo) it.next();
            builder.append(entrada.getCombo());
            builder.append("\n");
        }

        return builder.toString();
    }
//-----------------------------------------------OVERRIDES----------------------------------------------------

    /**
     * Agrega un combo a la carta (criterio de comparacion  ID )
     *
     * @param obj (Combo)
     * @return TRUE si fue agregado con exito
     */
    @Override
    public boolean agregar(Combo obj) {
        boolean rta = false;
        rta = setCombo.add(obj);
        return rta;
    }

    /**
     * Elimina un Combo del HashSet.
     * @param  obj
     * @return TRUE si se elimino con exito
     */
    @Override
    public boolean eliminar(Combo obj) {
        boolean rta = false;
        if (setCombo.contains(obj)) {
            rta = setCombo.remove(obj);

        }
        return rta;
    }

    /**
     * Carga el HashSet con uno
     * @param setCombo (HashSet<Combo>)
     */
    public void setSetCombo(HashSet<Combo> setCombo) {
        this.setCombo = setCombo;
    }
}
