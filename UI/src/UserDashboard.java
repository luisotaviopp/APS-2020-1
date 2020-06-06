import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class UserDashboard {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserDashboard window = new UserDashboard();
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
	public UserDashboard() {
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
		
		JLabel lblTitulo = new JLabel("SEJA BEM VINDO");
		lblTitulo.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 30, 882, 30);
		frame.getContentPane().add(lblTitulo);
		
		JButton btnEventos = new JButton("EVENTOS");
		btnEventos.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnEventos.setBounds(27, 90, 400, 200);
		frame.getContentPane().add(btnEventos);
		
		JButton btnPerfil = new JButton("MEU PERFIL");
		btnPerfil.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnPerfil.setBounds(27, 320, 400, 200);
		frame.getContentPane().add(btnPerfil);
		
		JButton btnIngressos = new JButton("MEUS INGRESSOS");
		btnIngressos.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnIngressos.setBounds(454, 90, 400, 200);
		frame.getContentPane().add(btnIngressos);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnSair.setBounds(454, 320, 400, 200);
		frame.getContentPane().add(btnSair);
	}

}
