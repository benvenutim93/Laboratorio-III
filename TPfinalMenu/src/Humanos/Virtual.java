package Humanos;

import Colecciones.CartaComidas;
import Excepciones.ComboNoExistenteException;
import Excepciones.ComidaInexistenteException;
import Humanos.Cliente;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Virtual extends Cliente implements Serializable {

    private static final long serialVersionUID = 3l;
    static final String K_TELEFONO = "Telefono";
    static final String K_DIRECCION = "Direccion";
    static final String K_ENTREGADO = "Entregado";

    private String telefono;
    private String direccion;
    private boolean entregado;

    public Virtual ()
    {
        super ();
        telefono = "";
        direccion = "";
        entregado = false;
    }

    public Virtual(String nombre, String apellido, String dni, String telefono, String direccion) {
        super(nombre, apellido, dni);
        this.telefono = telefono;
        this.direccion = direccion;
        this.entregado = false;
    }

    @Override
    public JSONObject code() throws JSONException {
        JSONObject jsonObject = super.code();
        jsonObject.put(K_TELEFONO, telefono);
        jsonObject.put(K_ENTREGADO, entregado);
        jsonObject.put(K_DIRECCION, direccion);
        return jsonObject;
    }

    /**
     * Cambia el estado del atributo "entregado" a true
     */
    public void realizarEntrega() {
        entregado=true;
    }
    /**
     * Guarda en el arreglo de pedidos, el combo seleccionado
     * @param cartaComidas es para mostrar la carta, y poder recorrerla y asi extraer los combos
     * @param num  es la posicion de donde se encuentra los combos
     */
    @Override
    public void pedirCombo(CartaComidas cartaComidas,int num) throws ComboNoExistenteException {
        super.pedirCombo(cartaComidas,num);
        setCantPedidos();
    }

    /**
     *  agrega una comida al pedido(plato principal, postre, guardicion, o bebida) NO AGREGA COMBOS
     *
     * @param num indica que comida es la que va a agregar
     * @param carta es la carta de comidas
     */
    @Override
    public void crearPedido(int num,CartaComidas carta)throws ComidaInexistenteException {
        super.crearPedido(num,carta);
        setCantPedidos();
    }

    /**Recorre el array de los pedidos, va sumando el precio
     * y modifica el atributo factura al terminar de sumar
     */
    @Override
    public void calcularFactura() {
        super.calcularFactura();
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

    /**
     * Muestra todos los pedidos de un cliente determinado
     * @return toString del builder
     */
    @Override
    public String mostrarPedidos() {
        return super.mostrarPedidos();
    }


    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String calle, String altura) {
        this.direccion = calle +" "+altura;
    }

    /**
     * @return el atributo entregado del cliente
     */
    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    @Override
    public String toString() {
        return super.toString()+ "\nTelefono= " +telefono+"\nDireccion= " +direccion+"\nEntregado= " + entregado;
    }


}
