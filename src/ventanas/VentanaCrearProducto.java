package ventanas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractButton;
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

	private JPanel jp, jpBool;
	private JComboBox<String> listaProductos;
	private JButton crearProducto;
	private JTextField campoNombre, campoDescripcion, campoPrecioUnidad, campoUnidadesStock, campoColor, campoTipo,
			campoTamano, campoNum, campoEditorial, campoTematica, campoAutor;
	private JLabel txtCrear, txtNombre, txtDescripcion, txtPrecioUnidad, txtUnidadesStock, txtPuntaFina, txtColor, txtNumAnillas,
			txtConAnillas, txtTipo, txtNumColores, txtTamano, txtNumHojas, txtEditorial, txtTematica, txtAutor;
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

		listaProductos = new JComboBox<String>();
		listaProductos.setBounds(25, 50, 120, 20);
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
		
		txtCrear = ComponentesVentana.crearLabel("CREAR PRODUCTO", 280, 15, 180, 25, "#000000", true, jp);
		txtCrear.setFont(new Font("Verdana", Font.BOLD, 16));

		txtNombre = ComponentesVentana.crearLabel("Nombre", 175, 65, 100, 25, "#000000", true, jp);
		campoNombre = ComponentesVentana.crearTextField(275, 65, 100, 25, true, false, "#F5F5F5", jp);

		txtPrecioUnidad = ComponentesVentana.crearLabel("Precio Unidad", 395, 65, 100, 25, "#000000", true, jp);
		campoPrecioUnidad = ComponentesVentana.crearTextField(495, 65, 100, 25, true, false, "#F5F5F5", jp);

		txtDescripcion = ComponentesVentana.crearLabel("Descripción", 175, 100, 100, 25, "#000000", true, jp);
		campoDescripcion = ComponentesVentana.crearTextField(275, 100, 100, 25, true, false, "#F5F5F5", jp);

		txtUnidadesStock = ComponentesVentana.crearLabel("Unidades Stock", 395, 100, 100, 25, "#000000", true, jp);
		campoUnidadesStock = ComponentesVentana.crearTextField(495, 100, 100, 25, true, false, "#F5F5F5", jp);

		
		
		txtColor = ComponentesVentana.crearLabel("Color", 175, 135, 100, 25, "#000000", false, jp);
		campoColor = ComponentesVentana.crearTextField(275, 135, 100, 25, false, true, "#F5F5F5", jp);
		
		//se reutiliza la misma opción de radio button para ambos productos
		txtPuntaFina = ComponentesVentana.crearLabel("Punta fina", 395, 135, 100, 25, "#000000", false, jp);
		txtConAnillas = ComponentesVentana.crearLabel("Con anillas", 395, 135, 100, 25, "#000000", false, jp);
		si = ComponentesVentana.crearRadioButton("SÍ", 0, 0, 50, 25, "#B1C5D0");
		no = ComponentesVentana.crearRadioButton("NO", 50, 0, 50, 25, "#B1C5D0");
		bg = ComponentesVentana.crearButtonGroup(si, no);
		jpBool = ComponentesVentana.crearPanelRadioButton(si, no);
		jp.add(jpBool);
		
		//estas 3 etiquetas utilizan el mismo jtextfield porque son iguales en su funcionamiento
		txtNumAnillas = ComponentesVentana.crearLabel("Num anillas", 175, 170, 100, 25, "#000000", false, jp);
		txtNumColores = ComponentesVentana.crearLabel("Num colores", 175, 170, 100, 25, "#000000", false, jp);
		txtNumHojas = ComponentesVentana.crearLabel("Num hojas", 175, 170, 100, 25, "#000000", false, jp);
		campoNum = ComponentesVentana.crearTextField(275, 170, 100, 25, false, true, "#F5F5F5", jp);

		txtTamano = ComponentesVentana.crearLabel("Tamaño", 395, 170, 100, 25, "#000000", false, jp);
		campoTamano = ComponentesVentana.crearTextField(495, 170, 100, 25, false, true, "#F5F5F5", jp);

		txtTipo = ComponentesVentana.crearLabel("Tipo", 175, 135, 100, 25, "#000000", false, jp);
		campoTipo = ComponentesVentana.crearTextField(275, 135, 100, 25, false, true, "#F5F5F5", jp);

		txtEditorial = ComponentesVentana.crearLabel("Editorial", 175, 135, 100, 25, "#000000", false, jp);
		campoEditorial = ComponentesVentana.crearTextField(275, 135, 100, 25, false, true, "#F5F5F5", jp);

		txtTematica = ComponentesVentana.crearLabel("Temática", 395, 135, 100, 25, "#000000", false, jp);
		campoTematica = ComponentesVentana.crearTextField(495, 135, 100, 25, false, true, "#F5F5F5", jp);

		txtAutor = ComponentesVentana.crearLabel("Autor", 175, 170, 100, 25, "#000000", false, jp);
		campoAutor = ComponentesVentana.crearTextField(275, 170, 100, 25, false, true, "#F5F5F5", jp);

		crearProducto = ComponentesVentana.crearBoton("CREAR", 350, 215, 85, 25, 12, "#FFFFFF", jp);

		crearProducto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String seleccionado = (String) listaProductos.getSelectedItem();

				boolean campoBool = true;

				if (jpBool.isVisible() && bg.getSelection() == null) {

					JOptionPane.showMessageDialog(null, "Rellena el radio button");

				} else {
					if (si.isSelected()) {
						campoBool = true;
					} else {
						campoBool = false;
					}
					try {

						if (seleccionado.equalsIgnoreCase("BOLIGRAFO")) {
							Boligrafo boliNuevo = new Boligrafo(campoNombre.getText(), campoDescripcion.getText(),
									Double.parseDouble(campoPrecioUnidad.getText()),
									Integer.parseInt(campoUnidadesStock.getText()), campoBool, campoColor.getText());
						} else if (seleccionado.equalsIgnoreCase("CARPETA")) {

							if (no.isSelected() && Integer.parseInt(campoNum.getText()) != 0) {
								JOptionPane.showMessageDialog(null,
										"Es incompatible que el número de anillas con la condición \"No tiene anillas\".\nSe establecerá el valor 0 anillas.");
								campoNum.setText("0");
							} else {
								Carpeta carpetaNueva = new Carpeta(campoNombre.getText(), campoDescripcion.getText(),
										Double.parseDouble(campoPrecioUnidad.getText()),
										Integer.parseInt(campoUnidadesStock.getText()), campoBool,
										Integer.parseInt(campoNum.getText()), campoTamano.getText(),
										campoColor.getText());
							}

						} else if (seleccionado.equalsIgnoreCase("ESTUCHE")) {
							Estuche estucheNuevo = new Estuche(campoNombre.getText(), campoDescripcion.getText(),
									Double.parseDouble(campoPrecioUnidad.getText()),
									Integer.parseInt(campoUnidadesStock.getText()), campoTipo.getText(),
									Integer.parseInt(campoNum.getText()));
						} else if (seleccionado.equalsIgnoreCase("LIBRETA")) {
							Libreta libretaNueva = new Libreta(campoNombre.getText(), campoDescripcion.getText(),
									Double.parseDouble(campoPrecioUnidad.getText()),
									Integer.parseInt(campoUnidadesStock.getText()),
									Integer.parseInt(campoNum.getText()), campoTamano.getText(), campoColor.getText());
						} else if (seleccionado.equalsIgnoreCase("LIBRO")) {
							Libro libroNuevo = new Libro(campoNombre.getText(), campoDescripcion.getText(),
									Double.parseDouble(campoPrecioUnidad.getText()),
									Integer.parseInt(campoUnidadesStock.getText()), campoEditorial.getText(),
									campoTematica.getText(), campoAutor.getText());

						}

						JOptionPane.showMessageDialog(null, "Producto creado!");
						limpiarCampos();

					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "Tienes que introducir un número");
					}

				}

			}

		});
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
