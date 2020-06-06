import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class index {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					index window = new index();
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
	public index() {
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
		JLabel lblTitulo = new JLabel("BILHETERIA");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.DARK_GRAY);
		lblTitulo.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 30));
		lblTitulo.setBounds(266, 53, 350, 58);
		frame.getContentPane().add(lblTitulo);
		
		// Botão Entrar
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEntrar.setBounds(266, 440, 350, 58);
		btnEntrar.setBackground(new Color(0, 250, 154));
		frame.getContentPane().add(btnEntrar);
	}
}
