package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import db.UsuarioPersistencia;
import model.User;
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
	

	public LoginListener(VLogin vLogin, VPrincipal vp, PInicio pInicio,VResgistroUser vReg) {

		this.vLogin = vLogin;
		this.vp = vp;
		this.pInicio = pInicio;
		this.vReg = vReg;
		uPers = new UsuarioPersistencia();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals(VLogin.BTN_ACCEDER)) {

			User user = vLogin.getUsuario();

			if (user != null) {

				String resultado = uPers.validarUsuario(user);

				if (resultado.equals("Acceso permitido")) {

					vp.hacerVisible();

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
				}else if(res == -1) {
					vReg.mostrarMensaje("El Usuario ya existe");
				}
			}
		}else if (e.getActionCommand().equals(VResgistroUser.BTN_CANCELAR)) {
			vReg.dispose();
			vLogin.hacerVisible();
			
		}else if (e.getSource() instanceof JMenuItem) {

			if (e.getActionCommand().equals(VPrincipal.MNTM_INICIO)) {
				vp.cargarPanel(pInicio);

			} else if (e.getActionCommand().equals(VPrincipal.MNTM_HORARIOS)) {

			} else if (e.getActionCommand().equals(VPrincipal.MNTM_RESERVASCLASES)) {

			} else if (e.getActionCommand().equals(VPrincipal.MNTM_RESERVASPISTAS)) {

			} else if (e.getActionCommand().equals(VPrincipal.MNTM_SALIR)) {
				vp.confirmarSalida();
			}

		}
	}
}
