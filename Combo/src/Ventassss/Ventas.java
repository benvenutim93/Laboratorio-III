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

    public ArrayList<Combo> getCombosVendidos() {
        return combosVendidos;
    }

    public void setCombosVendidos(ArrayList<Combo> combosVendidos) {
        this.combosVendidos = combosVendidos;
    }

    public int getCantCombosVendidos() {
        return cantCombosVendidos;
    }

    public void setCantCombosVendidos(int cantCombosVendidos) {
        this.cantCombosVendidos = cantCombosVendidos;
    }

    public double getMontoCombosVendidos() {
        return montoCombosVendidos;
    }

    public void setMontoCombosVendidos(double montoCombosVendidos) {
        this.montoCombosVendidos = montoCombosVendidos;
    }

    public Ventas(ArrayList<Combo> nuevo, int cantCombosVendidos, double montoCombosVendidos) {
        this.combosVendidos = nuevo;
        this.cantCombosVendidos = cantCombosVendidos;
        this.montoCombosVendidos = montoCombosVendidos;
    }

    public void agregarVenta(Combo nuevo){
        if(nuevo != null){
            combosVendidos.add(nuevo);
            cantCombosVendidos++;
            setMontoCombosVendidos(this.montoCombosVendidos+nuevo.getPrecio());
        }
    }

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

    public String listarVentas()
    {
        StringBuilder builder = new StringBuilder();
        for(Combo aux : combosVendidos){
            builder.append(aux.toString());
        }
        return  builder.toString();
    }

    @Override
    public String toString() {
        return listarVentas()+"         [[CANTIDAD COMBOS VENDIDOS: "+cantCombosVendidos+" - MONTOS COMBOS VENDIDOS: $"+montoCombosVendidos+"]]\n";
    }


}
