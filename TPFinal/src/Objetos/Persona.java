package Objetos;


public abstract class Persona {

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
