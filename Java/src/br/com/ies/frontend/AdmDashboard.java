package br.com.ies.frontend;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.SwingConstants;

import br.com.ies.frontend.builder.ComponentBuilder;

public class AdmDashboard {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public AdmDashboard() {
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
		
		frame.getContentPane().add(ComponentBuilder.buildLabel("ADIMINISTRAÇÃO", "Franklin Gothic Medium", Font.BOLD, 20, SwingConstants.CENTER, 0, 30, 882, 30));
		
		frame.getContentPane().add(ComponentBuilder.buildButton("EVENTOS", "Franklin Gothic Medium", Font.PLAIN, 13, 94, 82, 300, 130, null, null, () -> {
			new AdmEventos().toggleFrame();
			toggleFrame();
		}));
		
		frame.getContentPane().add(ComponentBuilder.buildButton("USUARIOS", "Franklin Gothic Medium", Font.PLAIN, 13, 488, 82, 300, 130, null, null, () -> {
			new AdmUsuarios().toggleFrame();
			toggleFrame();
		}));
		
		frame.getContentPane().add(ComponentBuilder.buildButton("RELATORIOS", "Franklin Gothic Medium", Font.PLAIN, 13, 94, 238, 300, 130, null, null, () -> {
			new RelatorioVendas().toggleFrame();
			toggleFrame();
		}));
		
		frame.getContentPane().add(ComponentBuilder.buildButton("ARTISTAS", "Franklin Gothic Medium", Font.PLAIN, 13, 488, 238, 300, 130, null, null, () -> {
			new AdmArtistas().toggleFrame();
			toggleFrame();
		}));
		
		frame.getContentPane().add(ComponentBuilder.buildButton("LOGS", "Franklin Gothic Medium", Font.PLAIN, 13, 94, 394, 300, 130, null, null, () -> {
			new Logs().toggleFrame();
			toggleFrame();
		}));
		
		frame.getContentPane().add(ComponentBuilder.buildButton("SAIR", "Franklin Gothic Medium", Font.PLAIN, 13, 488, 394, 300, 130,null,null, () -> {
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
