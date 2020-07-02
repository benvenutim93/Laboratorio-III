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

    /**
     * Lista todos los datos del pedido del cliente.
     * @return String
     */
    @Override
    public String listar() {
        StringBuilder sb = new StringBuilder();
        for (T elemento : lista)
        {
            sb.append(elemento.toString()+"\n");
        }
        return sb.toString();
    }

    /**
     * Agrega un objeto, que implemente la interfaz IPrecio, al ArrayList<T>
     * @param obj
     * @return boolean. True si fue agregado correctamente.
     */
    @Override
    public boolean agregar(Object obj) {
        return lista.add((T)obj);
    }

    /**
     * Elimina un objeto del ArrayList <T>, comprobando que este no sea null
     * @param obj
     * @return boolean. True si fue eliminado.
     */
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

    /**
     * Devuelve la cantidad todal de objetos ingresados en el ArrayList<T>
     * @return
     */
    public int getTotal(){
        return lista.size();
    }

    /**
     * Devuelve el ArrayList<T>
     * @return ArrayList<T>
     */
    public ArrayList<T> getLista(){
        return this.lista;
    }

    /**
     * Busca un objeto, pasandole un índice y lo devuelve.
     * @param i
     * @return T
     */
    public T getObjeto(int i){
        return lista.get(i);
    }
}
