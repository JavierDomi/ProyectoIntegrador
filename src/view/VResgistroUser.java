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

	private static final int ANCHO = 800;
	private static final int ALTO = 600;
	public static final String BTN_GUARDAR = "Guardar";
	public static final String BTN_CANCELAR = "Cancelar";
	private JTextField txtUsuario;
	private JPasswordField pswPassword;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JPasswordField pswPassword2;
	private JLabel lblConfirmarPassw;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtDNI;
	private JTextField txtDireccion;
	private JTextField txtEmail;
	private JTextField txtTelef;

	public VResgistroUser() {
		super("Registro Usuario");
		init();
		
	}

	private void init() {
		getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setBounds(50, 377, 75, 20);
		getContentPane().add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(446, 362, 75, 20);
		getContentPane().add(lblPassword);
		
		txtUsuario = new JTextField();
		txtUsuario.setToolTipText("Introduce tu usuario");
		txtUsuario.setBounds(156, 375, 182, 25);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		pswPassword = new JPasswordField();
		pswPassword.setToolTipText("Introduce tu password");
		pswPassword.setBounds(560, 360, 182, 26);
		getContentPane().add(pswPassword);
		
		btnGuardar = new JButton(BTN_GUARDAR);
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGuardar.setBounds(416, 486, 117, 29);
		getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton(BTN_CANCELAR);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelar.setBounds(254, 486, 117, 29);
		getContentPane().add(btnCancelar);
		
		lblConfirmarPassw = new JLabel("Confirm password");
		lblConfirmarPassw.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirmarPassw.setBounds(399, 405, 149, 20);
		getContentPane().add(lblConfirmarPassw);
		
		pswPassword2 = new JPasswordField();
		pswPassword2.setToolTipText("Confirma tu password");
		pswPassword2.setBounds(560, 403, 182, 26);
		getContentPane().add(pswPassword2);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(50, 104, 75, 20);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombre.setToolTipText("Introduce tu nombre");
		txtNombre.setColumns(10);
		txtNombre.setBounds(156, 101, 182, 25);
		getContentPane().add(txtNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellidos.setBounds(50, 146, 75, 20);
		getContentPane().add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtApellidos.setToolTipText("Introduce tus apellidos");
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(156, 143, 182, 25);
		getContentPane().add(txtApellidos);
		
		JLabel lblReg = new JLabel("Registro Usuario");
		lblReg.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblReg.setBounds(318, 6, 255, 38);
		getContentPane().add(lblReg);
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDNI.setBounds(50, 192, 75, 20);
		getContentPane().add(lblDNI);
		
		txtDNI = new JTextField();
		txtDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDNI.setToolTipText("Introduce tu DNI");
		txtDNI.setColumns(10);
		txtDNI.setBounds(156, 189, 182, 25);
		getContentPane().add(txtDNI);
		
		JLabel lblDireccion = new JLabel("Dirreción");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDireccion.setBounds(50, 241, 75, 20);
		getContentPane().add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setToolTipText("Introduce tu direccion");
		txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(156, 239, 586, 25);
		getContentPane().add(txtDireccion);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(446, 104, 75, 20);
		getContentPane().add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setToolTipText("Introduce tu usuario");
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(560, 104, 182, 25);
		getContentPane().add(txtEmail);
		
		JLabel lblWeb = new JLabel("Teléfono:");
		lblWeb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWeb.setBounds(446, 149, 75, 20);
		getContentPane().add(lblWeb);
		
		txtTelef = new JTextField();
		txtTelef.setToolTipText("Introduce tu usuario");
		txtTelef.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTelef.setColumns(10);
		txtTelef.setBounds(560, 147, 182, 25);
		getContentPane().add(txtTelef);
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
		
		String usuario = txtUsuario.getText().trim();
		String nombre = txtNombre.getText().trim();
		String apellidos = txtApellidos.getText().trim();
		String dni = txtDNI.getText().trim();
		String direccion = txtDireccion.getText().trim();
		String email = txtEmail.getText().trim();
		String telefono = txtTelef.getText().trim();
	
	
		
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
					if(nombre.isEmpty()) {
						mostrarError("Debe introducir el nombre");
					}else {
						if(apellidos.isEmpty()) {
							mostrarError("Debe introducir los apellidos");
						}else {
							if(dni.isEmpty()) {
								mostrarError("Debe introducir el DNI");
							}else {
								if(direccion.isEmpty()) {
									mostrarError("Debe introducir la direccion");
								}else {
									user = new User(usuario, pwd, nombre, apellidos, dni, direccion, email,telefono);
								}
							}
						}
					}
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
