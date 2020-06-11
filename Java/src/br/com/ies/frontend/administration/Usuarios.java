package br.com.ies.frontend.administration;

import java.awt.Color;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.IntStream;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import br.com.ies.backend.Main;
import br.com.ies.backend.dto.PersistenceParameterDTO;
import br.com.ies.backend.entity.NivelEntity;
import br.com.ies.backend.entity.UsuarioEntity;
import br.com.ies.backend.type.PersistenceType;
import br.com.ies.backend.util.PersistenceUtil;
import br.com.ies.backend.util.Util;
import br.com.ies.frontend.builder.ComponentBuilder;
import br.com.ies.frontend.util.Constants;

public class Usuarios {

	private JFrame frame;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Usuarios() {
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

		DefaultListModel<Object> defaultList = new DefaultListModel<>();
		PersistenceParameterDTO<String> persistenceParameterDTO2 = new PersistenceParameterDTO<>();
		persistenceParameterDTO2.setParameter("SELECT usr_codigo,usr_login FROM usuario.usuario");
		
		Main.getPersistenceManager().getPersistance(PersistenceType.POSTGRES).select(persistenceParameterDTO2,
				(u) ->{
				List<Object[]>	list = Util.castObjectToList(u);
				for(Object[] object : list) {
					StringJoiner stringJoiner = new StringJoiner(" - "); 
				
					Integer codigo = (Integer) object[0];
					String login = (String) object[1];
					
					stringJoiner.add(codigo.toString());
					stringJoiner.add(login);
					defaultList.addElement(stringJoiner.toString());
					
				}
		});
		
		JList<Object> listaUsuarios = ComponentBuilder.buildList("Franklin Gothic Medium", Font.PLAIN, 16, Color.LIGHT_GRAY, 29, 101, 258, 251, ListSelectionModel.SINGLE_SELECTION, defaultList);
		listaUsuarios.setSelectedIndex(0);
		frame.getContentPane().add(listaUsuarios);
		
		JTextField inputNome =  ComponentBuilder.buildTextField("Franklin Gothic Medium", Font.PLAIN, 13, 438, 101, 414, 40, 10);
		JTextField inputEmail  = ComponentBuilder.buildTextField("Franklin Gothic Medium", Font.PLAIN, 13, 439, 154, 413, 40, 10);
		JTextField inputUsuario = ComponentBuilder.buildTextField("Franklin Gothic Medium", Font.PLAIN, 13, 439, 207, 413, 40, 10);
		JPasswordField inputSenhaProvisoria = ComponentBuilder.buildPasswordField("Franklin Gothic Medium", Font.PLAIN, 13, 439, 260, 413, 40);

		frame.getContentPane().add(inputNome);
		frame.getContentPane().add(inputEmail);
		frame.getContentPane().add(inputUsuario);
		frame.getContentPane().add(inputSenhaProvisoria);
		

		DefaultComboBoxModel<Object> comboModel = new DefaultComboBoxModel<>();
		PersistenceParameterDTO<String> select = new PersistenceParameterDTO<>();
		select.setParameter("SELECT nvl_codigo, nvl_descricao FROM usuario.nivel");
		
		Main.getPersistenceManager().getPersistance(PersistenceType.POSTGRES).select(select, 
				(u) ->{
					List<Object[]> list = Util.castObjectToList(u);
					
					for(Object[] object : list) {
						StringJoiner stringJoiner = new StringJoiner(" - ");
						stringJoiner.add(object[0].toString());
						stringJoiner.add(object[1].toString());
						comboModel.addElement(stringJoiner.toString());
					}
				});
		
		JComboBox<Object> selectNivel = ComponentBuilder.buildComboBox("Franklin Gothic Medium", Font.PLAIN, 13,439, 312, 413, 40, comboModel);
		selectNivel.setSelectedIndex(0);
		frame.getContentPane().add(selectNivel);

		
		frame.getContentPane().add(ComponentBuilder.buildLabel("USUÁRIOS", "Franklin Gothic Medium", Font.BOLD, 20, SwingConstants.CENTER, null, null, null, 0, 20, 882, 30, null));
		frame.getContentPane().add(ComponentBuilder.buildButton("DELETAR USUÁRIO", "Franklin Gothic Medium", Font.PLAIN, 13, 29, 365, 255, 40, UIManager.getColor("Button.background"), null,
				() -> {
					if(listaUsuarios.getSelectedValue() ==null)return;
					Integer id = Integer.valueOf(listaUsuarios.getSelectedValue().toString().split(" - ")[0]);
					try {
					PreparedStatement preparedStatement = Main.getConnectionFactory().getPreparedStatement(String.format("DELETE FROM usuario.usuario WHERE usr_codigo = '%s'", id));
					preparedStatement.execute();
					preparedStatement.close();
					new Usuarios().toggleFrame();
					toggleFrame();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}));
		frame.getContentPane().add(ComponentBuilder.buildButton("EDITAR USUÁRIO", "Franklin Gothic Medium", Font.PLAIN, 13, 29, 424, 255, 40, null, null,
				() -> {
					if(listaUsuarios.getSelectedValue() ==null)return;
					Integer id = Integer.valueOf(listaUsuarios.getSelectedValue().toString().split(" - ")[0]);
					
					PersistenceParameterDTO<String> select1 = new PersistenceParameterDTO<>();
					select1.setParameter(String.format("SELECT usr_nome,usr_email,usr_login,usr_senha,nvl.nvl_descricao FROM usuario.usuario usr " + 
							"INNER JOIN usuario.nivel nvl ON usr.nvl_codigo = nvl.nvl_codigo WHERE usr_codigo='%s'",id));
					
					Main.getPersistenceManager().getPersistance(PersistenceType.POSTGRES).select(select1,
							(u) ->{
								List<Object[]> list = Util.castObjectToList(u);
								Object[] object = list.get(0);
								
								String nivel = String.valueOf(object[4]);
								
								inputNome.setText(String.valueOf(object[0]));
								inputEmail.setText(String.valueOf(object[1]));
								inputUsuario.setText(String.valueOf(object[2]));
								inputSenhaProvisoria.setText(String.valueOf(object[3]));

								
										IntStream.range(0, selectNivel.getModel().getSize()).filter(
												i -> selectNivel.getModel().getElementAt(i).toString().contains(nivel))
												.forEach(i -> selectNivel.setSelectedIndex(i));
							});
					
				}));
		frame.getContentPane().add(ComponentBuilder.buildButton("VOLTAR","Franklin Gothic Medium", Font.PLAIN, 13, 29, 479, 255, 40, null, null,
				() -> {
					new AdministratorDashboard().toggleFrame();
					toggleFrame();
				}));
		
		frame.getContentPane().add(ComponentBuilder.buildButton("CRIAR/ATUALIZAR USUARIO", "Franklin Gothic Medium", Font.PLAIN, 13, 312, 479, 540, 40, new Color(0, 250, 154), null,
				() -> {
					
					PersistenceParameterDTO<String> persistenceParameterDTO = new PersistenceParameterDTO<>();
					persistenceParameterDTO.setParameter(String.format("SELECT 8 FROM usuario.usuario WHERE usr_login = '%s'", inputUsuario.getText()));
					
					Main.getPersistenceManager().getPersistance(PersistenceType.POSTGRES).select(persistenceParameterDTO, 
							(object) ->
					{
						
						if(!(Util.castObjectToList(object).isEmpty())) {
							UsuarioEntity usuario = new UsuarioEntity();
							NivelEntity nivelEntity = new NivelEntity();
							nivelEntity.setNvlCodigo(Integer.valueOf(selectNivel.getSelectedItem().toString().split(" - ")[0]));
							usuario.setUsrCodigo(Integer.valueOf(Integer.valueOf(listaUsuarios.getSelectedValue().toString().split(" - ")[0])));
							usuario.setNivelEntity(nivelEntity);
							usuario.setUsrAtivo(Boolean.TRUE);
							usuario.setUsrNome(inputNome.getText());
							usuario.setUsrEmail(inputEmail.getText());
							usuario.setUsrLogin(inputUsuario.getText());
							usuario.setUsrSenha(inputSenhaProvisoria.getText());

							PersistenceUtil.persist(usuario);
							Util.showMessage(Constants.USER_CHANGED);
							new Usuarios().toggleFrame();
							toggleFrame();
						}
					}
							);
				}));

		frame.getContentPane().add(ComponentBuilder.buildLabel("SELECIONE OU CRIE UM USUÁRIO", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.CENTER, null, null, null, 29, 79, 258, 16, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("EMAIL", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, null, null, null, 312, 154, 127, 40, null));
		frame.getContentPane().add(ComponentBuilder.buildButton("CONSULTAR LOGS", "Franklin Gothic Medium", Font.PLAIN, 13, 312, 424, 540, 40, new Color(204, 255, 102), null,
				() -> {

				}));
		frame.getContentPane().add(ComponentBuilder.buildLabel("NOME", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, null, null, null, 311, 101, 127, 40, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("USUARIO", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, null, null, null, 312, 207, 127, 40, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("SENHA PROVISÁRIA", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, null, null, null, 312, 260, 127, 40, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("NÍVEL DE ACESSO", "Franklin Gothic Medium", Font.PLAIN, 13, null, null, null, null, 312, 312, 127, 40, null));


		frame.getContentPane().add(ComponentBuilder.buildButton("DESATIVAR USUÁRIO", "Franklin Gothic Medium", Font.PLAIN, 13, 312, 365, 540, 40, Color.WHITE, null,
				() -> {
					PersistenceParameterDTO<String> persistenceParameterDTO = new PersistenceParameterDTO<>();
					persistenceParameterDTO.setParameter(String.format("SELECT 8 FROM usuario.usuario WHERE usr_login = '%s'", inputUsuario.getText()));
					
					Main.getPersistenceManager().getPersistance(PersistenceType.POSTGRES).select(persistenceParameterDTO, 
							(object) ->
					{
						
						if(!(Util.castObjectToList(object).isEmpty())) {
							UsuarioEntity usuario = new UsuarioEntity();
							NivelEntity nivelEntity = new NivelEntity();
							nivelEntity.setNvlCodigo(Integer.valueOf(selectNivel.getSelectedItem().toString().split(" - ")[0]));
							usuario.setUsrCodigo(Integer.valueOf(Integer.valueOf(listaUsuarios.getSelectedValue().toString().split(" - ")[0])));
							usuario.setNivelEntity(nivelEntity);
							usuario.setUsrAtivo(Boolean.FALSE);
							usuario.setUsrNome(inputNome.getText());
							usuario.setUsrEmail(inputEmail.getText());
							usuario.setUsrLogin(inputUsuario.getText());
							usuario.setUsrSenha(inputSenhaProvisoria.getText());

							
							PersistenceUtil.persist(usuario);
							Util.showMessage(Constants.USER_DISABLED);
							new Usuarios().toggleFrame();
							toggleFrame();
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
