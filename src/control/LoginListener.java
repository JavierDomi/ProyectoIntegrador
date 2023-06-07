package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import db.UsuarioPersistencia;
import model.User;
import view.PHorarios;
import view.PInicio;
import view.VLogin;
import view.VPrincipal;
import view.VResgistroUser;

public class LoginListener implements ActionListener {

	private VLogin vLogin;
	private UsuarioPersistencia uPers;
	private VPrincipal vp;
	private PInicio pInicio;
	private VResgistroUser vReg;
	private PHorarios pHorarios;
	

	public LoginListener(VLogin vLogin, VPrincipal vp, PInicio pInicio,VResgistroUser vReg,PHorarios pHorarios) {

		this.vLogin = vLogin;
		this.vp = vp;
		this.pInicio = pInicio;
		this.vReg = vReg;
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
			
		}else if (e.getSource() instanceof JMenuItem) {

			if (e.getActionCommand().equals(VPrincipal.MNTM_INICIO)) {
				vp.cargarPanel(pInicio);

			} else if (e.getActionCommand().equals(VPrincipal.MNTM_HORARIOS)) {
				vp.cargarPanel(pHorarios);

			} else if (e.getActionCommand().equals(VPrincipal.MNTM_RESERVASCLASES)) {

			} else if (e.getActionCommand().equals(VPrincipal.MNTM_RESERVASPISTAS)) {

			} else if (e.getActionCommand().equals(VPrincipal.MNTM_SALIR)) {
				vp.confirmarSalida();
			}

		}
	}
}
