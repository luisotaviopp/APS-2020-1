package br.com.ies.frontend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;

public class Registro {

	private JFrame frame;
	private JTextField inputNome;
	private JTextField inputUsuario;
	private JTextField inputEmail;
	private JPasswordField inputSenha;
	private JPasswordField inputConfirmarSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro window = new Registro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registro() {
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

		JLabel lblTiulo = new JLabel("REGISTRO");
		lblTiulo.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 20));
		lblTiulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTiulo.setBounds(0, 20, 882, 34);
		frame.getContentPane().add(lblTiulo);

		JLabel lblNome = new JLabel("NOME COMPLETO");
		lblNome.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setBounds(382, 91, 118, 16);
		frame.getContentPane().add(lblNome);

		inputNome = new JTextField();
		inputNome.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		inputNome.setBounds(101, 120, 680, 40);
		frame.getContentPane().add(inputNome);
		inputNome.setColumns(10);

		JLabel lblUsuario = new JLabel("USU\u00C1RIO");
		lblUsuario.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblUsuario.setBounds(413, 173, 56, 16);
		frame.getContentPane().add(lblUsuario);

		inputUsuario = new JTextField();
		inputUsuario.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		inputUsuario.setBounds(101, 202, 680, 40);
		frame.getContentPane().add(inputUsuario);
		inputUsuario.setColumns(10);

		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBounds(413, 261, 56, 16);
		frame.getContentPane().add(lblEmail);

		inputEmail = new JTextField();
		inputEmail.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		inputEmail.setBounds(101, 290, 680, 40);
		frame.getContentPane().add(inputEmail);
		inputEmail.setColumns(10);

		JLabel lblSenha = new JLabel("SENHA");
		lblSenha.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setBounds(240, 354, 56, 16);
		frame.getContentPane().add(lblSenha);

		JLabel lblConfirmarSenha = new JLabel("CONFIRMAR SENHA");
		lblConfirmarSenha.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblConfirmarSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmarSenha.setBounds(550, 354, 126, 16);
		frame.getContentPane().add(lblConfirmarSenha);

		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnVoltar.setBounds(101, 455, 335, 40);
		frame.getContentPane().add(btnVoltar);

		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnRegistrar.setForeground(Color.BLACK);
		btnRegistrar.setBackground(new Color(0, 250, 154));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegistrar.setBounds(446, 455, 335, 40);
		frame.getContentPane().add(btnRegistrar);

		inputSenha = new JPasswordField();
		inputSenha.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		inputSenha.setBounds(101, 383, 335, 40);
		frame.getContentPane().add(inputSenha);

		inputConfirmarSenha = new JPasswordField();
		inputConfirmarSenha.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		inputConfirmarSenha.setBounds(446, 383, 335, 40);
		frame.getContentPane().add(inputConfirmarSenha);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void toggleFrame() {
		frame.setVisible(!frame.isVisible());
	}
}
