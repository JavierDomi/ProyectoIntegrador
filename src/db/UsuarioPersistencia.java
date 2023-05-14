package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.Query;

import model.User;


public class UsuarioPersistencia {
	
	static final String NOM_TABLA = "USERS";
	static final String COL_USER = "USER";
	static final String COL_PWD = "PASSWORD";	
	
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
	
	public String registrarUsuario (User user) {
		
		//TODO
		
		String query = "INSERT INTO " + NOM_TABLA + " ";
		
		String resultado = "";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rslt = null;
		
		return null;
		
	}

}
