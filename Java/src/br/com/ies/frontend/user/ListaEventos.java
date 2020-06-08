package br.com.ies.frontend.user;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import br.com.ies.frontend.builder.ComponentBuilder;

public class ListaEventos {

	private JFrame frame;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public ListaEventos() {
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

		JList listaEventos = new JList();
		listaEventos.setBackground(Color.LIGHT_GRAY);
		listaEventos.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 16));
		listaEventos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaEventos.setModel(new AbstractListModel() {
			String[] values = new String[] { "20/05/2020 - 21h - R$250,00 - Evento 02",
					"20/05/2020 - 22h - R$250,00 - Evento 01" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listaEventos.setBounds(60, 63, 350, 396);
		frame.getContentPane().add(listaEventos);
		
		frame.getContentPane().add(ComponentBuilder.buildLabel("VENDAS", "Franklin Gothic Medium", Font.BOLD, 20, SwingConstants.CENTER, null, null, null, 341, 20, 200, 30, null));
		frame.getContentPane().add(ComponentBuilder.buildButton("VOLTAR", "Franklin Gothic Medium", Font.PLAIN, 13, 60, 482, 350, 40, null, null,
				 () -> {
						
					}));
		frame.getContentPane().add(ComponentBuilder.buildLabel("EVENTO 01", "Tahoma", Font.BOLD, 16, SwingConstants.LEFT, null, null, null, 470, 59, 350, 30, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("Descrição de evento", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, null, SwingConstants.TOP, null, 470, 145, 350, 131, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("R$200,00", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, SwingConstants.LEFT, SwingConstants.TOP, null, 470, 429, 350, 30, null));
		frame.getContentPane().add(ComponentBuilder.buildButton("COMPRAR", "Franklin Gothic Medium", Font.PLAIN, 13, 470, 482, 350, 40, new Color(0, 250, 154), null,
				 () -> {
						
					}));
		frame.getContentPane().add(ComponentBuilder.buildLabel("20/05/2020 - 21:05:33", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, null, null, null, 470, 102, 350, 30, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("Rua xxx, 666, centro, lalala", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, SwingConstants.LEFT, SwingConstants.TOP, null, 470, 386, 350, 30, null));
		// colocar na rua xxx 666  -- lblEnderecoEvento.setAlignmentX(0.5f);

	}

	public JFrame getFrame() {
		return frame;
	}
	public void toggleFrame() {
		frame.setVisible(!frame.isVisible());
	}
}
