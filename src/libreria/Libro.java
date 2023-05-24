package libreria;

public class Libro extends Producto {

	private String editorial;
	private String tematica;
	private String autor;

	public Libro() {
		//Hola Patricia
		super();
	}

	public Libro(String nombre, String descripcion, double precioUnidad, int unidadesStock) {
		super(nombre, descripcion, precioUnidad, unidadesStock);
	}

	public Libro(String nombre, String descripcion, double precioUnidad, int unidadesStock,
			String editorial, String tematica, String autor) {
		super(nombre, descripcion, precioUnidad, unidadesStock);
		this.editorial = editorial;
		this.tematica = tematica;
		this.autor = autor;
		
		Producto.getListaProductos().add(this);
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getTematica() {
		return tematica;
	}

	public void setTematica(String tematica) {
		this.tematica = tematica;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	

	@Override
	public String toString() {
		return super.toString() + " editorial: " + editorial + ", tematica: " + tematica + ", autor: " + autor +
				"\n---------------------------------------------------------------------------" + "\n";
	}

	@Override
	public String generarCodigo() {
		String codigo = "LB";
		int numConsecutivo = 0;
		
		for (Producto producto : Producto.getListaProductos()) {
			if (producto instanceof Libro) {
				numConsecutivo++;
			}
		}
		codigo += String.format("%03d", numConsecutivo);
		
		return codigo;
	}

}
