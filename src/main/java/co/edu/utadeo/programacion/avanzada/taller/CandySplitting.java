package co.edu.utadeo.programacion.avanzada.taller;

import java.util.Scanner;
import static java.lang.Math.min;

/**
 * Google code jam CandySplitting
 * @author Andres Merchan
 *
 */
public class CandySplitting {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numbers = scan.nextInt();
		scan.nextLine();
		for (long row = 1; row <= numbers; row++) {

			int xor = 0, sum = 0, min = Integer.MAX_VALUE;
			int n = scan.nextInt();
			for (int i = 0; i < n; i++) {
				int candy = scan.nextInt();
				xor ^= candy;
				sum += candy;
				min = min(min, candy);
			}
			String res = xor == 0 ? Integer.toString(sum - min) : "NO";
			System.out.println(String.format("Case #%d: %s", row, res));
		}
		scan.close();
	}

}
