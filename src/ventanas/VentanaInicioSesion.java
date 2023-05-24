package ventanas;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import libreria.Cliente;

public class VentanaInicioSesion extends JFrame {

	private static Cliente cliente;
	private JButton iniciarSesion;
	private JTextField campoTelefono, campoNombre;
	private JLabel error, errorNumRepe, nombre, telefono, inicioSesion, bienvenido;
	private JTextArea mensaje;
	private JPanel jp, areaColor;

	public VentanaInicioSesion() {
		super("The Meow Desk");
		jp = new JPanel();
		this.setContentPane(jp);

		this.setLayout(new GroupLayout(jp));
		jp.setBackground(Color.white);

		// MENSAJES ERRORES

		error = ComponentesVentana.crearLabel("Error, el número de teléfono debe tener 9 dígitos", 50, 320, 320, 20,
				"#FF0000", false, jp);
		error.setFont(new Font("Calibri", Font.ITALIC, 13));
		error.setVisible(false);

		errorNumRepe = ComponentesVentana.crearLabel("Error, este numero esta asociado a otro usuario", 50, 320, 320,
				20, "#FF0000", false, jp);
		errorNumRepe.setFont(new Font("Calibri", Font.ITALIC, 13));
		errorNumRepe.setVisible(false);

		// Panel de color
		areaColor = new JPanel();
		areaColor.setBounds(350, 0, 420, 420);
		areaColor.setBackground(Color.decode("#B1C5D0"));
		bienvenido = ComponentesVentana.crearLabel("BIENVENID@!", 420, 130, 450, 40, "#FFFFFF", true, jp);
		bienvenido.setFont(new Font("ARIAL", Font.BOLD, 30));
		mensaje = ComponentesVentana.crearMensajeArea(
				"Introduzca su información personal para poder \n     disfrutar de una experiencia excepcional!", 375, 180,
				290, 140, "Arial", 13,"#B2C5D0", "#FFFFFF");
	
		jp.add(mensaje);
		jp.add(areaColor);

		// INICIO SESI N

		inicioSesion = ComponentesVentana.crearLabel("INICIA SESION EN TMD", 40, 15, 300, 42, "#B2C5D0", true, jp);
		inicioSesion.setFont(new Font("Verdana", Font.BOLD, 20));

		JSeparator separador = ComponentesVentana.crearSeparador(23, 55, 300, 25, "#B2C5D0");
		jp.add(separador);

		nombre = ComponentesVentana.crearLabel("Nombre", 140, 90, 210, 30, "#000000", true, jp);
		nombre.setFont(new Font("Calibri", Font.BOLD, 17));
		campoNombre = ComponentesVentana.crearTextField(108, 120, 120, 25, true, true, "#F5F5F5", jp);

		telefono = ComponentesVentana.crearLabel("Teléfono", 140, 180, 120, 30, "#000000", true, jp);
		telefono.setFont(new Font("Calibri", Font.BOLD, 17));
		campoTelefono = ComponentesVentana.crearTextField(108, 210, 120, 25, true, true, "#F5F5F5", jp);

		// INICIAR SESION BOTON

		iniciarSesion = ComponentesVentana.crearBoton("Iniciar Sesion", 108, 280, 120, 25, 17, "#B2C5D0", jp);
		iniciarSesion.setFont(new Font("Calibri", Font.BOLD, 17));
		iniciarSesion.setForeground(Color.decode("#FFFFFF"));
		iniciarSesion.setVerticalAlignment(SwingConstants.CENTER);
		jp.add(iniciarSesion);
		iniciarSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				cliente = iniciar();
			}

		});

		this.setSize(700, 390);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		;

	}

	private Cliente iniciar() {
		String numTelefono = campoTelefono.getText();
		String nombre = campoNombre.getText();
		error.setVisible(false);
		errorNumRepe.setVisible(false);

		if (nombre.isEmpty() || numTelefono.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Por favor rellena todos los campos.");
			return null;
		}

		boolean comprobacion = comprobarTelefono(numTelefono);

		
		 if (comprobacion && numTelefono.length() == 9) {
		        cliente = Cliente.iniciarSesion(nombre, numTelefono);

		        if (cliente != null) {
		            VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(cliente);
		            dispose();
		        } else {
		            errorNumRepe.setVisible(true);
		            System.out.println("Error: número de registro repetido.");
		        }
		    } else {
		        error.setVisible(true);
		        System.out.println("Error: el número de teléfono debe tener 9 dígitos.");
		       
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