package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import control.LoginListener;
import model.User;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.Icon;
import javax.swing.JButton;

public class VLogin extends JFrame{
	
	private static final int ANCHO = 400;
	private static final int ALTO = 200;
	
	public static final String BTN_ACCEDER = "Acceder";
	public static final String BTN_RESGISTRAR = "Nuevo Usuario";
	
	private JTextField txtUser;
	private JPasswordField pswPassword;
	private JButton btnAcceder;
	private JButton btnNuevoUsuario;

	public VLogin() {
		
		super ("Login");
		init();
		
	}

	private void init() {
		
		getContentPane().setLayout(null);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUser.setBounds(49, 35, 75, 20);
		getContentPane().add(lblUser);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(49, 70, 75, 20);
		getContentPane().add(lblPassword);
		
		txtUser = new JTextField();
		txtUser.setToolTipText("Introduce tu usuario");
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtUser.setBounds(173, 31, 162, 25);
		getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		pswPassword = new JPasswordField();
		pswPassword.setToolTipText("Introduce tu password");
		pswPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pswPassword.setBounds(173, 71, 162, 25);
		getContentPane().add(pswPassword);
		
		btnAcceder = new JButton(BTN_ACCEDER);
		btnAcceder.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAcceder.setBounds(204, 112, 100, 25);
		getContentPane().add(btnAcceder);
		
		btnNuevoUsuario = new JButton(BTN_RESGISTRAR);
		btnNuevoUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNuevoUsuario.setBounds(39, 115, 128, 21);
		getContentPane().add(btnNuevoUsuario);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		setSize(ANCHO, ALTO);
		centrarVentana();
		
	}

	private void centrarVentana() {
		   
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();                   
		Dimension ventana = new Dimension(ANCHO, ALTO);                     
		setLocation((pantalla.width - ventana.width) / 2,  (pantalla.height - ventana.height) / 2); 
		
	}
	
	public void hacerVisible() {
		
		setVisible(true);
		
	}

	public void setListener(LoginListener listener) {

		btnAcceder.addActionListener(listener);
		btnNuevoUsuario.addActionListener(listener);
		
	}

	public User getUsuario() {
		String user = txtUser.getText().trim();
		User usuario = null;
		
		if(user.isEmpty()) {
			mostrarError("Debe introducir el usuario");
		}else {
			String pwd = pswPassword.getText().trim();
			
			if(pwd.isEmpty()) {
				mostrarError("Debe introducir el password");
			}else {
				usuario = new User(user,pwd);
			}
		}
		return usuario;
	}


	public void mostrarError(String error) {
		
		JOptionPane.showMessageDialog(this, error, "ERROR", JOptionPane.ERROR_MESSAGE);
		
	}
	public void cargarUsuario(String usuario) {
		txtUser.setText(usuario);
		
	}
}