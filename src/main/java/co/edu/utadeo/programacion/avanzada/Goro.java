package co.edu.utadeo.programacion.avanzada;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Goro {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("data.txt"));
		Integer cases = 0;
		while (scanner.hasNextLine()) {
			if (cases == 0) {
				cases = Integer.parseInt(scanner.nextLine());
			} else {
				Integer numberOfCards = Integer.parseInt(scanner.nextLine());
				String cards = scanner.nextLine();
				String cardsA[] = cards.split(" ");
				int tempVar;
				float counts = 0;
				for (int i = 0; i < cardsA.length; i++) {
					if (!(Integer.parseInt(cardsA[i]) == (i + 1))) {
						cardsA[Integer.parseInt(cardsA[i])-1] = "";//(i + 1);
						counts=+2;
					}
				}
				System.out.println(counts);
			}
		}
		scanner.close();
	}

}
