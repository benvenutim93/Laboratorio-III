package Colecciones;

import Comidas.Combo;
import Comidas.Comida;
import Excepciones.CapacidadMaximaException;
import Excepciones.IdInexistenteMesaException;
import Excepciones.SinMesasException;
import Humanos.Cliente;
import Humanos.Presencial;
import Objetos.Mesa;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashSet;

public class Restaurant
{
    static final String K_LISTADOCLIENTES = "Listado Clientes";
    static final String K_LISTADOMESAS = "Listado Mesas";
    static final String K_CARTACOMIDAS = "Carta de Comidas";

    private ListaClientes listaClientes;
    private ListaMesas listaMesas;
    private CartaComidas cartaComidas;

    public Restaurant(){
        this.listaClientes = new ListaClientes();
        this.listaMesas = new ListaMesas();
        this.cartaComidas = new CartaComidas();

    }
    
    public JSONObject codeRestaurant() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(K_LISTADOCLIENTES, listaClientes.codeListaClientes());
        jsonObject.put(K_LISTADOMESAS, listaMesas.codeListaMesas());
        jsonObject.put(K_CARTACOMIDAS, cartaComidas.codeCartaComidas());
        return jsonObject;
    }

    public ListaClientes getListaClientes() {
        return listaClientes;
    }

    public ListaMesas getListaMesas() {
        return listaMesas;
    }

    public CartaComidas getCartaComidas() {
        return cartaComidas;
    }

    public String mostrarListaClientes(){
        return listaClientes.listar();
    }

    public String mostrarListaMesas(){
        return listaMesas.listar();
    }

    public String mostrarCartaComidas(){
        return cartaComidas.listarCompleto();
    }


    //------------------------- <<| M E T O D O S   C O M I D A S |>> ------------------------

    /**
     * Pasamanos-> Agrega una comida nueva a nuestra lista de comidas
     * @param nueva
     * @return true o false si la agrego o no respectivamente
     */
    public boolean agregarComida(Comida nueva){
        return cartaComidas.agregarComida(nueva);
    }

    /**
     * Pasamanos-> Agrega un combo nueva a nuestro set de combos
     * @param nuevo
     * @return true o false si lo agrego o no respectivamente
     */
    public boolean agregarCombo(Combo nuevo){
        return cartaComidas.agregarCombo(nuevo);
    }

    /**
     * Pasamanos-> Nos permite visualizar nuestro set de combos
     * @return string
     */
    public String listarCombos(){
        return cartaComidas.listarCombos();
    }

    /**
     * Pasamanos-> Nos permite visualizar nuestra lista de comidas
     * @return string
     */
    public String listaComidas(){
        return cartaComidas.listarComidas();
    }

    /**
     * Pasamanos-> Cuenta la cantidad de combos en la coleccion
     * @return cantidad de combos
     */
    public int getCantidadCombo(){
        return cartaComidas.getCantidadCombo();
    }

    public HashSet<Combo> getCartaCombo(){
        return cartaComidas.getCartaCombo();
    }

    /**
     * Pasamanos-> Nos permite visualizar tanto nustra lista de combos como todas las comidas individuales disponibles
     * @return string
     */
    public String listarCompleto(){
        return cartaComidas.listarCompleto();
    }

    /**
     * Pasamanos-> Elimina un combo determinado de la coleccion de combos
     * @param aBorrar
     * @return true o false si lo elimino o no respectivamente
     */
    public boolean eliminarCombo(Combo aBorrar){
        return cartaComidas.eliminarCombo(aBorrar);
    }

    /**
     * Pasamanos-> Elimina una comida determinada de la lista de comidas
     * @param aBorrar
     * @return true o false si la elimino o no respectivamente
     */
    public boolean eliminarComida(Comida aBorrar){
        return cartaComidas.eliminarComida(aBorrar);
    }



    //------------------------ <<| M E T O D O S   C L I E N T E S |>> -----------------------

    /**
     * Pasamanos-> Nos permite mostrar nuestra lista de Clientes
     * @return string
     */
    public String listarClientes(){
        return listaClientes.listar();
    }

    /**
     * Pasamanos-> Agrega un cleinte a la lista de clientes existente
     * @param obj
     * @return true o false si lo agrego o no respectivamente
     */
    public boolean agregarCliente(Cliente obj){
        return listaClientes.agregar(obj);
    }

    /**
     * Pasamanos-> Elimina de la lista de clientes existente el cliente enviado por parametro, si es que existe
     * @param obj
     * @return true o false si lo elimino o no respectivamente
     */
    public boolean eliminarCliente(Cliente obj){
        return listaClientes.eliminar(obj);
    }

    /**
     * Pasamanos-> Nos dice si un cleinte esta presente en nuestra lista de clientes
     * @param buscado
     * @return true o false si lo encontro o no respectivamente
     */
    public boolean contieneCliente(Cliente buscado){
        return listaClientes.contiene(buscado);
    }

    /**
     * Pasamanos-> Busca un cliente en nuestra lista por dni
     * @param dni
     * @return null si no lo encontro, sino el objeto en si con todos sus datos
     */
    public Cliente buscarPorDni(String dni){
        return listaClientes.buscarPorDni(dni);
    }

    //--------------------------- <<| M E T O D O S   M E S A S |>> --------------------------

    /**
     * Pasamanos-> Nos permite conocer la cantidad de mesas
     * @return tamaño de la lista de mesas
     */
    public int cantidadMesas (){
        return listaMesas.cantidadMesas();
    }

    /**
     * Pasamanos-> Imprime un listado de mesas libres
     * @return string con todas las mesas libres
     */
    public String imprimirMesasLibres (){
        return listaMesas.imprimirMesasLibres();
    }

    /**
     * Pasamanos-> Busca una mesa libre con la misma capacidad de gente que ingreso.
     * @param cantidadPersonas
     * @return devuelve una mesa libre que tenga la misma capacidad de gente que entro al restaurant o null si no existe
     */
    public Mesa buscarMesaPorCapacidad (int cantidadPersonas){
        return listaMesas.buscarMesaPorCapacidad(cantidadPersonas);
    }

    /**
     * Pasamanos-> Busca una mesa libre con mayor capacidad que la gente que ingreso al Restaurant.
     * @param cantidadPersonas
     * @return Un objeto Mesa con mayor capacidad de la gente que ingreso al Restaurant
     */
    public Mesa buscarMesaMayorCapacidad (int cantidadPersonas){
        return listaMesas.buscarMayorCapacidad(cantidadPersonas);
    }

    /**
     * Pasamanos-> Busca una mesa para la cantidad de Personas solicitadas
     * @param cantidadPersonas
     * @return una Mesa
     */
    public Mesa buscarMesa (int cantidadPersonas) throws SinMesasException{
        return listaMesas.buscarMesa(cantidadPersonas);
    }

    /**
     * Pasamanos-> Busca la mesa ocupada por el cliente en cuestion
     * @param dniCliente
     * @return Mesa
     * @throws NullPointerException
     */
    public Mesa buscarMesa (String dniCliente) throws NullPointerException{
        return  listaMesas.buscarMesa(dniCliente);
    }

    /**
     * Pasamanos-> Busca una mesa por ID
     * @param id
     * @return La posicion en el ArrayList que ocupa esa mesa
     */
    public int buscarMesaID (int id){
        return listaMesas.buscarMesaID(id);
    }

    /**
     * Pasamanos-> Verifica si la mesa se encuentra en el ArrayList.
     * @param mesa
     * @return true si esta agregada, false si no esta agregada
     */
    public boolean estaAgregadoMesa (Mesa mesa){
        return listaMesas.estaAgregado(mesa);
    }

    /**
     * Pasamanos-> Busca una mesa libre apta para el grupo de personas que vino al restaurant.
     * @param persona
     * @return devuelve el ID de la mesa ocupada
     */
    public boolean ocuparMesa (Presencial persona) throws IdInexistenteMesaException, SinMesasException, CapacidadMaximaException{
        return  listaMesas.ocuparMesa(persona);
    }

    /**
     * Pasamanos-> Establece el estado de Ocupado en libre a la mesa que le corresponde el ID enviado por parametro
     * Lanza una excepcion si el ID no existe.
     * @param ID
     * @throws IdInexistenteMesaException
     */
    public void liberarMesa (int ID) throws IdInexistenteMesaException{
        listaMesas.liberarMesa(ID);
    }

    /**
     * Pasamanos-> Busca una mesa en el ArrayList por el DNI del Cliente. Una vez encontrada, establece que la mesa está libre.
     * @param dniCliente (String)
     */
    public void liberarMesa (String dniCliente){
        listaMesas.liberarMesa(dniCliente);
    }

    /**
     * Pasamanos-> Nos permite conocer la cantidad de mesas
     * @return tamaño de la lista de mesas
     */
    public int capMaximaMesas (){
        return listaMesas.cantidadMesas();
    }

    /**
     * Pasamanos-> Busca la posicion de una mesa determinada en el ArrayList
     * @param obj (Mesa)
     * @return La posicion de la mesa buscada
     */
    public int buscarPosMesa (Mesa obj){
        return listaMesas.buscarPosMesa(obj);
    }

    /**
     * Pasamanos-> Imprime el listado de todas las mesas agregadas
     * @return string.
     */
    public String listarMesas(){
        return listaMesas.listar();
    }

    /**
     * Pasamanos-> Método que agrega una mesa en el ArrayList, si esté no fue agregado previamente.
     * @param objMesa
     * @return true si se agrego correctamente, false caso contrario
     */
    public boolean agregarMesa(Object objMesa){
        return listaMesas.agregar(objMesa);
    }

    /**
     * Pasamanos-> Elimina una Mesa del arrayList
     * @param obj
     * @return true si lo elimino correctamente. False caso contrario
     */
    public boolean eliminarMesa(Object obj){
        return listaMesas.eliminar(obj);
    }




}
