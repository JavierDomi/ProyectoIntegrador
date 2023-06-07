package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PClases extends JPanel {
	
	public static final String BTN_CONSULTAR = "Consultar";
	public static final String BTN_ELIMINAR = "Eliminar";
	private String[] distincion = {"TODAS", "1 estrella", "2 estrellas", "3 estrellas" };
	
	private DefaultComboBoxModel<String> dcbm; // Declarar DefaultComboBox
	private JButton btnConsultar;
	private JButton btnReservar;
	private JTable tblTabla;
	private DefaultTableModel tblModel;
	private JScrollPane scrpTabla;
	private JLabel lblClases;
	
	public PClases() {
		
		initComponents();
		}

	private void initComponents() {
		setLayout(null);
		setSize(VPrincipal.ANCHO - 30, VPrincipal.ALTO - 70);

		JLabel lblReservaClases = new JLabel("Reserva de Clases");
		lblReservaClases.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblReservaClases.setBounds(48, 39, 330, 20);
		add(lblReservaClases);
		dcbm = new DefaultComboBoxModel<>();

		btnConsultar = new JButton("Consultar Horarios");
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnConsultar.setBounds(48, 487, 153, 21);
		add(btnConsultar);

		lblClases = new JLabel("Clases:");
		lblClases.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblClases.setBounds(48, 80, 164, 20);
		add(lblClases);

		scrpTabla = new JScrollPane();
		scrpTabla.setBounds(48, 110, 670, 367);
		add(scrpTabla);

		tblTabla = new JTable();
		scrpTabla.setViewportView(tblTabla);
		configurarTabla(); // CONFIGURAR TABLA METODO UNA VEZ

		btnReservar = new JButton("Reservar");
		btnReservar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnReservar.setBounds(338, 487, 100, 21);
		add(btnReservar);
		
		JButton btnAnularReserva = new JButton("Anular Reserva");
		btnAnularReserva.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAnularReserva.setBounds(590, 488, 100, 21);
		add(btnAnularReserva);
		
	}

	private void configurarTabla() {
		// TODO Auto-generated method stub
		
	}
}