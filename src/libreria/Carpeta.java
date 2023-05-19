package libreria;

public class Carpeta extends Producto {

	private boolean conAnillas;
	private int numAnillas; // solo si conAnillas es true, si no es null
	private String tamano;
	private String color;

	public Carpeta() {
		super();
	}

	public Carpeta(String nombre, String descripcion, double precioUnidad, int unidadesStock) {
		super(nombre, descripcion, precioUnidad, unidadesStock);
	}

	public Carpeta(String nombre, String descripcion, double precioUnidad, int unidadesStock,
			boolean conAnillas, int numAnillas, String tamano, String color) {
		super(nombre, descripcion, precioUnidad, unidadesStock);
	    this.conAnillas = conAnillas;
	    if (conAnillas) {
	        this.numAnillas = numAnillas;
	    } else {
	        this.numAnillas = 0;
	    }
	    this.tamano = tamano;
	    this.color = color;
		Producto.getListaProductos().add(this);
	}

	public boolean isConAnillas() {
		return conAnillas;
	}

	public void setConAnillas(boolean conAnillas) {
		this.conAnillas = conAnillas;
	}

	public int getNumAnillas() {
		return numAnillas;
	}

	public void setNumAnillas(int numAnillas) {
            this.numAnillas = numAnillas;
        
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
		return super.toString() + ", conAnillas: " + conAnillas + ", numAnillas: " + numAnillas
				+ ", tamaño: " + tamano + ", color:" + color + "\n---------------------------------------------------------------------------"+ "\n";
	}

	@Override
	public String generarCodigo() {
		String codigo = "C";
		int num_consecutivo = 0;
		
		for (Producto producto : Producto.getListaProductos()) {
			if (producto instanceof Carpeta) {
				num_consecutivo++;
			}
		}
		codigo += String.format("%03d", num_consecutivo);
		
		return codigo;
	}
	}
