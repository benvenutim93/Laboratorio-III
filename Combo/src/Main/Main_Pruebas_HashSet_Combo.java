package Main;

import Ventassss.MapaVentas;
import Ventassss.Ventas;

public class Main_Pruebas_HashSet_Combo {

    public static void main(String[] args) {

        Combo combo1 = new Combo(326.89,"combo 1","descripcion1");
        Combo combo2 = new Combo(400,"combo 2","descripcion2");
        Combo combo3 = new Combo(269,"combo 3","descripcion3");
        Combo combo4 = new Combo(428.50,"combo 4","descripcion4");
        Combo combo5 = new Combo(359,"combo 5","descripcion5");
        Combo combo6 = new Combo(600,"combo 6","descripcion6");

        Ventas ventasSemana1 = new Ventas();

        ventasSemana1.agregarVenta(combo1);
        ventasSemana1.agregarVenta(combo2);
        ventasSemana1.agregarVenta(combo3);
        ventasSemana1.agregarVenta(combo4);
        ventasSemana1.agregarVenta(combo5);
        ventasSemana1.agregarVenta(combo6);

        ventasSemana1.eliminarVenta(combo1);
        ventasSemana1.eliminarVenta(combo2);

        //System.out.println(ventasSemana1.toString());

        MapaVentas mapaVentas = new MapaVentas();

        mapaVentas.agregarCombo("01-06",combo1);
        mapaVentas.agregarCombo("01-06",combo2);
        mapaVentas.agregarCombo("01-06",combo3);
        mapaVentas.agregarCombo("01-06",combo4);

        mapaVentas.agregarCombo("01-07",combo3);
        mapaVentas.agregarCombo("01-07",combo4);
        mapaVentas.agregarCombo("01-07",combo5);
        mapaVentas.agregarCombo("01-07",combo6);

        System.out.println(mapaVentas.mostrarMapa());

        System.out.println("----------------------------------------------------");

        mapaVentas.eliminarCombo("01-06",combo3);
        mapaVentas.eliminarCombo("01-07", combo3);
        System.out.println(mapaVentas.mostrarMapa());

/*
        CartaComidas Carta= new CartaComidas();

        Carta.agregarCombo(combo1);
        System.out.println("Id combo 1: "+combo1.getiD()+"\n Id combo 2:"+combo2.getiD());
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
*/
    }
}
