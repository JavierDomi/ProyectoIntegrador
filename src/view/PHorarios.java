package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class PHorarios extends JPanel {
	private JScrollPane scrollPane;
	private JTable tblHorarios;
	private DefaultTableModel tModel;
	private ArrayList<Clases>listaClases;
	
	
	public class Clases {
		private String nombre;
	
		
		public Clases(String nombre) {
			this.nombre = nombre;
	
		}

		public String getNombre() {
			return nombre;
		}

		
	}
	private void cargarDatos() {
		listaClases.add(new Clases("Yoga"));
	}
	public PHorarios() {
	
		init();
	}

	private void init() {
		setLayout(null);
		setSize(VPrincipal.ANCHO - 35, VPrincipal.ALTO - 15);
		
		JLabel lblHorarios = new JLabel("Horarios:");
		lblHorarios.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHorarios.setBounds(343, 18, 81, 32);
		add(lblHorarios);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 106, 650, 181);
		add(scrollPane);
		
		tblHorarios = new JTable();
		scrollPane.setViewportView(tblHorarios);
		
		
		String [] columnas = {"HORARIOS","LUNES","MARTES", "MIÉRCOLES","JUEVES", "VIERNES"};
		Object [][] datos = {
				{"10:00-11:00", "Yoga", " - ", "Boxeo","Futbol", "Pilates"},
				
				{"11:00-12:00", "Padel", "CrossFit", " - ","Tenis", "CardioJump"},
				
				{"12:00-13:00", " - ", "Spinning", " Zumba ","Yoga", "Pilates"},
				
				{"15:00-16:00", "Futbol", " - ", " Tenis","CrossFit", "Yoga"},
				
				{"16:00-17:00", "Tenis", "Zumba", " - ","Boxeo", " - "},
				
				{"17:00-18:00", "CrossFit", "Padel", " - ","Tenis", "Futbol"},
				
				{"18:00-19:00", "Spinning", "-", " Yoga ","Tenis", "CardioJump"},
				
				{"19:00-20:00", "Zumba", "Yoga", " - ","Padel", "Yoga"},
				
		};
		
		tModel = new DefaultTableModel(datos, columnas) {

			//para hacer tabla(columnas) no editable, но столбец (2) можем менять
			@Override
			public boolean isCellEditable(int row, int column) {
				/*if(column ==2) {
					return true;
				}*/
				return false;
			}
		};
		tblHorarios.setModel(tModel);
		scrollPane.setViewportView(tblHorarios);
		
	}	
		
	
	
	
}
