package LoMio;

import clientes.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Cliente extends Persona {

    private ArrayList<Combo> pedidos;
    private double factura;
    private int cantPedidos;
    CartaComidas cartaComidas= new CartaComidas();

    public Cliente(){
        super();
        pedidos=null;
        factura=0;
        cantPedidos=0;
    }

    public Cliente(String nombre, String apellido, String dni)
    {
        super(nombre,apellido,dni);
        pedidos= new ArrayList<Combo>();
        factura=0;
        cantPedidos=0;
    }

    /**
     * Recibe como parametro la carta de comida, y le pide el nombre del combo que desea
     * y lo guarda en el arreglo de pedidos
     * @param cartaComidas es para mostrar la carta, y poder recorrerla y asi extraer los combos/objetos
     */
    public void pedirCombo(CartaComidas cartaComidas)
    {
        cartaComidas.listarCarta();
        String nombre= "combo1";
        HashSet<Combo>carta=cartaComidas.getCarta();
        Iterator<Combo> it=  carta.iterator();
        Combo respuesta=null;
        while (it.hasNext())
        {
            Combo aux= (Combo) it.next();
            if(aux.getNombre().equalsIgnoreCase(nombre)) {
                respuesta= aux;
            }
        }
        if(respuesta != null) {
            pedidos.add(respuesta);
            setCantPedidos();
        }
    }

    /**Recorre el array de los pedidos y va sumando el precio
     * seria como un """set"""
     */
    public void calcularFactura()
    {
        for (Combo aux:pedidos)
        {
           factura+=aux.getPrecio();
        }
    }

    /**
     * Muestra todos los pedidos de un cliente determinado
     * @return toString del builder
     */
    public String mostrarPedidos()
    {
        StringBuilder buil=new StringBuilder();
        for(Combo aux:pedidos)
        buil.append(aux.toString());

        return buil.toString();
    }

    public  void setCantPedidos() {
        cantPedidos=pedidos.size();
    }

    public int getCantPedidos() {
        return cantPedidos;
    }

    public double getFactura() {
        return factura;
    }

    @Override
    public String toString() {
        return  super.toString()+"\n Pedidos realizados: "+mostrarPedidos()+"\n factura: "+factura+"\n cantPedidos: "+getCantPedidos();
    }
    public void PedirMesa(ListaMesas listaMesas)throws IdInexistenteMesaException, SinMesasException
    {
    }
}
