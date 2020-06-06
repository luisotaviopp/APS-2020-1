package br.com.ies.frontend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdmUsuarios {

	private JFrame frame;
	private JTextField inputEmail;
	private JTextField inputNome;
	private JTextField inputUsuario;
	private JTextField inputSenhaProvisoria;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public AdmUsuarios() {
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

		JList listaUsuarios = new JList();
		listaUsuarios.setBackground(Color.LIGHT_GRAY);
		listaUsuarios.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 16));
		listaUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaUsuarios.setModel(new AbstractListModel() {
			String[] values = new String[] { "Usu\u00E1rio 1", "Usu\u00E1rio 2", "Usu\u00E1rio 3", "Usu\u00E1rio 4",
					"Usu\u00E1rio 5", "Usu\u00E1rio 6" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listaUsuarios.setBounds(29, 101, 258, 251);
		frame.getContentPane().add(listaUsuarios);

		JLabel lblTitulo = new JLabel("USU\u00C1RIOS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 20));
		lblTitulo.setBounds(0, 20, 882, 30);
		frame.getContentPane().add(lblTitulo);

		JButton btnDeletarUsuario = new JButton("DELETAR USU\u00C1RIO");
		btnDeletarUsuario.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnDeletarUsuario.setBackground(UIManager.getColor("Button.background"));
		btnDeletarUsuario.setBounds(29, 365, 255, 40);
		frame.getContentPane().add(btnDeletarUsuario);

		JButton btnEditarUsuario = new JButton("EDITAR USU\u00C1RIO");
		btnEditarUsuario.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnEditarUsuario.setBounds(29, 424, 255, 40);
		frame.getContentPane().add(btnEditarUsuario);

		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnVoltar.setBounds(29, 479, 255, 40);
		frame.getContentPane().add(btnVoltar);

		JButton btnCriarUsuario = new JButton("CRIAR USU\u00C1RIO");
		btnCriarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCriarUsuario.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnCriarUsuario.setBackground(new Color(0, 250, 154));
		btnCriarUsuario.setBounds(312, 479, 540, 40);
		frame.getContentPane().add(btnCriarUsuario);

		JLabel lblSelecioneUsuario = new JLabel("SELECIONE OU CRIE UM USU\u00C1RIO");
		lblSelecioneUsuario.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblSelecioneUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelecioneUsuario.setBounds(29, 79, 258, 16);
		frame.getContentPane().add(lblSelecioneUsuario);

		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setBounds(312, 154, 127, 40);
		frame.getContentPane().add(lblEmail);

		JButton btnConsultarLogs = new JButton("CONSULTAR LOGS");
		btnConsultarLogs.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnConsultarLogs.setBackground(new Color(204, 255, 102));
		btnConsultarLogs.setBounds(312, 424, 540, 40);
		frame.getContentPane().add(btnConsultarLogs);

		inputEmail = new JTextField();
		inputEmail.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		inputEmail.setBounds(439, 154, 413, 40);
		frame.getContentPane().add(inputEmail);
		inputEmail.setColumns(10);

		JLabel lblNome = new JLabel("NOME");
		lblNome.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome.setBounds(311, 101, 127, 40);
		frame.getContentPane().add(lblNome);

		inputNome = new JTextField();
		inputNome.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		inputNome.setColumns(10);
		inputNome.setBounds(438, 101, 414, 40);
		frame.getContentPane().add(inputNome);

		inputUsuario = new JTextField();
		inputUsuario.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		inputUsuario.setColumns(10);
		inputUsuario.setBounds(439, 207, 413, 40);
		frame.getContentPane().add(inputUsuario);

		JLabel lblUsuario = new JLabel("USU\u00C1RIO");
		lblUsuario.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsuario.setBounds(312, 207, 127, 40);
		frame.getContentPane().add(lblUsuario);

		inputSenhaProvisoria = new JTextField();
		inputSenhaProvisoria.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		inputSenhaProvisoria.setColumns(10);
		inputSenhaProvisoria.setBounds(439, 260, 413, 40);
		frame.getContentPane().add(inputSenhaProvisoria);

		JLabel lblSenhaProvisoria = new JLabel("SENHA PROVIS\u00D3RIA");
		lblSenhaProvisoria.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblSenhaProvisoria.setHorizontalAlignment(SwingConstants.LEFT);
		lblSenhaProvisoria.setBounds(312, 260, 127, 40);
		frame.getContentPane().add(lblSenhaProvisoria);

		JComboBox selectNivel = new JComboBox();
		selectNivel.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		selectNivel.setModel(new DefaultComboBoxModel(new String[] { "USU\u00C1RIO", "GERENTE", "ADMINISTRADOR" }));
		selectNivel.setBounds(439, 312, 413, 40);
		frame.getContentPane().add(selectNivel);

		JLabel lblNivel = new JLabel("N\u00CDVEL DE ACESSO");
		lblNivel.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblNivel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNivel.setBounds(312, 312, 127, 40);
		frame.getContentPane().add(lblNivel);

		JButton btnDesativarUsuario = new JButton("DESATIVAR USU\u00C1RIO");
		btnDesativarUsuario.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnDesativarUsuario.setBackground(Color.WHITE);
		btnDesativarUsuario.setBounds(312, 365, 540, 40);
		frame.getContentPane().add(btnDesativarUsuario);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void toggleFrame() {
		frame.setVisible(!frame.isVisible());
	}
}
