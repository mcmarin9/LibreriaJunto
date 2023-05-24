package libreria;

public class Datos {

	public static void inicializar() {
		Boligrafo b1 = new Boligrafo("Super pen 1002", "�ltimo modelo", 1.99, 5, true, "azul");
		Boligrafo b2 = new Boligrafo("Boligrafo negro simple", "chulo", 2.50, 3, true, "negro");
		Boligrafo b3 = new Boligrafo("Boli rojo", "el de las profes", 0.50, 2, false, "rojo");
		Boligrafo b4 = new Boligrafo("Pilot cl�sico", "todo el mundo lo usa", 1.5, 2, true, "azul");
		Boligrafo b5 = new Boligrafo("Boligrafo rosa", "muy bonico", 2.00, 1, false, "rosa");
		Boligrafo b6 = new Boligrafo("Bic", "normal y corriente", 0.30, 8, false, "azul");

		Carpeta c1 = new Carpeta("Carpeta rosa", "muy bonita", 5, 2, true, 3, "A4", "rosa");
		Carpeta c2 = new Carpeta("Carpeta peque�a azul", "para el cole", 8, 0, false, 8, "A5", "azul");
		Carpeta c3 = new Carpeta("Carpeta marr�n", "aburrida", 3, 4, true, 4, "A3", "marr�n");
		Carpeta c4 = new Carpeta("Carpeta tortugas ninja", "graciosa", 4, 3, false, 0, "A4", "multicolor");
		Carpeta c5 = new Carpeta("Carpeta mandarina", "muy chula", 5.2, 6, true, 2, "A4", "naranja");
		Carpeta c6 = new Carpeta("Carpeta fuelle", "con fuelle y 12 apartados", 12, 3, false, 0, "A4", "roj");
		
		Libreta lt1 = new Libreta("Libreta HK", "libreta de hello kitty", 5.50, 1, 40, "A4", "rosa");
		Libreta lt2 = new Libreta("Libreta manzana", "libreta con una manzana", 1.20, 4, 25, "A5", "verde");
		Libreta lt3 = new Libreta("Mini libreta", "de bolsillo", 9.99, 5, 35, "A6", "azul");
		Libreta lt4 = new Libreta("Libreta simple", "libreta sin muelle", 2.50, 0, 35, "A4", "amarillo");
		Libreta lt5 = new Libreta("Libreta tapa dura", "de cuadros", 60, 5, 35, "A5", "blanco");
		Libreta lt6 = new Libreta("Libreta peque�a", "libreta normal", 2.00, 2, 30, "A5", "negro");

		Libro l1 = new Libro("Harry Potter y la c�mara secreta", "Segundo libro de la saga", 15.99, 2, "Salamandara",
				"Fantas�a", "JK Rowling");
		Libro l2 = new Libro("Moby Dick", "El de la ballena", 5.99, 1, "Alfaguara", "Aventuras", "Herman Melville");
		Libro l3 = new Libro("It", "El payaso", 10, 1, "DeBolsillo",
				"Terror", "Stephen King");
		Libro l4 = new Libro("Siega", "De la Parca", 12.95, 5, "Nocturna", "Juvenil", "Neal Shutersman");
		Libro l5 = new Libro("Orgullo y prejuicio", "Clasicazo", 6, 7, "Alma",
				"Rom�mtico", "Jane Austen");
		Libro l6 = new Libro("El tiempo entre costuras", "Ambientado en la Guerra Civil", 22, 3, "Planeta ", "Novela Hist�rica", "Mar�a Due�as");

		Estuche e1 = new Estuche("Estuche de Spiderman", "Estuche de lapices de spiderman", 10, 2, "lapices", 24);
		Estuche e2 = new Estuche("Estuche de princesas", "Estuche de rotuladores de princesas disney", 8.99, 1,
				"rotuladores", 20);
		Estuche e3 = new Estuche("Estuche Mickey", "Mikey Mouse", 8, 4, "rotuladores", 12);
		Estuche e4 = new Estuche("Estuche de gatitos", "Superventas", 15.50, 4,
				"l�pices", 36);
		Estuche e5 = new Estuche("Estuche b�sico", "Lo m�nimo", 5, 12, "t�mperas", 8);
		Estuche e6 = new Estuche("Estuche vac�o", "Para l�pices", 2, 3,
				"l�pices", 10);
		Estuche e7 = new Estuche("Estuche azul", "Con 15 tonos de azul", 22, 4, "t�mperas", 22);
		Estuche e8 = new Estuche("Estuche pastel", "Solo tiene tonos pastel", 15, 0,
				"t�mperas", 12);

		Cliente cl1 = new Cliente("Ana", "123456789");
		Cliente cl2 = new Cliente("Manolo", "963852741");
		Cliente admin = new Cliente("Admin", "987654321");

		cl1.getListaCompra().add(e1);
		cl1.getListaCompra().add(c2);
		cl1.getListaCompra().add(lt1);
	}

}
