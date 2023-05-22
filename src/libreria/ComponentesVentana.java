package libreria;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ComponentesVentana {

	public static JLabel crearLabel(String texto, int x, int y, int ancho, int alto, String colorFuente,
			boolean visible, JPanel jp) {
		JLabel etiqueta = new JLabel(texto);
		etiqueta.setBounds(x, y, ancho, alto);
		etiqueta.setForeground(Color.decode(colorFuente));
		etiqueta.setVisible(visible);
		jp.add(etiqueta);

		return etiqueta;
	}

	public static JTextField crearTextField(int x, int y, int ancho, int alto, boolean visible, boolean enabled,
			String color, JPanel jp) {
		JTextField campo = new JTextField();
		campo.setBounds(x, y, ancho, alto);
		campo.setBorder(new EmptyBorder(0, 1, 0, 0));
		campo.setBackground(Color.decode(color));
		campo.setHorizontalAlignment(SwingConstants.CENTER);
		campo.setVisible(visible);
		campo.setEnabled(enabled);
		jp.add(campo);
		return campo;
	}

	public static JSeparator crearSeparador(int x, int y, int ancho, int alto, String color) {
		JSeparator sep = new JSeparator();
		sep.setBounds(x, y, ancho, alto);
		sep.setBackground(Color.decode(color));
		sep.setForeground(Color.decode(color));
		return sep;
	}

	public static JButton crearBoton(String texto, int x, int y, int ancho, int alto, int tamanoLetra, String color,
			JPanel jp) {
		JButton boton = new JButton(texto);
		boton.setBounds(x, y, ancho, alto);
		boton.setFont(new Font("Arial", Font.BOLD, tamanoLetra));
		boton.setBackground(Color.decode(color));
		boton.setBorder(null);
		jp.add(boton);
		return boton;
	}

	public static JList<String> crearLista(JList<String> lista, Class<?> clase, JPanel jp) {
		lista = new JList<>();
		lista.setListData(VentanaComprar.obtenerListaProductos(clase));
		lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		lista.setBounds(350, 120, 200, 200);
		lista.setVisible(false);
		jp.add(lista);
		return lista;

	}

	public static JTextArea crearMensajeArea(String mensaje, int x, int y, int ancho, int alto, String color,
			String colorLetra) {
		JTextArea txtArea = new JTextArea(mensaje);
		txtArea.setBounds(x, y, ancho, alto);
		txtArea.setFont(new Font("ARIAL", Font.BOLD, 11));
		txtArea.setVisible(true);
		txtArea.setEditable(false);
		txtArea.setLineWrap(true);
		txtArea.setWrapStyleWord(true);
		txtArea.setBackground(Color.decode(color));
		txtArea.setForeground(Color.decode(colorLetra));
		txtArea.setEditable(false);

		return txtArea;
	}

	public static JRadioButton crearRadioButton(String opcion, int x, int y, int ancho, int alto, String colorLetra) {
		JRadioButton radio = new JRadioButton(opcion);
		radio.setBackground(Color.decode(colorLetra));
		radio.setBounds(x, y, ancho, alto);
		return radio;
	}

	public static JPanel crearRadioButtons(JRadioButton si, JRadioButton no, JPanel jp) {

		JPanel jpBool = new JPanel();
		jpBool.setBackground(Color.decode("#D1E8E5"));
		jpBool.setBounds(230, 140, 120, 30);

		ButtonGroup bg = new ButtonGroup();
		bg.add(si);
		bg.add(no);
		jpBool.add(si);
		jpBool.add(no);
		jpBool.setVisible(false);
		jp.add(jpBool);

		return jpBool;
	}

}
