package br.com.ies.frontend.user;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.ies.frontend.builder.ComponentBuilder;

public class ComprarIngresso {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField inputNumeroCartao;
	private JTextField inputCVV;
	private JTextField inputVencimento;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public ComprarIngresso() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		
		frame.getContentPane().add(ComponentBuilder.buildLabel("TÍTULO DO EVENTO", "Franklin Gothic Medium", Font.BOLD, 20, SwingConstants.CENTER, null, null, null, 0, 20, 882, 30, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("ARTISTA", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.CENTER, null, null, null, 74, 85, 734, 28, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("Quantos ingressos você deseja comprar?", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.CENTER, null, null, null, 74, 126, 734, 16, null));
		
		
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
		
		frame.getContentPane().add(ComponentBuilder.buildLabel("Qual a forma de pagamento?", "Franklin Gothic Medium", Font.PLAIN, 13, null, null, null, null, 70, 327, 167, 16, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("Caso a opção desejada seja dinheiro, por favor compareça na bilheteria do local com 30 minutos de antecedência", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.CENTER, null, null, null, 70, 266, 734, 41, null));
		
		contentPane.setLayout(null);
		contentPane.add(btnMenos);
		contentPane.add(lblQtdIngressos);
		contentPane.add(btnMais);
		contentPane.add(radioCredito);
		contentPane.add(radioDebito);
		contentPane.add(radioDinheiro);

		
		frame.getContentPane().add(ComponentBuilder.buildLabel("R$100,00", "Franklin Gothic Medium", Font.BOLD, 16, SwingConstants.CENTER, null, null, null, 74, 223, 734, 41, null));
		
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
		
		frame.getContentPane().add(ComponentBuilder.buildLabel("Número do cartão", "Franklin Gothic Medium", Font.PLAIN, 13, null, null, null, null, 475, 327, 331, 16, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("CVV", "Franklin Gothic Medium", Font.PLAIN, 13, null, null, null, null, 475, 391, 78, 16, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("Vencimento", "Franklin Gothic Medium", Font.PLAIN, 13, null, null, null, null, 647, 391, 78, 16, null));
		frame.getContentPane().add(ComponentBuilder.buildButton("VOLTAR", "Franklin Gothic Medium", Font.PLAIN, 13, 70, 470, 335, 40, null, null,
				 () -> {
						
					}));
		frame.getContentPane().add(ComponentBuilder.buildButton("CONFIRMAR PAGAMENTO", "Franklin Gothic Medium", Font.PLAIN, 13, 475, 470, 335, 40, new Color(0, 250, 154), null,
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
