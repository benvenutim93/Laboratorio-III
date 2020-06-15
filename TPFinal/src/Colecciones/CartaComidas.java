package Colecciones;

import Comidas.*;
import Interfaces.IOpBasicas;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import Excepciones.PrecioNegativoException;

public class CartaComidas
{
    private SetCombo setCombos;
    private ListaComidas listaComida;

    public CartaComidas(){
        this.listaComida=new ListaComidas();
        this.setCombos=new SetCombo();
    }

    public boolean agregarComida(Comida nueva){
        return listaComida.agregar(nueva);
    }
    public boolean agregarCombo(Combo nuevo){
        return setCombos.agregar(nuevo);
    }
    public String listarCombos(){
        return setCombos.listar();
    }
    public String listaComidas(){
        return listaComida.listar();
    }
    public int getCantidadCombo(){
        return   setCombos.getCantidad();
    }
    public HashSet<Combo> getCartaCombo(){
        return  setCombos.getCartaCombo();
    }
    public String listarCompleto(){
        StringBuilder builder=new StringBuilder();
        builder.append("----Combos----:\n"+setCombos.listar());
        builder.append("\n----Comidas----:\n"+listaComida.listar());
        return builder.toString();
    }
    public boolean eliminarCombo(Combo aBorrar){
        return setCombos.eliminar(aBorrar);
    }
    public boolean eliminarComida(Comida aBorrar){
        return listaComida.eliminar(aBorrar);
    }



}
