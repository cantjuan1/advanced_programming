package co.edu.utadeo.programacion.avanzada.taller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Uva 10190 - Divide, But Not Quite Conquer!
 * @author juan.cantor
 *
 */
public class DivideButNotQuiteConquer {

	public static int divide(int n, int m) {
		if (n < m) {
			return n;
		} else {
			System.out.print(n + " ");
			return divide(n / m, m);
		}
	}

	public static boolean itsOk(int n, int m) {
		if (n < m) {
			return true;
		} else {
			n = n / m;
			if (n % m > 0 && n > m) {
				return false;
			} else {
				return itsOk(n, m);
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("divide_but_not_quite_conquer_data"));
		while (in.hasNextLine()) {
			String[] inputs = in.nextLine().split(" ");
			int n = Integer.parseInt(inputs[0]);
			int m = Integer.parseInt(inputs[1]);
			if (itsOk(n, m))
				System.out.println(divide(n, m));
			else
				System.out.println("Boring!");
		}
		in.close();
	}

}
