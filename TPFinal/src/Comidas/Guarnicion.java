package Comidas;

public class Guarnicion extends  Comida{
    private boolean tieneSal;
    ///-------------------------------- [C O N S T R U C T O R E S ] --------------------------------

    public Guarnicion(double precio, String nombre, boolean tieneSal) {
        super(precio, nombre);
        this.tieneSal = tieneSal;
    }
    ///-------------------------------- [S E T T E R S /\ G E T T E R S] --------------------------------

    public void sinSal() {
        this.tieneSal = !tieneSal;
    }

    public boolean isTieneSal() {
        return tieneSal;
    }

    ///-------------------------------- [M E T O D O S] --------------------------------
    public String datos(){
        return "\n***********\n"+"Nombre: "+super.getNombre()+"\n"+"Tiene sal: "+isTieneSal()+"\n***********\n";
    }
}
