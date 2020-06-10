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
import br.com.ies.backend.entity.SituacaoVendaEntity;
import br.com.ies.backend.entity.UsuarioEntity;
import br.com.ies.backend.entity.VendaEntity;
import br.com.ies.backend.type.PersistenceType;
import br.com.ies.backend.util.PersistenceUtil;
import br.com.ies.backend.util.Util;
import br.com.ies.frontend.builder.ComponentBuilder;

public class MeusIngressos {

	private JFrame frame;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public MeusIngressos() {
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
		persistenceParameterDTO.setParameter(String.format("SELECT ven_codigo,ev.eve_titulo FROM faturamento.venda ve " + 
				"INNER JOIN evento.evento ev ON ve.eve_codigo = ev.eve_codigo " + 
				"WHERE siv_codigo = 3 " + 
				"AND usr_codigo = '%s'", Main.getUserManager().getUsuario().getUsrCodigo()));

		
		Main.getPersistenceManager().getPersistance(PersistenceType.POSTGRES).select(persistenceParameterDTO,
				(u) ->{
				List<Object[]>	list = Util.castObjectToList(u);
				for(Object[] object : list) {
					StringJoiner stringJoiner = new StringJoiner(" - "); 
				
					Integer codigo = (Integer) object[0];
					String titulo = (String) object[1];
					
					stringJoiner.add(codigo.toString());
					stringJoiner.add(titulo);
					
					defaultList.addElement(stringJoiner.toString());
				}
		});

		JLabel firstLine = ComponentBuilder.buildLabel("", "Franklin Gothic Medium", Font.BOLD, 16, SwingConstants.LEFT, null, null, null, 470, 59, 350, 30, null);
		JLabel secondLine = ComponentBuilder.buildLabel("", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, null, null, null, 470, 102, 350, 30, null);
		JLabel thirdLine = ComponentBuilder.buildLabel("", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, null, null, null, 470, 145, 350, 30, null);
		JLabel forthLine = ComponentBuilder.buildLabel("", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, SwingConstants.LEFT, SwingConstants.TOP, null, 470, 191, 350, 30, null);
		JLabel fifthLine = ComponentBuilder.buildLabel("","Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, SwingConstants.LEFT, SwingConstants.TOP, null, 470, 234, 350, 30, null);
		
		frame.getContentPane().add(firstLine);
		frame.getContentPane().add(secondLine);
		frame.getContentPane().add(thirdLine);
		frame.getContentPane().add(forthLine);
		frame.getContentPane().add(fifthLine);
		
		
		JList<Object> listaEventos = ComponentBuilder.buildList("Franklin Gothic Medium", Font.PLAIN, 16, Color.LIGHT_GRAY, 60, 63, 350, 396, ListSelectionModel.SINGLE_SELECTION, defaultList);
		ComponentBuilder.buildEventComponent(listaEventos,
				() -> {
					PersistenceParameterDTO<String> select = new PersistenceParameterDTO<>();
					select.setParameter(String.format("SELECT eve_titulo,eve_data,fop.fop_descricao,ven.ven_qtd,vp.vep_valor FROM faturamento.venda ven " + 
							"INNER JOIN evento.evento eve ON ven.eve_codigo = eve.eve_codigo " + 
							"INNER JOIN faturamento.venda_pagamento vp ON vp.ven_codigo = ven.ven_codigo " + 
							"INNER JOIN faturamento.forma_pagamento fop ON fop.fop_codigo = vp.fop_codigo " + 
							"WHERE ven.ven_codigo = '%s' " , Integer.valueOf(listaEventos.getSelectedValue().toString().split(" - ")[0])));
					
					Main.getPersistenceManager().getPersistance(PersistenceType.POSTGRES).select(select,
							(u) ->{
							List<Object[]>	list = Util.castObjectToList(u);
							for(Object[] object : list) {
								firstLine.setText((String) object[0]);
								secondLine.setText(Util.dateToString("dd/MM/yyyy - HH", (Date) object[1]).concat("h"));
								thirdLine.setText((String) object[2]);
								forthLine.setText((String) object[3].toString().concat(" ingressos"));
								fifthLine.setText("R$ ".concat(((Double) object[4]).toString()));
							}
					});
				});
		frame.getContentPane().add(listaEventos);
		
		frame.getContentPane().add(ComponentBuilder.buildLabel("MEUS INGRESSOS", "Franklin Gothic Medium", Font.BOLD, 20, SwingConstants.CENTER, null, null, null, 341, 20, 200, 30, null));
		frame.getContentPane().add(ComponentBuilder.buildButton("VOLTAR", "Franklin Gothic Medium", Font.PLAIN, 13, 60, 482, 350, 40, null, null,
				 () -> {
						new UserDashboard().toggleFrame();
						toggleFrame();
					}));
		
		PersistenceParameterDTO<String> select = new PersistenceParameterDTO<>();
		select.setParameter(String.format("SELECT eve_titulo,eve_data,fop.fop_descricao,ven.ven_qtd,vp.vep_valor FROM faturamento.venda ven " + 
				"INNER JOIN evento.evento eve ON ven.eve_codigo = eve.eve_codigo " + 
				"INNER JOIN faturamento.venda_pagamento vp ON vp.ven_codigo = ven.ven_codigo " + 
				"INNER JOIN faturamento.forma_pagamento fop ON fop.fop_codigo = vp.fop_codigo " + 
				"WHERE ven.usr_codigo = '%s' AND siv_codigo = 3" + 
				"LIMIT 1", Main.getUserManager().getUsuario().getUsrCodigo()));

		
		Main.getPersistenceManager().getPersistance(PersistenceType.POSTGRES).select(select,
				(u) ->{
				List<Object[]>	list = Util.castObjectToList(u);
				for(Object[] object : list) {
					firstLine.setText((String) object[0]);
					secondLine.setText(Util.dateToString("dd/MM/yyyy - HH", (Date) object[1]).concat("h"));
					thirdLine.setText((String) object[2]);
					forthLine.setText((String) object[3].toString().concat(" ingressos"));
					fifthLine.setText("R$ ".concat(((Double) object[4]).toString()));
					listaEventos.setSelectedIndex(0);
				}
		});
		
		frame.getContentPane().add(ComponentBuilder.buildButton("CANCELAR COMPRA", "Franklin Gothic Medium", Font.PLAIN, 13, 470, 482, 350, 40, new Color(204, 51, 51), null,
				 () -> {
						Integer value = Integer.valueOf(listaEventos.getSelectedValue().toString().split(" - ")[0]);
						
						PersistenceParameterDTO<String> select1 = new PersistenceParameterDTO<>();
						select1.setParameter(String.format("SELECT ven_codigo, ven_data,ven_qtd,usr_codigo FROM faturamento.venda WHERE ven_codigo = '%s'", value));
						Main.getPersistenceManager().getPersistance(PersistenceType.POSTGRES).select(select1, 
								(v) ->{
									List<Object[]> list  = Util.castObjectToList(v);
									for(Object[] object : list) {
										VendaEntity venda = new VendaEntity();
										venda.setVenCodigo((Integer) object[0]);
										venda.setVenData((Date) object[1]);
										venda.setVenQtd((Integer) object[2]);
										UsuarioEntity usuario = new UsuarioEntity();
										usuario.setUsrCodigo((Integer) object[3]);
										venda.setUsuarioEntity(usuario);
										SituacaoVendaEntity situacaoVenda = new SituacaoVendaEntity();
										situacaoVenda.setSivCodigo(5);
										venda.setSituacaoVendaEntity(situacaoVenda);
										PersistenceUtil.persist(venda);
									}
									
									new MeusIngressos().toggleFrame();
									toggleFrame();
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
