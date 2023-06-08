package model;

public class Pista {
	
	private String id;
	private String nombre;
	private String tipo;
	private double precio;
	private String horaIni;
	private String horaFin;
	private String dispo;
	private String fecha;
		
	public Pista(String id, String nombre, String tipo, double precio, String horaIni, String horaFin, String dispo,
			String fecha) {
	
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.precio = precio;
		this.horaIni = horaIni;
		this.horaFin = horaFin;
		this.dispo = dispo;
		this.fecha = fecha;
		
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

	public String getFecha() {
		return fecha;
	}

	public String getHoraIni() {
		return horaIni;
	}

	public String getHoraFin() {
		return horaFin;
	}
	
	
	
}


