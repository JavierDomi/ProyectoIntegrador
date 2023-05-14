package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class VThreeMonkeys extends JFrame {
	
	private static final int ANCHO = 750;
	private static final int ALTO = 400;

	public VThreeMonkeys () {
		
		super ("Home");
		setTitle("Ventana de Inicio");
		centrarVentana();
		init();
	}

	private void centrarVentana() {
		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();                   
		Dimension ventana = new Dimension(ANCHO, ALTO);                     
		setLocation((pantalla.width - ventana.width) / 2,  (pantalla.height - ventana.height) / 2); 	
		
	}

	private void init() {
		
		getContentPane().setLayout(null);
		
	}

}
