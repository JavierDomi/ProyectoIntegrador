package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.Query;

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

}
