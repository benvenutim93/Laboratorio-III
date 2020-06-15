package Objetos;

import java.util.Objects;

public class Mesa {
    private boolean estaOcupado;
    private int capacidad;
    private int idMesa;
    private String nombreCliente;

    //Constructores

    /**
     * Constructor default de la clase.
     * Establece la capacidad de la mesa en 4, y sin estar ocupada.
     */
    public Mesa ()
    {
        capacidad = 4;
        estaOcupado = false;
        idMesa = 1;
        nombreCliente = "";
    }
    public Mesa (int capacidad)
    {
        this.capacidad = capacidad;
        estaOcupado = false;
        idMesa = 1;
        nombreCliente = "";

    }
    public Mesa (int capacidad, boolean estaOcupado)
    {
        this.capacidad = capacidad;
        this.estaOcupado = estaOcupado;
        idMesa = 1;
        nombreCliente = "";
    }
    public Mesa (int capacidad, boolean estaOcupado, int idMesa, String nombreCliente)
    {
        this.capacidad = capacidad;
        this.estaOcupado = estaOcupado;
        this.idMesa = idMesa;
        this.nombreCliente = nombreCliente;
    }

    //Getters y Setters

    public int getCapacidad() {
        return capacidad;
    }

    public boolean isEstaOcupado() {
        return estaOcupado;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setEstaOcupado(boolean estaOcupado) {
        this.estaOcupado = estaOcupado;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * Convierte el booleano atributo de la clase en un mensaje.
     * True esta ocupado, False esta libre.
     * @return Un String diciendo si esta ocupada o libre.
     */
    public String conversionBooleanString () {
        String mensaje = "";
        if (estaOcupado)
            mensaje = "Esta ocupada";
        else
            mensaje = "Esta libre";
        return mensaje;
    }

    @Override
    public String toString() {
        return "Id Mesa: "+getIdMesa()+"\n"+conversionBooleanString()+"\nCapacidad: "+getCapacidad()+"\n";
    }

    /**
     * Verifica la igualdad de las Mesas en base al ID.
     * @param o
     * @return true si son iguales, false si no
     */
    @Override
    public boolean equals(Object o) {
        boolean rta = false;
        if (o != null)
        {
            if (getIdMesa() == ((Mesa)o).getIdMesa())
                rta = true;
        }
        return rta;
    }

    @Override
    public int hashCode() {
        return 17;
    }
}
