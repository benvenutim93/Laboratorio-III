package Colecciones;

import Objetos.Ventas;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;


public class MapaVentas
{
    private HashMap<String, Ventas> hashMap;
    private int cantCombosVendidos;
    private double montoCombosVendidos;

    public MapaVentas(){
        this.hashMap = new HashMap<String,Ventas>();
        this.cantCombosVendidos = 0;
        this.montoCombosVendidos = 0;

    }

    /**
     * Devuelve atributo del objeto
     * @return cantidad de combos vendidos
     */
    public int getCantCombosVendidos() {
        return cantCombosVendidos;
    }

    /**
     * Permite modificar el estado de los combos vendidos
     * @param cantCombosVendidos
     */
    public void setCantCombosVendidos(int cantCombosVendidos) {
        this.cantCombosVendidos = cantCombosVendidos;
    }

    /**
     * Devuelve atributo del objeto
     * @return el monto de combos vendidos
     */
    public double getMontoCombosVendidos() {
        return montoCombosVendidos;
    }

    /**
     * Permite modificar el estado del monto de combos vendidos
     * @param montoCombosVendidos
     */
    public void setMontoCombosVendidos(double montoCombosVendidos) {
        this.montoCombosVendidos = montoCombosVendidos;
    }

    /**
     * Permite agregar un combo vendido. Si ya se habia registrado una venta en ese dia, se agregara
     * a la lista de combos de ese dia. Si o se habia registrado ninguna venta, se crea una nueva lista
     * y se agrega este combo vendido en ella
     * @param fecha
     * @param nuevo
     */
    public void agregarCombo(String fecha, Combo nuevo)
    {
        Ventas ventas;
        if(hashMap.containsKey(fecha))
        {
            ventas = hashMap.get(fecha);
            ventas.agregarVenta(nuevo);
        }
        else
        {
            ventas = new Ventas();
            ventas.agregarVenta(nuevo);
            hashMap.put(fecha, ventas);
        }
        setCantCombosVendidos(this.cantCombosVendidos+ventas.getCantCombosVendidos());
    }

    /**
     * Nos permite eliminar un combo vendido
     * @param fecha
     * @param buscado
     * @return true si se logro eliminar, por el contrario devolvera false
     */
    public boolean eliminarCombo(String fecha, Combo buscado)
    {
        boolean rta = false;
        if(hashMap.containsKey(fecha))
        {
            Ventas ventas = hashMap.get(fecha);
            rta = ventas.eliminarVenta(buscado);
        }
        return rta;

    }

    /**
     * NOs permite mostrar toda la informacion del mapa de ventas
     * @return String con la informacion del mapa
     */
    public String mostrarMapa()
    {
        StringBuilder builder = new StringBuilder();
        Set<Entry<String,Ventas>> conjunto = hashMap.entrySet();
        Iterator<Entry<String, Ventas>> iterator = conjunto.iterator();

        while(iterator.hasNext())
        {
            Entry<String, Ventas> entrada = iterator.next();
            builder.append(">>>[ "+entrada.getKey()+" ]<<<");   //fecha
            Ventas ventas = entrada.getValue();
            builder.append(ventas.toString()+"\n\n");
        }
        return builder.toString();
    }



}
