package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.management.Query;

import model.Clase;
import model.Pista;
import model.User;


public class UsuarioPersistencia {
	
	//TABLA USUARIOS
	static final String NOM_TABLA = "USERS";
	static final String COL_USER = "USER";
	static final String COL_PWD = "PASSWORD";
	static final String COL_NOMBRE = "NOMBRE";
	static final String COL_APELLIDOS = "APELLIDOS";
	static final String COL_DNI = "DNI";
	static final String COL_DIRECCION = "DIRECCION";
	static final String COL_EMAIL = "EMAIL";
	static final String COL_TELEFONO = "TELEFONO";
	//
	
	//TABLA PISTAS
	static final String NOM_TABLA_PISTAS = "PISTAS";
	static final String COL_ID_PISTAS = "ID";
	static final String COL_NOMBRE_PISTAS = "NOMBRE";
	static final String COL_TIPO_PISTAS = "TIPO";
	static final String COL_PRECIO_PISTAS = "PRECIO";
	//
	
	//TABLA CLASES
	static final String NOM_TABLA_CLASES = "CLASES";
	static final String COL_NOM_CLASE = "NOMBRE";
	static final String COL_PRECIO_CLASE = "PRECIO";
	static final String COL_CAPACIDAD_CLASE = "CAPACIDAD";
	//
	
	private AccesoDB acceso;
	
	
	public UsuarioPersistencia() {
		acceso = new AccesoDB();
	}
	
	public String validarUsuario(User user) {
		
		String query = "SELECT " + COL_USER + ", " + COL_PWD + " FROM " + NOM_TABLA 
				+ " WHERE " + COL_USER + " = ?";
		
		String resultado = "";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rslt = null;
		
		try {
			
			con = acceso.getConexion();
			
			stmt = con.prepareStatement(query);
			stmt.setString(1, user.getUsuario());
			
			rslt = stmt.executeQuery();
			
			if (rslt.next()) {
			
				String pwd = rslt.getString(COL_PWD);
			
				if (pwd.equals(user.getPassword())) {
			
				resultado = "Acceso permitido";
				
				
				}else {
					
					resultado = "Contraseña incorrecta";
					
				}
				
			} else {
				
				resultado = "El usuario no se encuentra en la base de datos";
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			resultado = "Se ha producido un error, póngase en contacto con el administrador";
			
		} finally {
			
			try {
				
				if (rslt != null) 
					
					rslt.close();
					
				
				if (stmt != null) 
					
					stmt.close();	
				
				if (con != null) 
					
					con.close();
					
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
		}
		
		return resultado;
		
	} 
	
	public int registrarUsuario (User user) {
		
		//TODO
		
		String query = "INSERT INTO " + NOM_TABLA + "(" + COL_USER + ", " + COL_PWD + ", " + COL_NOMBRE + ", " 
		+ COL_APELLIDOS + ", " +  COL_DNI + ", " + COL_DIRECCION + ", " + COL_EMAIL+ ", " + COL_TELEFONO 
		+ ") VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection con = null;
		PreparedStatement stmt = null;
		int res = 0;
		try {
			con = acceso.getConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, user.getUsuario());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getNombre());
			stmt.setString(4, user.getApellidos());
			stmt.setString(5, user.getDni());
			stmt.setString(6, user.getDireccion());
			stmt.setString(7, user.getEmail());
			stmt.setString(8, user.getTelefono());
			
			
			res = stmt.executeUpdate();
		} catch (Exception e) {
			//e.printStackTrace();
			res = -1;
		}
		return res;
		
	}

	public ArrayList<String> selectPistas() {
		
		ArrayList<String> listaPistas = new ArrayList<>();
		
		String query = "SELECT DISTINCT " + COL_TIPO_PISTAS + " FROM " + NOM_TABLA_PISTAS;
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rslt = null;
		
		try {
			
			con = acceso.getConexion();
			
			stmt = con.createStatement();
			rslt = stmt.executeQuery(query);
			
			Pista pista = null;
			
			while (rslt.next()) {
				
				listaPistas.add(rslt.getString(1));
				
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if (rslt != null) rslt.close();
				if (stmt != null) stmt.close();
				if (con != null) con.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
		return listaPistas;
	}

	public ArrayList<Pista> selectPistasFiltro(String tipo, String fecha) {
		
		
		
		return null;
	}
	
	//RELLENAR TABLA CLASES
	public ArrayList<Clase> consultaClases() {
		
		ArrayList<Clase> listaClases = new ArrayList<>();
		
		String query = "SELECT * FROM " + NOM_TABLA_CLASES;
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rslt = null;
		
		try {
			con = acceso.getConexion();
			stmt = con.createStatement();
			rslt = stmt.executeQuery(query);			
			
			
			while (rslt.next()) {				
				Clase clase = new Clase(rslt.getString(1),rslt.getInt(2),rslt.getInt(3));
				listaClases.add(clase);
				
			}
			
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
			
		} catch (SQLException e) {			
			e.printStackTrace();
			
		} finally {
			try {				
				if (rslt != null) rslt.close();
				if (stmt != null) stmt.close();
				if (con != null) con.close();				
			} catch (SQLException e) {				
				e.printStackTrace();				
			}			
		}		
		return listaClases;
	}
	
	//RESERVAR CLASES
	public int reservarClase(String nombre) {
		String query = "UPDATE " + NOM_TABLA_CLASES 
						+ " SET " + COL_CAPACIDAD_CLASE + " = " + COL_CAPACIDAD_CLASE + " -1 "
						+ " WHERE " + COL_NOM_CLASE + " = ?"
						+ " AND " + COL_CAPACIDAD_CLASE + " > 0";		
				
				Connection con = null;
				PreparedStatement stmt = null;
				int res = 0;
				try {
					con = acceso.getConexion();
					stmt = con.prepareStatement(query);
					stmt.setString(1, nombre);				
					
					
					res = stmt.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
					res = -1;
				}
				return res;
				
			}
		
	}


