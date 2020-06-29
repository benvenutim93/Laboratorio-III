package Colecciones;

import Comidas.*;
import Interfaces.IOpBasicas;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class ListaComidas implements IOpBasicas<Comida>, Serializable {

    static final String K_LISTADOCOMIDA = "Listado Comida";

    private ArrayList<Comida>listaComidas;

    public ListaComidas() {
        this.listaComidas = new ArrayList<Comida>();
    }

///-------------------------------- [M E T O D O S] --------------------------------


    public JSONArray codeListaComidas() throws JSONException {
        JSONArray jsonArray = new JSONArray();
        for(Comida aux:listaComidas)
            jsonArray.put(aux.code());
        return jsonArray;
    }

    public ArrayList<Comida> getListaComidas() {
        return listaComidas;
    }

    /**
     * Busca la posicion de una comida en el ArrayList
     * @param aBuscar
     * @return posicion de la comida
     */
    public int getPosComida(Comida aBuscar){
        int rta=-1;
        if(listaComidas.contains(aBuscar)){
            rta= listaComidas.indexOf(aBuscar);
        }
        return rta;
    }
    /**
     * Restorna una comida del Arraylist
     * @param pos
     * @return Comida
     */
    public Comida getComidapos(int pos){
        Comida rta=null;
        if(!listaComidas.isEmpty()){
            rta=listaComidas.get(pos);
        }
        return rta;
    }
    //------------------------------------------listar---------------------
    public  String listaGuarnicion(){
        StringBuilder builder = new StringBuilder();
        if(!listaComidas.isEmpty()){
            for (Comida aux: listaComidas){
                if(aux instanceof Guarnicion){

                    builder.append(listaComidas.indexOf(aux)+". "+aux.toString()+"\n");
                }
            }
        }
        return builder.toString();
    }

    public  String listaPostre(){
        StringBuilder builder = new StringBuilder();
        if(!listaComidas.isEmpty()){
            for (Comida aux: listaComidas){
                if(aux instanceof Postre){

                    builder.append(listaComidas.indexOf(aux)+". "+aux.toString()+"\n");
                }
            }
        }
        return builder.toString();
    }

    public  String listaPlatosprincipales(){
        StringBuilder builder = new StringBuilder();
        if(!listaComidas.isEmpty()){
            for (Comida aux: listaComidas){
                if(aux instanceof PlatoPrincipal){

                    builder.append(listaComidas.indexOf(aux)+". "+aux.toString()+"\n");
                }
            }
        }
        return builder.toString();
    }

    public  String listaBebidas(){
        StringBuilder builder = new StringBuilder();
        if(!listaComidas.isEmpty()){
            for (Comida aux: listaComidas){
                if(aux instanceof Bebida){

                    builder.append(listaComidas.indexOf(aux)+". "+aux.toString()+"\n");
                }
            }
        }
        return builder.toString();
    }

    @Override
    public String listar() {
        StringBuilder builder = new StringBuilder();
        StringBuilder builderPlato = new StringBuilder();
        StringBuilder builderBebida = new StringBuilder();
        StringBuilder builderPostre = new StringBuilder();
        StringBuilder builderGuarnicion = new StringBuilder();

        if(!listaComidas.isEmpty()) {
            for (Comida aux : listaComidas) {

                if (aux instanceof PlatoPrincipal) {
                    builderPlato.append("\n"+aux.toString());

                }
                if (aux instanceof Bebida) {
                    builderBebida.append("\n"+aux.toString());
                }
                if (aux instanceof Postre) {
                    builderPostre.append("\n"+aux.toString());
                }
                if (aux instanceof Guarnicion) {
                    builderGuarnicion.append("\n"+aux.toString());
                }

            }
            builder.append("----PlatosPrincipales:" + builderPlato.toString());
            builder.append("\n----Bebidas:"+builderBebida.toString());
            builder.append("\n----Postres:"+builderPostre.toString());
            builder.append("\n----Guarniciones  :"+builderGuarnicion.toString());
        }else{
            builder.append("No hay comidas cargadas ");
        }

        return builder.toString();
    }

//---------------------------------------------------------------------------------------------------

    @Override
    /**
     * Agrega una comida al ArrayList sin que este repetida
     * @param nueva (Comida)
     * @return true agregado con exito
     */
    public boolean agregar(Comida obj) {
        boolean rta=false;
        if(!listaComidas.contains(obj)){
            rta = listaComidas.add(obj);
        }
        return rta;
    }


    @Override
    public boolean eliminar(Comida obj) {
        boolean rta=false;
        if(!listaComidas.isEmpty()){
            rta=listaComidas.remove(obj);
        }

        return rta;
    }
}
