package co.edu.utadeo.programacion.avanzada;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EjemploRecursion {

	public static int find_max(List<Integer> data) {
		int possible_max_1 = !data.isEmpty() ? data.get(0) : 0;
		int possible_max_2 = find_max(!data.isEmpty() ? data.subList(1, data.size() - 1) : new ArrayList<Integer>());
		if (possible_max_1 > possible_max_2) {
			return possible_max_1;
		} else {
			return possible_max_2;
		}
	}

	public static int obtener_mcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return obtener_mcd(a, a % b);
		}
	}

	public static void Hanoi(int n, int origen, int auxiliar, int destino) {
		if (n == 1)
			System.out.println("mover disco de " + origen + " a " + destino);
		else {
			Hanoi(n - 1, origen, destino, auxiliar);
			System.out.println("mover disco de " + origen + " a " + destino);
			Hanoi(n - 1, auxiliar, origen, destino);
		}
	}

	public static void main(String[] args) {
		// List<Integer> datos = new ArrayList<Integer>();
		// datos.add(1);
		// datos.add(500);
		// datos.add(200);
		// datos.add(9562);
		// datos.add(231);
		// datos.add(95);
		// datos.add(258);
		// datos.add(753);
		// System.out.println(find_max(datos));
		// System.out.println(obtener_mcd(100, 50));
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("Numero de discos: ");
		n = sc.nextInt();
		Hanoi(n, 1, 2, 3);
	}

}
