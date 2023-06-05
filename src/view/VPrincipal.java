package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import control.LoginListener;

import javax.swing.JMenuBar;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JMenu;
import java.awt.Font;

public class VPrincipal extends JFrame {
	public static final int ANCHO = 800;
	public static final int ALTO = 600;
	
	public static final String MNTM_INICIO = "Inicio";
	public static final String MNTM_HORARIOS = "Horarios";
	public static final String MNTM_RESERVASPISTAS = "Reservas Pistas";
	public static final String MNTM_RESERVASCLASES = "Reservas Clases";
	public static final String MNTM_SALIR = "Salir";
	
	private JMenuItem mntmReservaPistas;
	private JMenuItem mntmReservaClases;
	private JMenuItem mntmSalir;
	private JScrollPane scrpContenedor;
	private JMenuItem mntmHorarios;
	private JMenuItem mntmInicio;
	
	public VPrincipal() {
		super("** 3 M O N K E Y S **");
		crearMenu();
		init();
	}
	private void init() {
		setSize(ANCHO, ALTO);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		scrpContenedor = new JScrollPane();
		getContentPane().add(scrpContenedor, BorderLayout.CENTER);
		centrarVentana();
				
	}
	private void crearMenu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mntmInicio = new JMenuItem(MNTM_INICIO);
		mntmInicio.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mntmInicio);
		
		mntmHorarios = new JMenuItem(MNTM_HORARIOS);
		mntmHorarios.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mntmHorarios);
		
		JMenu mnReservas = new JMenu("Reservas                                ");
		mnReservas.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnReservas);
		
		mntmReservaPistas = new JMenuItem(MNTM_RESERVASPISTAS);
		mntmReservaPistas.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnReservas.add(mntmReservaPistas);
		
		mntmReservaClases = new JMenuItem(MNTM_RESERVASCLASES);
		mntmReservaClases.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnReservas.add(mntmReservaClases);
		
		mntmSalir = new JMenuItem(MNTM_SALIR);
		mntmSalir.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mntmSalir);
	}
	
	private void centrarVentana() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();               
		Dimension ventana = new Dimension(ANCHO, ALTO);               
		setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
	}
	
	public void cargarPanel(JPanel panel) {
		scrpContenedor.setViewportView(panel);
	}
	
	public void confirmarSalida() {
		int opcion = JOptionPane.showConfirmDialog(this, "¿Seguro que desea cerrar la aplicación?",
				"Confirmación de salida", JOptionPane.YES_NO_OPTION, 
				JOptionPane.QUESTION_MESSAGE);
		
		if (opcion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}		
	}
	
	public void setListener(LoginListener listener) {
		mntmInicio.addActionListener(listener);
		mntmHorarios.addActionListener(listener);
		mntmReservaPistas.addActionListener(listener);
		mntmReservaClases.addActionListener(listener);
		mntmSalir.addActionListener(listener);		
	}
	

}
