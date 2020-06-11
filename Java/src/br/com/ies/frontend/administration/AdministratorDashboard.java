package br.com.ies.frontend.administration;


import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.SwingConstants;

import br.com.ies.frontend.builder.ComponentBuilder;

public class AdministratorDashboard {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public AdministratorDashboard() {
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
		
		frame.getContentPane().add(ComponentBuilder.buildLabel("ADIMINISTRADOR", "Franklin Gothic Medium", Font.BOLD, 20, SwingConstants.CENTER, null, null, null, 0, 30, 882, 30, null));
		
		frame.getContentPane().add(ComponentBuilder.buildButton("EVENTOS", "Franklin Gothic Medium", Font.PLAIN, 13, 94, 82, 300, 100, null, null,
				() -> {
			new Eventos().toggleFrame();
			toggleFrame();
				}));
		
		frame.getContentPane().add(ComponentBuilder.buildButton("USUARIOS", "Franklin Gothic Medium", Font.PLAIN, 13, 488, 82, 300, 100, null, null, 
				() -> {
			new Usuarios().toggleFrame();
			toggleFrame();
				}));
		
		frame.getContentPane().add(ComponentBuilder.buildButton("RELATORIOS", "Franklin Gothic Medium", Font.PLAIN, 13, 94, 208, 300, 100, null, null, 
				() -> {
			new Relatorio().toggleFrame();
			toggleFrame();
				}));
		
		frame.getContentPane().add(ComponentBuilder.buildButton("ARTISTAS", "Franklin Gothic Medium", Font.PLAIN, 13, 488, 208, 300, 100, null, null, 
				() -> {
			new Artistas().toggleFrame();
			toggleFrame();
				}));
		
		frame.getContentPane().add(ComponentBuilder.buildButton("LOGS", "Franklin Gothic Medium", Font.PLAIN, 13, 94, 334, 300, 100, null, null, 
				() -> {
			new Logs().toggleFrame();
			toggleFrame();
				}));
		
		frame.getContentPane().add(ComponentBuilder.buildButton("LOCAL", "Franklin Gothic Medium", Font.PLAIN, 13, 488, 334, 300, 100, null, null, 
				() -> {
			new Local().toggleFrame();
			toggleFrame();
				}));
		
		frame.getContentPane().add(ComponentBuilder.buildButton("SAIR", "Franklin Gothic Medium", Font.PLAIN, 13, 288, 460, 300, 95, null, null, 
				() -> {
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
