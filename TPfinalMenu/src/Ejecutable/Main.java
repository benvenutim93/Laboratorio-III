package Ejecutable;

import Archivos.Archivador;
import Colecciones.ListaClientes;
import Colecciones.ListaMesas;
import Colecciones.Restaurant;
import Colecciones.SetCombo;
import Comidas.*;
import Humanos.Cliente;
import Humanos.Presencial;
import Humanos.Virtual;
import Menu.MenuPpal;
import  Objetos.Mesa;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.EOFException;
import java.io.IOException;
import java.util.Scanner;
import java.util.spi.AbstractResourceBundleProvider;

public class Main {
    static Scanner scan ;

    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant();
        scan = new Scanner (System.in);
/*
        //Plantos principal
        PlatoPrincipal milanesa= new PlatoPrincipal(250,"Milanesa",true);
        PlatoPrincipal milanesaNapo= new PlatoPrincipal(350,"Milanesa Napolitana",true);
        PlatoPrincipal milanesaCaballo= new PlatoPrincipal(325,"Milanesa Caballo",true);
        PlatoPrincipal hamburguesa= new PlatoPrincipal(250,"Hamburguesa",true);
        PlatoPrincipal pancho= new PlatoPrincipal(130,"Pancho",true);
        PlatoPrincipal choripan= new PlatoPrincipal(100,"Choripan",true);
        PlatoPrincipal sangucheCarne= new PlatoPrincipal(220,"Sanguche de Carne",true);
        PlatoPrincipal asadoDeTofu= new PlatoPrincipal(390,"Asado de Tofu",true);
        PlatoPrincipal pechugaAlaPlancha= new PlatoPrincipal(230,"Pechuga a la Plancha",true);
        PlatoPrincipal morcilla= new PlatoPrincipal(120,"Morcilla",true);
        //Bebidas
        Bebida coca = new Bebida(90,"Coca-Cola",true,"fria");
        Bebida pepsi = new Bebida(85,"Pepsi",true,"fria");
        Bebida manaosDeUva = new Bebida(60,"Manaos de Uva",true,"fria");
        Bebida sprite = new Bebida(92,"Sprite",true,"fria");
        Bebida pasoDelosToros = new Bebida(95,"Paso de los Toros",true,"fria");
        Bebida agua = new Bebida(80,"Agua",false,"fria");
        Bebida aguaSaborizada = new Bebida(100,"Agua saborizada",true,"fria");
        Bebida soda = new Bebida(75,"Soda",true,"fria");
        Bebida te = new Bebida(70,"Te",false,"Caliente");
        Bebida cafe = new Bebida(75,"Cafe",false,"Caliente");
        //Postre.
        Postre helado = new Postre(125,"Helado",true);
        Postre flan = new Postre(200,"Flan ",true);
        Postre ensaladaFrutas = new Postre(150,"Ensala de frutas",true);
        Postre bombonSuizo = new Postre(200,"Bombon Suizo ",true);
        Postre gelatina = new Postre(200,"Gelatina ",true);
        Postre postreChocolate = new Postre(200,"Postre Chocolate ",true);
        Postre brownie = new Postre(200,"Brownie ",true);
        Postre lemonPie = new Postre(200,"Lemon Pie ",true);
        Postre vigilante = new Postre(200,"Vigilante ",true);
        Postre postrBalcarce = new Postre(200,"Postre Balcarse ",true);
        //Guarniciones
        Guarnicion papasFritas = new Guarnicion(65,"Papas Fritas",true);
        Guarnicion papasNoisette = new Guarnicion(65,"Papas Noisette",true);
        Guarnicion papasPays = new Guarnicion(65,"Papas Pays",true);
        Guarnicion batatasFritas = new Guarnicion(95,"Batatas Fritas",true);
        Guarnicion pureDeZapallo = new Guarnicion(65,"Pure de Zapallo",true);
        Guarnicion pureDePapa = new Guarnicion(65,"Pure de papa",true);
        Guarnicion ensalada = new Guarnicion(70,"Ensalada",true);
        Guarnicion ensaladaRusa=new Guarnicion(100,"Ensalada Rusa",true);
        //Combos
        Combo combo1=new Combo(hamburguesa,pepsi,gelatina,batatasFritas);
        Combo combo2=new Combo(pancho,manaosDeUva,vigilante,pureDePapa);
        Combo combo3=new Combo(milanesaNapo,sprite,helado,papasFritas);
        Combo combo4=new Combo(sangucheCarne,pasoDelosToros,lemonPie,ensalada);
        Combo combo5=new Combo(choripan,soda,brownie,pureDeZapallo);
        Combo combo6=new Combo(morcilla,agua,flan,ensalada);
        Combo combo7=new Combo(milanesaCaballo,sprite,postrBalcarce,papasNoisette);
        Combo combo8=new Combo(pancho,cafe,bombonSuizo,ensalada);
        Combo combo9=new Combo(asadoDeTofu,aguaSaborizada,brownie,papasPays);
        Combo combo10=new Combo(pechugaAlaPlancha,aguaSaborizada,ensaladaFrutas,papasNoisette);

//----------------------------------------Combos-------------------------------------
        restaurant.agregarCombo(combo1);
        restaurant.agregarCombo(combo2);
        restaurant.agregarCombo(combo3);
        restaurant.agregarCombo(combo4);
        restaurant.agregarCombo(combo5);
        restaurant.agregarCombo(combo6);
        restaurant.agregarCombo(combo7);
        restaurant.agregarCombo(combo8);
        restaurant.agregarCombo(combo9);
        restaurant.agregarCombo(combo10);

//----------------------------------------Bebidas-------------------------------------
        restaurant.agregarComida(manaosDeUva);
        restaurant.agregarComida(coca);
        restaurant.agregarComida(pepsi);
        restaurant.agregarComida(te);
        restaurant.agregarComida(agua);
        restaurant.agregarComida(cafe);
        restaurant.agregarComida(sprite);
        restaurant.agregarComida(pasoDelosToros);
        restaurant.agregarComida(soda);
        restaurant.agregarComida(aguaSaborizada);

//----------------------------------------PlatosPrincipales-------------------------------------
        restaurant.agregarComida(milanesa);
        restaurant.agregarComida(milanesaNapo);
        restaurant.agregarComida(pancho);
        restaurant.agregarComida(hamburguesa);
        restaurant.agregarComida(milanesaCaballo);
        restaurant.agregarComida(choripan);
        restaurant.agregarComida(sangucheCarne);
        restaurant.agregarComida(asadoDeTofu);
        restaurant.agregarComida(pechugaAlaPlancha);
        restaurant.agregarComida(morcilla);


//----------------------------------------Guarniciones-------------------------------------
        restaurant.agregarComida(ensalada);
        restaurant.agregarComida(pureDePapa);
        restaurant.agregarComida(batatasFritas);
        restaurant.agregarComida(papasFritas);
        restaurant.agregarComida(papasNoisette);
        restaurant.agregarComida(papasPays);
        restaurant.agregarComida(pureDeZapallo);
        restaurant.agregarComida(ensaladaRusa);
//----------------------------------------Postres-------------------------------------
        restaurant.agregarComida(ensaladaFrutas);
        restaurant.agregarComida(helado);
        restaurant.agregarComida(flan);
        restaurant.agregarComida(gelatina);
        restaurant.agregarComida(bombonSuizo);
        restaurant.agregarComida(brownie);
        restaurant.agregarComida(postrBalcarce);
        restaurant.agregarComida(postreChocolate);
        restaurant.agregarComida(lemonPie);
        restaurant.agregarComida(vigilante);

*/
//----------------------------------------Clientes-------------------------------------
/*
        Presencial nico= new Presencial("Nico","Bertu","456",5);
        Presencial marian = new Presencial("Marian","Benv","123",2);
        Virtual lau = new Virtual("Lautaro", "Fullone", "789", "476965", "Espa 3571" );
        Virtual rodri = new Virtual("Rodri", "Perez", "159", "548525", "Lejos123");

        restaurant.agregarCliente(nico);
        restaurant.agregarCliente(lau);
        restaurant.agregarCliente(marian);
        restaurant.agregarCliente(rodri);
*/
//----------------------------------------Mesas-------------------------------------
 /*       Mesa a = new Mesa (4, false);
        Mesa b = new Mesa (8, false);
        Mesa c = new Mesa (6, true);
        Mesa d = new Mesa (3, false);
        Mesa e =new Mesa  (2, false);

        restaurant.agregarMesa(a);
        restaurant.agregarMesa(b);
        restaurant.agregarMesa(c);
        restaurant.agregarMesa(d);
        restaurant.agregarMesa(e);
*/


        //  try {
             // Archivador.agregarComidas(restaurant.getListaComidas());
             // Archivador.agregarMesas(restaurant.getListaMesas());
             // Archivador.cargarArchivoCombos(restaurant.getSetCombos());
              //Archivador.agregarClientes(restaurant.getListaClientes());



              restaurant.setListaMesas(Archivador.leerArchivoMesas());
              restaurant.getCartaComidas().setListaComida(Archivador.leerArchivoComidas());
              restaurant.getCartaComidas().setSetCombos(Archivador.leerArchivoCombos());
              restaurant.setListaClientes(Archivador.leerArchivoClientes());


              MenuPpal.MenuPrincipal(scan,restaurant);


             // Archivador.agregarComidas(restaurant.getListaComidas());
              //Archivador.agregarMesas(restaurant.getListaMesas());
              //Archivador.cargarArchivoCombos(restaurant.getSetCombos());
              //Archivador.agregarClientes(restaurant.getListaClientes());


       //   } catch (IOException g)
       //   {
       //       System.out.println("Fin main");
       //   }*/


    }

}