package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import db.UsuarioPersistencia;
import model.User;
import view.VLogin;

public class LoginListener implements ActionListener{
	
	private VLogin vLogin;
	private UsuarioPersistencia uPers;
	

	public LoginListener(VLogin vLogin) {
		
		this.vLogin = vLogin;
		uPers = new UsuarioPersistencia();
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals(VLogin.BTN_ACCEDER)) {
			
			User user = vLogin.getUsuario();
			
			if (user != null) {
				
				String resultado = uPers.validarUsuario(user);
				
				if (resultado.equals("Acceso permitido")) {
					
					//vLogin.mostrarError(resultado);
					
				} else {
					
					vLogin.mostrarError(resultado);
					
				}
				
			}
			
		} else if (e.getActionCommand().equals(VLogin.BTN_RESGISTRAR)) {
			
			//TODO
			// ABRIR VRegistroUser AL PULSAR BOTÓN
			
		}

	}

}
