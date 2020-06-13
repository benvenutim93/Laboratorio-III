package Ejecutable;

import Colecciones.CartaComidas;
import Comidas.*;
import Excepciones.*;
import Humanos.Cliente;
import Humanos.Presencial;
import Humanos.Virtual;
import Menu.MenuPpal;
import  Objetos.Mesa;
import Colecciones.ListaMesas;

import java.util.Scanner;

public class Main {
    static Scanner scan ;

    public static void main(String[] args) {

        scan = new Scanner (System.in);
        MenuPpal.MenuPrincipal(scan);

//        Mesa a = new Mesa (4, false);
//        Mesa b = new Mesa (8, false);
//        Mesa c = new Mesa (6, false);
//        Mesa d = new Mesa (3, false);
//        ListaMesas lista = new ListaMesas(a);
//        lista.addMesa(b);
//        lista.addMesa(c);
//        lista.addMesa(d);
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
//        PlatoPrincipal milanesa= new PlatoPrincipal(250,"Milanesa ",true);
//        PlatoPrincipal milanesaNapo= new PlatoPrincipal(350,"Milanesa Napolitana",true);
//        PlatoPrincipal sorrentinos= new PlatoPrincipal(286,"Sorrentinos",true);
//        PlatoPrincipal pancho= new PlatoPrincipal(130,"Pancho",true);
//        PlatoPrincipal burger= new PlatoPrincipal(320,"Hamburguesa",true);
//
//        Bebida coca = new Bebida(90,"Coca-Cola",true,"fria");
//        Bebida pepsi = new Bebida(85,"Pepsi",true,"fria");
//        Bebida manaos = new Bebida(90,"Manaos de Uva",true,"fria");
//
//        Postre helado = new Postre(125,"Helado",true);
//        Postre flan = new Postre(200,"Flan ",true);
//        Postre ensaladaFrutas = new Postre(150,"Ensala de frutas",true);
//
//        Guarnicion papasFritas = new Guarnicion(65,"Papas Fritas",true);
//        Guarnicion pureDePapa = new Guarnicion(65,"Pure de papa",true);
//        Guarnicion ensalada = new Guarnicion(70,"Ensalada",true);
//
//        Combo combo1=new Combo(milanesa,coca,helado);
//        Combo combo2= new Combo(pancho,manaos);
//        Virtual nico = new Virtual("Nicolas", "Bertuccio", "40256888", "2235897455", "Colon 3030");
//        Presencial rodri = new Presencial("Carlos", "Perez", "42256477", 5);
//
//
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