package libreria;

import ventanas.VentanaInicioSesion;

/**
 * @author MCarmen Marín y Patricia Cano
 */

public class Principal {
	public static void main(String[] args) {
		Datos.inicializar();
		Cliente cliente = null;
		if (cliente == null) {
			VentanaInicioSesion vis = new VentanaInicioSesion();
		}

		System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		System.out.println("-*       USUARIO ADMINISTRADOR:       -*");
		System.out.println("-*                 admin              -*");
		System.out.println("-*               987654321            -*");
		System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

		System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		System.out.println("-* Clientes por defecto:              -*");
		System.out.println("-*   Ana: 123456789 [3 productos]     -*");
		System.out.println("-*   Manolo: 963852741 [0 productos]  -*");
		System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
	}
}