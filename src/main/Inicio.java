package main;

import java.awt.EventQueue;

import control.LoginListener;
import view.VLogin;

public class Inicio {
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				VLogin vLogin = new VLogin();
				
				LoginListener listener = new LoginListener(vLogin);
				
				vLogin.setListener(listener);
				
				vLogin.hacerVisible();
				
			}
		});
		
	}

}
