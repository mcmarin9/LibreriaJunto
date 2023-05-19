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
	private JLabel txtPrincipal;

	public VentanaComprar(Cliente cliente) {

		jp = new JPanel();

		this.setContentPane(jp);
		
		
		this.setLayout(new GroupLayout(jp));
		this.setName("LIBERÍA");
		jp.setBackground(Color.decode("#F1F0EE"));

		txtPrincipal = new JLabel("COMPRAR");
		txtPrincipal.setBounds(320, 60, 180, 25);
		txtPrincipal.setFont(new Font("Arial", Font.BOLD, 30));
		jp.add(txtPrincipal);
		
		
		btnSalir = new JButton("SALIR");
		crearBoton(btnSalir, 15, 15, 80, 20, 12);
		btnSalir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		btnMasInfo = new JButton("+ INFO");
		crearBoton(btnMasInfo, 15, 35, 80, 20, 12);
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

		listaBoligrafos = new JList<>();
		crearLista(listaBoligrafos, Boligrafo.class);
		btnBoligrafos = new JButton("BOLIGRAFOS");
		crearBoton(btnBoligrafos, 40, 130, 120, 25, 16);
		oyente(btnBoligrafos, listaBoligrafos);

		listaCarpetas = new JList<>();
		crearLista(listaCarpetas, Carpeta.class);
		btnCarpetas = new JButton("CARPETAS");
		crearBoton(btnCarpetas, 40, 230, 110, 25, 16);
		oyente(btnCarpetas, listaCarpetas);

		listaEstuches = new JList<>();
		crearLista(listaEstuches, Estuche.class);
		btnEstuches = new JButton("ESTUCHES");
		crearBoton(btnEstuches, 190, 130, 110, 25, 16);
		oyente(btnEstuches, listaEstuches);

		listaLibretas = new JList<>();
		crearLista(listaLibretas, Libreta.class);
		btnLibretas = new JButton("LIBRETAS");
		crearBoton(btnLibretas, 40, 180, 110, 25, 16);
		oyente(btnLibretas, listaLibretas);

		listaLibros = new JList<>();
		crearLista(listaLibros, Libro.class);
		btnLibros = new JButton("LIBROS");
		crearBoton(btnLibros, 190, 180, 110, 25, 16);
		oyente(btnLibros, listaLibros);

		btnAnadir = new JButton("AÑADIR AL CARRITO");
		crearBoton(btnAnadir, 190, 230, 110, 25, 16);
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

	private void crearBoton(JButton btn, int x, int y, int ancho, int alto, int tamanoLetra) {
		btn.setBounds(x, y, ancho, alto);
		btn.setFont(new Font("Arial", Font.BOLD, tamanoLetra));
		btn.setBackground(Color.decode("#6384A6"));
		btn.setBorder(null);
		jp.add(btn);

	}

	private void crearLista(JList<String> lista, Class<?> clase) {
		lista.setListData(obtenerListaProductos(clase));
		lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		lista.setBounds(350, 120, 200, 200);
		lista.setVisible(false);
		jp.add(lista);

	}

	private String[] obtenerListaProductos(Class<?> clase) { // esto es como un comodín para meter cualquier clase
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
	 * @param cliente
	 * @param numCategoria -> con este número se indica la posición del array
	 *                     correspondiente a la letra del código del producto
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
