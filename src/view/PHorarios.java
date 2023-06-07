package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.LoginListener;

import javax.swing.JScrollPane;
import javax.swing.Icon;
import javax.swing.JButton;

public class PHorarios extends JPanel {
	public static final String BTN_APUNTARSE = "Apuntarse a clases";
	private JScrollPane scrollPane;
	private JTable tblHorarios;
	private DefaultTableModel tModel;
	private JButton btnApuntar;


	public PHorarios() {
	
		init();
	}

	private void init() {
		setLayout(null);
		setSize(VPrincipal.ANCHO - 35, VPrincipal.ALTO - 15);
		
		JLabel lblHorarios = new JLabel("Horarios");
		lblHorarios.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHorarios.setBounds(335, 36, 81, 32);
		add(lblHorarios);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 106, 650, 313);
		add(scrollPane);
		
		tblHorarios = new JTable();
		tblHorarios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(tblHorarios);
		
		
		String [] columnas = {"HORARIOS","LUNES","MARTES", "MIÉRCOLES","JUEVES", "VIERNES"};
		Object [][] datos = {
				{},
				{"10:00-11:00", "Yoga", " - ", "Boxeo","Futbol", "Pilates"},
				{},
				{"11:00-12:00", "Padel", "CrossFit", " - ","Tenis", "CardioJump"},
				{},
				{"12:00-13:00", " - ", "Spinning", " Zumba ","Yoga", "Pilates"},
				{},
				{"15:00-16:00", "Futbol", " - ", " Tenis","CrossFit", "Yoga"},
				{},
				{"16:00-17:00", "Tenis", "Zumba", " - ","Boxeo", " - "},
				{},
				{"17:00-18:00", "CrossFit", "Padel", " - ","Tenis", "Futbol"},
				{},
				{"18:00-19:00", "Spinning", "-", " Yoga ","Tenis", "CardioJump"},
				{},
				{"19:00-20:00", "Zumba", "Yoga", " - ","Padel", "Yoga"}
				
		};
		
		tModel = new DefaultTableModel(datos, columnas) {

			
			@Override
			public boolean isCellEditable(int row, int column) {
			
				return false;
			}
		};
		tblHorarios.setModel(tModel);
		scrollPane.setViewportView(tblHorarios);
		
		btnApuntar = new JButton(BTN_APUNTARSE);
		btnApuntar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnApuntar.setBounds(281, 466, 203, 52);
		add(btnApuntar);
		
		
	
	}	
	public void setListener(LoginListener listener) {

		btnApuntar.addActionListener(listener);
		
		
	}
	
}