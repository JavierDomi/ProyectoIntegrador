package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import db.UsuarioPersistencia;
import model.Pista;
import model.User;
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
	

	public LoginListener(VLogin vLogin, VPrincipal vp, PInicio pInicio,VResgistroUser vReg,PHorarios pHorarios, PPistas pPistas) {

		this.vLogin = vLogin;
		this.vp = vp;
		this.pInicio = pInicio;
		this.vReg = vReg;
		this.pPistas = pPistas;
		this.pHorarios = pHorarios;
		uPers = new UsuarioPersistencia();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

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
			
			
		

		} else if(e.getActionCommand().equals(VResgistroUser.BTN_GUARDAR)) {
			//guardar usuario en la base de datos
			User user = vReg.getUsuario();
			if(user != null) {
				int res = uPers.registrarUsuario(user);
				
				if(res == 1) {
					vReg.mostrarMensaje("El usuario se ha registrao con exito");
					vReg.dispose();
					vLogin.hacerVisible();
					vLogin.cargarUsuario(user.getUsuario());
					vReg.limpiar();
				}else if(res == -1) {
					vReg.mostrarMensaje("El Usuario ya existe");
				}
			}
		}else if (e.getActionCommand().equals(VResgistroUser.BTN_CANCELAR)) {
			vReg.dispose();
			vReg.limpiar();
			vLogin.hacerVisible();
			
		}else if(e.getActionCommand().equals(PHorarios.BTN_APUNTARSE)) {
			//////////
			//CARGAR PANEL DE CLASES!!!!!!!!
			//pHorarios.cargarPanel(pPistas);
			//pHorarios.setVisible(true);
			//pPistas.setVisible(false);
			///////
			vp.cargarPanel(pPistas);
			
		}else if (e.getSource() instanceof JMenuItem) {

			if (e.getActionCommand().equals(VPrincipal.MNTM_INICIO)) {
				vp.cargarPanel(pInicio);

			} else if (e.getActionCommand().equals(VPrincipal.MNTM_HORARIOS)) {
				vp.cargarPanel(pHorarios);
				

			} else if (e.getActionCommand().equals(VPrincipal.MNTM_RESERVASCLASES)) {

			} else if (e.getActionCommand().equals(VPrincipal.MNTM_RESERVASPISTAS)) {
				
				pPistas.cargarCombo(uPers.selectPistas());
				pPistas.limpiarConsulta();
				vp.cargarPanel(pPistas);

			} else if (e.getActionCommand().equals(VPrincipal.MNTM_SALIR)) {
				
				vp.confirmarSalida();
					
			} else if (e.getActionCommand().equals(PPistas.BTN_LIMP)) {
				
				pPistas.limpiarConsulta();
				
			} else if (e.getActionCommand().equals(PPistas.BTN_DISPO)) {
				
				constultarPistas();
				
			} else if (e.getActionCommand().equals(PPistas.BTN_DISPO)) {
				
				
				
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
