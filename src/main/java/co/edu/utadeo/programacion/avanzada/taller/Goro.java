package co.edu.utadeo.programacion.avanzada.taller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Google Code Jam Goro
 * @author Juan Cantor
 *
 */
public class Goro {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("goro_data"));
		while (in.hasNextLine()) {
			Integer cases = Integer.parseInt(in.nextLine());
			for (int i = 0; i < cases; i++) {
				Integer numberOfCards = Integer.parseInt(in.nextLine());
				String cards[] = in.nextLine().split(" ");
				float counts = 0;
				for (int j = 0; j < numberOfCards; j++) {
					if (!(Integer.parseInt(cards[j]) == (j + 1))) {
						cards[Integer.parseInt(cards[j]) - 1] = "" + (j + 1);
						counts++;
					}
				}
				System.out.println("Case " + (i + 1) + ": " + counts);
			}
		}
		in.close();
	}

}
