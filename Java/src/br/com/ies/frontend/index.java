package br.com.ies.frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import br.com.ies.frontend.builder.ComponentBuilder;

public class index {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					index window = new index();
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
	public index() {
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
		JLabel lblTitulo = new JLabel("BILHETERIA");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.DARK_GRAY);
		lblTitulo.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 30));
		lblTitulo.setBounds(266, 53, 350, 58);
		frame.getContentPane().add(lblTitulo);

		// Botão Entrar
		frame.getContentPane().add(ComponentBuilder.buildButton("ENTRAR", "Franklin Gothic Medium", Font.PLAIN, 13, 266,
				440, 350, 58, new Color(0, 250, 154), () -> {
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
