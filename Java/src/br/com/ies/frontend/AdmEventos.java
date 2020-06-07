
package br.com.ies.frontend;

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
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdmEventos {

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
	public AdmEventos() {
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

		JLabel lblEventos = new JLabel("EVENTOS");
		lblEventos.setHorizontalAlignment(SwingConstants.CENTER);
		lblEventos.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 20));
		lblEventos.setBounds(0, 20, 882, 30);
		frame.getContentPane().add(lblEventos);

		JButton btnDeletarEvento = new JButton("DELETAR EVENTO");
		btnDeletarEvento.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnDeletarEvento.setBounds(54, 365, 255, 40);
		frame.getContentPane().add(btnDeletarEvento);

		JButton btnEditarEvento = new JButton("EDITAR EVENTO");
		btnEditarEvento.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnEditarEvento.setBounds(54, 424, 255, 40);
		frame.getContentPane().add(btnEditarEvento);

		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnVoltar.setBounds(54, 479, 255, 40);
		frame.getContentPane().add(btnVoltar);

		JButton btnCriarEvento = new JButton("CRIAR EVENTO");
		btnCriarEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCriarEvento.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnCriarEvento.setBackground(new Color(0, 250, 154));
		btnCriarEvento.setBounds(332, 479, 515, 40);
		frame.getContentPane().add(btnCriarEvento);

		JLabel lblSelecioneEvento = new JLabel("SELECIONE OU CRIE UM EVENTO");
		lblSelecioneEvento.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblSelecioneEvento.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelecioneEvento.setBounds(54, 79, 258, 16);
		frame.getContentPane().add(lblSelecioneEvento);

		inputNome = new JTextField();
		inputNome.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		inputNome.setBounds(465, 105, 382, 40);
		frame.getContentPane().add(inputNome);
		inputNome.setColumns(10);

		inputEndereco = new JTextField();
		inputEndereco.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		inputEndereco.setColumns(10);
		inputEndereco.setBounds(465, 207, 382, 40);
		frame.getContentPane().add(inputEndereco);

		JLabel lblEndereco = new JLabel("ENDERE\u00C7O");
		lblEndereco.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblEndereco.setHorizontalAlignment(SwingConstants.LEFT);
		lblEndereco.setBounds(332, 209, 148, 38);
		frame.getContentPane().add(lblEndereco);

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

		JButton btnVerRelatorio = new JButton("VER RELAT\u00D3RIO");
		btnVerRelatorio.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnVerRelatorio.setBounds(54, 311, 255, 40);
		frame.getContentPane().add(btnVerRelatorio);

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

		JLabel lblArtista = new JLabel("ARTISTA");
		lblArtista.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblArtista.setHorizontalAlignment(SwingConstants.LEFT);
		lblArtista.setBounds(332, 367, 148, 38);
		frame.getContentPane().add(lblArtista);

		JLabel lblTipo = new JLabel("TIPO DE EVENTO");
		lblTipo.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblTipo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTipo.setBounds(332, 426, 148, 38);
		frame.getContentPane().add(lblTipo);

		JLabel lblData = new JLabel("DATA");
		lblData.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblData.setHorizontalAlignment(SwingConstants.LEFT);
		lblData.setBounds(332, 158, 148, 38);
		frame.getContentPane().add(lblData);

		inputData = new JTextField();
		inputData.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		inputData.setColumns(10);
		inputData.setBounds(465, 156, 382, 40);
		frame.getContentPane().add(inputData);

		JLabel lblNome = new JLabel("NOME");
		lblNome.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome.setBounds(332, 107, 148, 38);
		frame.getContentPane().add(lblNome);

		JLabel lblValor = new JLabel("VALOR DO INGRESSO");
		lblValor.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblValor.setHorizontalAlignment(SwingConstants.LEFT);
		lblValor.setBounds(332, 313, 133, 38);
		frame.getContentPane().add(lblValor);

		JLabel lblQuantidade = new JLabel("QUANTIDADE");
		lblQuantidade.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblQuantidade.setHorizontalAlignment(SwingConstants.LEFT);
		lblQuantidade.setBounds(332, 260, 148, 38);
		frame.getContentPane().add(lblQuantidade);
	}
	public JFrame getFrame() {
		return frame;
	}
	public void toggleFrame() {
		frame.setVisible(!frame.isVisible());
	}
}
