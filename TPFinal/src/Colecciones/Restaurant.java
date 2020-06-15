package Colecciones;

import Colecciones.CartaComidas;
import Colecciones.ListaClientes;
import Colecciones.ListaMesas;

public class Restaurant
{
    private ListaClientes listaClientes;
    private ListaMesas listaMesas;
    private CartaComidas cartaComidas;

    public Restaurant(){
        this.listaClientes = new ListaClientes();
        this.listaMesas = new ListaMesas();
        this.cartaComidas = new CartaComidas();
    }



}
