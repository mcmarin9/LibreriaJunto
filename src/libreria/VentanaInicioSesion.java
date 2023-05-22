package libreria;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class VentanaInicioSesion extends JFrame {

	private static Cliente cliente;
	private JButton iniciarSesion;
	private JTextField campoTelefono, campoNombre;
	private JLabel error, errorNumRepe, nombre, telefono, inicioSesion, bienvenido;
	private JTextArea mensaje;
	private JPanel jp, areaColor;

	public VentanaInicioSesion() {

		jp = new JPanel();
		this.setContentPane(jp);

		this.setLayout(new GroupLayout(jp));
		jp.setBackground(Color.white);

		// MENSAJES ERRORES

		error = ComponentesVentana.crearLabel("Error, el número de teléfono debe tener 9 dígitos", 25, 360, 320, 40, "#FF0000", false, jp);
		error.setFont(new Font("Calibri", Font.ITALIC, 16));
		error.setVisible(false);


		errorNumRepe = ComponentesVentana.crearLabel("Error, este numero esta asociado a otro usuario", 20, 360, 320, 40, "#FF0000", false, jp);
		errorNumRepe.setFont(new Font("Calibri", Font.ITALIC, 16));
		errorNumRepe.setVisible(false);


		// Panel de color
		areaColor = new JPanel();
		areaColor.setBounds(350, 0, 420, 420);
		areaColor.setBackground(Color.decode("#B1C5D0"));
		bienvenido = ComponentesVentana.crearLabel("BIENVENID@!", 400, 100, 450, 40, "#FFFFFF", true, jp);
		bienvenido.setFont(new Font("ARIAL", Font.BOLD, 32));
		mensaje = ComponentesVentana.crearMensajeArea("Introduzca su informacion personal para poder disfrutar de una experiencia excepcional!", 400, 150, 200, 140, "#B1C5D0", "#FFFFFF");

		jp.add(mensaje);
		jp.add(areaColor);

		// INICIO SESIÓN

		inicioSesion = ComponentesVentana.crearLabel("INICIA SESION EN TMD", 40, 15, 300, 42, "#B1C5D0", true, jp);
		inicioSesion.setFont(new Font("Verdana", Font.BOLD, 22));
	

		JSeparator separador = ComponentesVentana.crearSeparador(25, 55, 370, 25, "#B1C5D0");
		jp.add(separador);

		nombre = ComponentesVentana.crearLabel("Nombre", 145, 100, 210, 40, "#000000", true, jp);
		nombre.setFont(new Font("Calibri", Font.BOLD, 17));
		campoNombre = ComponentesVentana.crearTextField(105, 140, 140, 40, true, true, "#F5F5F5", jp);

		telefono = ComponentesVentana.crearLabel("Teléfono", 145, 190, 120, 40, "#000000", true, jp);
		telefono.setFont(new Font("Calibri", Font.BOLD, 17));
		campoTelefono = ComponentesVentana.crearTextField(105, 225, 140, 40, true, true, "#F5F5F5", jp);

		// INICIAR SESION BOTON

		iniciarSesion = ComponentesVentana.crearBoton("Iniciar Sesion", 108, 300, 130, 40, 18, "#B1C5D0", jp);
		iniciarSesion.setFont(new Font("Calibri", Font.BOLD, 18));
		iniciarSesion.setVerticalAlignment(SwingConstants.CENTER);
		jp.add(iniciarSesion);
		iniciarSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				cliente = iniciar();
			}

		});

		this.setSize(670, 450);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		;

	}





	public Cliente iniciar() {

		String numTelefono = campoTelefono.getText();
		String nombre = campoNombre.getText();
		error.setVisible(false);
		errorNumRepe.setVisible(false);

		if (numTelefono.length() == 9 && !nombre.isEmpty()) {
			cliente = Cliente.iniciarSesion(nombre, numTelefono);

			if (cliente != null) {

				VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(cliente);
				dispose();

			} else {
				errorNumRepe.setVisible(true);
				System.out.println("error");
			}

		} else {
			error.setVisible(true);
		}

		return cliente;

	}
	



}
