package main;
import view.PHorarios;
import java.awt.EventQueue;

import control.LoginListener;
import view.PInicio;
import view.PPistas;
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
				
				VResgistroUser vReg = new VResgistroUser();

				PInicio pInicio = new PInicio();
				
				PPistas pPistas = new PPistas();
				
				LoginListener listener = new LoginListener(vLogin, vp, pInicio, vReg, pHorarios, pPistas);
				
				vLogin.setListener(listener);				
				vLogin.hacerVisible();	
				
				vp.setListener(listener);
				
				vReg.setListener(listener);
				
				pPistas.setListener(listener);
				
			}
		});
		
	}

}
