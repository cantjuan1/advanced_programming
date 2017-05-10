package co.edu.utadeo.programacion.avanzada;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class FindTheTelephone {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("find_the_telephone_data"));
		HashMap<String, String> dictionary = new HashMap<String, String>();
		dictionary.put("ABC", "2");
		dictionary.put("DEF", "3");
		dictionary.put("GHI", "4");
		dictionary.put("JKL", "5");
		dictionary.put("MNO", "6");
		dictionary.put("PQRS", "7");
		dictionary.put("TUV", "8");
		dictionary.put("WXYZ", "9");

		while (in.hasNext()) {
			String expression = in.next();
			String letters[] = expression.split("");
			for (String letter : letters) {
				for (String key : dictionary.keySet()) {
					if (key.contains(letter)) {
						expression = expression.replace(letter, dictionary.get(key));
					}
				}
			}
			System.out.println(expression);
		}
		in.close();
	}

}
