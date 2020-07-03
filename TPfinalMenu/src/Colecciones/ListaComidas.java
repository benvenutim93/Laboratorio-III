package Colecciones;

import Comidas.*;
import Interfaces.IOpBasicas;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Nicolas
 */
public class ListaComidas implements IOpBasicas<Comida>, Serializable
{
    private static final long serialVersionUID = 11l;

    static final String K_LISTADOCOMIDA = "Listado Comida";

    private ArrayList<Comida> listaComidas;

    public ListaComidas() {
        this.listaComidas = new ArrayList<Comida>();
    }

///-------------------------------- [M E T O D O S] --------------------------------

    /**
     * Convierte  la ListaComidas en un JSONArray
     * @return JSONArray
     * @throws JSONException
     */
    public JSONArray codeListaComidas() throws JSONException {
        JSONArray jsonArray = new JSONArray();
        for (Comida aux : listaComidas)
            jsonArray.put(aux.code());
        return jsonArray;
    }

    /**
     * Devuelve la lista de comidas
     * @return ListaComidas
     */
    public ArrayList<Comida> getListaComidas() {
        return listaComidas;
    }

    /**
     * Busca la posicion de una comida en el ArrayList
     *
     * @param aBuscar
     * @return posicion de la comida
     */
    public int getPosComida(Comida aBuscar) {
        int rta = -1;
        if (listaComidas.contains(aBuscar)) {
            rta = listaComidas.indexOf(aBuscar);
        }
        return rta;
    }

    /**
     * Restorna una comida del Arraylist
     *
     * @param pos
     * @return Comida
     */
    public Comida getComidapos(int pos) {
        Comida rta = null;
        if (!listaComidas.isEmpty()) {
            rta = listaComidas.get(pos);
        }
        return rta;
    }
    /**
     * Devuelve la cantidad de comidas cargadas.
     * @return int(cantidad de comidas)
     */
    public int getCantComidas()
    {
        return listaComidas.size();
    }

    /**
     * Carga una lista de comida .
     * @param listaComidas (ArrayList<Comida>)
     */
    public void setListaComidas(ArrayList<Comida> listaComidas) {
        this.listaComidas = listaComidas;
    }
    //------------------------------------------listar---------------------

    /**
     * Devuelve todas las Guarniciones cargadas en la Lista de comidas
     * @return String(Guarnicion)
     */
    public String listaGuarnicion() {
        StringBuilder builder = new StringBuilder();
        if (!listaComidas.isEmpty()) {
            for (Comida aux : listaComidas) {
                if (aux instanceof Guarnicion) {

                    builder.append(listaComidas.indexOf(aux) + ". " + aux.toString() + "\n");
                }
            }
        }
        return builder.toString();
    }

    /**
     *Devuelve todas los Postre cargadas en la Lista de comidas
     * @return String(Postre)
     */
    public String listaPostre() {
        StringBuilder builder = new StringBuilder();
        if (!listaComidas.isEmpty()) {
            for (Comida aux : listaComidas) {
                if (aux instanceof Postre) {

                    builder.append(listaComidas.indexOf(aux) + ". " + aux.toString() + "\n");
                }
            }
        }
        return builder.toString();
    }

    /**
     *Devuelve todas las PlatosPrincipales cargadas en la Lista de comidas
     * @return String(PlatosPrincipales)
     */
    public String listaPlatosprincipales() {
        StringBuilder builder = new StringBuilder();
        if (!listaComidas.isEmpty()) {
            for (Comida aux : listaComidas) {
                if (aux instanceof PlatoPrincipal) {

                    builder.append(listaComidas.indexOf(aux) + ". " + aux.toString() + "\n");
                }
            }
        }
        return builder.toString();
    }

    /**
     *Devuelve todas las Bebidas cargadas en la Lista de comidas
     * @return String(Bebidas)
     */
    public String listaBebidas() {
        StringBuilder builder = new StringBuilder();
        if (!listaComidas.isEmpty()) {
            for (Comida aux : listaComidas) {
                if (aux instanceof Bebida) {

                    builder.append(listaComidas.indexOf(aux) + ". " + aux.toString() + "\n");
                }
            }
        }
        return builder.toString();
    }

    /**
     * Lista todas las comidas cargadas.
     * @return String
     */
    @Override
    public String listar() {
        StringBuilder builder = new StringBuilder();
        StringBuilder builderPlato = new StringBuilder();
        StringBuilder builderBebida = new StringBuilder();
        StringBuilder builderPostre = new StringBuilder();
        StringBuilder builderGuarnicion = new StringBuilder();

        if (!listaComidas.isEmpty()) {
            for (Comida aux : listaComidas) {

                if (aux instanceof PlatoPrincipal) {
                    builderPlato.append("\n" + aux.toString());

                }
                if (aux instanceof Bebida) {
                    builderBebida.append("\n" + aux.toString());
                }
                if (aux instanceof Postre) {
                    builderPostre.append("\n" + aux.toString());
                }
                if (aux instanceof Guarnicion) {
                    builderGuarnicion.append("\n" + aux.toString());
                }

            }
            builder.append("----PlatosPrincipales:\n" + builderPlato.toString());
            builder.append("\n\n----Bebidas:\n" + builderBebida.toString());
            builder.append("\n\n----Postres:\n" + builderPostre.toString());
            builder.append("\n\n----Guarniciones:\n" + builderGuarnicion.toString());
        } else {
            builder.append("No hay comidas cargadas ");
        }

        return builder.toString();
    }
    /**
     * Te lista las comidas con su posicion en el arreglo.
     * @return String
     */
    public String listarComidaConPosicion() {
        StringBuilder builder = new StringBuilder();

        if (!listaComidas.isEmpty()) {
            for (Comida aux : listaComidas) {

                if (aux instanceof PlatoPrincipal) {
                    builder.append("\n" + "\033[33m"+listaComidas.indexOf(aux) + "\u001B[0m"+ ". " + aux.toString() + "\n");

                }
                if (aux instanceof Bebida) {
                    builder.append("\n" + "\033[33m"+listaComidas.indexOf(aux) +"\u001B[0m"+ ". " + aux.toString() + "\n");
                }
                if (aux instanceof Postre) {
                    builder.append("\n" + "\033[33m"+listaComidas.indexOf(aux) + "\u001B[0m"+". " + aux.toString() + "\n");
                }
                if (aux instanceof Guarnicion) {
                    builder.append("\n" + "\033[33m"+listaComidas.indexOf(aux) + "\u001B[0m"+". " + aux.toString() + "\n");
                }

            }
        } else {
            builder.append("No hay comidas cargadas ");
        }

        return builder.toString();
    }

//-----------------------------------------------OVERRIDES----------------------------------------------------

    @Override
    /**
     * Agrega una comida al ArrayList sin que este repetida
     * @param nueva (Comida)
     * @return true agregado con exito
     */
    public boolean agregar(Comida obj) {
        boolean rta = false;
        if (!listaComidas.contains(obj)) {
            rta = listaComidas.add(obj);
        }
        return rta;
    }


    /**
     * Elimina una comida de la Lista.
     * @param obj (Comida)
     * @return true si se elimino con exito
     */
    @Override
    public boolean eliminar(Comida obj) {
        boolean rta = false;
        if (!listaComidas.isEmpty()) {
            rta = listaComidas.remove(obj);
        }

        return rta;
    }

}
