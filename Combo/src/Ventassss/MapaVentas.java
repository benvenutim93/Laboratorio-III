package Ventassss;

import Main.Combo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;


public class MapaVentas
{
    private HashMap<String,Ventas> hashMap;
    private int cantCombosVendidos;


    public MapaVentas(){
        this.hashMap = new HashMap<String,Ventas>();
        this.cantCombosVendidos = 0;
    }

    public HashMap<String, Ventas> getHashMap() {
        return hashMap;
    }

    public void setHashMap(HashMap<String, Ventas> hashMap) {
        this.hashMap = hashMap;
    }

    public int getCantCombosPedidos() {
        return cantCombosVendidos;
    }

    public void setCantCombosPedidos(int cantCombosPedidos) {
        this.cantCombosVendidos = cantCombosPedidos;
    }

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
        setCantCombosPedidos(this.cantCombosVendidos+ventas.getCantCombosVendidos());
    }

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
