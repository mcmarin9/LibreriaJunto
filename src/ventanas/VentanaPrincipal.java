package ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import libreria.Cliente;


public class VentanaPrincipal extends JFrame {

	private JLabel nombre, fotoGatito, iconos, iconos2, usuarioIcono, usuarioBienvenido;
	private JButton btnCrearProducto, btnSalir;
	private JMenuBar menuBar;
    private JMenuItem menuCambiarUsuario, menuMiCesta, menuComprar, menuVerProductos, menuMensajeBienvenido;
	
	
	//VENTANA PRINCIPAL

	public VentanaPrincipal(Cliente cliente) {

		super("INICIO");

		JPanel jp = new JPanel();
		this.setContentPane(jp);
		this.setLayout(new GroupLayout(jp));
		jp.setBackground(Color.decode("#F1F0EE"));


		//IMAGEN GATITO
		Image imagenGatito = null;
		
        try {
            URL url = new URL("https://i.ibb.co/tbQQLHf/gatitolibros.png");
            imagenGatito = ImageIO.read(url);
        } 
        catch (IOException e) {
        }


		ImageIcon redimensionada1 = new ImageIcon(imagenGatito.getScaledInstance(210,280, Image.SCALE_AREA_AVERAGING));
		fotoGatito = new JLabel(redimensionada1);
		fotoGatito.setBounds(440, 90, 210, 280);
		jp.add(fotoGatito);
		
		
		// ICONOS
		
		Image imagenIconos = null;
		
        try {
            URL url = new URL("https://i.ibb.co/Rj1M7dh/iconos-Redes.png");
            imagenIconos = ImageIO.read(url);
        } 
        catch (IOException e) {
        }
        
        ImageIcon redimensionada2 = new ImageIcon(imagenIconos.getScaledInstance(90, 90, Image.SCALE_SMOOTH));
		iconos = new JLabel(redimensionada2);
		iconos.setBounds(700, 320, 90, 90);
		jp.add(iconos);
		
		
		iconos2 = ComponentesVentana.crearLabel("@themeowdesk", 705, 340, 100, 100, "#000000", true, jp );
		iconos2.setFont(new Font("Calibri", Font.PLAIN, 13));
		jp.add(iconos2);
		
		
		//NOMBRE LIBRERÍA	
		nombre = ComponentesVentana.crearLabel("THE MEOW", 65, 110, 380, 60, "#6384A6", true, jp);
		nombre.setFont(new Font("Gill Sans MT", Font.BOLD, 45));
		nombre = ComponentesVentana.crearLabel("DESK", 65, 170, 380, 60, "#6384A6", true, jp);
		nombre.setFont(new Font("Gill Sans MT", Font.BOLD, 45));
		
		
		// RAYA
		JSeparator separador = ComponentesVentana.crearSeparador(65, 230, 130, 20, "#6384A6");
		jp.add(separador);
		
		
		//MENU		
        menuBar=new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setPreferredSize(new Dimension(menuBar.getWidth(), 45));
        
        // mensaje bienvenida
        menuMensajeBienvenido = new JMenuItem("         BIENVENID@ " + cliente.getNombre().toUpperCase());
        menuMensajeBienvenido.setBackground(Color.decode("#6384A6"));
        menuMensajeBienvenido.setForeground(Color.decode("#F1F0EE"));
        menuMensajeBienvenido.setFont(new Font("Gill Sans Nova", Font.BOLD, 11));
        //menuMensajeBienvenido.setBounds(30, 10, 100, 20);
        menuBar.add(menuMensajeBienvenido);
        
        // cambiar usuario
        menuCambiarUsuario=new JMenuItem("            CAMBIAR USUARIO");
        menuCambiarUsuario.setBackground(Color.decode("#6384A6"));
        menuCambiarUsuario.setForeground(Color.decode("#F1F0EE"));
        menuCambiarUsuario.setFont(new Font("Gill Sans Nova", Font.BOLD, 11));
        menuBar.add(menuCambiarUsuario);
        menuCambiarUsuario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				VentanaInicioSesion vis = new VentanaInicioSesion();
				
			}
		});
        
        
        
        /*
        //USUARIO CUENTA ICONO
        		ImageIcon user = new ImageIcon("https://static.vecteezy.com/system/resources/previews/020/911/740/non_2x/user-profile-icon-profile-avatar-user-icon-male-icon-face-icon-profile-icon-free-png.png");
        		Image usuarioOriginal = user.getImage();
        		ImageIcon redimensionada3 = new ImageIcon(usuarioOriginal.getScaledInstance(23, 20, Image.SCALE_SMOOTH));
        		
        		usuarioIcono = new JLabel(redimensionada3);
        		usuarioIcono.setBounds(574, 10, 34, 35);
        		menuBar.add(usuarioIcono);*/
        		

        menuVerProductos = new JMenuItem("            VER PRODUCTOS");
        menuVerProductos.setBackground(Color.decode("#6384A6"));
        menuVerProductos.setForeground(Color.decode("#FFFFFF"));
        menuVerProductos.setFont(new Font("Gill Sans Nova", Font.BOLD, 11));
        menuBar.add(menuVerProductos);

        menuVerProductos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				VentanaProductos vProductos = new VentanaProductos(cliente, "PRODUCTOS");
				
			}
		});
		

        menuComprar = new JMenuItem("            COMPRAR");
        menuComprar.setBackground(Color.decode("#6384A6"));
        menuComprar.setForeground(Color.decode("#FFFFFF"));
        menuComprar.setFont(new Font("Gill Sans Nova", Font.BOLD, 11));
        menuBar.add(menuComprar);

        menuComprar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				VentanaComprar vComprar = new VentanaComprar(cliente);
				
				
			}
		});
        
        menuMiCesta = new JMenuItem("                    MI CESTA");
        menuMiCesta.setBackground(Color.decode("#6384A6"));
        menuMiCesta.setForeground(Color.decode("#FFFFFF"));
        menuMiCesta.setFont(new Font("Gill Sans Nova", Font.BOLD, 11));
        menuBar.add(menuMiCesta);

        menuMiCesta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				VentanaProductos vCesta = new VentanaProductos(cliente, "CARRITO");
				
				
			}
		});
        
		
		//A ADIR PRODUCTOS
		btnCrearProducto = ComponentesVentana.crearBoton("CREAR PRODUCTO", 200, 230, 150, 40, 15, "#6384A6", jp);
		btnCrearProducto.setVisible(false);
		
		
		if (cliente.getNombre().equalsIgnoreCase("Admin") && (cliente.getTelefono().equalsIgnoreCase("987654321"))) {

			btnCrearProducto.setVisible(true);
			btnCrearProducto.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					VentanaCrearProducto vcn = new VentanaCrearProducto();
				}
			});
		}

        
		// SALIR DE LA APLICACION
        btnSalir = ComponentesVentana.crearBoton("SALIR", 20, 390, 100, 20, 12, "#6384A6", jp);
		btnSalir.setFont(new Font("Calibri", Font.PLAIN, 13));

		btnSalir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		

		this.setSize(850, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);

	}
}


