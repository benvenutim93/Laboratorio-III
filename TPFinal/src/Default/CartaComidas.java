package Default;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashSet;
import java.util.Iterator;


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
    /**
     * Agrega un combo a la carta (criterio de comparacion  ID )
     * @param agregar (Combo)
     * @return TRUE si fue agregado cin exito
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
    public boolean actualizarPrecioParticular(Combo aCambiar,int nuevoPrecio){
        boolean rta =false;

        Iterator<Combo> it = carta.iterator();
        while (it.hasNext()){
            Combo entrada= (Combo) it.next();
            if(entrada.getNombre().equalsIgnoreCase(aCambiar.getNombre())){
                aCambiar.cambiarPrecio(nuevoPrecio);
                rta=true;
            }

        }

        return rta;
    }
    /**
     * Crea una strind de la carta
     * @return String del  JSonArray
     * @throws JSONException
     */
    public String cargarJson () throws JSONException {
        JSONArray jsonArray = new JSONArray();

        Iterator<Combo> it = carta.iterator();
        while (it.hasNext()){
            Combo entrada= (Combo) it.next();
            //cargo un JsonObj en el array
            jsonArray.put(entrada.crearJson());

        }
        return jsonArray.toString();
    }
//todo revisar si esta bien
    /**
     * Crea un HashSet con los datos del JSON
     * @param aDecodificar (String )
     * @return Devuelve un HashSet con todos los datos del JSON
     * @throws JSONException
     */
    public HashSet<Combo> decodeJson(String aDecodificar)throws JSONException{
        HashSet<Combo> cartita=new HashSet<>();
        JSONArray array= new JSONArray(aDecodificar);
        int i;
        for (i=0;i < array.length();i++){
            JSONObject obj = array.getJSONObject(i);
            String nombre=obj.getString(CLAVE_NOMBRE);
            String descripion=obj.getString(CLAVE_DESCRIPCION);
            double precio = obj.getDouble(CLAVE_PRECIO);
            int id= obj.getInt(CLAVE_ID);

            Combo aux = new Combo(precio,nombre,descripion);
            aux.setiD(id);

            cartita.add(aux);
        }


        return cartita;

    }



}
