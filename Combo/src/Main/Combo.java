package Main;



public class Combo {

    private  double precio;
    private  String nombre;
    private String descripcion;
    private int iD;


    public static int idAutoincremental=0;


    ///-------------------------------- [C O N S T R U C T O R E S ] --------------------------------
    public Combo(double precio, String nombre, String descripcion) {
        this.precio = precio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.iD=++idAutoincremental;
    }
    /* si usamos el contructor vacio vamos a necesitar esot metodos
    public Combo(){

    }
    public void  setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    */

    ///-------------------------------- [M E T O D O S] --------------------------------

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre(){ return this.nombre; }
    public int getiD() {  return iD;    }
    public void cambiarPrecio(int precio){ this.precio=precio; }
    // PARA PROBAR SI AGREGA REPETIDOS  , BORRAR ESTA FUNCION

    ///-------------------------------- [O V E R R I D E ] --------------------------------
    @Override
    public String toString() {
        return "\n--------------\n"+"[" +nombre +"]\n"+"Descripcion= " + descripcion +
                "\nPrecio= $" + precio + "\n--------------";
    }
    @Override
    public boolean equals(Object o) {
        boolean rta=false;
        if(o instanceof Combo){
            Combo aux= (Combo)o;
            if(this.iD == aux.getiD()){
                rta=true;
            }
        }
        return rta;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
