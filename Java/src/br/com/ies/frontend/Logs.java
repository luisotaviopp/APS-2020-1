package br.com.ies.frontend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
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

		JLabel lblTitulo = new JLabel("LOGS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 20));
		lblTitulo.setBounds(341, 20, 200, 30);
		frame.getContentPane().add(lblTitulo);

		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnVoltar.setBounds(60, 482, 350, 40);
		frame.getContentPane().add(btnVoltar);

		JLabel lblNomeUsuario = new JLabel("USU\u00C1RIO 5");
		lblNomeUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeUsuario.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 16));
		lblNomeUsuario.setBounds(470, 59, 350, 30);
		frame.getContentPane().add(lblNomeUsuario);

		JLabel lblDataLog = new JLabel("20/05/2020 - 21:05:33");
		lblDataLog.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblDataLog.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataLog.setBounds(470, 102, 350, 30);
		frame.getContentPane().add(lblDataLog);

		JLabel lblDescricao = new JLabel("Comprou ingresso para o evento XYZ .");
		lblDescricao.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblDescricao.setVerticalAlignment(SwingConstants.TOP);
		lblDescricao.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescricao.setHorizontalTextPosition(SwingConstants.LEFT);
		lblDescricao.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblDescricao.setBounds(470, 145, 350, 314);
		frame.getContentPane().add(lblDescricao);

		JButton btnVerUsurio = new JButton("VER USU\u00C1RIO");
		btnVerUsurio.setBackground(new Color(0, 250, 154));
		btnVerUsurio.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnVerUsurio.setBounds(470, 482, 350, 40);
		frame.getContentPane().add(btnVerUsurio);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void toggleFrame() {
		frame.setVisible(!frame.isVisible());
	}
}
