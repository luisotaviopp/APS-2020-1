package br.com.ies.frontend.administration;

import java.awt.Color;
import java.awt.Font;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import br.com.ies.frontend.builder.ComponentBuilder;

public class RelatorioVendas {

	private JFrame frame;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public RelatorioVendas() {
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

		JList listaVendas = new JList();
		listaVendas.setBackground(Color.LIGHT_GRAY);
		listaVendas.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 16));
		listaVendas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaVendas.setModel(new AbstractListModel() {
			String[] values = new String[] { "20/05/2020 - 12:45 - R$250,00 - Evento 02",
					"20/05/2020 - 12:46 - R$250,00 - Evento 01", "20/05/2020 - 12:47 - R$250,00 - Evento 02",
					"20/05/2020 - 12:48 - R$250,00 - Evento 05", "20/05/2020 - 12:49 - R$250,00 - Evento 01",
					"20/05/2020 - 12:49 - R$250,00 - Evento 01", "20/05/2020 - 12:55 - R$100,00 - Evento 04",
					"20/05/2020 - 12:56 - R$120,00 - Evento 01", "20/05/2020 - 12:58 - R$210,00 - Evento 01",
					"20/05/2020 - 13:11 - R$650,00 - Evento 03" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listaVendas.setBounds(60, 63, 350, 396);
		frame.getContentPane().add(listaVendas);
		
		frame.getContentPane().add(ComponentBuilder.buildLabel("VENDAS","Franklin Gothic Medium", Font.BOLD, 20, SwingConstants.CENTER, null, null, null, 341, 20, 200, 30, null));
		frame.getContentPane().add(ComponentBuilder.buildButton("VOLTAR", "Franklin Gothic Medium", Font.PLAIN, 13, 60, 482, 350, 40, null, null,
				 () -> {
					
					}));
		frame.getContentPane().add(ComponentBuilder.buildLabel("EVENTO 01", "Franklin Gothic Medium", Font.BOLD, 16, SwingConstants.LEFT, null, null, null,470, 59, 350, 30,null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("Cartão de crédito", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, null, null, null, 470, 145, 350, 30,null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("4 ingressos","Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, SwingConstants.LEFT, SwingConstants.TOP, null, 470, 191, 350, 30,null));
		frame.getContentPane().add(ComponentBuilder.buildButton("CANCELAR COMPRA", "Franklin Gothic Medium", Font.PLAIN, 13, 470, 482, 350, 40, new Color(204, 51, 51), null,
				 () -> {
					
					}));
		frame.getContentPane().add(ComponentBuilder.buildLabel("20/05/2020 - 21:05:33", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, null, null, null, 470, 102, 350, 30, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("R$250,00","Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, SwingConstants.LEFT, SwingConstants.TOP, null, 470, 234, 350, 30,null));
	}
	public JFrame getFrame() {
		return frame;
	}

	public void toggleFrame() {
		frame.setVisible(!frame.isVisible());
	}
}
