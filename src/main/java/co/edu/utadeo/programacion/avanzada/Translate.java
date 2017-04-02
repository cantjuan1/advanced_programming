package co.edu.utadeo.programacion.avanzada;

import java.io.FileNotFoundException;

public class Translate {

	public static Integer factorial(Integer numero) {
		if (numero == 0)
			return 1;
		else
			return numero * factorial(numero - 1);
	}

	public static void main(String[] args) throws FileNotFoundException {
		/*Scanner fichero = new Scanner(new File("data.txt"));
		String letras[][] = { { "y", "a" }, { "e", "o" }, { "q", "z" } };
		Integer lineas = null;
		while (fichero.hasNextLine()) {
			String linea = fichero.nextLine();
			if (lineas == null) {
				lineas = Integer.parseInt(linea);
			} else {
				for (String[] llave : letras) {
					linea = linea.replaceAll(llave[0], llave[1]);
				}
				System.out.println(linea);
			}
		}
		fichero.close();*/
		System.out.println(factorial(5));
	}
}
