package view;

import java.awt.Font;
import control.LoginListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Clase;

public class PClases extends JPanel {
	
	public static final String BTN_RESERVAR = "Reservar Clase";
	public static final String BTN_HORARIOS = "Horarios";
		
	private JButton btnHorarios;
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

		btnHorarios = new JButton(BTN_HORARIOS);
		btnHorarios.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnHorarios.setBounds(592, 462, 120, 21);
		add(btnHorarios);

		lblClases = new JLabel("Clases:");
		lblClases.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblClases.setBounds(48, 80, 164, 20);
		add(lblClases);

		scrpTabla = new JScrollPane();
		scrpTabla.setBounds(48, 110, 510, 373);
		add(scrpTabla);

		tblTabla = new JTable();
		scrpTabla.setViewportView(tblTabla);
		configurarTabla(); // CONFIGURAR TABLA METODO UNA VEZ

		btnReservar = new JButton(BTN_RESERVAR);
		btnReservar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnReservar.setBounds(592, 394, 120, 21);
		add(btnReservar);
		
	}

	//CONFIGURAR TABLA
	private void configurarTabla() {
		tblModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) { // escribir iscell + ctrl spce
				return false;
			}
		};

		tblModel.addColumn("NOMBRE");
		tblModel.addColumn("PRECIO");
		tblModel.addColumn("PLAZAS DISPONIBLES");

		tblTabla.setModel(tblModel);

		tblTabla.getColumn("NOMBRE").setPreferredWidth(75);
		tblTabla.getColumn("PRECIO").setPreferredWidth(75);
		tblTabla.getColumn("PLAZAS DISPONIBLES").setPreferredWidth(75);


	}
	//RELLENAR TABLA
	public void rellenarTabla(ArrayList<Clase> listaClases) {
		tblTabla.clearSelection();
		tblModel.getDataVector().clear();
		Object[] fila = new Object[3];

		for (Clase clase : listaClases) {
			fila[0] = clase.getNombre();
			fila[1] = clase.getPrecio();
			fila[2] = clase.getCapacidad();
		
			tblModel.addRow(fila);
			
		}
	}
	public void setVisibleTabla(boolean b) {
		
		scrpTabla.setVisible(b);
				
	}
	
	public void mostrarError(String error) {
		JOptionPane.showMessageDialog(this, error, "ERROR", JOptionPane.ERROR_MESSAGE);		
	}

	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);		
		
	}
	public int mostrarConfirmacion (String confirmacion) {
		return JOptionPane.showConfirmDialog(this, confirmacion, "Confirmación", JOptionPane.YES_NO_OPTION);
	}

	public void setListener(LoginListener listener) {
		btnReservar.addActionListener(listener);
		btnHorarios.addActionListener(listener);
		
	}
	
	public String obtenerElementoSel() {
        if(tblTabla.getSelectedRow() == -1) {
        	
            mostrarError("No se ha seleccionado ninguna fila");
            return "";
        }
        else {
            return (String) tblTabla.getValueAt(tblTabla.getSelectedRow(), 0);
        }
	}
}