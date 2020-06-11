package Comidas;

import Excepciones.PrecioNegativoException;
import Interfaces.IPrecio;

public class Combo implements IPrecio {
    private PlatoPrincipal plato;
    private Bebida bebida;
    private Postre postre;
    private Guarnicion guarnicion;
    private double precio;
    private int id;

    public static int idAutoincremental = 0;
    ///-------------------------------- [C O N S T R U C T O R E S ] --------------------------------

    public Combo(PlatoPrincipal plato, Bebida bebida, Postre postre, Guarnicion guarnicion) {
        this.plato = plato;
        this.bebida = bebida;
        this.postre = postre;
        this.guarnicion = guarnicion;
        ponerPrecio();
        this.id = ++idAutoincremental;
    }

    public Combo(PlatoPrincipal plato, Bebida bebida, Postre postre) {
        this.plato = plato;
        this.bebida = bebida;
        this.postre = postre;
        ponerPrecio();
        this.id = ++idAutoincremental;
    }

    public Combo(PlatoPrincipal plato, Bebida bebida, Guarnicion guarnicion) {
        this.plato = plato;
        this.bebida = bebida;
        this.guarnicion = guarnicion;
        ponerPrecio();
        this.id = ++idAutoincremental;
    }

    private void ponerPrecio() {
        double rta;
        double acum = 0;
        if (plato != null) {
            acum += plato.getPrecio();
        }
        if (bebida != null) {
            acum += bebida.getPrecio();
        }
        if (postre != null) {
            acum += postre.getPrecio();
        }
        if (guarnicion != null) {
            acum += guarnicion.getPrecio();
        }
        //descuento
        rta = acum * .90;

        this.precio = rta;
    }
    ///-------------------------------- [S E T T E R S /\ G E T T E R S] --------------------------------


    @Override
    public double getPrecio() {
        return precio;
    }

    public int getId() {
        return id;
    }

    ///-------------------------------- [M E T O D O S] --------------------------------
    /**
     * Informacion del combo, como esta compuesto .
     * @return String
     */
    public String getCombo(){
        StringBuilder builder = new StringBuilder();
        builder.append("| -- [ Combo "+this.id+" ]  >> Precio: $"+this.precio+" << -- |\n");

        if(plato != null){
            builder.append("| Plato Principal: "+plato.getNombre()+"\n");
        }
        if(bebida !=null){
            builder.append("| Bebida: "+bebida.getNombre()+"\n");
        }
        if(postre != null){
            builder.append("| Postre: "+postre.getNombre()+"\n");
        }
        if(guarnicion != null){
            builder.append("| Guarnicion: "+guarnicion.getNombre()+"\n");
        }

        return builder.toString();
    }

    /**
     * Muestra todos los datos del combo , si tiene sal,libre de TACC.
     * @return String
     */
    public String getDatosCombo(){
        StringBuilder builder = new StringBuilder();
        builder.append("| -- [ Combo "+this.id+" ]  >> Precio: $"+this.precio+" << -- |\n");

        if(plato != null){
            builder.append("| Plato Principal: "+plato.datos()+"\n");
        }
        if(bebida !=null){
            builder.append("| Bebida: "+bebida.datos()+"\n");
        }
        if(postre != null){
            builder.append("| Postre: "+postre.datos()+"\n");
        }
        if(guarnicion != null){
            builder.append("| Guarnicion"+guarnicion.datos()+"\n");
        }
        return builder.toString();
    }
    //guarnicion
        public void sinSal(){
          guarnicion.sinSal();
        }
        //platoprincipal
        public void setAptoTACC(boolean b){
        plato.setAptoTacc(b);
        }
        //postre
        public void sacarTopping(){
        postre.sinTopping();
        }
        //bebida
        public void ponerGas(boolean b){
        bebida.setTieneGas(b);
        }
        public void ponerTemperatura(String b){
            bebida.setTemperatura(b);
        }

        public void cambiarPrecio(int precio) throws PrecioNegativoException {
        if(precio >= 0 ) {
            this.precio = precio;
        }else {
            throw new PrecioNegativoException("Error : Precio Negativo");
        }
    }
    @Override
    public boolean equals(Object o) {
        boolean rta=false;
        if(o instanceof Combo){
            Combo aux= (Combo)o;
            if(this.id == aux.getId()){
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
