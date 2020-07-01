package Objetos;

import Interfaces.IOpBasicas;
import Interfaces.IPrecio;

import java.io.Serializable;
import java.util.ArrayList;

public class Pedido <T extends IPrecio> implements IOpBasicas, Serializable
{

    private static final long serialVersionUID = 18l;

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

    public int getTotal(){
        return lista.size();
    }

    public ArrayList<T> getLista(){
        return this.lista;
    }

    public T getObjeto(int i){
        return lista.get(i);
    }
}
