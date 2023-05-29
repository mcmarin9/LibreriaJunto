package libreria;

public class Estuche extends Producto {

	// estuche (tipo(de lapices, rotuladores, temperas), numero de colores)
	private String tipo; // lapices, rotuladores, temperas
	private int numColores;

	public Estuche() {
		super();
	}

	public Estuche(String nombre, String descripcion, double precioUnidad, int unidadesStock) {
		super(nombre, descripcion, precioUnidad, unidadesStock);
	}

	public Estuche(String nombre, String descripcion, double precioUnidad, int unidadesStock, String tipo,
			int numColores) {
		super(nombre, descripcion, precioUnidad, unidadesStock);
		this.tipo = tipo;
		this.numColores = numColores;

		Producto.getListaProductos().add(this);
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getNumColores() {
		return numColores;
	}

	public void setNumColores(int numColores) {
		this.numColores = numColores;
	}

	@Override
	public String toString() {
		return super.toString() + " | "+ "Tipo: " + tipo + " | " + "Colores: " + numColores
				+ "\n---------------------------------------------------------------------------" + "\n";
	}

	@Override
	public String generarCodigo() {
		String codigo = "E";
		int numConsecutivo = 0;

		for (Producto producto : Producto.getListaProductos()) {
			if (producto instanceof Estuche) {
				numConsecutivo++;
			}
		}
		codigo += String.format("%03d", numConsecutivo);

		return codigo;
	}

}
