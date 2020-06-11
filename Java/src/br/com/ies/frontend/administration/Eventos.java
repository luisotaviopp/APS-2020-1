
package br.com.ies.frontend.administration;

import java.awt.Color;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.IntStream;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import br.com.ies.backend.Main;
import br.com.ies.backend.dto.PersistenceParameterDTO;
import br.com.ies.backend.entity.ArtistaEntity;
import br.com.ies.backend.entity.EventoEntity;
import br.com.ies.backend.entity.LocalEntity;
import br.com.ies.backend.entity.TipoEventoEntity;
import br.com.ies.backend.type.PersistenceType;
import br.com.ies.backend.util.PersistenceUtil;
import br.com.ies.backend.util.Util;
import br.com.ies.frontend.builder.ComponentBuilder;
import br.com.ies.frontend.util.Constants;

public class Eventos {

	private JFrame frame;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Eventos() {
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
		persistenceParameterDTO2.setParameter("SELECT eve_codigo, eve_titulo, eve_data FROM evento.evento");
		
		Main.getPersistenceManager().getPersistance(PersistenceType.POSTGRES).select(persistenceParameterDTO2,
				(u) ->{
				List<Object[]>	list = Util.castObjectToList(u);
				for(Object[] object : list) {
					StringJoiner stringJoiner = new StringJoiner(" - "); 
				
					Integer codigo = (Integer) object[0];
					String titulo = String.valueOf(object[1]);
					Date date = (Date) object[2];
					
					stringJoiner.add(codigo.toString());
					stringJoiner.add(titulo);
					stringJoiner.add(Util.dateToString("dd/MM/yyyy HH:mm", date));
					defaultList.addElement(stringJoiner.toString());
				}
		});
		
		JList<Object> listaEventos = ComponentBuilder.buildList("Franklin Gothic Medium", Font.PLAIN, 16, Color.LIGHT_GRAY, 54, 101, 258, 197, ListSelectionModel.SINGLE_SELECTION, defaultList);
		frame.getContentPane().add(listaEventos);


		JTextField inputQuantidade = ComponentBuilder.buildTextField("Franklin Gothic Medium", Font.PLAIN, 13,465, 258, 382, 40, 10);
		frame.getContentPane().add(inputQuantidade);
		
		JTextField inputValor = ComponentBuilder.buildTextField("Franklin Gothic Medium", Font.PLAIN, 13, 465, 311, 382, 40, 10);
		frame.getContentPane().add(inputValor);
		
		JTextField inputNome = ComponentBuilder.buildTextField("Franklin Gothic Medium", Font.PLAIN, 13, 465, 105, 382, 40, 10);
		frame.getContentPane().add(inputNome);
		
		JTextField inputData = ComponentBuilder.buildTextField("Franklin Gothic Medium", Font.PLAIN, 13, 465, 156, 382, 40, 10);
		frame.getContentPane().add(inputData);
		
		
		DefaultComboBoxModel<Object> comboModel = new DefaultComboBoxModel<>();
		
		JComboBox<Object> selectArtista = ComponentBuilder.buildComboBox("Franklin Gothic Medium", Font.PLAIN, 13, 465, 365, 382, 40, comboModel);
		PersistenceParameterDTO<String> select = new PersistenceParameterDTO<>();
		select.setParameter("SELECT art_codigo, art_nome FROM evento.artista");
		
		Main.getPersistenceManager().getPersistance(PersistenceType.POSTGRES).select(select, 
				(u) ->{
					List<Object[]> list = Util.castObjectToList(u);
					
					for(Object[] object : list) {
						StringJoiner stringJoiner = new StringJoiner(" - ");
						stringJoiner.add(object[0].toString());
						stringJoiner.add(object[1].toString());
						comboModel.addElement(stringJoiner.toString());
					}
					selectArtista.setSelectedIndex(0);
				});
		frame.getContentPane().add(selectArtista);
		
		DefaultComboBoxModel<Object> comboModel2 = new DefaultComboBoxModel<>();
		JComboBox<Object> selectTipoEvento = ComponentBuilder.buildComboBox("Franklin Gothic Medium", Font.PLAIN, 13, 465, 424, 382, 40, comboModel2);
		PersistenceParameterDTO<String> select2 = new PersistenceParameterDTO<>();
		select2.setParameter("SELECT tie_codigo, tie_descricao FROM evento.tipo_evento");
		
		Main.getPersistenceManager().getPersistance(PersistenceType.POSTGRES).select(select2, 
				(u) ->{
					List<Object[]> list = Util.castObjectToList(u);
					
					for(Object[] object : list) {
						StringJoiner stringJoiner = new StringJoiner(" - ");
						stringJoiner.add(object[0].toString());
						stringJoiner.add(object[1].toString());
						comboModel2.addElement(stringJoiner.toString());
					}
					selectTipoEvento.setSelectedIndex(0);
				});
		frame.getContentPane().add(selectTipoEvento);
		
		DefaultComboBoxModel<Object> comboModel21 = new DefaultComboBoxModel<>();
		JComboBox<Object> selectLocal = ComponentBuilder.buildComboBox("Franklin Gothic Medium", Font.PLAIN, 13, 465, 424, 382, 40, comboModel21);
		PersistenceParameterDTO<String> select21 = new PersistenceParameterDTO<>();
		select21.setParameter("SELECT loc_codigo,loc_logradouro,loc_numero,loc_bairro FROM evento.local");
		Main.getPersistenceManager().getPersistance(PersistenceType.POSTGRES).select(select21, 
				(u) ->{
					List<Object[]> list = Util.castObjectToList(u);
					
					for(Object[] object : list) {
						StringJoiner stringJoiner = new StringJoiner(" - ");
						stringJoiner.add(object[0].toString());
						stringJoiner.add(object[1].toString());
						stringJoiner.add(object[2].toString());
						stringJoiner.add(object[3].toString());
						comboModel21.addElement(stringJoiner.toString());
					}
					selectLocal.setSelectedIndex(0);
				});
		frame.getContentPane().add(selectLocal);
		JComboBox<Object> selectEndereco = ComponentBuilder.buildComboBox("Franklin Gothic Medium", Font.PLAIN, 13, 465, 207, 382, 40, comboModel21);
		frame.getContentPane().add(selectEndereco);

		
		frame.getContentPane().add(ComponentBuilder.buildLabel("EVENTOS", "Franklin Gothic Medium", Font.BOLD, 20, SwingConstants.CENTER, null, null, null, 0, 20, 882, 30, null));
		frame.getContentPane().add(ComponentBuilder.buildButton("DELETAR EVENTO", "Franklin Gothic Medium", Font.PLAIN, 13, 54, 365, 255, 40, null, null,
				 () -> {
					 if(listaEventos.getSelectedValue() ==null)return;
					 
						try{
							PreparedStatement preparedStatement = Main.getConnectionFactory().getPreparedStatement(String.format("DELETE FROM evento.evento WHERE eve_codigo='%s'", Integer.valueOf(listaEventos.getSelectedValue().toString().split(" - ")[0])));
							preparedStatement.execute();
							preparedStatement.close();
							
							Util.showMessage(Constants.EVENT_DELETED);
							
							new Eventos().toggleFrame();
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

		frame.getContentPane().add(ComponentBuilder.buildButton("CRIAR/ATUALIZAR EVENTO", "Franklin Gothic Medium", Font.PLAIN, 13, 332, 479, 515, 40, new Color(0, 250, 154), null,
				 () -> {
					 
					 
					 
					 EventoEntity evento = new EventoEntity();
						
						if(listaEventos.getSelectedValue() != null)
							evento.setEveCodigo(Integer.valueOf(listaEventos.getSelectedValue().toString().split(" - ")[0]));
						evento.setEveTitulo(inputNome.getText());
						evento.setEveData(Util.dateFromString("dd/MM/yyyy HH:mm", inputData.getText()));
						evento.setEveQtdIngressos(Integer.parseInt(inputQuantidade.getText()));
						evento.setEveValorIngresso(Double.parseDouble(inputValor.getText()));
						LocalEntity local = new LocalEntity();
						local.setLocCodigo(Integer.parseInt(selectLocal.getSelectedItem().toString().split(" - ")[0]));
						evento.setLocalEntity(local);
						ArtistaEntity artista = new ArtistaEntity();
						artista.setArtCodigo(Integer.valueOf(selectArtista.getSelectedItem().toString().split(" - ")[0]));
						evento.setArtistaEntity(artista);
						TipoEventoEntity tipoEvento = new TipoEventoEntity();
						tipoEvento.setTieCodigo(Integer.valueOf(selectTipoEvento.getSelectedItem().toString().split(" - ")[0]));
						evento.setTipoEventoEntity(tipoEvento);
						evento.setAberturaUsuarioEntity(Main.getUserManager().getUsuario());

						PersistenceUtil.persist(evento);
						Util.showMessage(Constants.EVENT_CHANGED);
						new Eventos().toggleFrame();
						toggleFrame();
					 
					}));
		frame.getContentPane().add(ComponentBuilder.buildLabel("SELECIONE OU CRIE UM EVENTO", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.CENTER, null, null, null, 54, 79, 258, 16, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("ENDEREÇO", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, null, null, null, 332, 209, 148, 38, null));
		frame.getContentPane().add(inputValor);
		frame.getContentPane().add(ComponentBuilder.buildLabel("ARTISTA", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, null, null, null, 332, 367, 148, 38, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("TIPO DE EVENTO", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, null, null, null, 332, 426, 148, 38, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("DATA", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, null, null, null, 332, 158, 148, 38, null));
		// input Data
		frame.getContentPane().add(ComponentBuilder.buildTextField("Franklin Gothic Medium", Font.PLAIN, 13, 465, 156, 382, 40, 10));
		frame.getContentPane().add(ComponentBuilder.buildLabel("NOME", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, null, null, null, 332, 107, 148, 38, null));
		
		
		frame.getContentPane().add(ComponentBuilder.buildButton("EDITAR EVENTO", "Franklin Gothic Medium", Font.PLAIN, 13, 54, 424, 255, 40, null, null,
				 () -> {
					 if(listaEventos.getSelectedValue() ==null)return;
						Integer id = Integer.valueOf(listaEventos.getSelectedValue().toString().split(" - ")[0]);
						
						PersistenceParameterDTO<String> select1 = new PersistenceParameterDTO<>();
						
						
						select1.setParameter(String.format("SELECT eve_titulo,eve_data,loc_logradouro,loc_lotacao_maxima,eve_valor_ingresso, art.art_nome, tie.tie_descricao FROM evento.evento e INNER JOIN evento.local el ON e.loc_codigo = el.loc_codigo INNER JOIN evento.artista art ON e.art_codigo = art.art_codigo "
								+ "INNER JOIN evento.tipo_evento tie ON e.tie_codigo = tie.tie_codigo WHERE e.eve_codigo = '%s'" ,id));
						
						Main.getPersistenceManager().getPersistance(PersistenceType.POSTGRES).select(select1,
								(u) ->{
									List<Object[]> list = Util.castObjectToList(u);
									Object[] object = list.get(0);
									
									String artista = String.valueOf(object[5]);
									String tipoEvento = String.valueOf(object[6]);
									String tituloEvento = String.valueOf(object[0]);
									
									inputNome.setText(String.valueOf(object[0]));
									inputData.setText(Util.stringFromDate("dd/MM/yyyy HH:mm", (Date) object[1]));
									inputQuantidade.setText(String.valueOf(object[3]));
									inputValor.setText(String.valueOf(object[4]));
									
									
											IntStream.range(0, selectArtista.getModel().getSize()).filter(
													i -> selectArtista.getModel().getElementAt(i).toString().contains(artista))
													.forEach(i -> selectArtista.setSelectedIndex(i));
											IntStream.range(0, selectLocal.getModel().getSize()).filter(
													i -> selectLocal.getModel().getElementAt(i).toString().contains(tipoEvento))
													.forEach(i -> selectLocal.setSelectedIndex(i));
											IntStream.range(0, selectEndereco.getModel().getSize()).filter(
													i -> selectEndereco.getModel().getElementAt(i).toString().contains(tituloEvento))
													.forEach(i -> selectEndereco.setSelectedIndex(i));
								});
						
						
					}));
		
		frame.getContentPane().add(ComponentBuilder.buildLabel("VALOR DO INGRESSO", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, null, null, null, 332, 313, 133, 38, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("QUANTIDADE", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, null, null, null, 332, 260, 148, 38, null));

	}
	public JFrame getFrame() {
		return frame;
	}
	public void toggleFrame() {
		frame.setVisible(!frame.isVisible());
	}
}
