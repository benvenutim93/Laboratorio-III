package Humanos;

import Humanos.Cliente;

public class Virtual extends Cliente
{
    private String telefono;
    private String direccion;
    private boolean entregado;

    public Virtual(String nombre, String apellido, String dni, String telefono, String direccion, boolean entregado) {
        super(nombre, apellido, dni);
        this.telefono = telefono;
        this.direccion = direccion;
        this.entregado = entregado;
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
