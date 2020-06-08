package br.com.ies.frontend.administration;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import br.com.ies.backend.Main;
import br.com.ies.backend.dto.PersistenceParameterDTO;
import br.com.ies.backend.type.PersistenceType;
import br.com.ies.backend.util.Util;
import br.com.ies.frontend.builder.ComponentBuilder;
import br.com.ies.frontend.util.RelatoriosDisponiveis;

public class Relatorio {

	private JFrame frame;
	private JScrollPane scrollPaneTabela = new JScrollPane();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Relatorio() {
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

		JPanel panelBotoes = new JPanel(new GridLayout(RelatoriosDisponiveis.values().length, 1));
		panelBotoes.setIgnoreRepaint(true);
		for (RelatoriosDisponiveis relatorio : RelatoriosDisponiveis.values()) {
			panelBotoes.add(ComponentBuilder.buildButton(relatorio.getTitulo(), "Franklin Gothic Medium", Font.PLAIN, 13,0, 0, 200, 50, null, null,
				() -> {
					selectRel(relatorio);
				}));
		}
		
		JScrollPane scrollPaneBotoes = new JScrollPane(panelBotoes);
		scrollPaneBotoes.setBounds(50,63, 200, 400);
		scrollPaneBotoes.setIgnoreRepaint(true);
		
		frame.getContentPane().add(scrollPaneBotoes);

		frame.getContentPane().add(ComponentBuilder.buildLabel("RELATÓRIOS","Franklin Gothic Medium", Font.BOLD, 20, SwingConstants.CENTER, null, null, null, 341, 20, 200, 30, null));
		
	}

	public void selectRel(RelatoriosDisponiveis relatorio) {
		this.frame.remove(scrollPaneTabela);


		PersistenceParameterDTO<String> persistenceParameterDTO = new PersistenceParameterDTO<>();
		persistenceParameterDTO.setParameter(relatorio.getQuery());

		Main.getPersistenceManager().getPersistance(PersistenceType.POSTGRES).select(persistenceParameterDTO, 
				(u) ->{
					List<Object[]> list = Util.castObjectToList(u);
					
					String[] columns = relatorio.getColunas().split(",");
					String[][] data = dataFormat(columns.length, list);
					
					final JTable table = new JTable(new DefaultTableModel(data, columns) {
						@Override
						public Class getColumnClass(int column) {
							return getValueAt(0, column).getClass();
						}
					});
					
					table.setBounds(0, 0, scrollPaneTabela.getWidth(), scrollPaneTabela.getHeight());
					
					scrollPaneTabela = new JScrollPane(table);
					scrollPaneTabela.setBounds(250, 63, 600, 400);
					frame.getContentPane().add(scrollPaneTabela);
					
					this.frame.repaint();
				});

	}

	public String[][] dataFormat(int colCount, List<Object[]> lista){
		NumberFormat numberFormat = new DecimalFormat("##,##0.00");
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		String[][] ret = new String[lista.size()][colCount];
		
		for (int i = 0; i < lista.size(); i++) {
			for (int j = 0; j < lista.get(i).length; j++) {
				if(lista.get(i)[j] instanceof Double || lista.get(i)[j] instanceof Float) {
					ret[i][j] = numberFormat.format((Number) lista.get(i)[j]);
				} if (lista.get(i)[j] instanceof Date) {
					ret[i][j] = dateFormat.format((Date) lista.get(i)[j]);
				} else {
					ret[i][j] = lista.get(i)[j].toString();
				}
			}
		}
		
		return ret;
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public void toggleFrame() {
		frame.setVisible(!frame.isVisible());
	}

}
