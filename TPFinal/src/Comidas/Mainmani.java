package Comidas;
import Colecciones.CartaComidas;
import Colecciones.Restaurant;
import Excepciones.CapacidadMaximaException;
import Excepciones.IdInexistenteMesaException;
import Excepciones.PrecioNegativoException;
import Excepciones.SinMesasException;
import Humanos.Cliente;
import Humanos.Presencial;
import Objetos.Mesa;

public class Mainmani {
    public static void main(String[] args) {

        PlatoPrincipal milanesa = new PlatoPrincipal(250, "Milanesa ", true);
        PlatoPrincipal milanesaNapo = new PlatoPrincipal(350, "Milanesa Napolitana", true);
        PlatoPrincipal sorrentinos = new PlatoPrincipal(286, "Sorrentinos", true);
        PlatoPrincipal pancho = new PlatoPrincipal(130, "Pancho", true);
        PlatoPrincipal burger = new PlatoPrincipal(320, "Hamburguesa", true);

        Mesa a = new Mesa (4, false);
        Mesa b = new Mesa (8, false);
        Mesa c = new Mesa (6, false);
        Mesa d = new Mesa (3, false);

        Bebida coca = new Bebida(90, "Coca-Cola", true, "fria");
        Bebida pepsi = new Bebida(85, "Pepsi", true, "fria");
        Bebida manaos = new Bebida(90, "Manaos de Uva", true, "fria");

        Postre helado = new Postre(125, "Helado", true);
        Postre flan = new Postre(200, "Flan ", true);
        Postre ensaladaFrutas = new Postre(150, "Ensala de frutas", true);

        Guarnicion papasFritas = new Guarnicion(65, "Papas Fritas", true);
        Guarnicion pureDePapa = new Guarnicion(65, "Pure de papa", true);
        Guarnicion ensalada = new Guarnicion(70, "Ensalada", true);

        //System.out.println(papasFritas.toString());
        /*try {
            papasFritas.cambiarPrecio(-10);
        } catch (PrecioNegativoException e) {
            e.printStackTrace();
        }*/
        //System.out.println(coca.datos());
        Combo combito = new Combo(pancho, pepsi, flan);

        //System.out.println(combito.getPrecio());
        combito.ponerTemperatura("caliente");
        combito.ponerGas(false);
        //System.out.println(combito.getCombo());

        Restaurant restaurant = new Restaurant();

        restaurant.agregarComida(milanesa);
        restaurant.agregarComida(milanesaNapo);
        restaurant.agregarComida(sorrentinos);

        Presencial presencial1 = new Presencial("Pepe","popo", "5421521", 5);
        Presencial presencial2 = new Presencial("Azul","popo", "2222", 2);
        restaurant.agregarCliente(presencial1);
        restaurant.agregarCliente(presencial2);

        System.out.println(restaurant.agregarMesa(a));

        System.out.println(restaurant.agregarMesa(c));
        restaurant.agregarMesa(b);
        restaurant.agregarMesa(d);

        try {
            restaurant.ocuparMesa(presencial1);
        } catch (IdInexistenteMesaException e) {
            e.printStackTrace();
        } catch (SinMesasException e) {
            e.printStackTrace();
        } catch (CapacidadMaximaException e) {
            e.printStackTrace();
        }


        System.out.println(restaurant.listarClientes());
        System.out.println(restaurant.listarCompleto());
        System.out.println(restaurant.listarMesas());



    }
}
