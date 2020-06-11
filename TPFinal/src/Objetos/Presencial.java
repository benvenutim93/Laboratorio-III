package Objetos;


import Excepciones.CapacidadMaximaException;
import Excepciones.IdInexistenteMesaException;
import Colecciones.ListaMesas;
import Excepciones.SinMesasException;

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

    public void PedirMesa(ListaMesas listaMesas) throws IdInexistenteMesaException, SinMesasException,CapacidadMaximaException
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

    @Override
    public String toString() {
        return super.toString()+"\nNumMesa= "+nuMesa+"\nCantidad Personas= " +cantPer+"\nEspera?= " +espera;

    }
}
