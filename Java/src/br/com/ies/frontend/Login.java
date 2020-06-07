package br.com.ies.frontend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import br.com.ies.frontend.builder.ComponentBuilder;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frame;
	private JLabel lblNome;
	private JLabel lblSenha;
	private JButton btnRegistrar;
	private JButton btnEsqueciSenha;
	private JPasswordField inputSenha;
	private JTextField inputUsuario;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Login() {
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
		
		//Título
//		JLabel lblTitulo = new JLabel("BILHETERIA");
//		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
//		lblTitulo.setForeground(Color.DARK_GRAY);
//		lblTitulo.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 20));
//		lblTitulo.setBounds(266, 23, 350, 58);
//		frame.getContentPane().add(lblTitulo);
		
		frame.getContentPane().add(ComponentBuilder.buildLabel("BILHETERIA", "Franklin Gothic Medium", Font.BOLD,
				20, SwingConstants.CENTER, 266, 23, 350, 58));
		
		frame.getContentPane().add(ComponentBuilder.buildButton("ENTRAR", "Franklin Gothic Medium", Font.PLAIN, 13, 266, 321, 350, 40, new Color(0, 250, 154), null, () -> {
			new AdmDashboard().toggleFrame();
			toggleFrame();
		}));
		
		// Label Username
		lblNome = new JLabel("NOME");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 16));
		lblNome.setBounds(356, 104, 170, 40);
		frame.getContentPane().add(lblNome);

		// Label Senha
		lblSenha = new JLabel("SENHA");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 16));
		lblSenha.setBounds(356, 197, 170, 40);
		frame.getContentPane().add(lblSenha);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnRegistrar.setBounds(266, 384, 350, 40);
		frame.getContentPane().add(btnRegistrar);
		
		inputSenha = new JPasswordField();
		inputSenha.setBounds(266, 238, 350, 41);
		frame.getContentPane().add(inputSenha);
		
		inputUsuario = new JTextField();
		inputUsuario.setBounds(266, 143, 350, 41);
		frame.getContentPane().add(inputUsuario);
		inputUsuario.setColumns(10);
	}
	public JFrame getFrame() {
		return frame;
	}
	public void toggleFrame() {
		frame.setVisible(!frame.isVisible());
	}
}
