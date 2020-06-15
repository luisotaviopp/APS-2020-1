package br.com.ies.frontend.administration;

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
import br.com.ies.backend.type.PersistenceType;
import br.com.ies.backend.util.Util;
import br.com.ies.frontend.builder.ComponentBuilder;

public class Logs {

	private JFrame frame;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Logs() {
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

		
		JLabel usuarioLabel = ComponentBuilder.buildLabel("", "Franklin Gothic Medium", Font.BOLD, 16, SwingConstants.LEFT, null, null, null, 470, 59, 350, 30, null);
		JLabel dataLabel = ComponentBuilder.buildLabel("","Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, null, null, null, 470, 102, 350, 30, null);
		JLabel logLabel = ComponentBuilder.buildLabel("","Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, SwingConstants.LEFT, SwingConstants.TOP, null, 470, 145, 350, 314, null);
		
		frame.getContentPane().add(usuarioLabel);
		frame.getContentPane().add(dataLabel);
		frame.getContentPane().add(logLabel);

		
		DefaultListModel<Object> defaultList = new DefaultListModel<Object>();
		JList<Object> listaLogs = ComponentBuilder.buildList("Franklin Gothic Medium", Font.PLAIN, 16, Color.LIGHT_GRAY, 60, 63, 350, 396, ListSelectionModel.SINGLE_SELECTION, defaultList);
		PersistenceParameterDTO<String> select = new PersistenceParameterDTO<String>();
		select.setParameter("SELECT ca.coa_codigo,usr_login, coa_data FROM usuario.controle_acesso ca " + 
				"INNER JOIN usuario.usuario usr ON ca.usr_codigo = usr.usr_codigo");
		Main.getPersistenceManager().getPersistance(PersistenceType.POSTGRES).select(select,
				(u) ->{
					List<Object[]> list = Util.castObjectToList(u);
					for(Object[] user : list) {
						StringJoiner stringJoiner = new StringJoiner(" - ");
						stringJoiner.add(user[0].toString());
						stringJoiner.add(user[1].toString());
						stringJoiner.add(user[2].toString());
						defaultList.addElement(stringJoiner.toString());
					}
					listaLogs.setSelectedIndex(0);
					
					usuarioLabel.setText(list.get(0)[0].toString());
					dataLabel.setText(Util.dateToString("dd/MM/yyyy", (Date) list.get(0)[2]));
					logLabel.setText("Logou-se");
					
				});
		
		ComponentBuilder.buildEventComponent(listaLogs, 
				() -> {
					PersistenceParameterDTO<String> select1 = new PersistenceParameterDTO<String>();
					select1.setParameter(String.format("SELECT ca.coa_codigo,usr_login, coa_data FROM usuario.controle_acesso ca " + 
							"INNER JOIN usuario.usuario usr ON ca.usr_codigo = usr.usr_codigo WHERE ca.coa_codigo = '%s'", Integer.parseInt(listaLogs.getSelectedValue().toString().split(" - ")[0])));
					Main.getPersistenceManager().getPersistance(PersistenceType.POSTGRES).select(select1, 
							(u) ->{
								List<Object[]> list = Util.castObjectToList(u);
								usuarioLabel.setText(list.get(0)[0].toString());
								dataLabel.setText(Util.dateToString("dd/MM/yyyy", (Date) list.get(0)[2]));
								logLabel.setText("Logou-se");
							});
				});
		
		frame.getContentPane().add(listaLogs);
		
		frame.getContentPane().add(ComponentBuilder.buildLabel("LOGS", "Franklin Gothic Medium", Font.BOLD, 20, SwingConstants.CENTER, null, null, null, 341, 20, 200, 30, null));
		frame.getContentPane().add(ComponentBuilder.buildButton("VOLTAR", "Franklin Gothic Medium", Font.PLAIN, 13, 60, 482, 350, 40, null, null,
				 () -> {
						new AdministratorDashboard().toggleFrame();
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
