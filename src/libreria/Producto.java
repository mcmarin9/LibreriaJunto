package libreria;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public abstract class Producto {

	private String codigo;
	private String nombre;
	private String descripcion;
	private double precioUnidad;
	private int unidadesStock;

	private static ArrayList<Producto> listaProductos = new ArrayList<>();

	public Producto() {

	}

	public Producto(String nombre, String descripcion, double precioUnidad, int unidadesStock) {
		setCodigo(generarCodigo());
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioUnidad = precioUnidad;
		this.unidadesStock = unidadesStock;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioUnidad() {
		return precioUnidad;
	}

	public void setPrecio_unidad(double precioUnidad) {
		this.precioUnidad = precioUnidad;
	}

	public int getUnidadesStock() {
		return unidadesStock;
	}

	public void setUnidadesStock(int unidadesStock) {
		this.unidadesStock = unidadesStock;
	}

	public static ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setLista_productos(ArrayList<Producto> listaProductos) {
		Producto.listaProductos = listaProductos;
	}

	@Override
	public String toString() {
		return "Código: " + codigo + " | " + "Nombre: " + nombre + " | " + "Desc: " + descripcion + "\n"
				+ "Precio: " + precioUnidad + "Stock: " + unidadesStock;
	}

	public abstract String generarCodigo();

	public static void mostrarProductos(JTextArea areaProductos) {

		for (Producto productos : Producto.getListaProductos()) {
			areaProductos.append(productos.toString());
			areaProductos.append(System.lineSeparator());
		}

	}

	public static Producto buscarProducto(String codigo) {
		for (Producto producto : getListaProductos()) {
			if (codigo.equalsIgnoreCase(producto.getCodigo())) {
				int unidadesStock = producto.getUnidadesStock();
				if (unidadesStock >= 1) {
					producto.setUnidadesStock(unidadesStock - 1);
					return producto;
				} else {
					JOptionPane.showMessageDialog(null, "No quedan unidades del producto " + codigo, "Error",
							JOptionPane.ERROR_MESSAGE);
					return null;
				}
			}
		}

		System.out.println("No existe ning�n producto con c�digo " + codigo);
		return null;
	}

}
