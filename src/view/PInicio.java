package view;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;

public class PInicio extends JPanel {
	public PInicio() {
		init();
	}

	private void init() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setSize(VPrincipal.ANCHO - 30, VPrincipal.ALTO - 70);
		
		JLabel lblBienvenido = new JLabel("¡ B i e n v e n i d o !");
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblBienvenido.setBounds(266, 174, 238, 25);
		add(lblBienvenido);
		
		JLabel lblNewLabel = new JLabel("3 M o n k e y s   S p o r t s   C e n t e r");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(99, 71, 571, 57);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("/Users/lvilkelenoka/Desktop/PI/ProyectoIntegrador/img/3M logo.png"));
		lblNewLabel_1.setBounds(289, 239, 191, 191);
		add(lblNewLabel_1);
		
		/*JLabel lblNewLabel_1 = new JLabel("");
        ImageIcon logo = new ImageIcon(getClass().getResource("/img/3Mlogo.png"));
        lblNewLabel_1.setIcon(new ImageIcon(PInicio.class.getResource("/img/220x220_3M.png")));
        lblNewLabel_1.setBounds(280, 238, 210, 214);
        add(lblNewLabel_1);*/
	}
}
