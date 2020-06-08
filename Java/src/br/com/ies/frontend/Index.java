package br.com.ies.frontend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.SwingConstants;

import br.com.ies.frontend.builder.ComponentBuilder;

public class Index {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index window = new Index();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Index() {
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

		// Título
		frame.getContentPane().add(ComponentBuilder.buildLabel("BILHETERIA", "Franklin Gothic Medium", Font.BOLD, 30, SwingConstants.CENTER, null, null, null, 266, 53, 350, 58,Color.DARK_GRAY));

		// Botão Entrar
		frame.getContentPane().add(ComponentBuilder.buildButton("ENTRAR", "Franklin Gothic Medium", Font.PLAIN, 13, 266,440, 350, 58, new Color(0, 250, 154),null, 
				() -> {
					new Login().toggleFrame();
					toggleFrame();
				}));
	}

	public JFrame getFrame() {
		return frame;
	}

	public void toggleFrame() {
		frame.setVisible(!frame.isVisible());
	}
}
