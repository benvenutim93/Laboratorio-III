package Ejecutable;

import Colecciones.CartaComidas;
import Colecciones.Restaurant;
import Comidas.*;
import Excepciones.*;
import Humanos.Cliente;
import Humanos.Presencial;
import Humanos.Virtual;
import Menu.*;
import  Objetos.Mesa;
import Colecciones.ListaMesas;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Scanner;

public class Main {
    static Scanner scan ;

    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant();

        PlatoPrincipal milanesa= new PlatoPrincipal(250,"Milanesa ",true);
        PlatoPrincipal milanesaNapo= new PlatoPrincipal(350,"Milanesa Napolitana",true);
        PlatoPrincipal sorrentinos= new PlatoPrincipal(286,"Sorrentinos",true);
        PlatoPrincipal pancho= new PlatoPrincipal(130,"Pancho",true);
        PlatoPrincipal burger= new PlatoPrincipal(320,"Hamburguesa",true);

        Bebida coca = new Bebida(90,"Coca-Cola",true,"fria");
        Bebida pepsi = new Bebida(85,"Pepsi",true,"fria");
        Bebida manaos = new Bebida(90,"Manaos de Uva",true,"fria");

        Postre helado = new Postre(125,"Helado",true);
        Postre flan = new Postre(200,"Flan ",true);
        Postre ensaladaFrutas = new Postre(150,"Ensala de frutas",true);

        Guarnicion papasFritas = new Guarnicion(65,"Papas Fritas",true);
        Guarnicion pureDePapa = new Guarnicion(65,"Pure de papa",true);
        Guarnicion ensalada = new Guarnicion(70,"Ensalada",true);

        scan = new Scanner (System.in);
        restaurant.agregarComida(manaos);
        restaurant.agregarComida(milanesa);
        restaurant.agregarComida(helado);
        restaurant.agregarComida(pureDePapa);
        restaurant.agregarComida(milanesaNapo);
        restaurant.agregarComida(pancho);
        restaurant.agregarComida(burger);
        restaurant.agregarComida(ensaladaFrutas);
        restaurant.agregarComida(ensalada);

        Presencial nico= new Presencial("Nico","Bertu","543453123",5);
        Presencial marian = new Presencial("Marian","Benv","54253",2);
        Virtual lau = new Virtual("Lautaro", "Fullone", "43317286", "476965", "Espa 3571" );
        Virtual rodri = new Virtual("Rodri", "Perez", "5454521", "548525", "Lejos123");

        restaurant.agregarCliente(nico);
        restaurant.agregarCliente(lau);
        restaurant.agregarCliente(marian);
        restaurant.agregarCliente(rodri);

        //MenuPpal.MenuPrincipal(scan,restaurant);

        Mesa a = new Mesa (4, false);
        Mesa b = new Mesa (8, false);
        Mesa c = new Mesa (6, false);
        Mesa d = new Mesa (3, false);

        restaurant.agregarMesa(a);
        restaurant.agregarMesa(b);
        restaurant.agregarMesa(c);
        restaurant.agregarMesa(d);

        Combo combo1 = new Combo(milanesa, coca, helado, papasFritas);
        Combo combo2 = new Combo(sorrentinos, pepsi, flan, pureDePapa);

        restaurant.agregarCombo(combo1);
        restaurant.agregarCombo(combo2);

        try {
            JSONObject jsonObject = restaurant.codeRestaurant();
            System.out.println(jsonObject.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }

/*
        lista.eliminar(b);
        System.out.println(lista.listar());
//
//        System.out.println(lista.imprimirListado());
//
////        Mesa aux = new Mesa ();
////
////        try {
////            lista.ocuparMesa(6);
////            System.out.println(lista.imprimirListado());
////
////            lista.liberarMesa(3);
////            System.out.println(lista.imprimirListado());
////        }
////        catch (IdInexistenteMesaException e)
////        {
////            System.out.println(e.getMessage());
////        }
////        catch (SinMesasException e)
////        {
////            System.out.println(e.getMessage());
////        }
////

//        CartaComidas carta= new CartaComidas();
//
//        carta.agregarCombo(combo1);
//        carta.agregarCombo(combo2);
//
//      /*  System.out.println(nico.toString());
//        System.out.println("---------------------------------");
//        System.out.println(rodri.toString());
//        */
//
//        try {
//            rodri.PedirMesa(lista);
//            rodri.PedirMesa(lista);
//            lista.liberarMesa(2);
//            if(!rodri.averiguarEspera(lista))
//            {
//                System.out.println("Usted no tiene espera");
//            }
//            if(rodri.getNuMesa()!=0)
//            {
//                rodri.pedirCombo(carta,1);
//                rodri.crearPedido(10);
//                System.out.println(rodri.mostrarPedidos());
//                System.out.println("factura"+rodri.calcularFactura());
//                rodri.eliminar(1);
//                System.out.println(rodri.mostrarPedidos());
//                System.out.println("factura"+rodri.calcularFactura());
//
//            }
//
//        }
//        catch (SinMesasException aa)
//        {
//            System.out.println(aa.getMessage());
//        }
//        catch (CapacidadMaximaException e) {
//            e.printStackTrace();
//        }
//        catch (IdInexistenteMesaException e) {
//            e.printStackTrace();
//        }
//        catch (ComboNoExistenteException e)
//        {
//            System.out.println(e.getMessage());
//        }
//        catch (ComidaInexistenteException e)
//        {
//            System.out.println(e.getMessage());
//        }
//
    }

}