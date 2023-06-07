package model;

public class Clase {
	private String nombre;
	private int precio;
	private int capacidad;
	
	
	public Clase(String nombre, int precio, int capacidad) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.capacidad = capacidad;
	}


	public int getCapacidad() {
		return capacidad;
	}


	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}


	public String getNombre() {
		return nombre;
	}


	public int getPrecio() {
		return precio;
	}

}
