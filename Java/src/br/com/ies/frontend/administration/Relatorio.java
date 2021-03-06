package br.com.ies.frontend.administration;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JFileChooser;
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
import br.com.ies.frontend.util.CSVUtils;
import br.com.ies.frontend.util.RelatoriosDisponiveis;

public class Relatorio {

	private JFrame frame;
	private JScrollPane scrollPaneTabela = new JScrollPane();
	
	private String[][] currentValue;
	private String[] currentColumn;

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

		JPanel panelBotoes = new JPanel(new GridLayout(RelatoriosDisponiveis.values().length + 1, 1));
		panelBotoes.setIgnoreRepaint(true);
		for (RelatoriosDisponiveis relatorio : RelatoriosDisponiveis.values()) {
			panelBotoes.add(ComponentBuilder.buildButton(relatorio.getTitulo(), "Franklin Gothic Medium", Font.PLAIN, 13,0, 0, 200, 50, null, null,
				() -> {
					selectRel(relatorio);
				}));
		}
		
		panelBotoes.add(ComponentBuilder.buildButton("Salvar como CSV", "Franklin Gothic Medium", Font.PLAIN, 13,0, 0, 200, 50, new Color(120, 255, 120), null,
				() -> {
					if(currentValue != null && currentValue.length > 0 ) {
						openSaveDialog();
					} else {
						Util.showMessage("Nenhum dado para ser exportado");
					}
				}));
		
		JScrollPane scrollPaneBotoes = new JScrollPane(panelBotoes);
		scrollPaneBotoes.setBounds(50,63, 200, 400);
		scrollPaneBotoes.setIgnoreRepaint(true);
		
		frame.getContentPane().add(scrollPaneBotoes);
		
		frame.getContentPane().add(ComponentBuilder.buildLabel("RELATÓRIOS","Franklin Gothic Medium", Font.BOLD, 20, SwingConstants.CENTER, null, null, null, 341, 20, 200, 30, null));
		frame.getContentPane().add(ComponentBuilder.buildButton("VOLTAR", "Franklin Gothic Medium", Font.PLAIN, 13,281, 480, 335, 40, null, null,
				() -> {
					new AdministratorDashboard().toggleFrame();
					toggleFrame();
				}));
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
						/**
						 * 
						 */
						private static final long serialVersionUID = -7518643323382537984L;

						@Override
						public Class<?> getColumnClass(int column) {
							return getValueAt(0, column).getClass();
						}
					});
					
					table.setBounds(0, 0, scrollPaneTabela.getWidth(), scrollPaneTabela.getHeight());
					
					scrollPaneTabela = new JScrollPane(table);
					scrollPaneTabela.setBounds(250, 63, 600, 400);
					frame.getContentPane().add(scrollPaneTabela);
					
					this.frame.repaint();
					
					currentColumn = columns;
					currentValue = data;
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
				} else if (lista.get(i)[j] instanceof Date) {
					ret[i][j] = dateFormat.format((Date) lista.get(i)[j]);
				} else {
					ret[i][j] = lista.get(i)[j].toString();
				}
			}
		}
		
		return ret;
	}
	
	public void openSaveDialog() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to save");   
		 
		int userSelection = fileChooser.showSaveDialog(frame);
		 
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			String extName = null;
			
			if(file.getName().lastIndexOf(".") != -1){
				extName = file.getName().substring(file.getName().lastIndexOf("."));
			}  else if (file.getName().isEmpty()) {
			}
			
			if(extName == null){
				file = new File(file.toString() + ".csv");
			} else if(!extName.equals(".csv")) {
			    file = new File(file.toString().replace(extName, ".csv")); 
			}
			
			exportCsv(file);
		}
	}
	
	public void exportCsv(File file) {
		Boolean exported = CSVUtils.saveToCSV(file, currentValue, currentColumn);
		
		if(!exported) {
			Util.showMessage("Erro ao exportar arquivo");
		}
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public void toggleFrame() {
		frame.setVisible(!frame.isVisible());
	}

}
