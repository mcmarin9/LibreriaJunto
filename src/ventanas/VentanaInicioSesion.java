package ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import libreria.Cliente;

public class VentanaInicioSesion extends JFrame {

	private Cliente cliente;
	private JButton iniciarSesion;
	private JTextField campoTelefono, campoNombre;
	private JLabel error, nombre, telefono, inicioSesion, bienvenido;
	private JPanel jp, areaColor;
	private JTextArea mensaje;

	public VentanaInicioSesion() {
		super("The Meow Desk");
		jp = new JPanel();
		this.setContentPane(jp);
		this.setLayout(new GroupLayout(jp));
		jp.setBackground(Color.white);

		// MENSAJES ERRORES
		error = ComponentesVentana.crearLabel("", 50, 320, 320, 20, true, jp);

		// Panel de color
		areaColor = new JPanel();
		areaColor.setBounds(350, 0, 420, 420);
		areaColor.setBackground(Color.decode("#B1C5D0"));
		bienvenido = ComponentesVentana.crearLabel("BIENVENID@!", 420, 130, 450, 40, true, jp);

		mensaje = ComponentesVentana.crearMensajeArea(
				"Introduzca su información personal para poder \n     disfrutar de una experiencia excepcional!", 375,
				180, 290, 140, "Arial", 13, "#B2C5D0", "#FFFFFF");
		jp.add(mensaje);
		jp.add(areaColor);

		// INICIO SESION

		inicioSesion = ComponentesVentana.crearLabel("INICIA SESION EN TMD", 40, 15, 300, 42, true, jp);

		JSeparator separador = ComponentesVentana.crearSeparador(23, 55, 300, 25, "#B2C5D0", jp);

		nombre = ComponentesVentana.crearLabel("Nombre", 140, 90, 210, 30, true, jp);
		campoNombre = ComponentesVentana.crearTextField(108, 120, 120, 25, true, true, "#F5F5F5", jp);

		telefono = ComponentesVentana.crearLabel("Teléfono", 140, 180, 120, 30, true, jp);
		campoTelefono = ComponentesVentana.crearTextField(108, 210, 120, 25, true, true, "#F5F5F5", jp);

		// INICIAR SESION BOTON
		iniciarSesion = ComponentesVentana.crearBoton("Iniciar Sesion", 108, 280, 120, 25, 17, "#B2C5D0", jp);
		iniciarSesion.setFont(new Font("Calibri", Font.BOLD, 17));
		iniciarSesion.setForeground(Color.decode("#FFFFFF"));

		iniciarSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				cliente = iniciar();
			}

		});

		configurarFuentes();

		this.setSize(700, 390);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);

	}

	private void configurarFuentes() {
		ComponentesVentana.fuenteLabel(error, "Calibri", 2, 13, "#FF0000");
		ComponentesVentana.fuenteLabel(bienvenido, "Arial", 1, 30, "#FFFFFF");
		ComponentesVentana.fuenteLabel(inicioSesion, "Verdana", 1, 20, "#B2C5D0");
		ComponentesVentana.fuenteLabel(nombre, "Calibri", 1, 17, "#000000");
		ComponentesVentana.fuenteLabel(telefono, "Calibri", 1, 17, "#000000");
	}

	private Cliente iniciar() {
		String numTelefono = campoTelefono.getText();
		String nombre = campoNombre.getText();
		
		if (nombre.isEmpty() || numTelefono.isEmpty()) {
			error.setText("         Por favor, rellena todos los campos.");
			return null;
		}

		boolean comprobacion = comprobarTelefono(numTelefono);

		if (comprobacion && numTelefono.length() == 9) {
			cliente = Cliente.iniciarSesion(nombre, numTelefono);

			if (cliente != null) {
				System.out.println("Usuario actual: " + cliente.getNombre() + " - " + cliente.getTelefono());
				VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(cliente);
				dispose();
			} else {
				error.setText("             Error, este número no disponible.");
			}
		} else {
			error.setText("Error, el número de teléfono debe tener 9 dígitos");

		}
		return cliente;

	}

	private boolean comprobarTelefono(String numTelefono) {

		for (char c : numTelefono.toCharArray()) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}

		return true;
	}
}