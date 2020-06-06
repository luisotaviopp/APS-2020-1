package br.com.ies.frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class ComprarIngresso extends JFrame {

	private JPanel contentPane;
	private JTextField inputNumeroCartao;
	private JTextField inputCVV;
	private JTextField inputVencimento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComprarIngresso frame = new ComprarIngresso();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ComprarIngresso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblTitulo = new JLabel("T\u00CDTULO DO EVENTO");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 20));
		lblTitulo.setBounds(0, 20, 882, 30);
		
		JLabel lblArtista = new JLabel("ARTISTA");
		lblArtista.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblArtista.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtista.setBounds(74, 85, 734, 28);
		
		JLabel lblQuantosIngressos = new JLabel("Quantos ingressos voc\u00EA deseja comprar?");
		lblQuantosIngressos.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblQuantosIngressos.setBounds(74, 126, 734, 16);
		lblQuantosIngressos.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnMenos = new JButton("-");
		btnMenos.setBounds(344, 169, 56, 41);
		
		JLabel lblQtdIngressos = new JLabel("1");
		lblQtdIngressos.setBounds(412, 168, 56, 41);
		lblQtdIngressos.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 16));
		lblQtdIngressos.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnMais = new JButton("+");
		btnMais.setBounds(480, 168, 56, 41);
		
		JRadioButton radioCredito = new JRadioButton("Cr\u00E9dito");
		radioCredito.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		radioCredito.setBounds(70, 352, 69, 25);
		
		JRadioButton radioDebito = new JRadioButton("D\u00E9bito");
		radioDebito.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		radioDebito.setBounds(70, 382, 65, 25);
		
		JRadioButton radioDinheiro = new JRadioButton("Dinheiro");
		radioDinheiro.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		radioDinheiro.setBounds(70, 415, 75, 25);
		
		JLabel lblPagamento = new JLabel("Qual a forma de pagamento?");
		lblPagamento.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblPagamento.setBounds(70, 327, 167, 16);
		
		JLabel lblAviso = new JLabel("Caso a op\u00E7\u00E3o desejada seja dinheiro, por favor compare\u00E7a na bilheteria do local com 30 minutos de anteced\u00EAncia.");
		lblAviso.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblAviso.setHorizontalAlignment(SwingConstants.CENTER);
		lblAviso.setBounds(70, 266, 734, 41);
		contentPane.setLayout(null);
		contentPane.add(lblTitulo);
		contentPane.add(lblArtista);
		contentPane.add(lblQuantosIngressos);
		contentPane.add(btnMenos);
		contentPane.add(lblQtdIngressos);
		contentPane.add(btnMais);
		contentPane.add(radioCredito);
		contentPane.add(radioDebito);
		contentPane.add(radioDinheiro);
		contentPane.add(lblPagamento);
		contentPane.add(lblAviso);
		
		JLabel lblValor = new JLabel("R$100,00");
		lblValor.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 16));
		lblValor.setHorizontalAlignment(SwingConstants.CENTER);
		lblValor.setBounds(74, 223, 734, 41);
		contentPane.add(lblValor);
		
		inputNumeroCartao = new JTextField();
		inputNumeroCartao.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		inputNumeroCartao.setBounds(475, 345, 335, 32);
		contentPane.add(inputNumeroCartao);
		inputNumeroCartao.setColumns(10);
		
		inputCVV = new JTextField();
		inputCVV.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		inputCVV.setBounds(475, 408, 163, 32);
		contentPane.add(inputCVV);
		inputCVV.setColumns(10);
		
		inputVencimento = new JTextField();
		inputVencimento.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		inputVencimento.setColumns(10);
		inputVencimento.setBounds(647, 408, 163, 32);
		contentPane.add(inputVencimento);
		
		JLabel lblNumCartao = new JLabel("N\u00FAmero do cart\u00E3o");
		lblNumCartao.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblNumCartao.setBounds(475, 327, 331, 16);
		contentPane.add(lblNumCartao);
		
		JLabel lblCVV = new JLabel("CVV");
		lblCVV.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblCVV.setBounds(475, 391, 78, 16);
		contentPane.add(lblCVV);
		
		JLabel lblVencimento = new JLabel("Vencimento");
		lblVencimento.setBounds(647, 391, 78, 16);
		contentPane.add(lblVencimento);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnVoltar.setBounds(70, 470, 335, 40);
		contentPane.add(btnVoltar);
		
		JButton btnConfirmar = new JButton("CONFIRMAR PAGAMENTO");
		btnConfirmar.setBackground(new Color(0, 250, 154));
		btnConfirmar.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnConfirmar.setBounds(475, 470, 335, 40);
		contentPane.add(btnConfirmar);
		
		
	}
}
