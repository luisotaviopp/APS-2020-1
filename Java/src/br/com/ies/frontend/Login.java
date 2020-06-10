package br.com.ies.frontend;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.ies.backend.Main;
import br.com.ies.backend.dto.PersistenceParameterDTO;
import br.com.ies.backend.entity.NivelEntity;
import br.com.ies.backend.entity.UsuarioEntity;
import br.com.ies.backend.type.PersistenceType;
import br.com.ies.backend.util.Util;
import br.com.ies.frontend.administration.AdministratorDashboard;
import br.com.ies.frontend.builder.ComponentBuilder;
import br.com.ies.frontend.user.UserDashboard;
import br.com.ies.frontend.util.Constants;

public class Login {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public Login() {
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
		
		//Título
//		JLabel lblTitulo = new JLabel("BILHETERIA");
//		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
//		lblTitulo.setForeground(Color.DARK_GRAY);
//		lblTitulo.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 20));
//		lblTitulo.setBounds(266, 23, 350, 58);
//		frame.getContentPane().add(lblTitulo);
		JTextField inputUsuario = ComponentBuilder.buildTextField("Franklin Gothic Medium", Font.BOLD, 16, 266, 143, 350, 41, 10);
		JPasswordField inputSenha = ComponentBuilder.buildPasswordField("Franklin Gothic Medium", Font.BOLD, 16, 266, 238, 350, 41);
		
		frame.getContentPane().add(inputUsuario);
		frame.getContentPane().add(inputSenha);
		
		frame.getContentPane().add(ComponentBuilder.buildLabel("BILHETERIA", "Franklin Gothic Medium", Font.BOLD, 20, SwingConstants.CENTER, null, null, null, 266, 23, 350, 58, null));
		
		frame.getContentPane().add(ComponentBuilder.buildButton("ENTRAR", "Franklin Gothic Medium", Font.PLAIN, 13, 266, 321, 350, 40, new Color(0, 250, 154), null, () -> {
			
			PersistenceParameterDTO<String> persistenceParameterDTO = new PersistenceParameterDTO<>();
			persistenceParameterDTO.setParameter(String.format("SELECT usr_codigo,usr_nome,usr_email,usr_login,usr_senha, nvl.nvl_codigo, nvl_descricao FROM usuario.usuario usr INNER JOIN usuario.nivel nvl ON nvl.nvl_codigo = usr.nvl_codigo WHERE usr.usr_login = '%s'", inputUsuario.getText()));
			
			Main.getPersistenceManager().getPersistance(PersistenceType.POSTGRES).select(persistenceParameterDTO, 
					(u) ->{
						List<Object[]> list = Util.castObjectToList(u);
						
						if(!(list.isEmpty())) {
							Object[] userObject = list.get(0);

							String password = (String) userObject[4];
							String level = (String) userObject[6];
							
							if(!(password.trim().equals(inputSenha.getText()))) {
								Util.showMessage(Constants.INVALID_PASSWORD);
								return;
							}
							if(level.equalsIgnoreCase("administrador"))
								new AdministratorDashboard().toggleFrame();
							else
								new UserDashboard().toggleFrame();
							
							UsuarioEntity usuario = new UsuarioEntity();
							NivelEntity nivel = new NivelEntity();
							nivel.setNvlCodigo((Integer) userObject[5]);
							nivel.setNvlDescricao(level);
							usuario.setNivelEntity(nivel);
							usuario.setUsrAtivo(Boolean.TRUE);
							usuario.setUsrCodigo((Integer) userObject[0]);
							usuario.setUsrEmail((String) userObject[2].toString().trim());
							usuario.setUsrLogin((String) userObject[3].toString().trim());
							usuario.setUsrNome((String) userObject[1].toString().trim());
							usuario.setUsrSenha((String) userObject[4].toString().trim());
							Main.getUserManager().setUsuario(usuario);
							toggleFrame();
						}else {
							Util.showMessage(Constants.USER_DOESNT_EXIST);
						}
					});
		}));
		
		// Label Username
		frame.getContentPane().add(ComponentBuilder.buildLabel("NOME", "Franklin Gothic Medium", Font.BOLD, 16, SwingConstants.CENTER, null, null, null, 356, 104, 170, 40, null));

		// Label Senha
		frame.getContentPane().add(ComponentBuilder.buildLabel("SENHA", "Franklin Gothic Medium", Font.BOLD, 16, SwingConstants.CENTER, null, null, null, 356, 197, 170, 40, null));
		
		// Botão Registrar
		frame.getContentPane().add(ComponentBuilder.buildButton("REGISTRAR", "Franklin Gothic Medium", Font.PLAIN, 13, 266, 384, 350, 40, null, null,
				 () -> {
						new Registrar().toggleFrame();
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
