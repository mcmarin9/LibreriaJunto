package ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import libreria.Cliente;
import libreria.Producto;

public class VentanaProductos extends JFrame {

	private JLabel listaProductos, txtCantidadProductos, txtTotal, nombreLibreria;
	private JButton btnMenu, btnPagar, btnBorrar;
	private JTextArea areaProductos;
	private JPanel areaColor;
	private JScrollPane scroll;

	private int numProductos;
	private double total;

	public VentanaProductos(Cliente cliente, String opcion) {

		super(opcion);
		JPanel jp = new JPanel();
		jp.setLayout(new GroupLayout(jp));
		this.setResizable(false);
		this.setContentPane(jp);

		jp.setBackground(Color.decode("#F1F0EE"));

		nombreLibreria = ComponentesVentana.crearLabel("The Meow Desk", 20, 17, 130, 15, true, jp);
		ComponentesVentana.fuenteLabel(nombreLibreria, "Gill Sans MT", 1, 14, "#B1C5D0");
		nombreLibreria.setForeground(Color.decode("#F1F0EE"));

		areaColor = new JPanel();
		areaColor.setBounds(0, 0, 850, 50);
		areaColor.setBackground(Color.decode("#B1C5D0"));
		jp.add(areaColor);

		listaProductos = ComponentesVentana.crearLabel(opcion, 365, 15, 200, 20, true, jp);
		ComponentesVentana.fuenteLabel(listaProductos, "Gill Sans MT", Font.BOLD, 18, "#F1F0EE");

		areaProductos = ComponentesVentana.crearMensajeArea("", 100, 100, 550, 550, "Arial", 13, "#FFFFFF", "#000000");
		areaProductos.setCaretPosition(0); // Establecer la posición del cursor en el inicio del texto
		jp.add(areaProductos);
		
		scroll = new JScrollPane(areaProductos);
		this.add(scroll);

		// MENU
		btnMenu = ComponentesVentana.crearBoton("MENU", 700, 15, 100, 20, 20, "#B1C5D0", jp);
		btnMenu.setFont(new Font("Gill Sans MT", Font.BOLD, 14));
		btnMenu.setForeground(Color.decode("#F1F0EE"));

		btnMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});

		// PAGAR
		btnPagar = ComponentesVentana.crearBoton("PAGAR", 580, 230, 90, 20, 13, "#B1C5D0", jp);

		numProductos = 0;
		total = cliente.precioTotal();

		// BORRAR PRODUCTO DEL CARRITO´
		btnBorrar = ComponentesVentana.crearBoton("BORRAR PRODUCTO", 580, 255, 180, 20, 13, "#B1C5D0", jp);
		btnPagar.setForeground(Color.decode("#FFFFFF"));
		btnBorrar.setForeground(Color.decode("#FFFFFF"));

		if (opcion.equalsIgnoreCase("PRODUCTOS")) {
			Producto.mostrarProductos(areaProductos);
			scroll.setBounds(100, 100, 655, 300);
			btnPagar.setVisible(false);
			btnBorrar.setVisible(false);

		} else { // cuando el botón que se ha pulsado es el de VerCarrito.
			
			// OPCIONES MI CESTA
			scroll.setBounds(100, 100, 450, 300);
			numProductos = cliente.mostrarListaCompra(areaProductos);

			txtCantidadProductos = ComponentesVentana.crearLabel("Número de productos: " + (numProductos - 1), 580, 150,
					230, 20, true, jp);
			ComponentesVentana.fuenteLabel(txtCantidadProductos, "Gill Sans MT", Font.BOLD, 15, "#000000");

			txtTotal = ComponentesVentana.crearLabel("Total: " + total + "€", 580, 180, 140, 20, true, jp);
			ComponentesVentana.fuenteLabel(txtTotal, "Gill Sans MT", Font.BOLD, 15, "#000000");

			btnPagar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					cliente.pagar();

					total = 0;
					numProductos = 0;
					actualizarTotales(0, 0);
					areaProductos.setText("");

				}
			});

			btnBorrar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String codBorrar = JOptionPane
							.showInputDialog("Introduce el código del producto que quieres borrar");
					boolean encontrado = false;
					for (Producto productoCarrito : cliente.getListaCompra()) {
						if (productoCarrito.getCodigo().equalsIgnoreCase(codBorrar)) {
							cliente.getListaCompra().remove(productoCarrito);
							productoCarrito.setUnidadesStock(productoCarrito.getUnidadesStock() + 1);
							total -= productoCarrito.getPrecioUnidad();
							areaProductos.setText("");
							numProductos = cliente.mostrarListaCompra(areaProductos);
							actualizarTotales(numProductos - 1, total);
							encontrado = true;
							break;
						}
					}
					
					if (!encontrado) {
						System.out.println("Ese producto no está en el carrito.");
					}
				}
			});
		}

		jp.setComponentZOrder(listaProductos, 0);

		this.setSize(850, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private void actualizarTotales(int cantidad, double precio) {
		txtCantidadProductos.setText("Número de productos: " + cantidad);
		txtTotal.setText("Total: " + precio + " €");
	}
}
