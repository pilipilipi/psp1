package pruebas.POO011;

public class titular {
	
	private String dni, apellidos, nombre; 
	private double telefono;
	
	titular (String dni, String apellidos, String nombre, double telefono){
		this.dni = dni;
		this.apellidos = apellidos;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getTelefono() {
		return telefono;
	}

	public void setTelefono(double telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "titular [dni=" + dni + ", apellidos=" + apellidos + ", nombre=" + nombre + ", telefono=" + telefono
				+ "]";
	}

}
