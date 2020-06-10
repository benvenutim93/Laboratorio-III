package Ventassss;

import Main.Combo;

import java.util.ArrayList;


public class Ventas
{
    private ArrayList<Combo> combosVendidos;
    private int cantCombosVendidos;
    private double montoCombosVendidos;

    public Ventas() {
        this.combosVendidos = new ArrayList<Combo>();
        this. cantCombosVendidos = 0;
        this.montoCombosVendidos = 0;
    }

    /**
     * Devuelve atributo del objeto
     * @return cantidad total de combos vendidos del dia
     */
    public int getCantCombosVendidos() {
        return cantCombosVendidos;
    }

    /**
     * Permite modificar el estado de la cantidad de combos vendidos
     * @param cantCombosVendidos
     */
    public void setCantCombosVendidos(int cantCombosVendidos) {
        this.cantCombosVendidos = cantCombosVendidos;
    }

    /**
     * Devuelve atributo del objeto
     * @return monto total de combos vendidos del dia
     */
    public double getMontoCombosVendidos() {
        return montoCombosVendidos;
    }

    /**
     * Nos permite modificar el estado de nuestro Monto de combos vendidos
     * @param montoCombosVendidos
     */
    public void setMontoCombosVendidos(double montoCombosVendidos) {
        this.montoCombosVendidos = montoCombosVendidos;
    }

    /**
     * Constructor del objeto mesa
     * @param nuevo
     * @param cantCombosVendidos
     * @param montoCombosVendidos
     */
    public Ventas(ArrayList<Combo> nuevo, int cantCombosVendidos, double montoCombosVendidos) {
        this.combosVendidos = nuevo;
        this.cantCombosVendidos = cantCombosVendidos;
        this.montoCombosVendidos = montoCombosVendidos;
    }

    /**
     * Permite agregar un combo vendido a nuestro array del tipo venta
     * @param nuevo
     */
    public void agregarVenta(Combo nuevo){
        if(nuevo != null){
            combosVendidos.add(nuevo);
            cantCombosVendidos++;
            setMontoCombosVendidos(this.montoCombosVendidos+nuevo.getPrecio());
        }
    }

    /**
     * Permite eliminar un combo vendido de nuestro array del tipo venta
     * @param buscado
     * @return true si logra eliminarlo, por lo contrario devuelve false
     */
    public boolean eliminarVenta(Combo buscado){
        boolean rta = false;
        if(combosVendidos.contains(buscado)){
            int pos = combosVendidos.indexOf(buscado);
            combosVendidos.remove(pos);
            cantCombosVendidos--;
            setMontoCombosVendidos(this.montoCombosVendidos-buscado.getPrecio());
            rta = true;
        }
        return rta;
    }

    /**
     * Nos devuelve nuestras ventas del dia en formato String
     * @return String de la lista
     */
    public String listarVentas()
    {
        StringBuilder builder = new StringBuilder();
        for(Combo aux : combosVendidos){
            builder.append(aux.toString());
        }
        return  builder.toString();
    }

    /**
     * Nos permite visualizar todos los atributos de nuestra venta
     * @return
     */
    @Override
    public String toString() {
        return listarVentas()+"         [[CANTIDAD COMBOS VENDIDOS: "+cantCombosVendidos+" - MONTOS COMBOS VENDIDOS: $"+montoCombosVendidos+"]]\n";
    }


}
