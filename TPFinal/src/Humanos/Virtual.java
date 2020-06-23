package Humanos;

import Colecciones.CartaComidas;
import Excepciones.ComboNoExistenteException;
import Excepciones.ComidaInexistenteException;
import Humanos.Cliente;

public class Virtual extends Cliente
{
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

    public void realizarEntrega() {
        entregado=true;
    }
    @Override
    public void pedirCombo(CartaComidas cartaComidas,int num) throws ComboNoExistenteException {
        super.pedirCombo(cartaComidas,num);
    }

    @Override
    public void crearPedido(int num,CartaComidas carta)throws ComidaInexistenteException {
        super.crearPedido(num,carta);
    }

    @Override
    public double calcularFactura() {
        return super.calcularFactura();
    }

    @Override
    public boolean eliminar(int i) {
        return super.eliminar(i);
    }

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

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

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
