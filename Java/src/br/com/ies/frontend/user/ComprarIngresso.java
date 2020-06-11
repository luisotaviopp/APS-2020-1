package br.com.ies.frontend.user;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.ies.backend.Main;
import br.com.ies.backend.entity.FormaPagamentoEntity;
import br.com.ies.backend.entity.SituacaoVendaEntity;
import br.com.ies.backend.entity.VendaEntity;
import br.com.ies.backend.entity.VendaPagamentoEntity;
import br.com.ies.backend.util.PersistenceUtil;
import br.com.ies.backend.util.Util;
import br.com.ies.frontend.builder.ComponentBuilder;
import br.com.ies.frontend.util.Constants;

public class ComprarIngresso {

	private JFrame frame;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ComprarIngresso() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		frame.setContentPane(contentPane);
		
		frame.getContentPane().add(ComponentBuilder.buildLabel(Main.getUserManager().getEvento().getEveTitulo().trim(), "Franklin Gothic Medium", Font.BOLD, 20, SwingConstants.CENTER, null, null, null, 0, 20, 882, 30, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel(Main.getUserManager().getEvento().getArtistaEntity().getArtNome().trim(), "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.CENTER, null, null, null, 74, 85, 734, 28, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("Quantos ingressos voce deseja comprar?", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.CENTER, null, null, null, 74, 126, 734, 16, null));
		
		
		JRadioButton radioCredito = new JRadioButton("Credito");
		radioCredito.setSelected(true);
		radioCredito.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		radioCredito.setBounds(70, 352, 69, 25);
		
		JRadioButton radioDebito = new JRadioButton("Debito");
		radioDebito.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		radioDebito.setBounds(70, 382, 65, 25);
		
		JRadioButton radioDinheiro = new JRadioButton("Dinheiro");
		radioDinheiro.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		radioDinheiro.setBounds(70, 415, 75, 25);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(radioCredito);
		buttonGroup.add(radioDebito);
		buttonGroup.add(radioDinheiro);
		
		frame.getContentPane().add(radioCredito);
		frame.getContentPane().add(radioDebito);
		frame.getContentPane().add(radioDinheiro);
		
		
		JLabel lblValorIngressos = ComponentBuilder.buildLabel(Main.getUserManager().getEvento().getEveValorIngresso().toString(), "Franklin Gothic Medium", Font.BOLD, 16, SwingConstants.CENTER, null, null, null, 74, 223, 734, 41, null);
		frame.getContentPane().add(lblValorIngressos);
		
		JLabel lblQtdIngressos = ComponentBuilder.buildLabel("1", "Franklin Gothic Medium", Font.PLAIN, 16, SwingConstants.CENTER, null, null, null, 412, 168, 56, 41, null);
		frame.getContentPane().add(lblQtdIngressos);
		
		contentPane.add(ComponentBuilder.buildButton("+", "Franklin Gothic Medium", Font.PLAIN, 16, 480, 168, 56, 41, null, null,
				() -> {
					Integer value = Integer.valueOf(lblQtdIngressos.getText());
					lblQtdIngressos.setText(Integer.toString(value + 1));
					lblValorIngressos.setText(Double.toString(Integer.valueOf(lblQtdIngressos.getText()) * Main.getUserManager().getEvento().getEveValorIngresso()));
				}));
		
		contentPane.add( ComponentBuilder.buildButton("-", "Franklin Gothic Medium", Font.PLAIN, 16,344, 169, 56, 41, null, null,
				() ->{
					Integer value = Integer.valueOf(lblQtdIngressos.getText());
					
					if(value > 1) 
						lblQtdIngressos.setText(Integer.toString(value - 1));
					
					lblValorIngressos.setText(Double.toString(Integer.valueOf(lblQtdIngressos.getText()) * Main.getUserManager().getEvento().getEveValorIngresso()));
				}));
		
		frame.getContentPane().add(ComponentBuilder.buildLabel("Qual a forma de pagamento?", "Franklin Gothic Medium", Font.PLAIN, 13, null, null, null, null, 70, 327, 167, 16, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("Caso a opcao desejada seja dinheiro, por favor compareca na bilheteria do local com 30 minutos de antecedencia", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.CENTER, null, null, null, 70, 266, 734, 41, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("Numero do cartao", "Franklin Gothic Medium", Font.PLAIN, 13, null, null, null, null, 475, 327, 331, 16, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("CVV", "Franklin Gothic Medium", Font.PLAIN, 13, null, null, null, null, 475, 391, 78, 16, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("Vencimento", "Franklin Gothic Medium", Font.PLAIN, 13, null, null, null, null, 647, 391, 78, 16, null));
		
		JTextField inputNumeroCartao = ComponentBuilder.buildTextField("Franklin Gothic Medium", Font.PLAIN, 13, 475, 345, 335, 32, 10);
		JTextField inputCVV = ComponentBuilder.buildTextField("Franklin Gothic Medium", Font.PLAIN, 13, 475, 408, 163, 32, 10);
		JTextField inputVencimento = ComponentBuilder.buildTextField("Franklin Gothic Medium", Font.PLAIN, 13, 647, 408, 163, 32, 10);
		
		contentPane.add(inputVencimento);
		contentPane.add(inputCVV);
		contentPane.add(inputNumeroCartao);
		
		frame.getContentPane().add(ComponentBuilder.buildButton("VOLTAR", "Franklin Gothic Medium", Font.PLAIN, 13, 60, 470, 350, 40, null, null,
				 () -> {
						new UserDashboard().toggleFrame();
						toggleFrame();
					}));
		
		frame.getContentPane().add(ComponentBuilder.buildButton("CONFIRMAR PAGAMENTO", "Franklin Gothic Medium", Font.PLAIN, 13, 475, 470, 335, 40, new Color(0, 250, 154), null,
				 () -> {
					 Integer formaPagamentoValue = -1;
					 
					 if(radioCredito.isSelected()) { 
						 if(inputNumeroCartao.getText().isEmpty() || inputCVV.getText().isEmpty() || inputVencimento.getText().isEmpty()) {
							 Util.showMessage(Constants.NEED_TO_FILL_ALL_FIELDS);
							 return;
						 }
						 formaPagamentoValue = 1;
					 }
					 else if(radioDebito.isSelected()) {
						 if(inputNumeroCartao.getText().isEmpty() || inputCVV.getText().isEmpty() || inputVencimento.getText().isEmpty()) {
							 Util.showMessage(Constants.NEED_TO_FILL_ALL_FIELDS);
							 return;
						 }
						 formaPagamentoValue = 2;
					 }
					 else if(radioDinheiro.isSelected()) 
						 formaPagamentoValue = 3;
					 
					 FormaPagamentoEntity formaPagamento = new FormaPagamentoEntity();
					 formaPagamento.setFopCodigo(formaPagamentoValue);
					 
					 VendaEntity venda = new VendaEntity();
					 venda.setEventoEntity(Main.getUserManager().getEvento());
					 venda.setUsuarioEntity(Main.getUserManager().getUsuario());
					 
					 SituacaoVendaEntity situacaoVenda = new SituacaoVendaEntity();
					 situacaoVenda.setSivCodigo(3);
					 venda.setSituacaoVendaEntity(situacaoVenda);
					 
					 venda.setVenData(new Date());
					 venda.setVenQtd(Integer.valueOf(lblQtdIngressos.getText()));
					 PersistenceUtil.persist(venda);
					 
					 VendaPagamentoEntity vendaPagamento = new VendaPagamentoEntity();
					 vendaPagamento.setFormaPagamentoEntity(formaPagamento);
					 vendaPagamento.setVepValor(Double.valueOf(lblValorIngressos.getText()));
					 vendaPagamento.setVendaEntity(venda);
					 vendaPagamento.setVepQtdParcelas(1);
					 
					 PersistenceUtil.persist(vendaPagamento);
					 Util.showMessage(Constants.SUCCESSFUL_BUY);
					 
					 new UserDashboard().toggleFrame();
					 toggleFrame();
					}));
		
	}
	public JFrame getFrame() {
		return frame;
	}
	public void toggleFrame() {
		frame.setVisible(!frame.isVisible());
	}

	
}
