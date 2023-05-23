package libreria;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Cliente {
	private String nombre;
	private String telefono;

	private ArrayList<Producto> listaCompra;
	private static ArrayList<Cliente> listaClientes = new ArrayList<>();

	public Cliente() {

	}

	public Cliente(String nombre, String telefono) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.listaCompra = new ArrayList<>();

		listaClientes.add(this);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public ArrayList<Producto> getListaCompra() {
		return listaCompra;
	}

	public void setLista_compra(ArrayList<Producto> listaCompra) {
		this.listaCompra = listaCompra;
	}

	public static ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		Cliente.listaClientes = listaClientes;
	}

	@Override
	public String toString() {
		return "Cliente [n=" + nombre + ", telefono=" + telefono + ", listaCompra=" + listaCompra + "]";
	}

	public static Cliente iniciarSesion(String n, String tlf) {
		boolean encontrado = false;
		Cliente nuevoCliente = null;

		for (Cliente cliente : getListaClientes()) {
			if (!n.equalsIgnoreCase(cliente.getNombre()) && tlf.equalsIgnoreCase(cliente.getTelefono())) {
				encontrado = true;
				cliente = null;
				return cliente;
				
			} else if (n.equalsIgnoreCase(cliente.getNombre()) && tlf.equalsIgnoreCase(cliente.getTelefono())) {
				encontrado = true;
				return cliente;
			}
		}

		if (!encontrado) {
			int respuesta = JOptionPane.showConfirmDialog(null,
					"No se ha encontrado ningún cliente con esos datos. ¿Desea registrarlo en el sistema?",
					"Confirmación", JOptionPane.YES_NO_OPTION);
			if (respuesta == JOptionPane.YES_OPTION) {
				nuevoCliente = new Cliente(n, tlf);
				return nuevoCliente;
			} else if (respuesta == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null,
						"Para entrar a la tienda tienes que estár registrado. Por favor introduce un usuario y teléfono válidos o acepta el registro.");
			}

		}
		return null;

	}

	/**
	 * Este método compone el código de producto formado por una letra y un número de tres dígitos y 
	 * llama a buscarProducto para que si existe el producto y si quedan unidades. 
	 * @param numCategoria
	 * @param numProducto
	 */
	public void anadirCarrito(int numCategoria, String numProducto) {
		String codigoProducto = null;
		Producto productoEncontrado = null;

		String letraCodigo = "";
		final String[] LETRAS = { "", "B", "C", "E", "LT", "LB" };

		letraCodigo = LETRAS[numCategoria];
		codigoProducto = letraCodigo + numProducto;
		System.out.println("Codigo producto:" + codigoProducto);
		productoEncontrado = Producto.buscarProducto(codigoProducto);

		if (productoEncontrado != null) {
			listaCompra.add(productoEncontrado);
			System.out.println("Producto añadido a la lista de la compra.");
		}
	}

	public int mostrarListaCompra(JTextArea areaTexto) {

		int contador = 1;

		if (getListaCompra().isEmpty()) {
			JOptionPane.showMessageDialog(null, "La lista de la compra está vacía");
		} else {
			for (Producto productoEnLista : getListaCompra()) {
				areaTexto.append("PRODUCTO " + contador
						+ "\n");
				areaTexto.append(productoEnLista.getCodigo() + "   -   " + productoEnLista.getNombre() + "\n");
				areaTexto.append(Double.toString(productoEnLista.getPrecioUnidad()) + " €");
				contador++;
				areaTexto.append(System.lineSeparator());
			}
		}
		
		return contador; 
	}

	public double pagar() {

		double total = precioTotal();

		if (total != 0) {
			JOptionPane.showMessageDialog(null,
					"Gracias por su compra, el total es: " + Math.round(total * 100.0) / 100.0 + " €");
			getListaCompra().clear();

		} else {
			JOptionPane.showMessageDialog(null, "El carrito de la compra está vacío.", "Carrito vacio",
					JOptionPane.ERROR_MESSAGE);
		}

		return Math.round(total * 100.0) / 100.0;
	}

	public double precioTotal() {

		double total = 0;

		for (Producto producto : getListaCompra()) {
			total += producto.getPrecioUnidad();
		}
		return total;
	}
	
	

}
