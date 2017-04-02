package co.edu.utadeo.programacion.avanzada.taller;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * UVA Happy Numbers
 * @author Andres Merchan
 *
 */
public class HappyNumber {

	private static TreeSet<Long> numeroFeliz = new TreeSet<Long>();
	private static TreeSet<Long> numeroTriste = new TreeSet<Long>();
	private static TreeSet<Long> noDeterminado = new TreeSet<Long>();

	public static void main(String[] args) {
		numeroFeliz.add(1L);
		Scanner entrada = new Scanner(System.in);
		int tc = entrada.nextInt();
		for (int i = 1; i <= tc; i++) {
			int n = entrada.nextInt();
			System.out.println("Case #: " + n + " is " + (validacion(n) ? "a Happy" : "an Unhappy") + " number.");
		}
		entrada.close();
	}

	private static boolean validacion(long n) {
		if (numeroFeliz.contains(n)) {
			return true;
		}
		if (numeroFeliz.contains(n) || noDeterminado.contains(n)) {
			return false;
		}
		noDeterminado.add(n);
		boolean flag = validacion(sumaCuadradaMod(n));

		if (flag) {
			numeroFeliz.addAll(noDeterminado);
		} else {
			numeroTriste.addAll(noDeterminado);
		}
		noDeterminado.clear();
		return flag;
	}

	private static long sumaCuadradaMod(long n) {
		long resultado = 0;
		while (n > 0) {
			long d = n % 10;
			resultado += d * d;
			n /= 10;
		}
		return resultado;
	}
}
