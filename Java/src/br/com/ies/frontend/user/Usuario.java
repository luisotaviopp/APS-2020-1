package br.com.ies.frontend.user;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.ies.backend.Main;
import br.com.ies.backend.util.PersistenceUtil;
import br.com.ies.backend.util.Util;
import br.com.ies.frontend.builder.ComponentBuilder;
import br.com.ies.frontend.util.Constants;

public class Usuario {

	private JFrame frame;

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
	@SuppressWarnings("deprecation")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		frame.getContentPane().add(ComponentBuilder.buildLabel("MEU PERFIL", "Franklin Gothic Medium", Font.BOLD, 20, SwingConstants.CENTER, null, null, null, 103, 20, 675, 30, null));
		frame.getContentPane().add(ComponentBuilder.buildButton("VOLTAR", "Franklin Gothic Medium", Font.PLAIN, 13, 127,469, 300, 40, null, null,
				() -> {
					new UserDashboard().toggleFrame();
					toggleFrame();
				}));
		frame.getContentPane().add(ComponentBuilder.buildLabel("DADOS PESSOAIS", "Franklin Gothic Medium", Font.BOLD, 13, SwingConstants.LEFT, null, null, null, 127, 78, 250, 30, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("Nome", "Franklin Gothic Medium", Font.PLAIN, 13, null, null, null, null, 127, 121, 56, 16, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("Email", "Franklin Gothic Medium", Font.PLAIN, 13, null, null, null, null, 127, 164, 56, 16, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("Usuário", "Franklin Gothic Medium", Font.PLAIN, 13, null, null, null, null, 127, 207, 56, 16, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("REDEFINIR SENHA","Franklin Gothic Medium", Font.BOLD, 13, SwingConstants.LEFT, null, null, null, 127, 280, 250, 30, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("Senha atual", "Franklin Gothic Medium", Font.PLAIN, 13, null, null, null, null, 127, 409, 81, 16, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("Nova senha", "Franklin Gothic Medium", Font.PLAIN, 13, null, null, null, null,  127, 323, 73, 16, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("Confirme a nova senha","Franklin Gothic Medium", Font.PLAIN, 13, null, null, null, null, 127, 366, 145, 16, null));
		
		JTextField inputNome  = ComponentBuilder.buildTextField("Franklin Gothic Medium", Font.PLAIN, 13, 313, 114, 441, 30, 10);
		JTextField inputEmail =  ComponentBuilder.buildTextField("Franklin Gothic Medium", Font.PLAIN, 13, 313, 157, 441, 30, 10);
		JTextField inputUsuario = ComponentBuilder.buildTextField("Franklin Gothic Medium", Font.PLAIN, 13, 313, 200, 441, 30, 10);
		JPasswordField inputSenhaAtual = ComponentBuilder.buildPasswordField("Franklin Gothic Medium", Font.PLAIN, 13, 313, 402, 441, 30);
		JPasswordField inputNovaSenha = ComponentBuilder.buildPasswordField("Franklin Gothic Medium", Font.PLAIN, 13, 313, 316, 441, 30);
		JPasswordField inputConfirmeSenha = ComponentBuilder.buildPasswordField("Franklin Gothic Medium", Font.PLAIN, 13, 313, 359, 441, 30);
		
		
		frame.getContentPane().add(inputNome);
		frame.getContentPane().add(inputEmail);
		frame.getContentPane().add(inputUsuario);
		frame.getContentPane().add(inputSenhaAtual);
		frame.getContentPane().add(inputNovaSenha);
		frame.getContentPane().add(inputConfirmeSenha);
		
		
		frame.getContentPane().add(ComponentBuilder.buildButton("ATUALIZAR","Franklin Gothic Medium", Font.PLAIN, 13, 454, 469, 300, 40, new Color(0, 250, 154), null,
				() -> {
					if(!(inputNovaSenha.getText().equals(inputConfirmeSenha.getText())) || inputNovaSenha.getText().isEmpty()) {
						Util.showMessage(Constants.PASSWORDS_DONT_MATCH);
						return;
					}
					Main.getUserManager().getUsuario().setUsrSenha(inputNovaSenha.getText());
					PersistenceUtil.persist(Main.getUserManager().getUsuario());
					Util.showMessage(Constants.PERSONAL_INFO_CHANGED);
					
					new UserDashboard().toggleFrame();
					toggleFrame();
				}));
		

		inputNome.setText(Main.getUserManager().getUsuario().getUsrNome());
		inputEmail.setText(Main.getUserManager().getUsuario().getUsrEmail());
		inputUsuario.setText(Main.getUserManager().getUsuario().getUsrLogin());
		inputSenhaAtual.setText(Main.getUserManager().getUsuario().getUsrSenha());
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void toggleFrame() {
		frame.setVisible(!frame.isVisible());
	}
}
