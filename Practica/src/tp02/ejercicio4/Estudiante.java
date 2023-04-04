package tp02.ejercicio4;

public class Estudiante {
	private String nombre;
	private String apellido;
	private String comision;
	private String email;
	private String direccon;

	public Estudiante(String nombre, String apellido, String comision, String email, String direccon) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.comision = comision;
		this.email = email;
		this.direccon = direccon;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getComision() {
		return comision;
	}
	public void setComision(String comision) {
		this.comision = comision;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccon;
	}
	public void setDireccion(String direccon) {
		this.direccon = direccon;
	}
	
	public String tusDatos() {
		return "Estudiante [Nombre:=" + getNombre() + ", Apellido:=" + getApellido() + ", Email:="
				+ getEmail() + ", comision:=" + getComision() + ", direccion:=" + getDireccion() + "]";
	}
}