package libreria;

public class Boligrafo extends Producto {

	private boolean puntaFina;
	private String color;

	public Boligrafo() {
		super();
	}

	public Boligrafo(String nombre, String descripcion, double precioUnidad, int unidadesStock) {
		super(nombre, descripcion, precioUnidad, unidadesStock);
	}

	public Boligrafo(String nombre, String descripcion, double precioUnidad, int unidadesStock, boolean puntaFina,
			String color) {
		super(nombre, descripcion, precioUnidad, unidadesStock);
		this.puntaFina = puntaFina;
		this.color = color;

		Producto.getListaProductos().add(this);

	}

	public boolean isPuntaFina() {
		return puntaFina;
	}

	public void setPuntaFina(boolean punta_fina) {
		this.puntaFina = punta_fina;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return super.toString() + " Punta Fina: " + puntaFina + " Color: " + color
				+ "\n---------------------------------------------------------------------------" + "\n";
	}

	@Override
	public String generarCodigo() {
		String codigo = "B";
		int num_consecutivo = 0;

		for (Producto producto : Producto.getListaProductos()) {
			if (producto instanceof Boligrafo) {
				num_consecutivo++;
			}
		}
		codigo += String.format("%03d", num_consecutivo);

		return codigo;
	}

}
