package libreria;

public class Libreta extends Producto {
	private int numHojas;
	private String tamano; // a5, a3 etc
	private String color;

	public Libreta() {
		super();
	}

	public Libreta(String nombre, String descripcion, double precioUnidad, int unidadesStock) {
		super(nombre, descripcion, precioUnidad, unidadesStock);
	}

	public Libreta(String nombre, String descripcion, double precioUnidad, int unidadesStock, int numHojas,
			String tamano, String color) {
		super(nombre, descripcion, precioUnidad, unidadesStock);
		this.numHojas = numHojas;
		this.tamano = tamano;
		this.color = color;

		Producto.getListaProductos().add(this);
	}

	public int getNumHojas() {
		return numHojas;
	}

	public void setNumHojas(int num_hojas) {
		this.numHojas = num_hojas;
	}

	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return super.toString() + " | " +"NumHojas: " + numHojas + " | " +"Tamaño: " + tamano + " | "+"Color: " + color
				+ "\n---------------------------------------------------------------------------" + "\n";
	}

	@Override
	public String generarCodigo() {
		String codigo = "LT";
		int numConsecutivo = 0;

		for (Producto producto : Producto.getListaProductos()) {
			if (producto instanceof Libreta) {
				numConsecutivo++;
			}
		}
		codigo += String.format("%03d", numConsecutivo);

		return codigo;
	}
}
