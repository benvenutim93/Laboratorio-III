package Main;

import org.json.JSONException;

import java.util.HashSet;

public class Main_Pruebas_HashSet_Combo {
    public static void main(String[] args) {

        Combo combo1 = new Combo(326.89,"combo 1","descripcion1");
        Combo combo2 = new Combo(400,"combo 2","descripcion2");
        Combo combo3 = new Combo(269,"combo 3","descripcion3");
        Combo combo4 = new Combo(428.50,"combo 4","descripcion4");
        Combo combo5 = new Combo(359,"combo 5","descripcion5");
        Combo combo6 = new Combo(600,"combo 6","descripcion6");

        CartaComidas Carta= new CartaComidas();

        Carta.agregarCombo(combo1);
        System.out.println("Id combo 1: "+combo1.getiD()+"\n Id combo 2:"+combo2.getiD());
        combo2.setiD(combo1.getiD());
        System.out.println("Id combo2: "+combo2.getiD());

        System.out.println("Agregar combo 2 --> "+Carta.agregarCombo(combo2));

        Carta.agregarCombo(combo3);
        Carta.agregarCombo(combo4);
        Carta.agregarCombo(combo5);
        Carta.agregarCombo(combo6);

        System.out.println(Carta.listarCarta());
        System.out.println("Cambia precio combo3");
        System.out.println(Carta.actualizarPrecioParticular(combo3,200));

        System.out.println(Carta.listarCarta());

        try {
            String json=Carta.cargarJson();
            System.out.println(json);

            CartaComidas carta2 =new CartaComidas( Carta.decodeJson(json));
            System.out.println("Jsondecode");
            System.out.println(carta2.listarCarta());

        }catch (JSONException e){
            e.printStackTrace();
        }

    }
}
