package Colecciones;

import Humanos.Cliente;
import Interfaces.IOpBasicas;

import java.util.ArrayList;

public class ListaClientes implements IOpBasicas<Cliente>
{
    private ArrayList<Cliente>listaClientes;

    public ListaClientes() {
        this.listaClientes = new ArrayList<Cliente>();
    }

    @Override
    public String listar() {
        StringBuilder builder = new StringBuilder();
        for (Cliente aux : listaClientes)
            builder.append(aux.toString()+"\n");
        return builder.toString();
    }

    @Override
    public boolean agregar(Cliente obj) {
        boolean rta = false;
        if( (obj != null) && (!listaClientes.contains(obj)) )
        {
            rta = listaClientes.add(obj);
        }
        return rta;
    }

    @Override
    public boolean eliminar(Cliente obj) {
        boolean rta = false;
        if( (obj != null) && (listaClientes.contains(obj)) )
        {
            rta = listaClientes.remove(obj);
        }
        return rta;
    }

    public boolean contiene(Cliente buscado){
        boolean rta = false;
        if (buscado != null)
            rta = listaClientes.contains(buscado);
        return rta;
    }

    public Cliente buscarPorDni(String dni){
        Cliente aux = null;;
        int i =0;
        boolean flag = false;

        while ( (i < listaClientes.size()) && (flag == false) )
        {
            aux = listaClientes.get(i);
            if (aux.getDNI().equals(dni))
                flag = true;

            i++;
        }
        if (flag)
        {
            return aux;
        }
        else
            return null;
    }


}