package ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import libreria.Boligrafo;
import libreria.Carpeta;
import libreria.Cliente;
import libreria.Estuche;
import libreria.Libreta;
import libreria.Libro;
import libreria.Producto;

public class VentanaComprar extends JFrame {

	private JPanel jp, areaColor;
	private JButton btnSalir, btnBoligrafos, btnCarpetas, btnEstuches, btnLibretas, btnLibros, btnAnadir, btnMasInfo;
	private JList<String> listaBoligrafos, listaCarpetas, listaEstuches, listaLibretas, listaLibros;
	private JLabel txtPrincipal, txtSeleccionar;

	public VentanaComprar(Cliente cliente) {
		super("COMPRAR");
		
		jp = new JPanel();

		this.setContentPane(jp);
		
		
		this.setLayout(new GroupLayout(jp));
		this.setName("LIBERIA");
		jp.setBackground(Color.decode("#F1F0EE"));
		

		areaColor = new JPanel();
		areaColor.setBounds(0, 0, 640, 45);
		areaColor.setBackground(Color.decode("#B2C5D0"));
		jp.add(areaColor);

		txtPrincipal = ComponentesVentana.crearLabel("COMPRAR",280, 10, 180, 25, true, jp);
		ComponentesVentana.fuenteLabel(txtPrincipal, "Gill Sans Nova", 1, 16, "#F1F0EE");
		
		txtSeleccionar = ComponentesVentana.crearLabel("Para seleccionar varios productos al mismo tiempo mantén pulsado CONTROL.",40, 325, 540, 24, true, jp);
		ComponentesVentana.fuenteLabel(txtSeleccionar, "Arial", Font.ITALIC, 12, "#6384A6");
		
		
		btnSalir = ComponentesVentana.crearBoton("SALIR", 15, 3, 80, 20, 12, "#B2C5D0", jp);
		btnSalir.setForeground(Color.decode("#F1F0EE"));
		btnSalir.addActionListener(new ActionListener() {

			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		btnMasInfo = ComponentesVentana.crearBoton("+ INFO", 15, 22, 80, 20, 12, "#B2C5D0", jp);
		btnMasInfo.setForeground(Color.decode("#F1F0EE"));

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
		btnBoligrafos = ComponentesVentana.crearBoton("BOLIGRAFOS", 40, 130, 110, 25, 13, "#B2C5D0", jp);
		oyente(btnBoligrafos, listaBoligrafos);

		listaCarpetas = ComponentesVentana.crearLista(listaCarpetas, Carpeta.class, jp);
		btnCarpetas = ComponentesVentana.crearBoton("CARPETAS", 40, 230, 110, 25, 13, "#B2C5D0", jp);
		oyente(btnCarpetas, listaCarpetas);

		listaEstuches = ComponentesVentana.crearLista(listaEstuches, Estuche.class, jp);
		btnEstuches = ComponentesVentana.crearBoton("ESTUCHES", 190, 130, 110, 25, 13, "#B2C5D0", jp);
		oyente(btnEstuches, listaEstuches);

		listaLibretas = ComponentesVentana.crearLista(listaLibretas, Libreta.class, jp);
		btnLibretas = ComponentesVentana.crearBoton("LIBRETAS", 40, 180, 110, 25, 13, "#B2C5D0", jp);
		oyente(btnLibretas, listaLibretas);

		listaLibros = ComponentesVentana.crearLista(listaLibros, Libro.class, jp);
		btnLibros = ComponentesVentana.crearBoton("LIBROS", 190, 180, 110, 25, 13, "#B2C5D0", jp);
		oyente(btnLibros, listaLibros);

		btnAnadir = ComponentesVentana.crearBoton("AÑADIR", 190, 230, 110, 25, 13, "#6384A6", jp);
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

		

		jp.setComponentZOrder(areaColor, 10);

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



	public static String[] obtenerListaProductos(Class<?> clase) { // esto es como un comod�n para meter cualquier clase
		ArrayList<String> productos = new ArrayList<String>();

		for (Producto producto : Producto.getListaProductos()) {
			if (clase.isInstance(producto)) {
				productos.add(producto.getCodigo() + " - " + producto.getNombre() + " - " + producto.getPrecioUnidad()
						+ " €");
			}
		}

		return productos.toArray(new String[0]);
	}

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
	 * @param numCategoria -> indica en el m�todo anadirCarrito la letra correspondiente al tipo de producto
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
