package br.com.ies.frontend.administration;

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

import br.com.ies.frontend.builder.ComponentBuilder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Usuarios {

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
	public Usuarios() {
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

		
		frame.getContentPane().add(ComponentBuilder.buildLabel("USUÁRIOS", "Franklin Gothic Medium", Font.BOLD, 20, SwingConstants.CENTER, null, null, null, 0, 20, 882, 30, null));
		frame.getContentPane().add(ComponentBuilder.buildButton("DELETAR USUÁRIO", "Franklin Gothic Medium", Font.PLAIN, 13, 29, 365, 255, 40, UIManager.getColor("Button.background"), null,
				 () -> {
						
					}));
		frame.getContentPane().add(ComponentBuilder.buildButton("EDITAR USUÁRIO", "Franklin Gothic Medium", Font.PLAIN, 13, 29, 424, 255, 40, null, null,
				 () -> {
						
					}));
		frame.getContentPane().add(ComponentBuilder.buildButton("VOLTAR","Franklin Gothic Medium", Font.PLAIN, 13, 29, 479, 255, 40, null, null,
				 () -> {
						
					}));
		frame.getContentPane().add(ComponentBuilder.buildButton("CRIAR USUÁRIO", "Franklin Gothic Medium", Font.PLAIN, 13, 312, 479, 540, 40, new Color(0, 250, 154), null,
				 () -> {
						
					}));

		frame.getContentPane().add(ComponentBuilder.buildLabel("SELECIONE OU CRIE UM USUÁRIO", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.CENTER, null, null, null, 29, 79, 258, 16, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("EMAIL", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, null, null, null, 312, 154, 127, 40, null));
		frame.getContentPane().add(ComponentBuilder.buildButton("CONSULTAR LOGS", "Franklin Gothic Medium", Font.PLAIN, 13, 312, 424, 540, 40, new Color(204, 255, 102), null,
				 () -> {
						
					}));
		frame.getContentPane().add(ComponentBuilder.buildTextField("Franklin Gothic Medium", Font.PLAIN, 13, 439, 154, 413, 40, 10));
		frame.getContentPane().add(ComponentBuilder.buildLabel("NOME", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, null, null, null, 311, 101, 127, 40, null));
		frame.getContentPane().add(ComponentBuilder.buildTextField("Franklin Gothic Medium", Font.PLAIN, 13, 438, 101, 414, 40, 10));
		frame.getContentPane().add(ComponentBuilder.buildTextField("Franklin Gothic Medium", Font.PLAIN, 13, 439, 207, 413, 40, 10));
		frame.getContentPane().add(ComponentBuilder.buildLabel("USUÁRIO", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, null, null, null, 312, 207, 127, 40, null));
		frame.getContentPane().add(ComponentBuilder.buildTextField("Franklin Gothic Medium", Font.PLAIN, 13, 439, 260, 413, 40, 10));
		frame.getContentPane().add(ComponentBuilder.buildLabel("SENHA PROVISÓRIA", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.LEFT, null, null, null, 312, 260, 127, 40, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("NÍVEL DE ACESSO", "Franklin Gothic Medium", Font.PLAIN, 13, null, null, null, null, 312, 312, 127, 40, null));
		frame.getContentPane().add(ComponentBuilder.buildButton("DESATIVAR USUÁRIO", "Franklin Gothic Medium", Font.PLAIN, 13, 312, 365, 540, 40, Color.WHITE, null,
				 () -> {
						
					}));
		
		JComboBox selectNivel = new JComboBox();
		selectNivel.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		selectNivel.setModel(new DefaultComboBoxModel(new String[] { "USU\u00C1RIO", "GERENTE", "ADMINISTRADOR" }));
		selectNivel.setBounds(439, 312, 413, 40);
		frame.getContentPane().add(selectNivel);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void toggleFrame() {
		frame.setVisible(!frame.isVisible());
	}
}
