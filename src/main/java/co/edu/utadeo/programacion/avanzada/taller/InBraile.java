package co.edu.utadeo.programacion.avanzada.taller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * UVA In Braille
 * @author Juan Cantor
 *
 */
public class InBraile {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("in_braile_data"));
		String braileLetters[] = { ".***..", "*.....", "*.*...", "**....", "**.*..", "*..*..", "***...", "****..",
				"*.**..", ".**..." };
		while (in.hasNext()) {
			Integer lines = Integer.parseInt(in.nextLine());
			if (lines == 0) {
				break;
			}
			String type = in.nextLine();
			if ("S".equals(type)) {
				String firtsLine = "";
				String secondLine = "";
				String thirdLine = "";
				String digits[] = in.nextLine().split("");
				for (int i = 0; i < lines; i++) {
					firtsLine += braileLetters[Integer.parseInt(digits[i])].substring(0, 2) + " ";
					secondLine += braileLetters[Integer.parseInt(digits[i])].substring(2, 4) + " ";
					thirdLine += braileLetters[Integer.parseInt(digits[i])].substring(4, 6) + " ";
				}
				System.out.println(firtsLine);
				System.out.println(secondLine);
				System.out.println(thirdLine);
			} else {
				String braile[] = new String[lines];
				for (int i = 0; i < lines; i++) {
					String braileParts[] = in.nextLine().split(" ");
					for (int j = 0; j < braileParts.length; j++) {
						if (braile[j] == null) {
							braile[j] = "";
						}
						braile[j] += braileParts[j];
					}
				}
				String digits = "";
				for (int i = 0; i < braile.length; i++) {
					for (int j = 0; j < braileLetters.length; j++) {
						if (braile[i].equals(braileLetters[j])) {
							digits += j;
						}
					}
				}
				System.out.println(digits);
			}
		}
		in.close();
	}

}
