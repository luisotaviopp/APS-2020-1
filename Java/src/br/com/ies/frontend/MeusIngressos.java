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

public class MeusIngressos {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MeusIngressos window = new MeusIngressos();
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
	public MeusIngressos() {
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
			String[] values = new String[] {"SHOW DO PATATI PATATA", "Turma da M\u00F4nica tour"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listaEventos.setBounds(60, 63, 350, 396);
		frame.getContentPane().add(listaEventos);
		
		JLabel lblTitulo = new JLabel("MEUS INGRESSOS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 20));
		lblTitulo.setBounds(341, 20, 200, 30);
		frame.getContentPane().add(lblTitulo);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnVoltar.setBounds(60, 482, 350, 40);
		frame.getContentPane().add(btnVoltar);
		
		JLabel lblNomeEvento = new JLabel("SHOW DO PATATI PATATA");
		lblNomeEvento.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeEvento.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 16));
		lblNomeEvento.setBounds(470, 59, 350, 30);
		frame.getContentPane().add(lblNomeEvento);
		
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
		
		JButton btnCancelarCompra = new JButton("CANCELAR COMPRA");
		btnCancelarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelarCompra.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnCancelarCompra.setBackground(new Color(204, 51, 51));
		btnCancelarCompra.setBounds(470, 482, 350, 40);
		frame.getContentPane().add(btnCancelarCompra);
		
		JLabel lblData = new JLabel("20/05/2020 - 21h");
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
}
