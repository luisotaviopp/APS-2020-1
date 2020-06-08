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
		
		frame.getContentPane().add(ComponentBuilder.buildLabel("ADIMINISTRA��O", "Franklin Gothic Medium", Font.BOLD, 20, SwingConstants.CENTER, null, null, null, 0, 30, 882, 30, null));
		
		frame.getContentPane().add(ComponentBuilder.buildButton("EVENTOS", "Franklin Gothic Medium", Font.PLAIN, 13, 94, 82, 300, 130, null, null,
				() -> {
			new Eventos().toggleFrame();
			toggleFrame();
				}));
		
		frame.getContentPane().add(ComponentBuilder.buildButton("USUARIOS", "Franklin Gothic Medium", Font.PLAIN, 13, 488, 82, 300, 130, null, null, 
				() -> {
			new Usuarios().toggleFrame();
			toggleFrame();
				}));
		
		frame.getContentPane().add(ComponentBuilder.buildButton("RELATORIOS", "Franklin Gothic Medium", Font.PLAIN, 13, 94, 238, 300, 130, null, null, 
				() -> {
			new RelatorioVendas().toggleFrame();
			toggleFrame();
				}));
		
		frame.getContentPane().add(ComponentBuilder.buildButton("ARTISTAS", "Franklin Gothic Medium", Font.PLAIN, 13, 488, 238, 300, 130, null, null, 
				() -> {
			new Artistas().toggleFrame();
			toggleFrame();
				}));
		
		frame.getContentPane().add(ComponentBuilder.buildButton("LOGS", "Franklin Gothic Medium", Font.PLAIN, 13, 94, 394, 300, 130, null, null, 
				() -> {
			new Logs().toggleFrame();
			toggleFrame();
				}));
		
		frame.getContentPane().add(ComponentBuilder.buildButton("SAIR", "Franklin Gothic Medium", Font.PLAIN, 13, 488, 394, 300, 130, null, null, 
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