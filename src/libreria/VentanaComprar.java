package libreria;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class VentanaComprar extends JFrame {

	private JPanel jp;
	private JButton btnSalir, btnBoligrafos, btnCarpetas, btnEstuches, btnLibretas, btnLibros, btnAnadir, btnMasInfo;
	private JList<String> listaBoligrafos, listaCarpetas, listaEstuches, listaLibretas, listaLibros;
	private JLabel txtPrincipal, txtSeleccionar;

	public VentanaComprar(Cliente cliente) {

		jp = new JPanel();

		this.setContentPane(jp);
		
		
		this.setLayout(new GroupLayout(jp));
		this.setName("LIBERÍA");
		jp.setBackground(Color.decode("#F1F0EE"));

		txtPrincipal = ComponentesVentana.crearLabel("COMPRAR",320, 60, 180, 25, "#000000", true, jp);
		txtPrincipal.setFont(new Font("Arial", Font.BOLD, 16));
		
		txtPrincipal = ComponentesVentana.crearLabel("Para seleccionar varios productos al mismo tiempo mantén pulsado SHIFT.",15, 315, 540, 25, "#000000", true, jp);
		txtPrincipal.setFont(new Font("Arial", Font.ITALIC, 16));
		
		
		btnSalir = ComponentesVentana.crearBoton("SALIR", 15, 15, 80, 20, 12, "#6384A6", jp);
		btnSalir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		btnMasInfo = ComponentesVentana.crearBoton("+ INFO", 15, 35, 80, 20, 12, "#6384A6", jp);
		btnMasInfo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (listaBoligrafos.isVisible()) {
					verMasInfo(listaBoligrafos, 1, Boligrafo.class);
				} else if (listaCarpetas.isVisible()) {
					verMasInfo(listaCarpetas, 2, Carpeta.class);
				} else if (listaEstuches.isVisible()) {
					verMasInfo(listaEstuches, 3, Estuche.class);
				} else if (listaLibretas.isVisible()) {
					verMasInfo(listaLibretas, 4, Libreta.class);
				} else if (listaLibros.isVisible()) {
					verMasInfo(listaLibros, 5, Libro.class);
				}
			}
		});

		listaBoligrafos = ComponentesVentana.crearLista(listaBoligrafos, Boligrafo.class, jp);
		btnBoligrafos = ComponentesVentana.crearBoton("BOLIGRAFOS", 40, 130, 110, 25, 16, "#6384A6", jp);
		oyente(btnBoligrafos, listaBoligrafos);

		listaCarpetas = ComponentesVentana.crearLista(listaCarpetas, Carpeta.class, jp);
		btnCarpetas = ComponentesVentana.crearBoton("CARPETAS", 40, 230, 110, 25, 16, "#6384A6", jp);
		oyente(btnCarpetas, listaCarpetas);

		listaEstuches = ComponentesVentana.crearLista(listaEstuches, Estuche.class, jp);
		btnEstuches = ComponentesVentana.crearBoton("ESTUCHES", 190, 130, 110, 25, 16, "#6384A6", jp);
		oyente(btnEstuches, listaEstuches);

		listaLibretas = ComponentesVentana.crearLista(listaLibretas, Libreta.class, jp);
		btnLibretas = ComponentesVentana.crearBoton("LIBRETAS", 40, 180, 110, 25, 16, "#6384A6", jp);
		oyente(btnLibretas, listaLibretas);

		listaLibros = ComponentesVentana.crearLista(listaLibros, Libro.class, jp);
		btnLibros = ComponentesVentana.crearBoton("LIBROS", 190, 180, 110, 25, 16, "#6384A6", jp);
		oyente(btnLibros, listaLibros);

		btnAnadir = ComponentesVentana.crearBoton("AÑADIR AL CARRITO", 190, 230, 110, 25, 16, "#6384A6", jp);
		btnAnadir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (listaBoligrafos.isVisible()) {
					guardarProducto(cliente, 1, listaBoligrafos);
				} else if (listaCarpetas.isVisible()) {
					guardarProducto(cliente, 2, listaCarpetas);
				} else if (listaEstuches.isVisible()) {
					guardarProducto(cliente, 3, listaEstuches);
				} else if (listaLibretas.isVisible()) {
					guardarProducto(cliente, 4, listaLibretas);
				} else if (listaLibros.isVisible()) {
					guardarProducto(cliente, 5, listaLibros);
				}
			}
		});

		

		this.setResizable(false);
		this.setSize(650, 400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	public void oyente(JButton btn, JList<String> lista) {
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ocultar(lista);

			}
		});
	}



	public static String[] obtenerListaProductos(Class<?> clase) { // esto es como un comodín para meter cualquier clase
		ArrayList<String> productos = new ArrayList<String>();

		for (Producto producto : Producto.getListaProductos()) {
			if (clase.isInstance(producto)) {
				productos.add(producto.getCodigo() + " - " + producto.getNombre() + " - " + producto.getPrecioUnidad()
						+ " €");
			}
		}

		return productos.toArray(new String[0]);
	}

/**
 * 
 * @param lista
 * @param numCategoria
 * @param clase
 */
	private void verMasInfo(JList<String> lista, int numCategoria, Class<?> clase) {

		final String[] LETRAS = { "", "B", "C", "E", "LT",  "LB"};

		String letraCodigo = LETRAS[numCategoria];

		String codigoProducto = "";

		int[] productosSeleccionados = lista.getSelectedIndices();

		for (int i = 0; i < productosSeleccionados.length; i++) {
			int numProducto = productosSeleccionados[i];

			String numProductoStr = String.format("%03d", numProducto);
			codigoProducto = letraCodigo + numProductoStr;

			for (Producto producto : Producto.getListaProductos()) {
				if (producto.getCodigo().equals(codigoProducto) && clase.isInstance(producto)) {

					String infoProducto = producto.toString();

					JOptionPane.showMessageDialog(null, infoProducto, "Información del producto",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}

	/**
	 * @param cliente
	 * @param numCategoria -> indica en el método anadirCarrito la letra correspondiente al tipo de producto
	 * @param lista -> es una lista por si se añade más de un producto a la vez
	 */
	
	private void guardarProducto(Cliente cliente, int numCategoria, JList<String> lista) {

		int numProducto = 0;
		String numProductoStr = "";

		int[] productosSeleccionados = lista.getSelectedIndices();

		for (int i = 0; i < productosSeleccionados.length; i++) {
			numProducto = productosSeleccionados[i];
			numProductoStr = String.format("%03d", numProducto);
			cliente.anadirCarrito(numCategoria, numProductoStr);
		}

	}

	private void ocultar(JList<String> lista) {
		lista.clearSelection();

		listaBoligrafos.setVisible(false);
		listaCarpetas.setVisible(false);
		listaEstuches.setVisible(false);
		listaLibretas.setVisible(false);
		listaLibros.setVisible(false);

		lista.setVisible(true);

	}

}
