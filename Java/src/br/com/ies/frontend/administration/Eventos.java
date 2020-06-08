
package br.com.ies.frontend.administration;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import br.com.ies.frontend.builder.ComponentBuilder;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Eventos {

	private JFrame frame;
	private JTextField inputNome;
	private JTextField inputEndereco;
	private JTextField inputQuantidade;
	private JTextField inputValor;
	private JTextField inputData;

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

		JList listaEventos = new JList();
		listaEventos.setBackground(Color.LIGHT_GRAY);
		listaEventos.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 16));
		listaEventos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaEventos.setModel(new AbstractListModel() {
			String[] values = new String[] { "1 - Evento teste - 20/05/2020", "2 - Evento teste - 20/05/2020",
					"3 - Evento teste - 20/05/2020", "4 - Evento teste - 20/05/2020", "5 - Evento teste - 20/05/2020",
					"6 - Evento teste - 20/05/2020" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listaEventos.setBounds(54, 101, 258, 197);
		frame.getContentPane().add(listaEventos);
		
		frame.getContentPane().add(ComponentBuilder.buildLabel("EVENTOS", "Franklin Gothic Medium", Font.BOLD, 20, SwingConstants.CENTER, null, null, null, 0, 20, 882, 30, null));
		frame.getContentPane().add(ComponentBuilder.buildButton("DELETAR EVENTO", "Franklin Gothic Medium", Font.PLAIN, 13, 54, 365, 255, 40, null, null,
				 () -> {
						
					}));

		frame.getContentPane().add(ComponentBuilder.buildButton("EDITAR EVENTO", "Franklin Gothic Medium", Font.PLAIN, 13, 54, 424, 255, 40, null, null,
				 () -> {
						
					}));
		frame.getContentPane().add(ComponentBuilder.buildButton("VOLTAR", "Franklin Gothic Medium", Font.PLAIN, 13, 54, 479, 255, 40, null, null,
				 () -> {
						
					}));

		frame.getContentPane().add(ComponentBuilder.buildButton("CRIAR EVENTO", "Franklin Gothic Medium", Font.PLAIN, 13, 332, 479, 515, 40, new Color(0, 250, 154), null,
				 () -> {
						
					}));
		frame.getContentPane().add(ComponentBuilder.buildLabel("SELECIONE OU CRIE UM EVENTO", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.CENTER, null, null, null, 54, 79, 258, 16, null));
		// input Nome
		frame.getContentPane().add(ComponentBuilder.buildTextField("Franklin Gothic Medium", Font.PLAIN, 13, 465, 105, 382, 40, 10));
		// input Endereco
		frame.getContentPane().add(ComponentBuilder.buildTextField("Franklin Gothic Medium", Font.PLAIN, 13, 465, 207, 382, 40, 10));
		frame.getContentPane().add(ComponentBuilder.buildLabel("ENDEREÇO", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, null, null, null, 332, 209, 148, 38, null));


		inputQuantidade = new JTextField();
		inputQuantidade.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		inputQuantidade.setColumns(10);
		inputQuantidade.setBounds(465, 258, 382, 40);
		frame.getContentPane().add(inputQuantidade);

		inputValor = new JTextField();
		inputValor.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		inputValor.setColumns(10);
		inputValor.setBounds(465, 311, 382, 40);
		frame.getContentPane().add(inputValor);
		
		frame.getContentPane().add(ComponentBuilder.buildButton("VER RELATÓRIO", "Franklin Gothic Medium", Font.PLAIN, 13, 54, 311, 255, 40, null, null, null));

		JComboBox selectArtista = new JComboBox();
		selectArtista.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		selectArtista.setModel(new DefaultComboBoxModel(new String[] { "a", "b", "c", "d", "e" }));
		selectArtista.setBounds(465, 365, 382, 40);
		frame.getContentPane().add(selectArtista);

		JComboBox selectTipo = new JComboBox();
		selectTipo.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		selectTipo.setModel(new DefaultComboBoxModel(
				new String[] { "Show", "Festival", "Teatro", "Cinema", "Palestra", "Workshop" }));
		selectTipo.setBounds(465, 424, 382, 40);
		frame.getContentPane().add(selectTipo);
		
		frame.getContentPane().add(ComponentBuilder.buildLabel("ARTISTA", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, null, null, null, 332, 367, 148, 38, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("TIPO DE EVENTO", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, null, null, null, 332, 426, 148, 38, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("DATA", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, null, null, null, 332, 158, 148, 38, null));
		// input Data
		frame.getContentPane().add(ComponentBuilder.buildTextField("Franklin Gothic Medium", Font.PLAIN, 13, 465, 156, 382, 40, 10));
		frame.getContentPane().add(ComponentBuilder.buildLabel("NOME", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, null, null, null, 332, 107, 148, 38, null));
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
