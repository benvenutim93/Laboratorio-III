package Humanos;


import java.util.HashSet;
import java.util.Iterator;

import Colecciones.CartaComidas;
import Colecciones.ListaMesas;
import Comidas.*;
import Excepciones.CapacidadMaximaException;
import Excepciones.ComboNoExistenteException;
import Excepciones.IdInexistenteMesaException;
import Excepciones.SinMesasException;
import Objetos.Pedido;
import Excepciones.ComidaInexistenteException;

public class Cliente extends Persona {

    Pedido pedido;
    private double factura;
    private int cantPedidos;
    CartaComidas cartaComidas= new CartaComidas();

    public Cliente(){
        super();
        pedido=new Pedido();
        factura=0;
        cantPedidos=0;
    }

    public Cliente(String nombre, String apellido, String dni)
    {
        super(nombre,apellido,dni);
        pedido=new Pedido();
        factura=0;
        cantPedidos=0;
    }

    /**
     * Recibe como parametro la carta de comida, y le pide el nombre del combo que desea
     * y lo guarda en el arreglo de pedidos
     * @param cartaComidas es para mostrar la carta, y poder recorrerla y asi extraer los combos/objetos
     */
    public void pedirCombo(CartaComidas cartaComidas, int num) throws ComboNoExistenteException {
        Combo respuesta = null;
        if(num<=cartaComidas.getCantidad()) {
            int nombre = 1;
            HashSet<Combo> carta = cartaComidas.getCarta();
            Iterator<Combo> it = carta.iterator();


            while (it.hasNext()) {
                Combo aux = (Combo) it.next();
                if (aux.getId() == (nombre)) {
                    respuesta = aux;
                }
            }
            if (respuesta != null) {
                pedido.agregar(respuesta);
                setCantPedidos();
            }
        }
        else
            throw new ComboNoExistenteException("El combo ingresado es invalido");
    }

    /** agrega una comida al pedido(plato principal, postre, guardicion, o bebida) NO AGREGA COMBOS
     *
     * @param num indica que comida es la que va a agregar
     */
    public void crearPedido(int num) throws ComidaInexistenteException
    {
        switch (num)
        {
            case 1:
                System.out.println("CASE 1");
                Bebida bebida=new Bebida(15,"agua",false, "natural");
                pedido.agregar(bebida);
                break;
            case 2:
                PlatoPrincipal platoPrincipal= new PlatoPrincipal(100,"milanga",true);
                pedido.agregar(platoPrincipal);
                break;
            case 3:
                Postre postre=new Postre(200,"helado",false);
                pedido.agregar(postre);
                break;
            case 4:
                Guarnicion guarnicion=new Guarnicion(150,"fritas",true);
                pedido.agregar(guarnicion);
                break;
            default:
                throw new ComidaInexistenteException("La opcion ingresada es invalida");

        }

    }

    /**Recorre el array de los pedidos y va sumando el precio
     * seria como un """set"""
     */
    public double calcularFactura()
    {
        factura=0;
        for (int i=0;i< pedido.getTotal();i++)
        {
            if(pedido.getObjeto(i) instanceof Combo) {
                Combo combo = (Combo) pedido.getObjeto(i);
                factura+=combo.getPrecio();
            }
            if(pedido.getObjeto(i) instanceof PlatoPrincipal) {
                PlatoPrincipal platoPrincipal = (PlatoPrincipal) pedido.getObjeto(i);
                factura+=platoPrincipal.getPrecio();
            }
            if(pedido.getObjeto(i) instanceof Bebida) {
                Bebida bebida = (Bebida) pedido.getObjeto(i);
                factura+=bebida.getPrecio();
            }
            if(pedido.getObjeto(i) instanceof Postre) {
                Postre postre = (Postre) pedido.getObjeto(i);
                factura+=postre.getPrecio();
            }
            if(pedido.getObjeto(i) instanceof Guarnicion) {
                Guarnicion guarnicion = (Guarnicion) pedido.getObjeto(i);
                factura+=guarnicion.getPrecio();
            }
        }
        return factura;
    }

    /**elimina ya sea un combo o una comida elegida
     *
     * @param i es en donde se encuentra el combo o la comida q se elige para eliminar
     * @return true si lo elimino, false si no
     */
    public boolean eliminar(int i)
    {
        factura-=pedido.getObjeto(i).getPrecio();
        return pedido.eliminar(pedido.getObjeto(i));
    }
    /**
     * Muestra todos los pedidos de un cliente determinado
     * @return toString del builder
     */
    public String mostrarPedidos()
    {
        StringBuilder buil=new StringBuilder();
        for(int i=0;i< pedido.getTotal();i++){
            buil.append("\n["+i+"]\n");
            if(pedido.getObjeto(i) instanceof Combo) {
                Combo combo = (Combo) pedido.getObjeto(i);
                buil.append(combo.getCombo());
            }
            if(pedido.getObjeto(i) instanceof PlatoPrincipal) {
                PlatoPrincipal platoPrincipal = (PlatoPrincipal) pedido.getObjeto(i);
                buil.append(platoPrincipal.toString());
            }
            if(pedido.getObjeto(i) instanceof Bebida) {
                Bebida bebida = (Bebida) pedido.getObjeto(i);
                buil.append(bebida.toString());
            }
            if(pedido.getObjeto(i) instanceof Postre) {
                Postre postre = (Postre) pedido.getObjeto(i);
                buil.append(postre.toString());
            }
            if(pedido.getObjeto(i) instanceof Guarnicion) {
                Guarnicion guarnicion = (Guarnicion) pedido.getObjeto(i);
                buil.append(guarnicion.toString());
            }
        }
        return buil.toString();
    }

    public  void setCantPedidos() {
        cantPedidos=pedido.getTotal();
    }

    public int getCantPedidos() {
        return cantPedidos;
    }

    public double getFactura() {
        return factura;
    }

    @Override
    public String toString() {
        return  super.toString()+"\nPedidos realizados= "+mostrarPedidos()+"\nFactura= "+factura+"\nCantidad de Pedidos= "+getCantPedidos();
    }


}
