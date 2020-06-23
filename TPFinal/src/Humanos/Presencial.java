package Humanos;

import Colecciones.CartaComidas;
import Colecciones.ListaMesas;
import Excepciones.*;
import Objetos.Mesa;

public class Presencial extends Cliente {

    private int cantPer;
    private boolean espera;

    public Presencial()
    {
        super();
        cantPer=0;
        espera=false;
    }
    public Presencial(String nombre, String apellido, String dni,int cantPer)
    {
        super(nombre,apellido,dni);
        this.cantPer=cantPer;
        espera= false;
    }

    /**
     * Pide una mesa, en caso de no haber, usa las excepciones
     *
     */
    public void pedirMesa(ListaMesas listaMesas) throws IdInexistenteMesaException, SinMesasException,CapacidadMaximaException
    {
        listaMesas.ocuparMesa(cantPer, getDNI());
    }

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

    @Override
    public void pedirCombo(CartaComidas cartaComidas, int num) throws ComboNoExistenteException {
        super.pedirCombo(cartaComidas, num);
    }

    @Override
    public void crearPedido(int num,CartaComidas carta) throws ComidaInexistenteException {
        super.crearPedido(num,carta);
    }


    @Override
    public String mostrarPedidos() {
        return super.mostrarPedidos();
    }

    /**
     * llama al mostrarPedido de cliente
     * @return
     */


    @Override
    public double calcularFactura() {
        return super.calcularFactura();
    }

    @Override
    public double getFactura() {
        return super.getFactura();
    }

    @Override
    public boolean eliminar(int i) {
        return super.eliminar(i);
    }


    public boolean getEspera()
    {
        return espera;
    }
    @Override
    public String toString() {
        return super.toString()+"\nCantidad Personas= " +cantPer+"\nEspera= " +espera;

    }

    public int getCantidadPersonas() {
        return this.cantPer;
    }
}
