package librosAutores;

public class Libro {
	private String titulo;
	private float precio;
	private int stock;
	private Autor fulano;
	
	//CONSTRUCTORES
	
	public Libro ()
	{
		titulo = "";
		precio = 0;
		stock = 0;
		fulano = null;
	}
	
	public Libro (String Titulo, float Precio, int Stock, Autor a)
	{
		titulo = Titulo;
		precio = Precio;
		stock = Stock;
		
		fulano = a;
	}

	//GETTERS
	
	public String getTitulo ()
	{
		return titulo;
	}
	
	public float getPrecio ()
	{
		return precio;
	}
	
	public int getStock()
	{
		return stock;
	}
	
	public Autor getAutor()
	{
		return fulano;
	}
	
	public String getNombreApellidoAutor()
	{
		return fulano.getNombre()+" "+fulano.getApellido();
	}
	
	//SETTERS
	
	public void setTitulo (String Titulo)
	{
		titulo = Titulo;
	}
	
	public void setPrecio (float Precio)
	{
		precio = Precio;
	}
	
	public void setStock (int Stock)
	{
		stock = Stock;
	}
	
	public void setAutor (Autor a)
	{
		fulano = a;
	}
	
	//METODOS
	
	public void modificarPrecio (float nuevoPrecio)
	{
		precio = nuevoPrecio;
	}
	
	public void modificarStock (int nuevoStock) //Reemplaza el numero del stock
	{
		stock = nuevoStock;
	}
	
	public void aumentarStock (int aumentoStock)//Aumenta el numero del stock
	{
		stock = stock + aumentoStock;
	}
	
	public boolean hayStock () //Devuelve true si hay copias disponibles en el stock 
	{
		if (stock > 0)
			return true;
		else 
			return false;
	}
	//FUNCIONES DE IMPRESION EN PANTALLA
	
	public void mostrarAutor ()
	{
		System.out.println("Nombre: "+fulano.getNombre());
		System.out.println("Apellido: "+fulano.getApellido());
		System.out.println("Mail: "+fulano.getMail());
		System.out.println("Genero: "+fulano.getGenero());
	}
	
	public void mostrarLibro ()
	{
		boolean a;
		System.out.println("Titulo: "+getTitulo());
		System.out.println("Precio: "+getPrecio());
		System.out.println("Autor:");
		mostrarAutor();
		a = hayStock();
		if (a)
			System.out.println("Hay stock. "+getStock()+" copias disponibles");
		else
			System.out.println("No hay stock disponible");	
	}
	
	
	public void imprimirFrase ()
	{
		System.out.println("El libro "+getTitulo()+ " de "+getNombreApellidoAutor()+" se vende a "+getPrecio()+ " pesos." );
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", precio=" + precio + ", stock=" + stock + ", fulano=" + fulano + "]";
	}
	

	
	

}
