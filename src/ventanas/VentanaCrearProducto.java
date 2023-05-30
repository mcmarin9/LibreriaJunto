package ventanas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import libreria.Boligrafo;
import libreria.Carpeta;
import libreria.Estuche;
import libreria.Libreta;
import libreria.Libro;

public class VentanaCrearProducto extends JFrame {

	private JPanel jp, jpBool, areaColor;
	private JComboBox<String> listaProductos;
	private JButton btnCrearProducto;
	private JTextField campoNombre, campoDescripcion, campoPrecioUnidad, campoUnidadesStock, campoColor, campoTipo,
			campoTamano, campoNum, campoEditorial, campoTematica, campoAutor;
	private JLabel txtCrear, txtNombre, txtDescripcion, txtPrecioUnidad, txtUnidadesStock, txtPuntaFina, txtColor,
			txtNumAnillas, txtConAnillas, txtTipo, txtNumColores, txtTamano, txtNumHojas, txtEditorial, txtTematica,
			txtAutor;
	private ButtonGroup bg;
	private JRadioButton si, no;

	public VentanaCrearProducto() {

		super("CREAR PRODUCTO");

		jp = new JPanel();
		this.setContentPane(jp);
		this.setSize(700, 360);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(new GroupLayout(jp));
		jp.setBackground(Color.decode("#B1C5D0"));

		this.setVisible(true);

		areaColor = new JPanel();
		areaColor.setBounds(0, 0, 700, 45);
		areaColor.setBackground(Color.decode("#FFFFFF"));
		jp.add(areaColor);

		listaProductos = new JComboBox<String>();
		listaProductos.setBounds(25, 100, 120, 20);
		add(listaProductos);

		listaProductos.addItem("---------");
		listaProductos.addItem("BOLIGRAFO");
		listaProductos.addItem("CARPETA");
		listaProductos.addItem("ESTUCHE");
		listaProductos.addItem("LIBRETA");
		listaProductos.addItem("LIBRO");
		listaProductos.setSelectedItem("---------");

		listaProductos.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				actualizarCampos();

			}
		});

		jp.add(listaProductos);

		txtCrear = ComponentesVentana.crearLabel("CREAR PRODUCTO", 260, 10, 180, 25, true, jp);
		ComponentesVentana.fuenteLabel(txtCrear, "Gill Sans MT", 1, 16, "#FFFFFF");
		txtCrear.setForeground(Color.decode("#B1C5D0"));

		// CAMPOS COMUNES
		txtNombre = ComponentesVentana.crearLabel("Nombre", 175, 95, 100, 25, true, jp);
		campoNombre = ComponentesVentana.crearTextField(275, 95, 100, 25, true, false, "#F5F5F5", jp);

		txtPrecioUnidad = ComponentesVentana.crearLabel("Precio Unidad", 395, 95, 100, 25, true, jp);
		campoPrecioUnidad = ComponentesVentana.crearTextField(495, 95, 100, 25, true, false, "#F5F5F5", jp);

		txtDescripcion = ComponentesVentana.crearLabel("Descripción", 175, 130, 100, 25, true, jp);
		campoDescripcion = ComponentesVentana.crearTextField(275, 130, 100, 25, true, false, "#F5F5F5", jp);

		txtUnidadesStock = ComponentesVentana.crearLabel("Unidades Stock", 395, 130, 100, 25, true, jp);
		campoUnidadesStock = ComponentesVentana.crearTextField(495, 130, 100, 25, true, false, "#F5F5F5", jp);

		// CAMPOS ESPECIFICOS
		txtColor = ComponentesVentana.crearLabel("Color", 175, 165, 100, 25, false, jp);
		campoColor = ComponentesVentana.crearTextField(275, 165, 100, 25, false, true, "#F5F5F5", jp);

		// se reutiliza la misma opción de radio button para ambos productos
		txtPuntaFina = ComponentesVentana.crearLabel("Punta fina", 395, 165, 100, 25, false, jp);
		txtConAnillas = ComponentesVentana.crearLabel("Con anillas", 395, 165, 100, 25, false, jp);
		si = ComponentesVentana.crearRadioButton("SÍ", 0, 0, 50, 25, "#B1C5D0");
		no = ComponentesVentana.crearRadioButton("NO", 50, 0, 50, 25, "#B1C5D0");
		bg = ComponentesVentana.crearButtonGroup(si, no);
		jpBool = ComponentesVentana.crearPanelRadioButton(si, no);
		jp.add(jpBool);

		// estas 3 etiquetas utilizan el mismo jtextfield porque son iguales en su
		// funcionamiento
		txtNumAnillas = ComponentesVentana.crearLabel("Num anillas", 175, 200, 100, 25, false, jp);
		txtNumColores = ComponentesVentana.crearLabel("Num colores", 175, 200, 100, 25, false, jp);
		txtNumHojas = ComponentesVentana.crearLabel("Num hojas", 175, 200, 100, 25, false, jp);
		campoNum = ComponentesVentana.crearTextField(275, 200, 100, 25, false, true, "#F5F5F5", jp);

		txtTamano = ComponentesVentana.crearLabel("Tamaño", 395, 200, 100, 25, false, jp);
		campoTamano = ComponentesVentana.crearTextField(495, 200, 100, 25, false, true, "#F5F5F5", jp);

		txtTipo = ComponentesVentana.crearLabel("Tipo", 175, 165, 100, 25, false, jp);
		campoTipo = ComponentesVentana.crearTextField(275, 165, 100, 25, false, true, "#F5F5F5", jp);

		txtEditorial = ComponentesVentana.crearLabel("Editorial", 175, 165, 100, 25, false, jp);
		campoEditorial = ComponentesVentana.crearTextField(275, 165, 100, 25, false, true, "#F5F5F5", jp);

		txtTematica = ComponentesVentana.crearLabel("Temática", 395, 165, 100, 25, false, jp);
		campoTematica = ComponentesVentana.crearTextField(495, 165, 100, 25, false, true, "#F5F5F5", jp);

		txtAutor = ComponentesVentana.crearLabel("Autor", 175, 200, 100, 25, false, jp);
		campoAutor = ComponentesVentana.crearTextField(275, 200, 100, 25, false, true, "#F5F5F5", jp);

		btnCrearProducto = ComponentesVentana.crearBoton("CREAR", 300, 265, 85, 25, 12, "#FFFFFF", jp);
		btnCrearProducto.setForeground(Color.decode("#B1C5D0"));

		btnCrearProducto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				crearProducto();

			}

		});

		jp.setComponentZOrder(txtCrear, 0);

	}

	private void crearProducto() {
		String seleccionado = (String) listaProductos.getSelectedItem();

		boolean campoBool = true;

		if (si.isSelected()) {
			campoBool = true;
		} else {
			campoBool = false;
		}

		try {
			// CREACION DE LOS PRODUCTOS
			switch (seleccionado.toUpperCase()) {
			case "BOLIGRAFO":
				if (!campoVacio(campoColor) && controlErroresGeneral()) {
					Boligrafo boliNuevo = new Boligrafo(obtenerTexto(campoNombre), obtenerTexto(campoDescripcion),
							Double.parseDouble(obtenerTexto(campoPrecioUnidad)),
							Integer.parseInt(obtenerTexto(campoUnidadesStock)), campoBool, obtenerTexto(campoColor));
					creacionExito();
				} else {
					mostrarMensajeError("Rellena todos los campos.");
				}
				break;

			case "CARPETA":
				if (!campoVacio(campoNum) && !campoVacio(campoTamano) && !campoVacio(campoColor) && controlErroresGeneral()) {
					if (no.isSelected() && Integer.parseInt(obtenerTexto(campoNum)) != 0) {
						mostrarMensajeError(
								"Es incompatible que el número de anillas sea distinto de 0 con la condición \"No tiene anillas\".\nSe establecerá el valor 0 para las anillas.");
						campoNum.setText("0");
					} else {
						Carpeta carpetaNueva = new Carpeta(obtenerTexto(campoNombre), obtenerTexto(campoDescripcion),
								Double.parseDouble(obtenerTexto(campoPrecioUnidad)),
								Integer.parseInt(obtenerTexto(campoUnidadesStock)), campoBool,
								Integer.parseInt(obtenerTexto(campoNum)), obtenerTexto(campoTamano),
								obtenerTexto(campoColor));
						creacionExito();
					}
				} else {
					mostrarMensajeError("Rellena todos los campos.");
				}
				break;

			case "ESTUCHE":
	
				if (!campoVacio(campoTipo) && !campoVacio(campoNum) && controlErroresGeneral()) {
					Estuche estucheNuevo = new Estuche(obtenerTexto(campoNombre), obtenerTexto(campoDescripcion),
							Double.parseDouble(obtenerTexto(campoPrecioUnidad)),
							Integer.parseInt(obtenerTexto(campoUnidadesStock)), obtenerTexto(campoTipo),
							Integer.parseInt(obtenerTexto(campoNum)));
					creacionExito();
				} else {
					mostrarMensajeError("Rellena todos los campos.");
				}
				break;

			case "LIBRETA":
				if (!campoVacio(campoNum) && !campoVacio(campoTamano) && !campoVacio(campoColor) && controlErroresGeneral()) {
					Libreta libretaNueva = new Libreta(obtenerTexto(campoNombre), obtenerTexto(campoDescripcion),
							Double.parseDouble(obtenerTexto(campoPrecioUnidad)),
							Integer.parseInt(obtenerTexto(campoUnidadesStock)),
							Integer.parseInt(obtenerTexto(campoNum)), obtenerTexto(campoTamano),
							obtenerTexto(campoColor));
					creacionExito();

				} else {
					mostrarMensajeError("Rellena todos los campos.");
				}
				break;

			case "LIBRO":
				if (!campoVacio(campoEditorial) && !campoVacio(campoTematica) && !campoVacio(campoAutor) && controlErroresGeneral()) {
					Libro libroNuevo = new Libro(obtenerTexto(campoNombre), obtenerTexto(campoDescripcion),
							Double.parseDouble(obtenerTexto(campoPrecioUnidad)),
							Integer.parseInt(obtenerTexto(campoUnidadesStock)), obtenerTexto(campoEditorial),
							obtenerTexto(campoTematica), obtenerTexto(campoAutor));
					creacionExito();

				} else {
					mostrarMensajeError("Rellena todos los campos.");
				}
				break;

			default:
				mostrarMensajeError("Selecciona un producto válido.");
				break;
			}
		} catch (NumberFormatException e) {
			mostrarMensajeError("Tienes que introducir un número válido");
		}
	}

	private boolean controlErroresGeneral() {

		if (jpBool.isVisible() && bg.getSelection() == null) {
			return false;
		}

		if (campoVacio(campoNombre) || campoVacio(campoDescripcion) || campoVacio(campoPrecioUnidad)
				|| campoVacio(campoUnidadesStock)) {
			return false;
		}

		if (!campoNumerico(campoPrecioUnidad, double.class) || !campoNumerico(campoUnidadesStock, int.class)
				|| (campoNum.isVisible() && !campoNumerico(campoNum, int.class))) {
			return false;
		}

		return true;
	}

	private boolean campoVacio(JTextField campo) {
		String texto = obtenerTexto(campo);
		if (texto.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	private void creacionExito() {
		JOptionPane.showMessageDialog(null, "Producto creado!");
		limpiarCampos();
	}

	private void mostrarMensajeError(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

	private String obtenerTexto(JTextField campo) {
		return campo.getText();
	}

	private boolean campoNumerico(JTextField campo, Class<?> tipo) {
		String texto = obtenerTexto(campo);

		try {
			if (tipo == int.class) {
				Integer.parseInt(texto);
			} else if (tipo == double.class) {
				Double.parseDouble(texto);
			}
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private void actualizarCampos() {
		String seleccionado = (String) listaProductos.getSelectedItem();
		boolean productoSeleccionado = !seleccionado.equals("---------");

		campoNombre.setEnabled(productoSeleccionado);
		campoDescripcion.setEnabled(productoSeleccionado);
		campoPrecioUnidad.setEnabled(productoSeleccionado);
		campoUnidadesStock.setEnabled(productoSeleccionado);

		ocultarTodosLosCampos();

		if (seleccionado.equalsIgnoreCase("BOLIGRAFO")) {
			txtColor.setVisible(true);
			campoColor.setVisible(true);
			txtPuntaFina.setVisible(true);
			jpBool.setVisible(true);
		} else if (seleccionado.equalsIgnoreCase("CARPETA")) {
			txtColor.setVisible(true);
			campoColor.setVisible(true);
			txtConAnillas.setVisible(true);
			jpBool.setVisible(true);
			txtNumAnillas.setVisible(true);
			campoNum.setVisible(true);
			txtTamano.setVisible(true);
			campoTamano.setVisible(true);
		} else if (seleccionado.equalsIgnoreCase("ESTUCHE")) {
			txtTipo.setVisible(true);
			campoTipo.setVisible(true);
			txtNumColores.setVisible(true);
			campoNum.setVisible(true);
		} else if (seleccionado.equalsIgnoreCase("LIBRETA")) {
			txtColor.setVisible(true);
			campoColor.setVisible(true);
			txtNumHojas.setVisible(true);
			campoNum.setVisible(true);
			txtTamano.setVisible(true);
			campoTamano.setVisible(true);
		} else if (seleccionado.equalsIgnoreCase("LIBRO")) {
			txtEditorial.setVisible(true);
			campoEditorial.setVisible(true);
			txtTematica.setVisible(true);
			campoTematica.setVisible(true);
			txtAutor.setVisible(true);
			campoAutor.setVisible(true);

		}

		jp.revalidate();
		jp.repaint();
	}

	private void ocultarTodosLosCampos() {

		txtColor.setVisible(false);
		campoColor.setVisible(false);
		txtPuntaFina.setVisible(false);
		jpBool.setVisible(false);
		txtConAnillas.setVisible(false);
		txtNumAnillas.setVisible(false);
		txtTamano.setVisible(false);
		campoTamano.setVisible(false);
		txtTipo.setVisible(false);
		campoTipo.setVisible(false);
		txtNumColores.setVisible(false);
		txtNumHojas.setVisible(false);
		campoNum.setVisible(false);
		txtEditorial.setVisible(false);
		campoEditorial.setVisible(false);
		txtTematica.setVisible(false);
		campoTematica.setVisible(false);
		txtAutor.setVisible(false);
		campoAutor.setVisible(false);

	}

	private void limpiarCampos() {
		campoNombre.setText("");
		campoDescripcion.setText("");
		campoPrecioUnidad.setText("");
		campoUnidadesStock.setText("");
		bg.clearSelection();

		campoColor.setText("");
		campoTamano.setText("");
		campoTipo.setText("");
		campoNum.setText("");
		campoEditorial.setText("");
		campoTematica.setText("");
		campoAutor.setText("");

	}

}
