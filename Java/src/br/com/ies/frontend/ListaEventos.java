package br.com.ies.frontend;

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

		JLabel lblTitulo = new JLabel("VENDAS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 20));
		lblTitulo.setBounds(341, 20, 200, 30);
		frame.getContentPane().add(lblTitulo);

		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnVoltar.setBounds(60, 482, 350, 40);
		frame.getContentPane().add(btnVoltar);

		JLabel lblNomeEvento = new JLabel("EVENTO 01");
		lblNomeEvento.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeEvento.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNomeEvento.setBounds(470, 59, 350, 30);
		frame.getContentPane().add(lblNomeEvento);

		JLabel lblDescriçãoEvento = new JLabel("Descri\u00E7\u00E3o");
		lblDescriçãoEvento.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblDescriçãoEvento.setVerticalAlignment(SwingConstants.TOP);
		lblDescriçãoEvento.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescriçãoEvento.setBounds(470, 145, 350, 131);
		frame.getContentPane().add(lblDescriçãoEvento);

		JLabel lblValorEvento = new JLabel("R$200,00");
		lblValorEvento.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblValorEvento.setVerticalAlignment(SwingConstants.TOP);
		lblValorEvento.setHorizontalAlignment(SwingConstants.LEFT);
		lblValorEvento.setHorizontalTextPosition(SwingConstants.LEFT);
		lblValorEvento.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblValorEvento.setBounds(470, 429, 350, 30);
		frame.getContentPane().add(lblValorEvento);

		JButton btnComprar = new JButton("COMPRAR");
		btnComprar.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnComprar.setBackground(new Color(0, 250, 154));
		btnComprar.setBounds(470, 482, 350, 40);
		frame.getContentPane().add(btnComprar);

		JLabel lblDataEvento = new JLabel("20/05/2020 - 21:05:33");
		lblDataEvento.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblDataEvento.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataEvento.setBounds(470, 102, 350, 30);
		frame.getContentPane().add(lblDataEvento);

		JLabel lblEnderecoEvento = new JLabel("Rua xxx, 666, centro, lalala");
		lblEnderecoEvento.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblEnderecoEvento.setVerticalAlignment(SwingConstants.TOP);
		lblEnderecoEvento.setHorizontalTextPosition(SwingConstants.LEFT);
		lblEnderecoEvento.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnderecoEvento.setAlignmentX(0.5f);
		lblEnderecoEvento.setBounds(470, 386, 350, 30);
		frame.getContentPane().add(lblEnderecoEvento);
	}

	public JFrame getFrame() {
		return frame;
	}
	public void toggleFrame() {
		frame.setVisible(!frame.isVisible());
	}
}
