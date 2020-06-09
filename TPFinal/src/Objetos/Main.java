package Objetos;

import Colecciones.ListaMesas;
import Excepciones.IdInexistenteMesaException;
import Excepciones.SinMesasException;
import org.json.JSONException;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    Mesa a = new Mesa (4, false);
        Mesa b = new Mesa (8, false);
        Mesa c = new Mesa (6, false);
        Mesa d = new Mesa (3, false);

        ListaMesas lista = new ListaMesas(a);

        lista.addMesa(b);
        lista.addMesa(c);
        lista.addMesa(d);

        System.out.println(lista.imprimirListado());

//        Mesa aux = new Mesa ();
//
//        try {
//            lista.ocuparMesa(6);
//            System.out.println(lista.imprimirListado());
//
//            lista.liberarMesa(3);
//            System.out.println(lista.imprimirListado());
//        }
//        catch (IdInexistenteMesaException e)
//        {
//            System.out.println(e.getMessage());
//        }
//        catch (SinMesasException e)
//        {
//            System.out.println(e.getMessage());
//        }
//


        



    }
}