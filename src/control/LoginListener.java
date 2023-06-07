package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import db.UsuarioPersistencia;
import model.Clase;
import model.Pista;
import model.User;
import view.PClases;
import view.PHorarios;
import view.PInicio;
import view.PPistas;
import view.VLogin;
import view.VPrincipal;
import view.VResgistroUser;

public class LoginListener implements ActionListener {

	private VLogin vLogin;
	private UsuarioPersistencia uPers;
	private VPrincipal vp;
	private PInicio pInicio;
	private VResgistroUser vReg;
	private PPistas pPistas;
	private PHorarios pHorarios;
	private PClases pClases;

	public LoginListener(VLogin vLogin, VPrincipal vp, PInicio pInicio, VResgistroUser vReg, PHorarios pHorarios,
			PPistas pPistas, PClases pClases) {

		this.vLogin = vLogin;
		this.vp = vp;
		this.pInicio = pInicio;
		this.vReg = vReg;
		this.pPistas = pPistas;
		this.pHorarios = pHorarios;
		this.pClases = pClases;
		uPers = new UsuarioPersistencia();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JMenuItem) {

			if (e.getActionCommand().equals(VPrincipal.MNTM_INICIO)) {
				vp.cargarPanel(pInicio);

			} else if (e.getActionCommand().equals(VPrincipal.MNTM_HORARIOS)) {
				vp.cargarPanel(pHorarios);

			} else if (e.getActionCommand().equals(VPrincipal.MNTM_RESERVASCLASES)) {
				vp.cargarPanel(pClases);
				ArrayList<Clase> listaClases = uPers.consultaClases();
				pClases.rellenarTabla(listaClases);

			} else if (e.getActionCommand().equals(VPrincipal.MNTM_RESERVASPISTAS)) {
				pPistas.cargarCombo(uPers.selectPistas());
				pPistas.limpiarConsulta();
				vp.cargarPanel(pPistas);

			} else if (e.getActionCommand().equals(VPrincipal.MNTM_SALIR)) {
				vp.confirmarSalida();
			}

		} else if (e.getSource() instanceof JButton) {
			// VENTANA LOGIN
			if (e.getActionCommand().equals(VLogin.BTN_ACCEDER)) {
				User user = vLogin.getUsuario();
				if (user != null) {
					String resultado = uPers.validarUsuario(user);
					if (resultado.equals("Acceso permitido")) {
						vLogin.dispose();
						vp.hacerVisible();
						vp.cargarPanel(pInicio);
					} else {
						vLogin.mostrarError(resultado);
					}
				}

			} else if (e.getActionCommand().equals(VLogin.BTN_RESGISTRAR)) {
				vLogin.dispose();
				vReg.hacerVisible();

			// VENTANA REGISTRO USER
			} else if (e.getActionCommand().equals(VResgistroUser.BTN_GUARDAR)) {
				// guardar usuario en la base de datos
				User user = vReg.getUsuario();
				if (user != null) {
					int res = uPers.registrarUsuario(user);

					if (res == 1) {
						vReg.mostrarMensaje("El usuario se ha registrao con exito");
						vReg.dispose();
						vLogin.hacerVisible();
						vLogin.cargarUsuario(user.getUsuario());
						vReg.limpiar();
					} else if (res == -1) {
						vReg.mostrarMensaje("El Usuario ya existe");
					}
				}
			} else if (e.getActionCommand().equals(VResgistroUser.BTN_CANCELAR)) {
				vReg.dispose();
				vReg.limpiar();
				vLogin.hacerVisible();

			// VENTANA RESERVA PISTAS
			} else if (e.getActionCommand().equals(PPistas.BTN_LIMP)) {
				pPistas.limpiarConsulta();

			} else if (e.getActionCommand().equals(PPistas.BTN_DISPO)) {
				constultarPistas();

			} else if (e.getActionCommand().equals(PPistas.BTN_DISPO)) {

			// VENTANA RESERVA CLASES
			} else if (e.getActionCommand().equals(PClases.BTN_RESERVAR)) {
				String nombre = pClases.obtenerElementoSel();
				if (nombre.equals("")) {
					pClases.mostrarError("Debe seleccionar un registro de la tabla");
				} else {
					int opcion = pClases.mostrarConfirmacion("¿Seguro que desea reservar la clase?");

					if (opcion == JOptionPane.YES_OPTION) {

						int res = uPers.reservarClase(nombre);
						if (res == 1) {
							ArrayList<Clase> listaClases = uPers.consultaClases();
							pClases.rellenarTabla(listaClases);
							;
							pClases.mostrarMensaje("Se reservado al clase con éxito");
						} else {
							pClases.mostrarError("No se ha podido reservar la clase");
						}
					}
				}

			} else if (e.getActionCommand().equals(PClases.BTN_HORARIOS)) {
				vp.cargarPanel(pHorarios);
			}
		}
	}

	private void constultarPistas() {

		String tipo = pPistas.getCmbPista();
		String fecha = pPistas.getTxtFecha();

		ArrayList<Pista> listaPistas = uPers.selectPistasFiltro(tipo, fecha);

		if (listaPistas.size() > 0) {

			pPistas.rellenarTabla(listaPistas);
			pPistas.setVisibleTabla(true);

		} else {

			pPistas.setVisible(false);
			JOptionPane.showMessageDialog(pPistas, "No se han encontrado datos para el filtro introducido",
					"Resultado de Consulta", JOptionPane.INFORMATION_MESSAGE);

		}

	}
}
