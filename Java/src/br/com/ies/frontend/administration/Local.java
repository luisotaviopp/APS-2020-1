package br.com.ies.frontend.administration;

import java.awt.Color;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.StringJoiner;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import br.com.ies.backend.Main;
import br.com.ies.backend.dto.PersistenceParameterDTO;
import br.com.ies.backend.entity.LocalEntity;
import br.com.ies.backend.type.PersistenceType;
import br.com.ies.backend.util.PersistenceUtil;
import br.com.ies.backend.util.Util;
import br.com.ies.frontend.builder.ComponentBuilder;
import br.com.ies.frontend.util.Constants;

public class Local {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public Local() {
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
		persistenceParameterDTO2.setParameter("SELECT loc_codigo,loc_logradouro FROM evento.local");
		
		Main.getPersistenceManager().getPersistance(PersistenceType.POSTGRES).select(persistenceParameterDTO2,
				(u) ->{
				List<Object[]>	list = Util.castObjectToList(u);
				for(Object[] object : list) {
					StringJoiner stringJoiner = new StringJoiner(" - "); 
				
					Integer codigo = (Integer) object[0];
					String logradouro = (String) object[1];
					
					stringJoiner.add(codigo.toString());
					stringJoiner.add(logradouro);
					defaultList.addElement(stringJoiner.toString());
					
				}
		});
		
		JList<Object> listaLocais = ComponentBuilder.buildList("Franklin Gothic Medium", Font.PLAIN, 16, Color.LIGHT_GRAY, 29, 101, 258, 251, ListSelectionModel.SINGLE_SELECTION, defaultList);
		frame.getContentPane().add(listaLocais);
		
		//DAQUI PRA BAIXO
		frame.getContentPane().add(ComponentBuilder.buildLabel("LOCAIS", "Franklin Gothic Medium", Font.BOLD, 20, SwingConstants.CENTER, null, null, null, 0, 20, 882, 30, null));

		JLabel lblSelecioneUsuario = new JLabel("SELECIONE OU CRIE UM LOCAL");
		lblSelecioneUsuario.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblSelecioneUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelecioneUsuario.setBounds(30, 79, 258, 16);
		frame.getContentPane().add(lblSelecioneUsuario);
		
		frame.getContentPane().add(ComponentBuilder.buildLabel("LOGRADOURO", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, null, null, null, 311, 101, 127, 40, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("NUMERO", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, null, null, null, 312, 154, 127, 40, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("BAIRRO", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, null, null, null, 312, 207, 127, 40, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("CIDADE", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, null, null, null, 312, 260, 127, 40, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("UF", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, null, null, null, 312, 312, 127, 40, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("LOTAÇÃO MAXIMA", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, null, null, null, 312, 365, 127, 40, null));
		
		
		JTextField inputLogradouro =  ComponentBuilder.buildTextField("Franklin Gothic Medium", Font.PLAIN, 13, 476, 101, 376, 40, 10);
		JTextField inputNumero  = ComponentBuilder.buildTextField("Franklin Gothic Medium", Font.PLAIN, 13, 476, 154, 376, 40, 5);
		JTextField inputBairro = ComponentBuilder.buildTextField("Franklin Gothic Medium", Font.PLAIN, 13, 476, 207, 376, 40, 10);
		JTextField inputCidade = ComponentBuilder.buildTextField("Franklin Gothic Medium", Font.PLAIN, 13, 476, 260, 376, 40, 10);
		JTextField inputUF = ComponentBuilder.buildTextField("Franklin Gothic Medium", Font.PLAIN, 13, 476, 312, 376, 40, 2);
		JTextField inputLotacaoMaxima = ComponentBuilder.buildTextField("Franklin Gothic Medium", Font.PLAIN, 13, 476, 365, 376, 40, 10);

		frame.getContentPane().add(inputLogradouro);
		frame.getContentPane().add(inputNumero);
		frame.getContentPane().add(inputBairro);
		frame.getContentPane().add(inputCidade);
		frame.getContentPane().add(inputUF);
		frame.getContentPane().add(inputLotacaoMaxima);
		
		frame.getContentPane().add(ComponentBuilder.buildButton("DELETAR LOCAL","Franklin Gothic Medium", Font.PLAIN, 13, 32, 418, 255, 40, null, null,
				() -> {
					if(listaLocais.getSelectedValue() ==null)return;
					Integer id = Integer.valueOf(listaLocais.getSelectedValue().toString().split(" - ")[0]);
					try {
					PreparedStatement preparedStatement = Main.getConnectionFactory().getPreparedStatement(String.format("DELETE FROM evento.local WHERE loc_codigo = '%s'", id));
					preparedStatement.execute();
					preparedStatement.close();
					new Local().toggleFrame();
					toggleFrame();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}));
		
		frame.getContentPane().add(ComponentBuilder.buildButton("EDITAR LOCAL","Franklin Gothic Medium", Font.PLAIN, 13, 312, 418, 540, 40, null, null,
				() -> {
					if(listaLocais.getSelectedValue() ==null)return;
					Integer id = Integer.valueOf(listaLocais.getSelectedValue().toString().split(" - ")[0]);
					
					PersistenceParameterDTO<String> select1 = new PersistenceParameterDTO<>();
					select1.setParameter(String.format("SELECT loc_codigo, loc_logradouro, loc_numero, loc_bairro, loc_cidade, loc_uf, loc_lotacao_maxima"
							+ " FROM evento.local  WHERE loc_codigo='%s'",id));
					
					Main.getPersistenceManager().getPersistance(PersistenceType.POSTGRES).select(select1,
							(u) ->{
								List<Object[]> list = Util.castObjectToList(u);
								Object[] object = list.get(0);
								
								inputLogradouro.setText(String.valueOf(object[1]));
								inputNumero.setText(String.valueOf(object[2]));
								inputBairro.setText(String.valueOf(object[3]));
								inputCidade.setText(String.valueOf(object[4]));
								inputUF.setText(String.valueOf(object[5]));
								inputLotacaoMaxima.setText(String.valueOf(object[6]));
							});
				}));
		
		frame.getContentPane().add(ComponentBuilder.buildButton("VOLTAR","Franklin Gothic Medium", Font.PLAIN, 13, 32, 479, 255, 40, null, null,
				() -> {
					new AdministratorDashboard().toggleFrame();
					toggleFrame();
				}));
		
		frame.getContentPane().add(ComponentBuilder.buildButton("CRIAR LOCAL","Franklin Gothic Medium", Font.PLAIN, 13, 312, 479, 540, 40, new Color(0, 250, 154), null,
				() -> {
					LocalEntity local = new LocalEntity();
					
					if(listaLocais.getSelectedValue() != null) {
						local.setLocCodigo(Integer.valueOf(Integer.valueOf(listaLocais.getSelectedValue().toString().split(" - ")[0])));
					}
					local.setLocLogradouro(inputLogradouro.getText());
					local.setLocNumero(inputNumero.getText());
					local.setLocBairro(inputBairro.getText());
					local.setLocCidade(inputCidade.getText());
					local.setLocUf(inputUF.getText());
					local.setLocLotacaoMaxima(Integer.parseInt(inputLotacaoMaxima.getText()));

					PersistenceUtil.persist(local);
					Util.showMessage(Constants.LOCAL_REGISTRED);
					new Local().toggleFrame();
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
