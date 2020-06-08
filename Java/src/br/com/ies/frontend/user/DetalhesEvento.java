package br.com.ies.frontend.user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import br.com.ies.frontend.builder.ComponentBuilder;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DetalhesEvento {

	private JFrame frame;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public DetalhesEvento() {
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

		frame.getContentPane().add(ComponentBuilder.buildLabel("NOME DO EVENTO", "Franklin Gothic Medium", Font.BOLD, 20, SwingConstants.CENTER, null, null, null, 0, 20, 882, 20, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("ARTISTA","Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.CENTER, null, null, null, 0, 65, 882, 16, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("Rua Lorem Ipsum, 6669 - Centro - Florianópolis", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.CENTER, null, null, null, 0, 121, 882, 35, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("Ingressos dispon\u00EDveis: 250", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.CENTER, null, null, null, 0, 307, 882, 16, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("R$100,00", "Franklin Gothic Medium", Font.BOLD, 16, SwingConstants.CENTER, null, null, null, 0, 336, 882, 16, null));
		frame.getContentPane().add(ComponentBuilder.buildButton("VOLTAR","Franklin Gothic Medium", Font.PLAIN, 13, 94, 455, 300, 40, null, null, 
				 () -> {
						
					}));
		frame.getContentPane().add(ComponentBuilder.buildButton("COMPRAR INGRESSOS", "Franklin Gothic Medium", Font.PLAIN, 13, 488, 455, 300, 40, new Color(0, 250, 154), null,
				 () -> {
						
					}));
		frame.getContentPane().add(ComponentBuilder.buildLabel("25/05/2020", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.CENTER, null, null, null, 0, 228, 882, 35, null));
	}

	public JFrame getFrame() {
		return frame;
	}

	public void toggleFrame() {
		frame.setVisible(!frame.isVisible());
	}

}
