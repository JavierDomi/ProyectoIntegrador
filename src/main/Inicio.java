package main;

import java.awt.EventQueue;

import control.LoginListener;
import view.PInicio;
import view.VLogin;
import view.VPrincipal;

public class Inicio {
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				VLogin vLogin = new VLogin();
				
				VPrincipal vp = new VPrincipal();
				
				PInicio pInicio = new PInicio();
				
				LoginListener listener = new LoginListener(vLogin, vp, pInicio);
				
				vLogin.setListener(listener);				
				vLogin.hacerVisible();				
				vp.setListener(listener);
				
			}
		});
		
	}

}
