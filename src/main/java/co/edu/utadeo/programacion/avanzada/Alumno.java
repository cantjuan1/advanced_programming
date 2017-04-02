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
		this.setIdentificacion(identificacion1);
		this.setDireccion(direccion1);
	}

	public Alumno() {
		nombre = "Camilo";
		setIdentificacion("123");
		valorMatricula = 0;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
