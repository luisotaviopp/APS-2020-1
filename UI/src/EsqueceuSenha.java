import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class EsqueceuSenha {

	private JFrame frame;
	private JTextField inputEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EsqueceuSenha window = new EsqueceuSenha();
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
	public EsqueceuSenha() {
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
		
		JLabel lblTitulo = new JLabel("ESQUECI A SENHA");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 20));
		lblTitulo.setBounds(0, 20, 882, 30);
		frame.getContentPane().add(lblTitulo);
		
		JLabel lblEmail = new JLabel("Por favor, digite o seu email.");
		lblEmail.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBounds(236, 197, 410, 40);
		frame.getContentPane().add(lblEmail);
		
		inputEmail = new JTextField();
		inputEmail.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		inputEmail.setBounds(70, 237, 740, 40);
		frame.getContentPane().add(inputEmail);
		inputEmail.setColumns(10);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnVoltar.setBounds(70, 411, 335, 40);
		frame.getContentPane().add(btnVoltar);
		
		JButton btnResetarSenha = new JButton("RESETAR SENHA");
		btnResetarSenha.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnResetarSenha.setBackground(new Color(0, 250, 154));
		btnResetarSenha.setBounds(475, 411, 335, 40);
		frame.getContentPane().add(btnResetarSenha);
	}

}
