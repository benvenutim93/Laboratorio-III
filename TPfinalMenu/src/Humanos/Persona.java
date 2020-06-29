package Humanos;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public abstract class Persona implements Serializable {

    static final String K_NOMBRE = "Nombre" ;
    static final String K_APELLIDO = "Apellido" ;
    static final String K_DNI = "Dni" ;

    private String nombre;
    private String apellido;
    private String DNI;

    public Persona()
    {
        nombre = "";
        apellido = "";
        DNI = "";
    }

    public Persona(String nombre, String apellido, String dni)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = dni;
    }

    public JSONObject code() throws JSONException
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(K_NOMBRE, getNombre());
        jsonObject.put(K_APELLIDO, getApellido());
        jsonObject.put(K_DNI, getDNI());
        return jsonObject;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return "\nNombre= "+nombre+"\nApellido= "+apellido+"\nDni= "+DNI;
    }
}
