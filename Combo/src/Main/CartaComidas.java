package Main;


import java.util.HashSet;
import java.util.Iterator;


public class CartaComidas {
    private HashSet<Combo> carta;


    public CartaComidas() {
        this.carta =new HashSet<Combo>();
    }
///-------------------------------- [M E T O D O S] --------------------------------
    /**
     * Agrega un combo a la carta (criterio de comparacion  ID )
     * @param agregar (Combo)
     * @return TRUE si fue agregado cin exito
     */
    public boolean agregarCombo(Combo agregar){
        boolean rta=false;
        rta =carta.add(agregar);
        return rta;
    }
    /**
     * Lista el menu
     * @return Carta Completa con todos sus combos
     */
    public String listarCarta(){
        StringBuilder builder = new StringBuilder();
        Iterator<Combo> it = carta.iterator();
        while (it.hasNext()){
            Combo entrada= (Combo) it.next();
            builder.append(entrada.toString());
            builder.append("\n");
        }

        return builder.toString();
    }

    /**
     * Cambia el precio de un producto en particular (CRITERIO para cambiar NOMBRE).
     * @param aCambiar (Combo)
     * @param nuevoPrecio (Integer)
     * @return TRUE si se pudo cambiar el nombre - FALSE sino se pudo cambiar
     *
     *
     *
     */
    public boolean actualizarPrecioParticular(Combo aCambiar,int nuevoPrecio){
        boolean rta =false;

        Iterator<Combo> it = carta.iterator();
        while (it.hasNext()){
            Combo entrada= (Combo) it.next();
            if(entrada.getNombre().equalsIgnoreCase(aCambiar.getNombre())){
                aCambiar.cambiarPrecio(nuevoPrecio);
                rta=true;
            }

        }
        return rta;
    }



}
