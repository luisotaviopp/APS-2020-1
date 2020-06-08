package br.com.ies.frontend.administration;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import br.com.ies.frontend.builder.ComponentBuilder;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Component;

public class Logs {

	private JFrame frame;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Logs() {
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

		JList listaLogs = new JList();
		listaLogs.setBackground(Color.LIGHT_GRAY);
		listaLogs.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 16));
		listaLogs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaLogs.setModel(new AbstractListModel() {
			String[] values = new String[] { "Usu\u00E1rio 1 - Logou", "Usu\u00E1rio 2 - Saiu",
					"Usu\u00E1rio 5 - Comprou ingresso do evento 1", "Usu\u00E1rio 6 - Cancelou compra do ingresso " };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listaLogs.setBounds(60, 63, 350, 396);
		frame.getContentPane().add(listaLogs);
		
		frame.getContentPane().add(ComponentBuilder.buildLabel("LOGS", "Franklin Gothic Medium", Font.BOLD, 20, SwingConstants.CENTER, null, null, null, 341, 20, 200, 30, null));
		frame.getContentPane().add(ComponentBuilder.buildButton("VOLTAR", "Franklin Gothic Medium", Font.PLAIN, 13, 60, 482, 350, 40, null, null,
				 () -> {
						
					}));
		frame.getContentPane().add(ComponentBuilder.buildLabel("Usuário 5", "Franklin Gothic Medium", Font.BOLD, 16, SwingConstants.LEFT, null, null, null, 470, 59, 350, 30, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("20/05/2020 - 21:05:33","Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, null, null, null, 470, 102, 350, 30, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("Comprou ingresso para o evento XYZ .","Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, SwingConstants.LEFT, SwingConstants.TOP, null, 470, 145, 350, 314, null));
		frame.getContentPane().add(ComponentBuilder.buildButton("VER USUÁRIO", "Franklin Gothic Medium", Font.PLAIN, 13, 470, 482, 350, 40, new Color(0, 250, 154), null,
				 () -> {
						
					}));
	}

	public JFrame getFrame() {
		return frame;
	}

	public void toggleFrame() {
		frame.setVisible(!frame.isVisible());
	}
}
