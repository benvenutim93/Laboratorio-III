package clientes;

import LoMio.Cliente;
import LoMio.Presencial;

public class Main {

    public static void main(String[] args) {

        Combo combo1 =new Combo(100,"combo1","descripcion");
        Combo combo2 =new Combo(50,"combo2","descripcion");
        Combo combo3 =new Combo(150,"combo3","descripcion");

        CartaComidas cartaComidas= new CartaComidas();
        cartaComidas.agregarCombo(combo1);
        cartaComidas.agregarCombo(combo2);
        cartaComidas.agregarCombo(combo3);

        Cliente cliente =new Cliente("rodrigo","perez","123");


        cliente.pedirCombo(cartaComidas);
        cliente.pedirCombo(cartaComidas);
        cliente.pedirCombo(cartaComidas);
        cliente.pedirCombo(cartaComidas);
        cliente.calcularFactura();

        System.out.println(cliente.toString());

        Mesa a = new Mesa (4, false);
        Mesa b = new Mesa (8, false);
        Mesa c = new Mesa (6, false);
        Mesa d = new Mesa (3, false);

        ListaMesas listaMesas= new ListaMesas();

        listaMesas.addMesa(a);
        listaMesas.addMesa(b);
        listaMesas.addMesa(c);
        listaMesas.addMesa(d);

        Cliente cliente2 = new Presencial("rodrigo","perez","123",4);

        try {
            cliente2.PedirMesa(listaMesas);
        }
        catch (SinMesasException e)
        {
            e.printStackTrace();
        }
        catch (IdInexistenteMesaException e)
        {
            e.printStackTrace();
        }
    }
}
