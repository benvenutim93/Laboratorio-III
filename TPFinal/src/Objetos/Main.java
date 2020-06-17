package Objetos;

import Colecciones.CartaComidas;
import Colecciones.ListaMesas;
import Colecciones.Restaurant;
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

        lista.agregar(b);
        lista.agregar(c);
        lista.agregar(d);

        System.out.println(lista.listar());

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
