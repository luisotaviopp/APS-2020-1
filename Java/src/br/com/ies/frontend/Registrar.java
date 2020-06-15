package br.com.ies.frontend;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.ies.backend.Main;
import br.com.ies.backend.dto.PersistenceParameterDTO;
import br.com.ies.backend.entity.NivelEntity;
import br.com.ies.backend.entity.UsuarioEntity;
import br.com.ies.backend.type.PersistenceType;
import br.com.ies.backend.util.PersistenceUtil;
import br.com.ies.backend.util.Util;
import br.com.ies.frontend.builder.ComponentBuilder;
import br.com.ies.frontend.util.Constants;

public class Registrar {

	private JFrame frame;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Registrar() {
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
		
		JTextField inputNome = ComponentBuilder.buildTextField("Franklin Gothic Medium", Font.PLAIN, 13, 101, 120, 680, 40, 10);
		JTextField inputUsuario	= ComponentBuilder.buildTextField("Franklin Gothic Medium", Font.PLAIN, 13, 101, 202, 680, 40, 10);
		JTextField inputEmail = ComponentBuilder.buildTextField("Franklin Gothic Medium", Font.PLAIN, 13, 101, 290, 680, 40, 10);
		JPasswordField inputSenha = ComponentBuilder.buildPasswordField("Franklin Gothic Medium", Font.PLAIN, 13, 101, 383, 335, 40);
		JPasswordField inputConfirmarSenha = ComponentBuilder.buildPasswordField("Franklin Gothic Medium", Font.PLAIN, 13, 446, 383, 335, 40);
		
		frame.getContentPane().add(inputNome);
		frame.getContentPane().add(inputUsuario);
		frame.getContentPane().add(inputEmail);
		frame.getContentPane().add(inputSenha);
		frame.getContentPane().add(inputConfirmarSenha);
		
		frame.getContentPane().add(ComponentBuilder.buildLabel("REGISTRO", "Franklin Gothic Medium", Font.PLAIN, 20, SwingConstants.CENTER, null, null, null, 0, 20, 882, 34, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("NOME COMPLETO","Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.CENTER, null, null, null, 382, 91, 118, 16, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("Usuário", "Franklin Gothic Medium", Font.PLAIN, 13, null, null, null, null, 413, 173, 56, 16, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("EMAIL", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.CENTER, null, null, null, 413, 261, 56, 16, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("SENHA", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.CENTER, null, null, null, 240, 354, 56, 16, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("CONFIRMAR SENHA","Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.CENTER, null, null, null, 550, 354, 126, 16, null));
		frame.getContentPane().add(ComponentBuilder.buildButton("VOLTAR", "Franklin Gothic Medium", Font.PLAIN, 13,101, 455, 335, 40, null, null,
				() -> {
					new Login().toggleFrame();
					toggleFrame();
				}));
		frame.getContentPane().add(ComponentBuilder.buildButton("REGISTRAR","Franklin Gothic Medium", Font.PLAIN, 13, 446, 455, 335, 40, new Color(0, 250, 154), Color.BLACK, 
				() -> {

					PersistenceParameterDTO<String> persistenceParameterDTO = new PersistenceParameterDTO<>();
					persistenceParameterDTO.setParameter(String.format("SELECT 8 FROM usuario.usuario WHERE usr_login = '%s'", inputUsuario.getText()));
					
					
					if(!(inputSenha.getText().equals(inputConfirmarSenha.getText())) || inputSenha.getText().isEmpty()) {
						Util.showMessage(Constants.PASSWORDS_DONT_MATCH);
						return;
					}
					
					Main.getPersistenceManager().getPersistance(PersistenceType.POSTGRES).select(persistenceParameterDTO, 
							(object) ->
					{
						if(Util.castObjectToList(object).isEmpty()) {
							UsuarioEntity usuario = new UsuarioEntity();
							NivelEntity nivelEntity = new NivelEntity();
							nivelEntity.setNvlCodigo(2);
							usuario.setNivelEntity(nivelEntity);
							usuario.setUsrAtivo(Boolean.TRUE);
							usuario.setUsrEmail(inputEmail.getText());
							usuario.setUsrLogin(inputUsuario.getText());
							usuario.setUsrNome(inputNome.getText());
							usuario.setUsrSenha(inputSenha.getText());
							
							PersistenceUtil.persist(usuario);
							Util.showMessage(Constants.USER_REGISTRED);
							new Login().toggleFrame();
							toggleFrame();
						}else {
							Util.showMessage(Constants.USER_ALREADY_EXISTS);
						}
					}
					);
				}));

	}
	public JFrame getFrame() {
		return frame;
	}

	public void toggleFrame() {
		frame.setVisible(!frame.isVisible());
	}
}
