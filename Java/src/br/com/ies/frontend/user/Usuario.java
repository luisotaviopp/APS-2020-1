package br.com.ies.frontend.user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

import br.com.ies.frontend.Index;
import br.com.ies.frontend.builder.ComponentBuilder;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPasswordField;

public class Usuario {

	private JFrame frame;
	private JTextField inputNome;
	private JTextField inputEmail;
	private JTextField inputUsuario;
	private JPasswordField inputSenhaAtual;
	private JPasswordField inputConfirmeSenha;
	private JPasswordField inputNovaSenha;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Usuario() {
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

		frame.getContentPane().add(ComponentBuilder.buildLabel("MEU PERFIL", "Franklin Gothic Medium", Font.BOLD, 20, SwingConstants.CENTER, null, null, null, 103, 20, 675, 30, null));
		
		// Input Nome
		frame.getContentPane().add(ComponentBuilder.buildTextField("Franklin Gothic Medium", Font.PLAIN, 13, 313, 114, 441, 30, 10));

		// Input Email
		frame.getContentPane().add(ComponentBuilder.buildTextField("Franklin Gothic Medium", Font.PLAIN, 13, 313, 157, 441, 30, 10));

		// Input Usuario
		frame.getContentPane().add(ComponentBuilder.buildTextField("Franklin Gothic Medium", Font.PLAIN, 13, 313, 200, 441, 30, 10));

		frame.getContentPane().add(ComponentBuilder.buildButton("VOLTAR", "Franklin Gothic Medium", Font.PLAIN, 13, 127,469, 300, 40, null, null,
				() -> {
					new Index().toggleFrame();
					toggleFrame();
				}));

		frame.getContentPane().add(ComponentBuilder.buildLabel("DADOS PESSOAIS", "Franklin Gothic Medium", Font.BOLD, 13, SwingConstants.LEFT, null, null, null, 127, 78, 250, 30, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("Nome", "Franklin Gothic Medium", Font.PLAIN, 13, null, null, null, null, 127, 121, 56, 16, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("Email", "Franklin Gothic Medium", Font.PLAIN, 13, null, null, null, null, 127, 164, 56, 16, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("Usuário", "Franklin Gothic Medium", Font.PLAIN, 13, null, null, null, null, 127, 207, 56, 16, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("REDEFINIR SENHA","Franklin Gothic Medium", Font.BOLD, 13, SwingConstants.LEFT, null, null, null, 127, 280, 250, 30, null));
		frame.getContentPane().add(ComponentBuilder.buildButton("ATUALIZAR","Franklin Gothic Medium", Font.PLAIN, 13, 454, 469, 300, 40, new Color(0, 250, 154), null,
				() -> {
					
				}));
		frame.getContentPane().add(ComponentBuilder.buildLabel("Senha atual", "Franklin Gothic Medium", Font.PLAIN, 13, null, null, null, null, 127, 409, 81, 16, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("Nova senha", "Franklin Gothic Medium", Font.PLAIN, 13, null, null, null, null,  127, 323, 73, 16, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("Confirme a nova senha","Franklin Gothic Medium", Font.PLAIN, 13, null, null, null, null, 127, 366, 145, 16, null));

		inputSenhaAtual = new JPasswordField();
		inputSenhaAtual.setBounds(313, 402, 441, 30);
		frame.getContentPane().add(inputSenhaAtual);

		inputConfirmeSenha = new JPasswordField();
		inputConfirmeSenha.setBounds(313, 359, 441, 30);
		frame.getContentPane().add(inputConfirmeSenha);

		inputNovaSenha = new JPasswordField();
		inputNovaSenha.setBounds(313, 316, 441, 30);
		frame.getContentPane().add(inputNovaSenha);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void toggleFrame() {
		frame.setVisible(!frame.isVisible());
	}
}