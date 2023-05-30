package ventanas;

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

	public static JLabel crearLabel(String texto, int x, int y, int ancho, int alto, boolean visible, JPanel jp) {
		JLabel etiqueta = new JLabel(texto);
		etiqueta.setBounds(x, y, ancho, alto);
		etiqueta.setVisible(visible);
		jp.add(etiqueta);

		return etiqueta;
	}
	
	public static void fuenteLabel(JLabel etiqueta, String fuente, int estilo, int tamano, String colorFuente) {
		/* Font.PLAIN: 0.
		 * Font.BOLD:  1.
		 * Font.ITALIC: 2. */
		etiqueta.setFont(new Font(fuente, estilo, tamano));
		etiqueta.setForeground(Color.decode(colorFuente));
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

	public static JSeparator crearSeparador(int x, int y, int ancho, int alto, String color, JPanel jp) {
		JSeparator sep = new JSeparator();
		sep.setBounds(x, y, ancho, alto);
		sep.setBackground(Color.decode(color));
		sep.setForeground(Color.decode(color));
		jp.add(sep);

		return sep;
	}

	public static JButton crearBoton(String texto, int x, int y, int ancho, int alto, int tamanoLetra, String color,
			JPanel jp) {
		JButton boton = new JButton(texto);
		boton.setBounds(x, y, ancho, alto);
		boton.setFont(new Font("Gill Sans MT", Font.BOLD, tamanoLetra));
		boton.setBackground(Color.decode(color));
		boton.setVerticalAlignment(SwingConstants.CENTER);
		boton.setBorder(null);
		jp.add(boton);
		return boton;
	}

	public static JList<String> crearLista(JList<String> lista, Class<?> clase, JPanel jp) {
		lista = new JList<>();
		lista.setListData(VentanaComprar.obtenerListaProductos(clase));
		lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		lista.setBounds(350, 120, 230, 180);
		lista.setVisible(false);
		jp.add(lista);
		return lista;

	}

	public static JTextArea crearMensajeArea(String mensaje, int x, int y, int ancho, int alto, String tipoLetra, int tamanio, String color,
			String colorLetra) {
		JTextArea txtArea = new JTextArea(mensaje);
		txtArea.setBounds(x, y, ancho, alto);
		txtArea.setFont(new Font(tipoLetra, Font.BOLD, tamanio));
		txtArea.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
		txtArea.setAlignmentY(JTextArea.CENTER_ALIGNMENT);
		txtArea.setVisible(true);
		txtArea.setEditable(false);
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

	public static JPanel crearPanelRadioButton(JRadioButton si, JRadioButton no) {

		JPanel jpBool = new JPanel();
		jpBool.setLayout(null);
		jpBool.setBackground(Color.decode("#B1C5D0"));
		jpBool.setBounds(495, 165, 100, 25);
		jpBool.add(si);
		jpBool.add(no);
		jpBool.setLayout(null);
		jpBool.setVisible(false);
		return jpBool;
	}

	public static ButtonGroup crearButtonGroup(JRadioButton si, JRadioButton no) {
		ButtonGroup bg = new ButtonGroup();
		bg.add(si);
		bg.add(no);
		return bg;
	}


}
