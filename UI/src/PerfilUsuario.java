import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JPasswordField;

public class PerfilUsuario {

	private JFrame frame;
	private JTextField inputNome;
	private JTextField inputEmail;
	private JTextField inputUsuario;
	private JPasswordField inputSenhaAtual;
	private JPasswordField inputConfirmeSenha;
	private JPasswordField inputNovaSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfilUsuario window = new PerfilUsuario();
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
	public PerfilUsuario() {
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
		
		JLabel lblTitulo = new JLabel("MEU PERFIL");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 20));
		lblTitulo.setBounds(103, 20, 675, 30);
		frame.getContentPane().add(lblTitulo);
		
		inputNome = new JTextField();
		inputNome.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		inputNome.setToolTipText("");
		inputNome.setBounds(313, 114, 441, 30);
		frame.getContentPane().add(inputNome);
		inputNome.setColumns(10);
		
		inputEmail = new JTextField();
		inputEmail.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		inputEmail.setBounds(313, 157, 441, 30);
		frame.getContentPane().add(inputEmail);
		inputEmail.setColumns(10);
		
		inputUsuario = new JTextField();
		inputUsuario.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		inputUsuario.setBounds(313, 200, 441, 30);
		frame.getContentPane().add(inputUsuario);
		inputUsuario.setColumns(10);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnVoltar.setBounds(127, 469, 300, 40);
		frame.getContentPane().add(btnVoltar);
		
		JLabel lblDadosPessoais = new JLabel("DADOS PESSOAIS");
		lblDadosPessoais.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 13));
		lblDadosPessoais.setHorizontalAlignment(SwingConstants.LEFT);
		lblDadosPessoais.setBounds(127, 78, 250, 30);
		frame.getContentPane().add(lblDadosPessoais);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblNome.setBounds(127, 121, 56, 16);
		frame.getContentPane().add(lblNome);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblEmail.setBounds(127, 164, 56, 16);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblUsuario = new JLabel("Usu\u00E1rio");
		lblUsuario.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblUsuario.setBounds(127, 207, 56, 16);
		frame.getContentPane().add(lblUsuario);
		
		JLabel lblRedefinirSenha = new JLabel("REDEFINIR SENHA");
		lblRedefinirSenha.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 13));
		lblRedefinirSenha.setHorizontalAlignment(SwingConstants.LEFT);
		lblRedefinirSenha.setBounds(127, 280, 250, 30);
		frame.getContentPane().add(lblRedefinirSenha);
		
		JButton btnAtualizar = new JButton("ATUALIZAR");
		btnAtualizar.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnAtualizar.setBackground(new Color(0, 250, 154));
		btnAtualizar.setBounds(454, 469, 300, 40);
		frame.getContentPane().add(btnAtualizar);
		
		JLabel lblSenhaAtual = new JLabel("Senha atual");
		lblSenhaAtual.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblSenhaAtual.setBounds(127, 409, 81, 16);
		frame.getContentPane().add(lblSenhaAtual);
		
		JLabel lblNovaSenha = new JLabel("Nova senha");
		lblNovaSenha.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblNovaSenha.setBounds(127, 323, 73, 16);
		frame.getContentPane().add(lblNovaSenha);
		
		JLabel lblConfirmeSenha = new JLabel("Confirme a nova senha");
		lblConfirmeSenha.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblConfirmeSenha.setBounds(127, 366, 145, 16);
		frame.getContentPane().add(lblConfirmeSenha);
		
		inputSenhaAtual = new JPasswordField();
		inputSenhaAtual.setBounds(313, 402, 441, 30);
		frame.getContentPane().add(inputSenhaAtual);
		
		inputConfirmeSenha = new JPasswordField();
		inputConfirmeSenha.setBounds(313, 359, 441, 30);
		frame.getContentPane().add(inputConfirmeSenha);
		
		inputNovaSenha = new JPasswordField();
		inputNovaSenha.setBounds(313, 316, 441, 30);
		frame.getContentPane().add(inputNovaSenha);
	}

}