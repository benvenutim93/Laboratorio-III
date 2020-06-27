package Colecciones;

import Comidas.Combo;
import Excepciones.PrecioNegativoException;
import Interfaces.IOpBasicas;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashSet;
import java.util.Iterator;

public class SetCombo implements IOpBasicas<Combo> {

    static final String K_LISTADOCOMBOS= "Listado Combos";

    private HashSet<Combo> setCombo;

    public SetCombo() {
        this.setCombo = new HashSet<Combo>();
    }

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
    public boolean actualizarPrecioCombo(Combo aCambiar, int nuevoPrecio) throws PrecioNegativoException {
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

    public HashSet<Combo> getCartaCombo() {
        return setCombo;
    }

    public int getCantidad() {
        return setCombo.size();
    }


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

    @Override
    public boolean eliminar(Combo obj) {
        boolean rta = false;
        if (setCombo.contains(obj)) {
            rta = setCombo.remove(obj);

        }
        return rta;
    }
}
