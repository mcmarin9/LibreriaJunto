package libreria;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VentanaProductos extends JFrame {

	private JLabel listaProductos, txtCantidadProductos, txtTotal;
	private JButton btnMenu, btnPagar;
	private JTextArea areaProductos;
	private JPanel areaP;
	private JScrollPane scroll;
	
	private int numProductos; 
	private double total;

	public VentanaProductos(Cliente cliente, String opcion) {

		super();

		JPanel jp = new JPanel();
		jp.setLayout(new GroupLayout(jp));
		this.setContentPane(jp);

		jp.setBackground(Color.decode("#F1F0EE"));

		areaP = new JPanel();
		areaP.setBounds(0, 0, 850, 55);
		areaP.setBackground(Color.decode("#D4B49F"));
		jp.add(areaP);

		listaProductos = ComponentesVentana.crearLabel(opcion, 100, 17, 200, 20, "#F1F0EE", true, jp);
		listaProductos.setFont(new Font("Verdana", Font.BOLD, 16));

		areaProductos = ComponentesVentana.crearMensajeArea("", 100, 100, 400, 400, "#FFFFFF", "#000000");

		scroll = new JScrollPane(areaProductos);
		scroll.setBounds(100, 100, 400, 300);
		this.add(scroll);

		// MENU

		btnMenu = ComponentesVentana.crearBoton("MENU", 600, 280, 100, 20, 12, "#D4B49F", jp);
		btnMenu.setFont(new Font("Calibri Bold", Font.PLAIN, 15));

		btnMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});

		// PAGAR
		btnPagar = ComponentesVentana.crearBoton("PAGAR", 600, 180, 100, 20, 20, "#D4B49F", jp);
		btnPagar.setFont(new Font("Calibri Bold", Font.PLAIN, 15));
		
		numProductos = 0; 
		total = cliente.precioTotal();
		
		if (opcion.equalsIgnoreCase("PRODUCTOS")) {
			Producto.mostrarProductos(areaProductos);
			btnPagar.setVisible(false);
		} else {
			
			numProductos = cliente.mostrarListaCompra(areaProductos);
			
			txtCantidadProductos = ComponentesVentana.crearLabel("Número de productos: "+ (numProductos-1), 550, 80, 230, 20, "#000000", true, jp);
			txtCantidadProductos.setFont(new Font("Calibri Bold", Font.PLAIN, 20));
			txtTotal = ComponentesVentana.crearLabel("Total: "  + total + " €", 550, 100, 140, 20, "#000000", true, jp);
			txtTotal.setFont(new Font("Calibri Bold", Font.PLAIN, 20));
			
			btnPagar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					cliente.pagar();
					
			        total = 0; 
			        numProductos = 0; 
			        txtCantidadProductos.setText("Número de productos: " + numProductos);
			        txtTotal.setText("Total: " + total + " €");
			        areaProductos.setText("");
					
				}
			});
		}
		

		


		jp.setComponentZOrder(listaProductos, 0);

		this.setSize(850, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}


}

