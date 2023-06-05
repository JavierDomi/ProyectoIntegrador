package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import db.UsuarioPersistencia;
import model.User;
import view.PInicio;
import view.VLogin;
import view.VPrincipal;

public class LoginListener implements ActionListener {

	private VLogin vLogin;
	private UsuarioPersistencia uPers;
	private VPrincipal vp;
	private PInicio pInicio;

	public LoginListener(VLogin vLogin, VPrincipal vp, PInicio pInicio) {

		this.vLogin = vLogin;
		this.vp = vp;
		this.pInicio = pInicio;
		uPers = new UsuarioPersistencia();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals(VLogin.BTN_ACCEDER)) {

			User user = vLogin.getUsuario();

			if (user != null) {

				String resultado = uPers.validarUsuario(user);

				if (resultado.equals("Acceso permitido")) {

					// vLogin.mostrarError(resultado);

				} else {

					vLogin.mostrarError(resultado);

				}

			}

		} else if (e.getActionCommand().equals(VLogin.BTN_RESGISTRAR)) {

			// TODO
			// ABRIR VRegistroUser AL PULSAR BOTÓN

		} else if (e.getSource() instanceof JMenuItem) {

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
