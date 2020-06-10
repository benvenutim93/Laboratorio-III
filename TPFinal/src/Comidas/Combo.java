package Comidas;

import org.json.JSONException;
import org.json.JSONObject;
import Excepciones.PrecioNegativoException;

public class Combo {

    static final String CLAVE_PRECIO ="precio";
    static final String CLAVE_NOMBRE ="nombre";
    static final String CLAVE_DESCRIPCION ="descripcion";
    static final String CLAVE_ID ="id";

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
    public String getNombre(){ return this.nombre; }
    public int getiD() {  return iD;    }
    public void cambiarPrecio(int precio) throws PrecioNegativoException {
        if(precio >= 0 ) {
            this.precio = precio;
        }else {
            throw new PrecioNegativoException("Error : Precio Negativo");
        }
    }
    public double getPrecio() {
        return precio;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public  void setiD(int a){
        this.iD=a;
    }

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

    /**
     * Crea un JsonObject con todos los datos
     * @return JsonObject
     * @throws JSONException
     */
    public JSONObject crearJson () throws JSONException
    {
        JSONObject json = new JSONObject();
        json.put(CLAVE_DESCRIPCION,getDescripcion());
        json.put(CLAVE_ID,getiD());
        json.put(CLAVE_NOMBRE,getNombre());
        json.put(CLAVE_PRECIO,getPrecio());
        return json;

    }
}
