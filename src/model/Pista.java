package model;

public class Pista {
	
	private String ID;
	private String nombre;
	private String tipo;
	private double precio;
	private String dispo;
	
	public Pista(String iD, String nombre, String tipo, double precio, String dispo) {
		
		super();
		ID = iD;
		this.nombre = nombre;
		this.tipo = tipo;
		this.precio = precio;
		this.dispo = dispo;
		
	}

	public String getNombre() {
		
		return nombre;
		
	}

	public String getTipo() {
		
		return tipo;
		
	}

	public double getPrecio() {
		
		return precio;
		
	}
	
	public String getDispo() {
		
		return dispo;
		
	}

}
