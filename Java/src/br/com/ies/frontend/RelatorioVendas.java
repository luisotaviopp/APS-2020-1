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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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

		JLabel lblTitulo = new JLabel("VENDAS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 20));
		lblTitulo.setBounds(341, 20, 200, 30);
		frame.getContentPane().add(lblTitulo);

		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnVoltar.setBounds(60, 482, 350, 40);
		frame.getContentPane().add(btnVoltar);

		JLabel lvlNomeEvento = new JLabel("EVENTO 01");
		lvlNomeEvento.setHorizontalAlignment(SwingConstants.LEFT);
		lvlNomeEvento.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 16));
		lvlNomeEvento.setBounds(470, 59, 350, 30);
		frame.getContentPane().add(lvlNomeEvento);

		JLabel lblFormaPagamento = new JLabel("Cart\u00E3o de cr\u00E9dito");
		lblFormaPagamento.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblFormaPagamento.setHorizontalAlignment(SwingConstants.LEFT);
		lblFormaPagamento.setBounds(470, 145, 350, 30);
		frame.getContentPane().add(lblFormaPagamento);

		JLabel lblQtdIngressos = new JLabel("4 ingressos");
		lblQtdIngressos.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblQtdIngressos.setVerticalAlignment(SwingConstants.TOP);
		lblQtdIngressos.setHorizontalAlignment(SwingConstants.LEFT);
		lblQtdIngressos.setHorizontalTextPosition(SwingConstants.LEFT);
		lblQtdIngressos.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblQtdIngressos.setBounds(470, 191, 350, 30);
		frame.getContentPane().add(lblQtdIngressos);

		JButton btnCancelar = new JButton("CANCELAR COMPRA");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnCancelar.setBackground(new Color(204, 51, 51));
		btnCancelar.setBounds(470, 482, 350, 40);
		frame.getContentPane().add(btnCancelar);

		JLabel lblData = new JLabel("20/05/2020 - 21:05:33");
		lblData.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblData.setHorizontalAlignment(SwingConstants.LEFT);
		lblData.setBounds(470, 102, 350, 30);
		frame.getContentPane().add(lblData);

		JLabel lblValor = new JLabel("R$250,00");
		lblValor.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblValor.setVerticalAlignment(SwingConstants.TOP);
		lblValor.setHorizontalTextPosition(SwingConstants.LEFT);
		lblValor.setHorizontalAlignment(SwingConstants.LEFT);
		lblValor.setAlignmentX(0.5f);
		lblValor.setBounds(470, 234, 350, 30);
		frame.getContentPane().add(lblValor);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void toggleFrame() {
		frame.setVisible(!frame.isVisible());
	}
}
