package librosAutores;

public class Autor {
	
	private String nombre;
	private String apellido;
	private String mail;
	private char genero;
	
	//CONSTRUCTORES
	
	public Autor ()
	{
		nombre = "";
		apellido = "";
		mail = "";
		genero = 'u';
	}
	
	public Autor (String Nombre, String Apellido, String Mail, char Genero)
	{
		nombre = Nombre;
		apellido = Apellido;
		mail = Mail;
		genero = Genero;
	}
	
	//GETTERS
	
	public String getNombre()
	{
		return nombre;
	}
	
	public String getApellido ()
	{
		return apellido;
	}
	
	public String getMail()
	{
		return mail;
	}
	
	public char getGenero()
	{
		return genero;
	}
	
	//SETTERS
	
	public void setNombre(String Nombre)
	{
		nombre = Nombre;
	}
	
	public void setApellido (String Apellido)
	{
		apellido = Apellido;
	}
	
	public void setMail (String Mail)
	{
		mail = Mail;
	}
	
	public void setGenero (char Genero)
	{
		genero = Genero;
	}

	//METODOS
	
	@Override
	public String toString() {
		return "Autor [nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail + ", genero=" + genero + "]";
	}
	

}
