package co.edu.utadeo.programacion.avanzada;

public class Alumno {
	
	private String nombre;
	private String identificacion; 
	private String direccion;
	double valorMatricula;

	public String getNombre() {
		return this.nombre;
	}

	public Alumno(String nombre1, String identificacion1, String direccion1) {
		this.nombre = nombre1;
		this.identificacion = identificacion1;
		this.direccion = direccion1;
	}

	public Alumno() {
		nombre = "Camilo";
		identificacion = "123";
		valorMatricula = 0;
	}

}
