package br.com.ies.frontend.user;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import br.com.ies.backend.Main;
import br.com.ies.backend.dto.PersistenceParameterDTO;
import br.com.ies.backend.entity.ArtistaEntity;
import br.com.ies.backend.entity.EventoEntity;
import br.com.ies.backend.type.PersistenceType;
import br.com.ies.backend.util.Util;
import br.com.ies.frontend.builder.ComponentBuilder;

public class ListaEventos {

	private JFrame frame;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public ListaEventos() {
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
		
		PersistenceParameterDTO<String> persistenceParameterDTO = new PersistenceParameterDTO<>();
		persistenceParameterDTO.setParameter("SELECT eve_codigo,eve_titulo,eve_valor_ingresso,eve_data FROM evento.evento");
		
		Main.getPersistenceManager().getPersistance(PersistenceType.POSTGRES).select(persistenceParameterDTO,
				(u) ->{
				List<Object[]>	list = Util.castObjectToList(u);
				for(Object[] object : list) {
					StringJoiner stringJoiner = new StringJoiner(" - "); 
				
					Integer codigo = (Integer) object[0];
					String titulo = (String) object[1];
					double price = (double) object[2];
					Date date = (Date) object[3];
					
					stringJoiner.add(codigo.toString());
					stringJoiner.add(Util.dateToString("dd/MM/yyyy", date));
					stringJoiner.add(Util.dateToString("HH:mm", date));
					stringJoiner.add("R$".concat(Double.toString(price)));
					stringJoiner.add(titulo);
					defaultList.addElement(stringJoiner.toString());
					
				}
		});
		
		
		frame.getContentPane().add(ComponentBuilder.buildLabel("VENDAS", "Franklin Gothic Medium", Font.BOLD, 20, SwingConstants.CENTER, null, null, null, 341, 20, 200, 30, null));
		frame.getContentPane().add(ComponentBuilder.buildButton("VOLTAR", "Franklin Gothic Medium", Font.PLAIN, 13, 60, 482, 350, 40, null, null,
				 () -> {
						new UserDashboard().toggleFrame();
						toggleFrame();
					}));
		JLabel firstLine = ComponentBuilder.buildLabel("", "Tahoma", Font.BOLD, 14, SwingConstants.LEFT, null, null, null, 470, 59, 350, 30, null);
		JLabel secondLine = ComponentBuilder.buildLabel("", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, null, null, null, 470, 102, 350, 30, null);
		JLabel thirdLine = ComponentBuilder.buildLabel("", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, null, SwingConstants.TOP, null, 470, 145, 350, 131, null);
		JLabel forthLine = ComponentBuilder.buildLabel("", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, SwingConstants.LEFT, SwingConstants.TOP, 0.5F, 470, 386, 350, 30, null);
		JLabel fifthLine = ComponentBuilder.buildLabel("", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, SwingConstants.LEFT, SwingConstants.TOP, null, 470, 429, 350, 30, null);
		
		frame.getContentPane().add(firstLine);
		frame.getContentPane().add(secondLine);
		frame.getContentPane().add(thirdLine);
		frame.getContentPane().add(forthLine);
		frame.getContentPane().add(fifthLine);

		
		JList<Object> listaEventos = ComponentBuilder.buildList("Franklin Gothic Medium", Font.PLAIN, 16, Color.LIGHT_GRAY, 60, 63, 350, 396, ListSelectionModel.SINGLE_SELECTION, defaultList);
		ComponentBuilder.buildEventComponent(listaEventos, ()->{
			Integer id = Integer.valueOf(listaEventos.getSelectedValue().toString().split(" - ")[0].trim());
			
			PersistenceParameterDTO<String> select = new PersistenceParameterDTO<>();
			select.setParameter(String.format("SELECT (eve_titulo || ' - ' || art.art_nome),eve_data,te.tie_descricao,(loc.loc_logradouro || ', '  || loc.loc_numero || ',' || loc.loc_bairro || ', ' || loc.loc_cidade || ', ' || loc.loc_uf) as endereco,eve_valor_ingresso,ee.eve_codigo,ee.eve_titulo,art.art_nome FROM evento.evento ee " + 
					"INNER JOIN evento.tipo_evento te ON te.tie_codigo = ee.tie_codigo " + 
					"INNER JOIN evento.local loc ON ee.loc_codigo = loc.loc_codigo " + 
					"INNER JOIN evento.artista art ON art.art_codigo = ee.art_codigo WHERE eve_codigo = '%s'", id));
			
			Main.getPersistenceManager().getPersistance(PersistenceType.POSTGRES).select(select, 
					(u) ->{
						List<Object[]> list = Util.castObjectToList(u);
						Object[] object = list.get(0);
						firstLine.setText((String) object[0]);
						secondLine.setText(Util.dateToString("dd/MM/yyyy - HH:mm", (Date) object[1]));
						thirdLine.setText((String) object[2]);
						forthLine.setText((String) object[3]);
						fifthLine.setText("R$".concat(((Double)object[4]).toString()));

						EventoEntity evento = new EventoEntity();
						evento.setEveCodigo((Integer) object[5]);
						evento.setEveValorIngresso(((Double)object[4]));
						evento.setEveTitulo((String) object[6]);
						ArtistaEntity artista = new ArtistaEntity();
						artista.setArtNome((String) object[7]);
						evento.setArtistaEntity(artista);
						Main.getUserManager().setEvento(evento);
						
					});
		});
		frame.getContentPane().add(listaEventos);
		
		frame.getContentPane().add(ComponentBuilder.buildButton("COMPRAR", "Franklin Gothic Medium", Font.PLAIN, 13, 470, 482, 350, 40, new Color(0, 250, 154), null,
				 () -> {
						new ComprarIngresso().toggleFrame();
						toggleFrame();
					}));
		
		PersistenceParameterDTO<String> select = new PersistenceParameterDTO<>();
		select.setParameter(String.format("SELECT (eve_titulo || ' - ' || art.art_nome),eve_data,te.tie_descricao,(loc.loc_logradouro || ', '  || loc.loc_numero || ',' || loc.loc_bairro || ', ' || loc.loc_cidade || ', ' || loc.loc_uf) as endereco,eve_valor_ingresso,ee.eve_codigo,ee.eve_titulo,art.art_nome FROM evento.evento ee " + 
				"INNER JOIN evento.tipo_evento te ON te.tie_codigo = ee.tie_codigo " + 
				"INNER JOIN evento.local loc ON ee.loc_codigo = loc.loc_codigo " + 
				"INNER JOIN evento.artista art ON art.art_codigo = ee.art_codigo WHERE eve_codigo = '%s'", 1));
		
		Main.getPersistenceManager().getPersistance(PersistenceType.POSTGRES).select(select, 
				(u) ->{
					List<Object[]> list = Util.castObjectToList(u);
					Object[] object = list.get(0);
					firstLine.setText((String) object[0]);
					secondLine.setText(Util.dateToString("dd/MM/yyyy - HH:mm", (Date) object[1]));
					thirdLine.setText((String) object[2]);
					forthLine.setText((String) object[3]);
					fifthLine.setText("R$".concat(((Double)object[4]).toString()));
					
					EventoEntity evento = new EventoEntity();
					evento.setEveCodigo((Integer) object[5]);
					evento.setEveValorIngresso(((Double)object[4]));
					evento.setEveTitulo((String) object[6]);
					ArtistaEntity artista = new ArtistaEntity();
					artista.setArtNome((String) object[7]);
					evento.setArtistaEntity(artista);
					Main.getUserManager().setEvento(evento);
				});
	}

	public JFrame getFrame() {
		return frame;
	}
	public void toggleFrame() {
		frame.setVisible(!frame.isVisible());
	}
}
