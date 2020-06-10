package LoMio;

import clientes.IdInexistenteMesaException;
import clientes.ListaMesas;
import clientes.SinMesasException;

public class Presencial extends Cliente {

    private int nuMesa;
    private int cantPer;
    private boolean espera;

    public Presencial()
    {
        super();
        nuMesa=0;
        cantPer=0;
        espera=false;
    }
    public Presencial(String nombre, String apellido, String dni,int cantPer)
    {
        super(nombre,apellido,dni);
        this.cantPer=cantPer;
    }

    public void PedirMesa(ListaMesas listaMesas) throws IdInexistenteMesaException, SinMesasException
    {
        int numMesa=0;
        numMesa=listaMesas.ocuparMesa(cantPer);
        setNuMesa(numMesa);
    }

    public void setNuMesa(int nuMesa) {
        this.nuMesa = nuMesa;
    }

    public int getNuMesa() {
        return nuMesa;
    }
}
