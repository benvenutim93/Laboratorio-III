package Colecciones;

import Comidas.*;
import Interfaces.IOpBasicas;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import Excepciones.PrecioNegativoException;

/**
 * @author Nicolas
 */
public class CartaComidas
{
    static final String K_COMBOS = "Combos";
    static final String K_LISTADOCOMIDA = "Listado Comida";

    private SetCombo setCombos;
    private ListaComidas listaComida;

    public CartaComidas(){
        this.listaComida=new ListaComidas();
        this.setCombos=new SetCombo();
    }
///-------------------------------- [M E T O D O S] --------------------------------

    /**
     * Devuelve la lista de comidas .
     * @return ListaComidas(clase)
     */
    public ListaComidas getListaComida ()
    {
        return listaComida;
    }

    /**
     * Devuelve los combos cargados.
     * @return SetCombo(clases)
     */
    public SetCombo getSetCombos ()
    {
        return setCombos;
    }

    /**
     * Crea un Json Object de la clase.
     * @return JSONObject
     * @throws JSONException
     */
    public JSONObject codeCartaComidas() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(K_LISTADOCOMIDA, listaComida.codeListaComidas());
        jsonObject.put(K_COMBOS, setCombos.codeSetCombos());
        return jsonObject;
    }

    /**
     * Agrega una comida nueva a nuestra lista de comidas
     * @param nueva
     * @return true o false si la agrego o no respectivamente
     */
    public boolean agregarComida(Comida nueva){
        return listaComida.agregar(nueva);
    }

    /**
     * Agrega un combo nueva a nuestro set de combos
     * @param nuevo
     * @return true o false si lo agrego o no respectivamente
     */
    public boolean agregarCombo(Combo nuevo){
        return setCombos.agregar(nuevo);
    }

    /**
 * Devuelve la cantidad de combos que hay cargados.
 * @return int
 */
public int getCantidadCombo(){
    return   setCombos.getCantidad();
}

    /**
     * Busca la comida en un lugar especifico del arreglo de comidas
     * @param pos (entero)
     * @return Comida
     */
    public  Comida getComidaPos(int pos){return  listaComida.getComidapos(pos);}

    /**
     * Devuelve un hashset de combos.
     * @return HashSet<Combo>
     */
    public HashSet<Combo> getCartaCombo(){
        return  setCombos.getSetCombo();
    }

    /**
     * Elimina un combo determinado de la coleccion de combos
     * @param aBorrar
     * @return true o false si lo elimino o no respectivamente
     */
    public boolean eliminarCombo(Combo aBorrar){
        return setCombos.eliminar(aBorrar);
    }

    /**
     * Elimina una comida determinada de la lista de comidas
     * @param aBorrar
     * @return true o false si la elimino o no respectivamente
     */
    public boolean eliminarComida(Comida aBorrar){
        return listaComida.eliminar(aBorrar);
    }

    /**
     * Carga una lista de comidas .
     * @param listaComida
     */
    public void setListaComida(ListaComidas listaComida) {
        this.listaComida = listaComida;
    }

    /**
     * Carga el SetCombos .
     * @param setCombos
     */
    public void setSetCombos(SetCombo setCombos) {
        this.setCombos = setCombos;
    }
///-----------------------------------------Listar--------------------------------------
    /**
     * Nos permite visualizar nuestro set de combos
     * @return string
     */
    public String listarCombos(){
        return setCombos.listar();
    }

    /**
     * Nos permite visualizar nuestra lista de comidas
     * @return string
     */
    public String listarComidas(){
        return listaComida.listar();
    }

    /**
     * Cuenta la cantidad de combos en la coleccion
     * @return cantidad de combos
     */


    /**
     * Nos permite visualizar tanto nustra lista de combos como todas las comidas individuales disponibles
     * @return string
     */
    public String listarCompleto(){
        StringBuilder builder=new StringBuilder();
        builder.append("----Combos----:\n"+setCombos.listar());
        builder.append("\n----Comidas----:\n"+listaComida.listar());
        return builder.toString();
    }
    /**
     * Lista las Bebidas con su indice
     * @return String
     */
    public  String listarBebidas(){return listaComida.listaBebidas();}

    /**
     * Lista los postres con su indice
     * @return String
     */
    public  String listarPostres(){return listaComida.listaPostre();}

    /**
     * Lista los platos principales con su indice
     * @return String
     */
    public  String listarPlatosPrincipales(){return listaComida.listaPlatosprincipales();}

    /**
     * Lista las guarniciones con su indice
     * @return String
     */
    public  String listarGuarnicion(){return listaComida.listaGuarnicion();}

    /**
     * Lista la comidas con sus respectivas posiciones
     * @return String
     */
    public String listarComidaConPosicion() {
        return listaComida.listarComidaConPosicion();
    }
    ///-----------------------------------------------------------------


}
