package co.edu.utadeo.programacion.avanzada;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InBraile {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("in_braile_data"));
		String braileLetters[] = { ".***..", "*.....", "*.*...", "**....", "**.*..", "*..*..", "***...", "****..",
				"*.**..", ".**..." };
		while (in.hasNext()) {
			Integer lines = Integer.parseInt(in.nextLine());
			String type = in.nextLine();
			if ("S".equals(type)) {
				String letters[] = in.nextLine().split("");
				String part1 = "";
				String part2 = "";
				String part3 = "";
				for (String letter : letters) {
					part1 += braileLetters[Integer.parseInt(letter)].substring(0, 2) + " ";
					part2 += braileLetters[Integer.parseInt(letter)].substring(2, 4) + " ";
					part3 += braileLetters[Integer.parseInt(letter)].substring(4, 6) + " ";
				}
				System.out.println(part1);
				System.out.println(part2);
				System.out.println(part3);
			} else {

			}
		}

	}

}
