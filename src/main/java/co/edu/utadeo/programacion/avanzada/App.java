package co.edu.utadeo.programacion.avanzada;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class App {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		File file = new File("C:\\Users\\juan.cantor\\Documents\\numbers.txt");
		FileInputStream fileInputStream = new FileInputStream(file);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
		String stringLine;

		BigInteger sum = new BigInteger("0");
		int auxiliar = 1;
		while ((stringLine = bufferedReader.readLine()) != null) {
			System.out.println(auxiliar + " " + stringLine);
			BigInteger currentLine = new BigInteger(stringLine);
			sum = sum.add(currentLine);
			auxiliar++;
		}
		System.out.println(sum.toString().substring(0, 10));
		bufferedReader.close();

	}
}
