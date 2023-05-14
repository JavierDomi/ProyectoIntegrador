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

public class VResgistroUser extends JFrame{
	
	private static final int ANCHO = 500;
	private static final int ALTO = 250;
	
	public static final String BTN_ACCEDER = "Acceder";
	
	private JTextField txtUser;
	private JPasswordField pswPassword;
	private JButton btnRegistrar;
	private JPasswordField pswConPassword;

	public VResgistroUser() {
		
		super ("Registro Usuario");
		setTitle("Registro Usuario");
		centrarVentana();
		init();
		
	}

	private void init() {
		
		getContentPane().setLayout(null);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUser.setBounds(52, 32, 75, 20);
		getContentPane().add(lblUser);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(52, 72, 75, 20);
		getContentPane().add(lblPassword);
		
		txtUser = new JTextField();
		txtUser.setToolTipText("Introduce tu usuario");
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtUser.setBounds(269, 30, 162, 25);
		getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		pswPassword = new JPasswordField();
		pswPassword.setToolTipText("Introduce tu password");
		pswPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pswPassword.setBounds(269, 70, 162, 25);
		getContentPane().add(pswPassword);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegistrar.setBounds(269, 159, 100, 25);
		getContentPane().add(btnRegistrar);
		
		pswConPassword = new JPasswordField();
		pswConPassword.setToolTipText("Introduce tu password");
		pswConPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pswConPassword.setBounds(269, 109, 162, 25);
		getContentPane().add(pswConPassword);
		
		JLabel lblConPassword = new JLabel("Confirmar Password");
		lblConPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblConPassword.setBounds(52, 114, 128, 20);
		getContentPane().add(lblConPassword);
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

		btnRegistrar.addActionListener(listener);
		
	}

	public User getUsuario() {
		
		String user = txtUser.getText();
		User usuario = null;
		
		if (user.isEmpty()) {
			
			mostrarError("Debe introducir el usuario");
			
		} else {
			
			
			String pwd = pswPassword.getText().trim();
			String pwdCon = pswConPassword.getText().trim();
			
			if (pwd.isEmpty() || pwdCon.isEmpty()) 
				
				mostrarError("Debe introducir la contraseña en ambos campos");
			
			else if (!pwd.equals(pwdCon)){
				
				mostrarError("La contraseña de verificación no coincide");
				
			} else {
				
				usuario = new User(user, pwd);
				
			}
			
		}
		
		return usuario;
	}

	public void mostrarError(String error) {
		
		JOptionPane.showMessageDialog(this, error, "ERROR", JOptionPane.ERROR_MESSAGE);
		
	}
}