package co.edu.utadeo.programacion.avanzada.taller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Uva 10696 - f91
 * @author juan.cantor
 *
 */
public class F91 {

	public static int f91(int n) {
		if (n <= 100) {
			return f91(f91(n + 11));
		} else {
			return n - 10;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("f91_data"));
		while (in.hasNextLine()) {
			Integer number = in.nextInt();
			if (number == 0)
				break;
			else
				System.out.println("f91(" + number + ") = " + f91(number));
		}
		in.close();
	}

}
