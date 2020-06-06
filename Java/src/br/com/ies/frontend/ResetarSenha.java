package br.com.ies.frontend;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;

public class ResetarSenha {

	private JFrame frame;
	private JPasswordField inputSenha;
	private JPasswordField inputConfirmaSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResetarSenha window = new ResetarSenha();
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
	public ResetarSenha() {
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
		
		JLabel lblTitulo = new JLabel("RESETAR SENHA");
		lblTitulo.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 20, 882, 34);
		frame.getContentPane().add(lblTitulo);
		
		JLabel lblNovaSenha = new JLabel("NOVA SENHA");
		lblNovaSenha.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblNovaSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblNovaSenha.setBounds(107, 216, 260, 28);
		frame.getContentPane().add(lblNovaSenha);
		
		JLabel lblConfirmaSenha = new JLabel("CONFIRME A SENHA");
		lblConfirmaSenha.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblConfirmaSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmaSenha.setBounds(512, 216, 260, 28);
		frame.getContentPane().add(lblConfirmaSenha);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnVoltar.setBounds(70, 335, 335, 40);
		frame.getContentPane().add(btnVoltar);
		
		JButton btnResetaSenha = new JButton("RESETAR SENHA");
		btnResetaSenha.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnResetaSenha.setBounds(475, 335, 335, 40);
		btnResetaSenha.setBackground(new Color(0, 250, 154));
		frame.getContentPane().add(btnResetaSenha);
		
		inputSenha = new JPasswordField();
		inputSenha.setBounds(70, 250, 335, 40);
		frame.getContentPane().add(inputSenha);
		
		inputConfirmaSenha = new JPasswordField();
		inputConfirmaSenha.setBounds(475, 250, 335, 40);
		frame.getContentPane().add(inputConfirmaSenha);
		
		
	}

}
