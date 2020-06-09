package Default;

public class Main {

    public static void main(String[] args) {
	    Mesa a = new Mesa (4, false, 1);
        Mesa b = new Mesa (8, false, 2);
        Mesa c = new Mesa (6, false, 3);
        Mesa d = new Mesa (3, false, 4);

        ListaMesas lista = new ListaMesas(a);
        lista.addMesa(b);
        lista.addMesa(c);
        lista.addMesa(d);

        System.out.println(lista.imprimirListado());

        Mesa aux = new Mesa ();

        lista.ocuparMesa(6);
        System.out.println(lista.imprimirListado());








    }
}
