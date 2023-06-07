package main;
import view.PHorarios;
import java.awt.EventQueue;

import control.LoginListener;
import view.PInicio;
import view.VLogin;
import view.VPrincipal;
import view.VResgistroUser;
public class Inicio {
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				VLogin vLogin = new VLogin();
				
				VPrincipal vp = new VPrincipal();
				PHorarios pHorarios = new PHorarios();
				
				PInicio pInicio = new PInicio();
				VResgistroUser vReg = new VResgistroUser();
				
				LoginListener listener = new LoginListener(vLogin, vp, pInicio, vReg, pHorarios);
				
				vLogin.setListener(listener);				
				vLogin.hacerVisible();				
				vp.setListener(listener);
				
				vReg.setListener(listener);
				
			}
		});
		
	}

}
