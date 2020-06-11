package br.com.ies.frontend.administration;
import java.awt.Color;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.StringJoiner;

import javax.swing.DefaultListModel;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import br.com.ies.backend.Main;
import br.com.ies.backend.dto.PersistenceParameterDTO;
import br.com.ies.backend.entity.ArtistaEntity;
import br.com.ies.backend.type.PersistenceType;
import br.com.ies.backend.util.PersistenceUtil;
import br.com.ies.backend.util.Util;
import br.com.ies.frontend.builder.ComponentBuilder;
import br.com.ies.frontend.util.Constants;

public class Artistas {

	private JFrame frame;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Artistas() {
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
		
		DefaultListModel<Object> defaultList = new DefaultListModel<>();
		PersistenceParameterDTO<String> persistenceParameterDTO2 = new PersistenceParameterDTO<>();
		persistenceParameterDTO2.setParameter("SELECT art_codigo,art_nome FROM evento.artista");
		
		Main.getPersistenceManager().getPersistance(PersistenceType.POSTGRES).select(persistenceParameterDTO2,
				(u) ->{
				List<Object[]>	list = Util.castObjectToList(u);
				for(Object[] object : list) {
					StringJoiner stringJoiner = new StringJoiner(" - "); 
				
					Integer codigo = (Integer) object[0];
					String nome = (String) object[1];
					
					stringJoiner.add(codigo.toString());
					stringJoiner.add(nome);
					defaultList.addElement(stringJoiner.toString());
					
				}
		});
		
		JList<Object> listaArtistas = ComponentBuilder.buildList("Franklin Gothic Medium", Font.PLAIN, 16, Color.LIGHT_GRAY, 29, 101, 258, 251, ListSelectionModel.SINGLE_SELECTION, defaultList);
		frame.getContentPane().add(listaArtistas);
		
		listaArtistas.setBounds(54, 101, 258, 251);
		frame.getContentPane().add(listaArtistas);
		
		frame.getContentPane().add(ComponentBuilder.buildLabel("ARTISTAS", "Franklin Gothic Medium", Font.BOLD, 20, SwingConstants.CENTER, null, null, null, 0, 20, 882, 30, null));
		frame.getContentPane().add(ComponentBuilder.buildButton("DELETAR ARTISTA", "Franklin Gothic Medium", Font.PLAIN, 13, 54, 365, 255, 40, null, null,
				 () -> {
					 if(listaArtistas.getSelectedValue() ==null)return;
						Integer id = Integer.valueOf(listaArtistas.getSelectedValue().toString().split(" - ")[0]);
						try {
						PreparedStatement preparedStatement = Main.getConnectionFactory().getPreparedStatement(String.format("DELETE FROM evento.artista WHERE art_codigo = '%s'", id));
						preparedStatement.execute();
						preparedStatement.close();
						new Artistas().toggleFrame();
						toggleFrame();
						}catch(Exception e) {
							e.printStackTrace();
						}	
					}));
		
		frame.getContentPane().add(ComponentBuilder.buildButton("VOLTAR", "Franklin Gothic Medium", Font.PLAIN, 13, 54, 479, 255, 40, null, null,
				 () -> {
						new AdministratorDashboard().toggleFrame();
						toggleFrame();
					}));
		
		frame.getContentPane().add(ComponentBuilder.buildLabel("NOME", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.CENTER, null, null, null, 460, 79, 258, 16, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("DESCRIÇÃO", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.CENTER, null, null, null, 460, 159, 258, 16, null));
		JTextField inputNome = ComponentBuilder.buildTextField("Franklin Gothic Medium", Font.PLAIN, 13, 332, 101, 515, 40, 10);

		frame.getContentPane().add(inputNome);		
		
		JEditorPane txtBoxDescricao = new JEditorPane();
		txtBoxDescricao.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		txtBoxDescricao.setBounds(332, 188, 515, 276);
		frame.getContentPane().add(txtBoxDescricao);
		
		frame.getContentPane().add(ComponentBuilder.buildButton("CRIAR ARTISTA", "Franklin Gothic Medium", Font.PLAIN, 13, 332, 479, 515, 40, new Color(0, 250, 154), null,
				 () -> {
					 ArtistaEntity artista = new ArtistaEntity();
					 if(listaArtistas.getSelectedValue() != null)
						 artista.setArtCodigo(Integer.valueOf(Integer.valueOf(listaArtistas.getSelectedValue().toString().split(" - ")[0])));
					 	artista.setArtNome(inputNome.getText());
					 	artista.setArtDescricao(txtBoxDescricao.getText());

						PersistenceUtil.persist(artista);
						Util.showMessage(Constants.ARTISTAS_REGISTRED);
						new Artistas().toggleFrame();
						toggleFrame();
					}));
		
		frame.getContentPane().add(ComponentBuilder.buildLabel("SELECIONE OU CRIE UM ARTISTA", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.CENTER, null, null, null, 54, 79, 258, 16, null));
		
		frame.getContentPane().add(ComponentBuilder.buildButton("EDITAR ARTISTA", "Franklin Gothic Medium", Font.PLAIN, 13, 54, 424, 255, 40, null, null,
				 () -> {
						if(listaArtistas.getSelectedValue() ==null)return;
						Integer id = Integer.valueOf(listaArtistas.getSelectedValue().toString().split(" - ")[0]);
						
						PersistenceParameterDTO<String> select1 = new PersistenceParameterDTO<>();
						select1.setParameter(String.format("SELECT art_codigo,art_nome,art_descricao FROM evento.artista WHERE art_codigo = '%s' " ,id));
						
						Main.getPersistenceManager().getPersistance(PersistenceType.POSTGRES).select(select1,
								(u) ->{
									List<Object[]> list = Util.castObjectToList(u);
									Object[] object = list.get(0);
									
									inputNome.setText(String.valueOf(object[1]));
									txtBoxDescricao.setText(String.valueOf(object[2]));

								});
					}));
	}

	public JFrame getFrame() {
		return frame;
	}
	public void toggleFrame() {
		frame.setVisible(!frame.isVisible());
	}

}
