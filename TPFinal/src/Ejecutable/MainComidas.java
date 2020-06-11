package Ejecutable;
import Comidas.*;
import Excepciones.PrecioNegativoException;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class MainComidas {
    public static void main(String[] args) {

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
/*
        System.out.println(papasFritas.toString());
        try {
            papasFritas.cambiarPrecio(-10);
        }catch (PrecioNegativoException e){
            e.printStackTrace();
        }
        System.out.println(coca.datos());
        */

        ArrayList<Combo>arrayList = new ArrayList<Combo>();
        Combo combito = new Combo(pancho,pepsi,flan);
        Combo combazo = new Combo(milanesa, coca, helado, papasFritas);
        arrayList.add(combazo);
        arrayList.add(combito);

        for (Combo aux:arrayList){
            System.out.println(aux.getCombo());
        }






    }
}
