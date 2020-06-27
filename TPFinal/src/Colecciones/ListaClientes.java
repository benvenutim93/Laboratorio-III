package Colecciones;

import Humanos.Cliente;
import Humanos.Persona;
import Humanos.Presencial;
import Humanos.Virtual;
import Interfaces.IOpBasicas;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListaClientes implements IOpBasicas<Cliente>
{
    public static String K_VIRTUALES = "Virtuales";
    public static String K_PRESECIALES = "Presenciales";
    private ArrayList<Cliente>listaClientes;

    public ListaClientes() {
        this.listaClientes = new ArrayList<Cliente>();
    }

    /**
     * Nos permite mostrar nuestra lista de Clientes
     * @return string
     */
    @Override
    public String listar() {
        StringBuilder builder = new StringBuilder();
        for (Cliente aux : listaClientes)
            builder.append(aux.toString()+"\n");
        return builder.toString();
    }

    public JSONObject codeListaClientes() throws JSONException {
        JSONArray virtuales = new JSONArray();
        JSONArray presenciales = new JSONArray();
        JSONObject jsonObject = new JSONObject();

        for (Persona aux : listaClientes){
            if (aux instanceof Virtual)
                virtuales.put(aux.code());
            else if (aux instanceof Presencial)
                presenciales.put(aux.code());

        }
        jsonObject.put(K_VIRTUALES, virtuales);
        jsonObject.put(K_PRESECIALES, presenciales);
        return jsonObject;
    }

    /**
     * Agrega un cleinte a la lista de clientes existente
     * @param obj
     * @return true o false si lo agrego o no respectivamente
     */
    @Override
    public boolean agregar(Cliente obj) {
        boolean rta = false;
        if( (obj != null) && (!listaClientes.contains(obj)) )
        {
            rta = listaClientes.add(obj);
        }
        return rta;
    }

    /**
     * Elimina de la lista de clientes existente el cliente enviado por parametro, si es que existe
     * @param obj
     * @return true o false si lo elimino o no respectivamente
     */
    @Override
    public boolean eliminar(Cliente obj) {
        boolean rta = false;
        if( (obj != null) && (listaClientes.contains(obj)) )
        {
            rta = listaClientes.remove(obj);
        }
        return rta;
    }

    /**
     * Nos dice si un cleinte esta presente en nuestra lista de clientes
     * @param buscado
     * @return true o false si lo encontro o no respectivamente
     */
    public boolean contiene(Cliente buscado){
        boolean rta = false;
        if (buscado != null)
            rta = listaClientes.contains(buscado);
        return rta;
    }

    /**
     * Busca un cliente en nuestra lista por dni
     * @param dni
     * @return null si no lo encontro, sino el objeto en si con todos sus datos
     */
    public Cliente buscarPorDni(String dni){
        Cliente aux = null;;
        int i =0;
        boolean flag = false;

        while ( (i < listaClientes.size()) && (flag == false) )
        {
            aux = listaClientes.get(i);
            if (aux.getDNI().equals(dni))
                flag = true;

            i++;
        }
        if (flag)
        {
            return aux;
        }
        else
            return null;
    }


}