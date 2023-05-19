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

		error = ComponentesVentana.crearLabel("Error, el número de teléfono debe tener 9 dígitos", 50, 265, 300, 20, "#FF0000", false, jp);
		error.setFont(new Font("Calibri", Font.ITALIC, 10));
		error.setVisible(false);


		errorNumRepe = ComponentesVentana.crearLabel("Error, este numero esta asociado a otro usuario", 50, 265, 300, 20, "#FF0000", false, jp);
		errorNumRepe.setFont(new Font("Calibri", Font.ITALIC, 10));
		errorNumRepe.setVisible(false);


		// Panel de color
		areaColor = new JPanel();
		areaColor.setBounds(300, 0, 300, 300);
		areaColor.setBackground(Color.decode("#B1C5D0"));
		bienvenido = ComponentesVentana.crearLabel("BIENVENID@!", 350, 100, 430, 20, "#FFFFFF", true, jp);
		bienvenido.setFont(new Font("ARIAL", Font.BOLD, 20));
		mensaje = ComponentesVentana.crearMensajeArea("Introduzca su informacion personal para poder disfrutar de una experiencia excepcional!", 330, 130, 160, 110, "#B1C5D0", "#FFFFFF");

		jp.add(mensaje);
		jp.add(areaColor);

		// INICIO SESIÓN

		inicioSesion = ComponentesVentana.crearLabel("INICIA SESION EN TMD", 40, 15, 230, 22, "#B1C5D0", true, jp);
		inicioSesion.setFont(new Font("Verdana", Font.BOLD, 15));
	

		JSeparator separador = ComponentesVentana.crearSeparador(25, 35, 350, 15, "#B1C5D0");
		jp.add(separador);

		nombre = ComponentesVentana.crearLabel("Nombre", 117, 80, 190, 20, "#000000", true, jp);
		nombre.setFont(new Font("Calibri", Font.BOLD, 15));
		campoNombre = ComponentesVentana.crearTextField(95, 100, 100, 20, true, true, "#F5F5F5", jp);

		telefono = ComponentesVentana.crearLabel("Teléfono", 117, 150, 100, 20, "#000000", true, jp);
		telefono.setFont(new Font("Calibri", Font.BOLD, 15));
		campoTelefono = ComponentesVentana.crearTextField(95, 170, 100, 20, true, true, "#F5F5F5", jp);

		// INICIAR SESION BOTON

		iniciarSesion = ComponentesVentana.crearBoton("Iniciar Sesion", 90, 230, 110, 20, 14, "#B1C5D0", jp);
		iniciarSesion.setFont(new Font("Calibri", Font.BOLD, 13));
		iniciarSesion.setVerticalAlignment(SwingConstants.CENTER);
		jp.add(iniciarSesion);
		iniciarSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				cliente = iniciar();
			}

		});

		this.setSize(550, 330);
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
