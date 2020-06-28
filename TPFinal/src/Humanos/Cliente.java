package Humanos;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import Colecciones.CartaComidas;
import Comidas.*;
import Excepciones.ComboNoExistenteException;
import Objetos.Pedido;
import Excepciones.ComidaInexistenteException;
import org.json.JSONException;
import org.json.JSONObject;

public class Cliente extends Persona implements Serializable {

    static final String K_FACTURA = "Factura" ;
    static final String K_CANTIDADPEDIDOS = "Cantidad de Pedidos" ;

    private Pedido pedido;  //se puede usar transient para que el pedido no se guarde en el archivo
    private double factura;
    private int cantPedidos;


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

    public void setPedido(Pedido nuevo){
        pedido = nuevo;
    }
    @Override
    public JSONObject code() throws JSONException {
        JSONObject jsonObject = super.code();
        jsonObject.put(K_FACTURA, getFactura());
        jsonObject.put(K_CANTIDADPEDIDOS, getCantPedidos());
        return jsonObject;
    }


    /**
     * Recibe como parametro la carta de comida, y le pide el nombre del combo que desea
     * y lo guarda en el arreglo de pedidos
     * @param cartaComidas es para mostrar la carta, y poder recorrerla y asi extraer los combos/objetos
     */
    public void pedirCombo(CartaComidas cartaComidas, int num) throws ComboNoExistenteException {
        Combo respuesta = null;
        if(num<=cartaComidas.getCantidadCombo()) {
            int nombre = 1;
            HashSet<Combo> carta = cartaComidas.getCartaCombo();
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
    public void crearPedido(int num,CartaComidas carta) throws ComidaInexistenteException
    {
        Scanner scan= new Scanner(System.in);
        int numero=0;
        switch (num)
        {
            case 1:
                System.out.println(carta.listarBebidas());
                System.out.println("Ingrese el numero de la bebida a elegir");
                numero=scan.nextInt();
                pedido.agregar(carta.getComidaPos(numero));

                break;
            case 2:

                System.out.println(carta.listarPlatosPrincipales());
                System.out.println("Ingrese el numero del plato a elegir");
                numero=scan.nextInt();
                pedido.agregar(carta.getComidaPos(numero));
                break;
            case 3:
                System.out.println(carta.listarPostres());
                System.out.println("Ingrese el numero del postre a elegir");
                numero=scan.nextInt();
                pedido.agregar(carta.getComidaPos(numero));
                break;
            case 4:
                System.out.println(carta.listarGuarnicion());
                System.out.println("Ingrese el numero de la guarnicion a elegir");
                numero=scan.nextInt();
                pedido.agregar(carta.getComidaPos(numero));
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

    @Override
    public boolean equals(Object o) {
        boolean rta=false;
        if(o != null){
            if (o instanceof Cliente){
                Cliente aux = (Cliente)o;
                if(aux.getDNI().equalsIgnoreCase(getDNI())){
                    rta=true;
                }
            }

        }
     return  rta;
    }

    @Override
    public int hashCode() {
        return 3;
    }
}
