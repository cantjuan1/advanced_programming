package co.edu.utadeo.programacion.avanzada;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Persona {

	private String nombre;
	private Integer edad;
	private String dni;
	private char sexo;
	private Double peso;
	private Double altura;

	public Persona() {
		this.nombre = "";
		this.dni = generaDNI();
		this.edad = 0;
		this.sexo = 'H';
		this.peso = 0.0;
		this.altura = 0.0;
	}

	public Persona(String nombre, Integer edad, char sexo) {
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.peso = 0.0;
		this.altura = 0.0;
	}

	public Persona(String nombre, Integer edad, String dni, char sexo, Double peso, Double altura) {
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}

	public int calcularIMC() {
		Double pesoIdeal = peso / Math.pow(altura, 2);
		if (pesoIdeal > 17 && pesoIdeal < 26) {
			return 0;
		} else if (pesoIdeal > 25) {
			return 1;
		} else {
			return -1;
		}
	}

	public Boolean esMayorDeEdad() {
		return edad > 17;
	}

	private void comprobarSexo(char sexo) {
		Matcher matcher = Pattern.compile("H|M").matcher(String.valueOf(sexo));
		if (!matcher.find()) {
			this.sexo = 'H';
		}
	}

	public String toString() {
		return String.format("Nombre: %1s\n, Edad: %2i\n, Dni: %3s\n, Sexo: %4s\n, Peso: %5d\n, Altura: %6d\n", nombre,
				edad, dni, sexo, peso, altura);
	}

	private String generaDNI() {
		return ((char) new Random().nextInt((97 - 122) + 1) + 97) + ""
				+ (new Random().nextInt((10000001 - 99999999) + 1) + 10000001);
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
		comprobarSexo(sexo);
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}
}
