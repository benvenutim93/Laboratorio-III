package Default;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListaMesas {
    public static String K_LISTA = "Lista de Mesas";
    public static String K_MESA_CAPACIDAD = "Capacidad";
    public static String K_MESA_ID = "ID";
    public static String K_MESA_OCUPADO = "Ocupado";

    private ArrayList<Mesa> listaMesa;

    public ListaMesas ()
    {
        listaMesa = new ArrayList<Mesa>();
    }

    /**
     * Constructor que crea un ArrayList de Mesas y agrega la Mesa recibida por parámetro al ArrayList
     * @param objMesa
     */
    public ListaMesas (Mesa objMesa)
    {
        listaMesa = new ArrayList<Mesa>();
        listaMesa.add(objMesa);
    }

    public ArrayList<Mesa> getListaMesa() {
        return listaMesa;
    }

    public int cantidadMesas ()
    {
        return listaMesa.size();
    }

    /**
     * Método que agrega una mesa en el ArrayList, si esté no fue agregado previamente.
     * @param objMesa
     * @return true si se agrego correctamente, false caso contrario
     */
    public boolean addMesa (Mesa objMesa)
    {
        boolean agregado = false;
        if (estaAgregado(objMesa))
            agregado = false;
        else
        {
            listaMesa.add(objMesa);
            agregado = true;
        }
        return agregado;
    }

    /**
     * Imprime el listado de todas las mesas agregadas
     * @return string.
     */
    public String imprimirListado ()
    {
        StringBuilder sb = new StringBuilder ();
        for (Mesa obj : listaMesa)
        {
            sb.append(obj.toString()+"\n");
        }
        return sb.toString();
    }

    /**
     * Imprime un listado de mesas libres
     * @return string con todas las mesas libres
     */
    public String imprimirMesasLibres ()
    {
        StringBuilder sb = new StringBuilder ();
                for (Mesa obj : listaMesa)
                {
                    if (!obj.isEstaOcupado())
                    {
                        sb.append(obj.toString()+"\n");
                    }
                }
        return sb.toString();
    }

    /**
     * Busca una mesa libre con la misma capacidad de gente que ingreso.
     * @param cantidadPersonas
     * @return devuelve una mesa libre que tenga la misma capacidad de gente que entro al restaurant o null si no existe
     */
    public Mesa buscarMesaPorCapacidad (int cantidadPersonas)
    {
        int flag = 0, i = 0;
        Mesa aux = null;
        while ((i < cantidadMesas()) && (flag == 0))
        {
            if ((listaMesa.get(i).getCapacidad() == cantidadPersonas) && (!listaMesa.get(i).isEstaOcupado())) {
                aux = listaMesa.get(i);
                flag = 1;
            }
            i++;
        }
        return aux;
    }

    /**
     * Busca una mesa libre con mayor capacidad que la gente que ingreso al Restaurant.
     * @param cantidadPersonas
     * @return Un objeto Mesa con mayor capacidad de la gente que ingreso al Restaurant
     */

    public Mesa buscarMayorCapacidad (int cantidadPersonas)
    {
        int flag = 0, i = 0;
        Mesa aux = null;
        while ((i < cantidadMesas()) && (flag == 0))
        {
            if ((listaMesa.get(i).getCapacidad() > cantidadPersonas) && !listaMesa.get(i).isEstaOcupado()) {
                aux = listaMesa.get(i);
                flag = 1;
            }
            i++;
        }
        return aux;
    }

    /**
     * Busca una mesa para la cantidad de Personas solicitadas
     * @param capacidadPersonas
     * @return una Mesa
     */

    public Mesa buscarMesa (int capacidadPersonas)
    {
        Mesa aux = buscarMesaPorCapacidad(capacidadPersonas);
        if (aux == null)
        {
            aux = buscarMayorCapacidad(capacidadPersonas);
        }
        return aux;
    }

    /**
     * Verifica si la mesa se encuentra en el ArrayList.
     * @param mesa
     * @return true si esta agregada, false si no esta agregada
     */
    public boolean estaAgregado (Mesa mesa)
    {
        boolean existe = false;
        for (Mesa a : listaMesa)
        {
            if (a.equals(mesa))
                existe = true;
        }
        return existe;
    }

    /**
     * Busca una mesa libre apta para el grupo de personas que vino al restaurant.
     * @param cantidadPersonas
     */

    public void ocuparMesa (int cantidadPersonas)
    {
        Mesa aux = buscarMesa(cantidadPersonas);
        aux.setEstaOcupado(true);
    }
    /** Crea un String con los datos del array
     * @return String de Json de la Lista de Mesas
     * @throws JSONException
     */
    public String createJsonString () throws JSONException
    {
        JSONArray array = new JSONArray();

        for (Mesa a : listaMesa)
        {
            JSONObject obj = new JSONObject();
            obj.put(K_MESA_CAPACIDAD, a.getCapacidad());
            obj.put(K_MESA_ID, a.getIdMesa());
            obj.put(K_MESA_OCUPADO, a.isEstaOcupado());

            array.put(obj);
        }

        return array.toString();
    }

    /** Recibe un String codificado en JSON, y lo pasa a un ArrayList de Mesas
     * @param json
     * @return ArrayList <Mesa>
     * @throws JSONException
     */
    public ArrayList <Mesa> decodeJsonString (String json) throws JSONException
    {
        ArrayList<Mesa> listadoMesas = new ArrayList<Mesa>();
        JSONArray array = new JSONArray(json);

        for (int i = 0; i < array.length(); i++)
        {
            JSONObject obj = array.getJSONObject(i);
            Mesa aux = new Mesa ();

            aux.setCapacidad(obj.getInt(K_MESA_CAPACIDAD));
            aux.setEstaOcupado(obj.getBoolean(K_MESA_OCUPADO));
            aux.setIdMesa(obj.getInt(K_MESA_ID));

            listadoMesas.add(aux);
        }

        return listadoMesas;
    }

}
