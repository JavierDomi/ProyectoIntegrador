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

	private static final int ANCHO = 400;
	private static final int ALTO = 250;
	public static final String BTN_GUARDAR = "Guardar";
	public static final String BTN_CANCELAR = "Cancelar";
	private JTextField txtUser;
	private JPasswordField pswPassword;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JPasswordField pswPassword2;
	private JLabel lblConfirmarPassw;

	public VResgistroUser() {
		super("Registro Usuario");
		init();
		
	}

	private void init() {
		getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("User");
		lblUsuario.setBounds(30, 30, 75, 20);
		getContentPane().add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(30, 62, 75, 20);
		getContentPane().add(lblPassword);
		
		txtUser = new JTextField();
		txtUser.setToolTipText("Introduce tu usuario");
		txtUser.setBounds(183, 27, 182, 25);
		getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		pswPassword = new JPasswordField();
		pswPassword.setToolTipText("Introduce tu password");
		pswPassword.setBounds(183, 59, 182, 26);
		getContentPane().add(pswPassword);
		
		btnGuardar = new JButton(BTN_GUARDAR);
		btnGuardar.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnGuardar.setBounds(226, 158, 117, 29);
		getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton(BTN_CANCELAR);
		btnCancelar.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnCancelar.setBounds(62, 158, 117, 29);
		getContentPane().add(btnCancelar);
		
		lblConfirmarPassw = new JLabel("Confirm password");
		lblConfirmarPassw.setBounds(30, 102, 149, 20);
		getContentPane().add(lblConfirmarPassw);
		
		pswPassword2 = new JPasswordField();
		pswPassword2.setToolTipText("Introduce tu password");
		pswPassword2.setBounds(183, 99, 182, 26);
		getContentPane().add(pswPassword2);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		setSize(ANCHO,ALTO);
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
		btnGuardar.addActionListener(listener);
		btnCancelar.addActionListener(listener);
	}

	public User getUsuario() {
		User user = null;
		
		String usuario = txtUser.getText().trim();
	
		
		if(usuario.isEmpty()) {
			mostrarError("Debe introducir el usuario");
		}else {
			String pwd = pswPassword.getText().trim();
			String pwd2 = pswPassword2.getText().trim();
			
			if(pwd.isEmpty() || pwd2.isEmpty()) {
				mostrarError("Debe introducir el password y la confirmación");
			}else {
				if(!pwd.equals(pwd2)) {
					mostrarError("Las contraseñas no coinciden");
				}else {
					user = new User(usuario, pwd);
				}
				
			}
		}
		
		
		
		return user;
	}

	public void mostrarError(String error) {
		JOptionPane.showMessageDialog(this, error, "ERROR", JOptionPane.ERROR_MESSAGE);
		
	}
	public void mostrarMensaje(String texto) {
		JOptionPane.showMessageDialog(this, texto, "Infromacion", JOptionPane.INFORMATION_MESSAGE);
		
	}

	public void mostrarMensaje(String texto, String titulo, int icono) {
		JOptionPane.showMessageDialog(this,texto, titulo, icono);
		
	}
}
