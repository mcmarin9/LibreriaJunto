package libreria;

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

public class VentanaCrearProducto extends JFrame {

	private JPanel jp, jpBool;
	private JComboBox<String> listaProductos;
	private JButton crearProducto;
	private JTextField campoNombre, campoDescripcion, campoPrecioUnidad, campoUnidadesStock, campoColor, campoTipo,
			campoTamano, campoNum, campoEditorial, campoTematica, campoAutor;
	private JLabel txtNombre, txtDescripcion, txtPrecioUnidad, txtUnidadesStock, txtPuntaFina, txtColor, txtNumAnillas,
			txtConAnillas, txtTipo, txtNumColores, txtTamano, txtNumHojas, txtEditorial, txtTematica, txtAutor;
	private ButtonGroup bg;
	private JRadioButton si, no;

	public VentanaCrearProducto() {

		jp = new JPanel();

		this.setContentPane(jp);
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(new GroupLayout(jp));
		this.setName("AÑADIR PRODUCTO");
		jp.setBackground(Color.decode("#D1E8E5"));

		this.setVisible(true);

		listaProductos = new JComboBox<String>();
		listaProductos.setBounds(10, 10, 110, 20);
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

		txtNombre = ComponentesVentana.crearLabel("Nombre", 135, 30, 80, 20, "#000000", true, jp);
		txtDescripcion = ComponentesVentana.crearLabel("Descripción", 135, 55, 80, 20, "#000000", true, jp);
		txtPrecioUnidad = ComponentesVentana.crearLabel("Precio Unidad", 135, 80, 80, 20, "#000000", true, jp);
		txtUnidadesStock = ComponentesVentana.crearLabel("Unidades Stock", 135, 105, 80, 20, "#000000", true, jp);

		campoNombre = ComponentesVentana.crearTextField(225, 30, 80, 20, true, false, "#F5F5F5", jp);
		campoDescripcion = ComponentesVentana.crearTextField(225, 55, 80, 20, true, false, "#F5F5F5", jp);
		campoPrecioUnidad = ComponentesVentana.crearTextField(225, 80, 80, 20, true, false, "#F5F5F5", jp);
		campoUnidadesStock = ComponentesVentana.crearTextField(225, 105, 80, 20, true, false, "#F5F5F5", jp);

		txtColor = ComponentesVentana.crearLabel("Color", 10, 145, 80, 20, "#000000", false, jp);
		campoColor = ComponentesVentana.crearTextField(80, 145, 80, 20, false, true, "#F5F5F5", jp);

		txtPuntaFina = ComponentesVentana.crearLabel("Punta fina", 175, 145, 80, 20, "#000000", false, jp);
		txtConAnillas = ComponentesVentana.crearLabel("Con anillas", 175, 145, 80, 20, "#000000", false, jp);

		
		si = ComponentesVentana.crearRadioButton("SÍ", 0, 0, 60, 20, "#D1E8E5");
		no = ComponentesVentana.crearRadioButton("NO", 70, 0, 60, 20, "#D1E8E5");

		/*si = new JRadioButton("SÍ");
		si.setBackground(Color.decode("#D1E8E5"));
		si.setBounds(0, 0, 60, 20);
		no = new JRadioButton("NO");
		no.setBackground(Color.decode("#D1E8E5"));
		no.setBounds(70, 0, 60, 20);
		 */
		/*
		jpBool = new JPanel();
		jpBool.setBackground(Color.decode("#D1E8E5"));
		jpBool.setBounds(230, 140, 120, 30);

		bg = new ButtonGroup();
		bg.add(si);
		bg.add(no);
		jpBool.add(si);
		jpBool.add(no);
		jpBool.setVisible(false);
		jp.add(jpBool);
		*/
		jpBool = ComponentesVentana.crearRadioButtons(si, no, jp);

		txtNumAnillas = ComponentesVentana.crearLabel("Num anillas", 10, 170, 80, 20, "#000000", false, jp);

		txtTamano = ComponentesVentana.crearLabel("Tamaño", 175, 170, 80, 20, "#000000", false, jp);

		campoTamano = ComponentesVentana.crearTextField(230, 170, 80, 20, false, true, "#F5F5F5", jp);

		txtTipo = ComponentesVentana.crearLabel("Tipo", 10, 145, 80, 20, "#000000", false, jp);
		campoTipo = ComponentesVentana.crearTextField(80, 145, 80, 20, false, true, "#F5F5F5", jp);

		txtNumColores = ComponentesVentana.crearLabel("Num colores", 10, 170, 80, 20, "#000000", false, jp);
		txtNumHojas = ComponentesVentana.crearLabel("Num hojas", 10, 170, 80, 20, "#000000", false, jp);
		campoNum = ComponentesVentana.crearTextField(80, 170, 80, 20, false, true, "#F5F5F5", jp);

		txtEditorial = ComponentesVentana.crearLabel("Editorial", 10, 145, 80, 20, "#000000", false, jp);
		campoEditorial = ComponentesVentana.crearTextField(80, 145, 80, 20, false, true, "#F5F5F5", jp);

		txtTematica = ComponentesVentana.crearLabel("Temática", 175, 145, 80, 20, "#000000", false, jp);
		campoTematica = ComponentesVentana.crearTextField(230, 145, 80, 20, false, true, "#F5F5F5", jp);

		txtAutor = ComponentesVentana.crearLabel("Autor", 10, 170, 80, 20, "#000000", false, jp);
		campoAutor = ComponentesVentana.crearTextField(80, 170, 80, 20, false, true, "#F5F5F5", jp);

		crearProducto = ComponentesVentana.crearBoton("CREAR", 155, 200, 50, 20, 12, "#B1C5D0", jp);

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
							// si campoBool es false el numero de anillas va a ser 0

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
