package Objetos;

import Interfaces.IOpBasicas;
import Interfaces.IPrecio;

import java.util.ArrayList;

public class Pedido <T extends IPrecio> implements IOpBasicas {
    private ArrayList<T> lista;

    public Pedido ()
    {
        lista = new ArrayList<T>();
    }

    @Override
    public String listar() {
        StringBuilder sb = new StringBuilder();
        for (T elemento : lista)
        {
            sb.append(elemento.toString()+"\n");
        }
        return sb.toString();
    }

    @Override
    public boolean agregar(Object obj) {
        return lista.add((T)obj);
    }

    @Override
    public boolean eliminar(Object obj) {
        boolean eliminado = false;
        if (obj != null) {
            if (lista.contains(obj)) {
                eliminado = lista.remove(obj);
            }
        }
        return eliminado;
    }

}
