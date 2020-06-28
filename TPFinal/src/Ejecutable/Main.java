package Ejecutable;

import Archivos.Archivador_CartaComidas;
import Colecciones.ListaComidas;
import Colecciones.Restaurant;
import Comidas.*;
import Humanos.Presencial;
import Humanos.Virtual;
import  Objetos.Mesa;
import java.util.Scanner;

public class Main {
    static Scanner scan ;

    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant();

        //Plantos principal
        PlatoPrincipal milanesa= new PlatoPrincipal(250,"Milanesa",true);
        PlatoPrincipal milanesaNapo= new PlatoPrincipal(350,"Milanesa Napolitana",true);
        PlatoPrincipal milanesaCaballo= new PlatoPrincipal(325,"Milanesa Caballo0",true);
        PlatoPrincipal hamburguesa= new PlatoPrincipal(250,"Hamburguesa",true);
        PlatoPrincipal pancho= new PlatoPrincipal(130,"Pancho",true);
        PlatoPrincipal choripan= new PlatoPrincipal(100,"Choripan",true);
        PlatoPrincipal sangucheCarne= new PlatoPrincipal(220,"Sanguche de Carne",true);
        PlatoPrincipal asadoDeTofu= new PlatoPrincipal(390,"Asado de Tofu",true);
        PlatoPrincipal pechugaAlaPlancha= new PlatoPrincipal(230,"Pechua a la Plancha",true);
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
        Bebida te = new Bebida(70,"te",false,"Caliente");
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

        //scan = new Scanner (System.in);

        restaurant.agregarComida(manaosDeUva);
        restaurant.agregarComida(milanesa);
        restaurant.agregarComida(helado);
        restaurant.agregarComida(pureDePapa);
        restaurant.agregarComida(milanesaNapo);
        restaurant.agregarComida(pancho);
        restaurant.agregarComida(hamburguesa);
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

/*
        try {
            JSONObject jsonObject = restaurant.codeRestaurant();
            System.out.println(jsonObject.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }*/


        ListaComidas listaComidas = Archivador_CartaComidas.leerArchivoComidas();
        System.out.println(listaComidas.listar());



    }

}