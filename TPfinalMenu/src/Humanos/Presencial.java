package Humanos;

import Colecciones.CartaComidas;
import Colecciones.ListaMesas;
import Excepciones.*;
import Objetos.Mesa;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Presencial extends Cliente implements Serializable {


    private static final long serialVersionUID = 2l;
    static final String K_CANTIDADPERSONAS = "Cantidad de Personas";
    static final String K_ESPERA = "Espera";
    private int cantPer;
    private boolean espera;

    public Presencial()
    {
        super();
        cantPer=0;
        espera=true;
    }
    public Presencial(String nombre, String apellido, String dni,int cantPer)
    {
        super(nombre,apellido,dni);
        this.cantPer=cantPer;
        espera= true;
    }

    @Override
    public JSONObject code() throws JSONException {
        JSONObject jsonObject = super.code();
        jsonObject.put(K_CANTIDADPERSONAS, getCantidadPersonas());
        jsonObject.put(K_ESPERA, espera);
        return jsonObject;
    }

    /**
     * Pide una mesa, en caso de no haber, usa las excepciones
     *
     */

    /**
     * informa al cliente si tiene espera o no, mediante el uso de una excepcion
     * @param listaMesas
     * @return retorna true si tiene espera, o false si no tiene
     * @throws SinMesasException
     */
    public boolean averiguarEspera(ListaMesas listaMesas)throws SinMesasException
    {
        Mesa mesa=listaMesas.buscarMesa(cantPer);
        if(mesa==null) {
            espera=true;
        }
        else
            espera=false;
        return espera;
    }

    /**
     * Guarda en el arreglo de pedidos, el combo seleccionado
     * @param cartaComidas es para mostrar la carta, y poder recorrerla y asi extraer los combos
     * @param num  es la posicion de donde se encuentra los combos
     */
    @Override
    public void pedirCombo(CartaComidas cartaComidas, int num) throws ComboNoExistenteException {
        super.pedirCombo(cartaComidas, num);
    }

    /**
     *  agrega una comida al pedido(plato principal, postre, guardicion, o bebida) NO AGREGA COMBOS
     *
     * @param num indica que comida es la que va a agregar
     * @param carta es la carta de comidas
     */
    @Override
    public void crearPedido(int num,CartaComidas carta) throws ComidaInexistenteException {
        super.crearPedido(num,carta);
        setCantPedidos();
    }
    /**
     * Muestra todos los pedidos de un cliente determinado
     * @return toString del builder
     */

    @Override
    public String mostrarPedidos() {
        return super.mostrarPedidos();
    }

    /**
     * llama al mostrarPedido de cliente
     * @return
     */


    /**Recorre el array de los pedidos, va sumando el precio
     * y modifica el atributo factura al terminar de sumar
     */
    @Override
    public void calcularFactura() {
         super.calcularFactura();
    }

    @Override
    public double getFactura() {
        return super.getFactura();
    }

    /**elimina ya sea un combo o una comida elegida
     *
     * @param i es en donde se encuentra el combo o la comida q se elige para eliminar
     * @return true si lo elimino, false si no
     */
    @Override
    public boolean eliminar(int i) {
        return super.eliminar(i);
    }


    public boolean getEspera()
    {
        return espera;
    }

    /**
     * Sirve para mostrar un mensaje en la espera
     * @return Un mensaje, dependiendo si tiene o no espera
     */
    public String booleanToString ()
    {
        String rta = "";
        if (espera)
        {
            rta = "El cliente debe aguardar un momento";
        }
        else rta = "No posee espera";
        return rta;
    }
    @Override
    public String toString() {
        return super.toString()+"\nCantidad Personas= " +cantPer+"\nEspera= " +booleanToString();

    }

    public int getCantidadPersonas() {
        return this.cantPer;
    }

    public void setCantPer(int cantPer) {
        this.cantPer = cantPer;
    }

    public void setEspera(boolean espera) {
        this.espera = espera;
    }
}
