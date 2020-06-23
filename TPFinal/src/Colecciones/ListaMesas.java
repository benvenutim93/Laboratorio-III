package Colecciones;

import Excepciones.CapacidadMaximaException;
import Excepciones.IdInexistenteMesaException;
import Excepciones.SinMesasException;
import Interfaces.IOpBasicas;
import Objetos.Mesa;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import Humanos.*;

import java.util.ArrayList;

public class ListaMesas implements IOpBasicas {
    //Claves JSON
    public static String K_MESA_DNICLIENTE = "Dni Cliente";
    public static String K_MESA_CAPACIDAD = "Capacidad";
    public static String K_MESA_ID = "ID";
    public static String K_MESA_OCUPADO = "Ocupado";
    //Atributos de clase
    private ArrayList<Mesa> listaMesa;



    //Constructores
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

    /**
     * Nos permite conocer la cantidad de mesas
     * @return tamaño de la lista de mesas
     */
    public int cantidadMesas ()
    {
        return listaMesa.size();
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
            aux = listaMesa.get(i);
            if ((aux.getCapacidad() == cantidadPersonas) && (!aux.isEstaOcupado()))
                flag = 1;
            i++;
        }
        if (flag == 0)
            aux = null;
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
            aux = listaMesa.get(i);
            if ((aux.getCapacidad() >= cantidadPersonas) && (!aux.isEstaOcupado()))
                flag = 1;
            i++;
        }
        if (flag == 0)
            aux = null;
        return aux;
    }

    /**
     * Busca una mesa para la cantidad de Personas solicitadas
     * @param cantidadPersonas
     * @return una Mesa
     */

    public Mesa buscarMesa (int cantidadPersonas) throws SinMesasException
    {
        Mesa aux = buscarMesaPorCapacidad(cantidadPersonas);

        if (aux == null)
            aux = buscarMayorCapacidad(cantidadPersonas);

        if (aux == null)
            throw new SinMesasException("No hay mesas disponibles");
        return aux;
    }

    /**
     * Busca una mesa por ID
     * @param id
     * @return La posicion en el ArrayList que ocupa esa mesa
     */

    public int buscarMesaID (int id)
    {
        int flag = 0, i = 0, pos = -1;
        while (i < cantidadMesas() && flag == 0)
        {
            Mesa comparar = listaMesa.get(i);
            if (comparar.getIdMesa() == id)
            {
                flag = 1;
                pos = i;
            }
            i++;
        }
        return pos;
    }

    /**
     * Busca la mesa ocupada por el cliente en cuestion
     * @param dniCliente
     * @return Mesa
     * @throws NullPointerException
     */

    public Mesa buscarMesa (String dniCliente) throws NullPointerException
    {
        Mesa aux = null;
        int i = 0, flag = 0;
        while ((i < cantidadMesas()) && (flag == 0))
        {
            aux = listaMesa.get(i);
            if (aux.getDniCliente().equalsIgnoreCase(dniCliente))
            {
                flag = 1;
            }
        }

        if (aux == null)
            throw new NullPointerException ("El cliente no esta ocupando ninguna mesa");

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
     * @return devuelve el ID de la mesa ocupada
     */

    public void ocuparMesa (int cantidadPersonas, String dni) throws IdInexistenteMesaException, SinMesasException, CapacidadMaximaException
    {
        int idMesa = 0;
        if (capMaximaMesas() >= cantidadPersonas)
        {
            Mesa aux = buscarMesa(cantidadPersonas);
            aux.setEstaOcupado(true);
            idMesa = aux.getIdMesa();
            aux.setDniCliente(dni);
        }
        else throw new CapacidadMaximaException("No tenemos mesa para tantas personas");
    }

    /**
     * Establece el estado de Ocupado en libre a la mesa que le corresponde el ID enviado por parametro
     * Lanza una excepcion si el ID no existe.
     * @param ID
     * @throws IdInexistenteMesaException
     */
    public void liberarMesa (int ID) throws IdInexistenteMesaException
    {
        int pos = buscarMesaID(ID);
        if (pos == -1)
            throw new IdInexistenteMesaException("El ID no existe");
        else
            listaMesa.get(pos).setEstaOcupado(false);
    }

    /**
     * Busca una mesa en el ArrayList por el DNI del Cliente. Una vez encontrada, establece que la mesa está libre.
     * @param dniCliente (String)
     */
    public void liberarMesa (String dniCliente)
    {
        Mesa obj = buscarMesa(dniCliente);
        obj.setEstaOcupado(false);
    }

    /**
     * Busca en el ArrayList de mesas, la mesa con mayor capacidad
     * @return Devuelve la capacidad maxima de la mesa mas grande.
     */

    public int capMaximaMesas ()
    {
        int max = 0;
        for (Mesa a : listaMesa)
        {
            if (a.getCapacidad() > max)
                max = a.getCapacidad();
        }
        return max;
    }

    /**
     * Busca la posicion de una mesa determinada en el ArrayList
     * @param obj (Mesa)
     * @return La posicion de la mesa buscada
     */
    public int buscarPosMesa (Mesa obj)
    {
        int i = 0, pos = -1;
        while ((i < listaMesa.size()) && (pos == -1))
        {
            if (listaMesa.get(i).equals(obj))
            {
                pos = i;
            }
            i++;
        }
        return pos;
    }

    /**
     * Crea un String con los datos del array
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
            obj.put(K_MESA_DNICLIENTE,a.getDniCliente());
            array.put(obj);
        }
        return array.toString();
    }

    /**
     * Recibe un String codificado en JSON, y lo pasa a un ArrayList de Mesas
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
            aux.setDniCliente(obj.getString(K_MESA_DNICLIENTE));

            listadoMesas.add(aux);
        }
        return listadoMesas;
    }

    //Metodos Interfaz

    /**
     * Imprime el listado de todas las mesas agregadas
     * @return string.
     */
    @Override
    public String listar() {
        StringBuilder sb = new StringBuilder ();
        for (Mesa obj : listaMesa)
        {
            sb.append(obj.toString()+"\n");
        }
        return sb.toString();
    }

    /**
     * Método que agrega una mesa en el ArrayList, si esté no fue agregado previamente.
     * @param objMesa
     * @return true si se agrego correctamente, false caso contrario
     */

    @Override
    public boolean agregar(Object objMesa) {
        boolean agregado = false;
        if (objMesa != null) {

            if (objMesa instanceof Mesa) {
                Mesa aux = (Mesa)objMesa;

                aux.setIdMesa(cantidadMesas() + 1);
                listaMesa.add(aux);
                agregado = true;

            }
        }
            return agregado;
    }

    /**
     * Elimina una Mesa del arrayList
     * @param obj
     * @return true si lo elimino correctamente. False caso contrario
     */
    @Override
    public boolean eliminar(Object obj) {
        boolean eliminado = false;
        if (obj != null)
        {
            if (obj instanceof Mesa)
            {
                Mesa aux = (Mesa) obj;
                int pos = buscarPosMesa(aux);
                if (pos != -1)
                {
                    listaMesa.remove(pos);
                    eliminado = true;
                }
            }
        }
        return eliminado;
    }
}
