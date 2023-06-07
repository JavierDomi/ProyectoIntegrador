package view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import control.LoginListener;
import model.Pista;

public class PPistas extends JPanel{
	
	public static final String BTN_DISPO = "Ver Disponibilidad";
	public static final String BTN_RES = "Reservar";
	public static final String BTN_LIMP = "Limpiar";
	
	private JTable tblTabla;
	private JTextField txtFecha;
	private JComboBox cmbPista;
	private JButton btnDisponibilidad;
	private JButton btnReservar;
	private JScrollPane scrpTabla;
	private DefaultTableModel tModel;
	private DefaultComboBoxModel<String> dcbmPistas;
	private JButton btnLimpiar;
	
	public PPistas() {
		
		init();
		
	}

	private void init() {
		
		setLayout(null);
		setSize(VPrincipal.ANCHO - 30, VPrincipal.ALTO - 70);
		
		JLabel lblTipoPista = new JLabel("Pista");
		lblTipoPista.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTipoPista.setBounds(50, 48, 75, 15);
		add(lblTipoPista);
		
		cmbPista = new JComboBox<String>();
		dcbmPistas = new DefaultComboBoxModel<String>();
		cmbPista.setModel(dcbmPistas);
		cmbPista.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbPista.setBounds(50, 85, 145, 21);
		add(cmbPista);
		
		JLabel lblFecha = new JLabel("Fecha (DD/MM/AAAA)");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFecha.setBounds(272, 48, 125, 15);
		add(lblFecha);
		
		btnDisponibilidad = new JButton("Ver Disponibilidad");
		btnDisponibilidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDisponibilidad.setBounds(521, 85, 145, 21);
		add(btnDisponibilidad);
		
		scrpTabla = new JScrollPane();
		scrpTabla.setBounds(56, 175, 610, 223);
		add(scrpTabla);
		
		tblTabla = new JTable();
		scrpTabla.setViewportView(tblTabla);
		
		btnReservar = new JButton("Reservar");
		btnReservar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnReservar.setBounds(574, 451, 92, 21);
		add(btnReservar);
		
		txtFecha = new JTextField();
		txtFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtFecha.setBounds(272, 86, 125, 19);
		add(txtFecha);
		txtFecha.setColumns(10);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLimpiar.setBounds(547, 46, 92, 21);
		add(btnLimpiar);
		
		
	}
	
	private void configurarTabla() {
		
		tModel = new DefaultTableModel() {
			
			@Override
			public boolean isCellEditable(int row, int column) {
				
				return false;
				
			}
			
		};
		
		tModel.addColumn("Nombre");
		tModel.addColumn("Tipo");
		tModel.addColumn("Precio / h");
		tModel.addColumn("Hora Inicio");
		tModel.addColumn("Hora Fin");
		tModel.addColumn("Disponibilidad");
		
		tblTabla.setModel(tModel);
		
		tblTabla.getColumn("Nombre").setPreferredWidth(100);
		tblTabla.getColumn("Tipo").setPreferredWidth(100);
		tblTabla.getColumn("Precio / h").setPreferredWidth(100);
		tblTabla.getColumn("Hora Incio").setPreferredWidth(70);
		tblTabla.getColumn("Hora Fin").setPreferredWidth(70);
		tblTabla.getColumn("Disponibilidad").setPreferredWidth(100);
		
	}
	
	public void rellenarTabla(ArrayList<Pista> listaPistas) {
		
		tModel.getDataVector().clear();
		
		Object[] fila = new Object[6];
		
		for (Pista pista : listaPistas) {
			
			fila [0] = pista.getNombre();
			fila [0] = pista.getTipo();
			fila [0] = pista.getPrecio();
			fila [0] = "09:00";
			fila [0] = "11:00";
			fila [0] = pista.getDispo();				
			
		}
		
		tModel.addRow(fila);
		
	}
	
	public void setVisibleTabla(boolean b) {
		
		scrpTabla.setVisible(b);
		btnReservar.setVisible(b);
		
	}
	
	public void cargarCombo (ArrayList<String> pistas) {
		
		dcbmPistas.removeAllElements();
		dcbmPistas.addElement("Todas");
		
		for (String pista : pistas) {
			
			dcbmPistas.addElement(pista);
			
		}
		
	}
	
	public void limpiarConsulta() {
		
		cmbPista.setSelectedItem("Todas");
		txtFecha.setText("");
		
		setVisibleTabla(false);
		
	}

	public void setListener(LoginListener listener) {
		
		btnDisponibilidad.addActionListener(listener);
		btnLimpiar.addActionListener(listener);
		btnReservar.addActionListener(listener);
		
	}

	public String getTxtFecha() {
		
		return txtFecha.getText();
	}

	public String getCmbPista() {
		
		return (String) cmbPista.getSelectedItem();
	}
	
	
	
}
