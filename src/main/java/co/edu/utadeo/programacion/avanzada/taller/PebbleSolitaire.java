package co.edu.utadeo.programacion.avanzada.taller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Uva 10651 - Pebble Solitaire
 * 
 * @author juan.cantor
 *
 */
public class PebbleSolitaire {

	public static void main(String arg[]) throws FileNotFoundException {
		Scanner in = new Scanner(new File("pebble_solitaire_data"));
		while (in.hasNextLine()) {
			Integer lines = Integer.parseInt(in.nextLine());
			for (int i = 0; i < lines; i++) {
				
			}
		}
		in.close();
	}
}
