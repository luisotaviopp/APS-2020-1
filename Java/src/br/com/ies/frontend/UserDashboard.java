package br.com.ies.frontend;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import br.com.ies.frontend.builder.ComponentBuilder;

public class UserDashboard {

	private JFrame frame;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public UserDashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		frame.getContentPane().add(ComponentBuilder.buildLabel("SEJA BEM VINDO", "Franklin Gothic Medium", Font.BOLD,
				20, SwingConstants.CENTER, 0, 30, 882, 30));

		frame.getContentPane().add(ComponentBuilder.buildButton("EVENTOS", "Franklin Gothic Medium", Font.PLAIN, 13, 27,
				90, 400, 200,null, () -> {
					new ListaEventos().toggleFrame();
					toggleFrame();
				}));
		frame.getContentPane().add(ComponentBuilder.buildButton("MEU PERFIL", "Franklin Gothic Medium", Font.PLAIN, 13,
				27, 320, 400, 200,null, () -> {
					new PerfilUsuario().toggleFrame();
					toggleFrame();
				}));

		frame.getContentPane().add(ComponentBuilder.buildButton("MEUS INGRESSOS", "Franklin Gothic Medium", Font.PLAIN,
				13, 454, 90, 400, 200,null, () -> {
					new MeusIngressos().toggleFrame();
					toggleFrame();
				}));

		frame.getContentPane().add(ComponentBuilder.buildButton("SAIR", "Franklin Gothic Medium", Font.PLAIN, 13, 454,
				320, 400, 200,null, () -> {
					System.exit(0);
				}));
	}

	public JFrame getFrame() {
		return frame;
	}

	public void toggleFrame() {
		frame.setVisible(!frame.isVisible());
	}

}
