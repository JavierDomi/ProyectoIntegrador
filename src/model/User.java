package model;

public class User {
	
	private String usuario;
	private String password;
	private String nombre;
	private String apellidos;
	private String dni;
	private String direccion;
	private String email;
	private String telefono;
	
	public User(String usuario, String password, String nombre, String apellidos, String dni, String direccion,
			String email, String telefono) {
		this.usuario = usuario;
		this.password = password;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
	}

	public User(String usuario, String password) {
		this.usuario = usuario;
		this.password = password;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getPassword() {
		return password;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getDni() {
		return dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefono() {
		return telefono;
	}

	

}
