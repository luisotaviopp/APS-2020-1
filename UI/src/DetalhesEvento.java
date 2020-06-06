import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DetalhesEvento {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetalhesEvento window = new DetalhesEvento();
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
	public DetalhesEvento() {
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
		
		JLabel lblTitulo = new JLabel("NOME DO EVENTO");
		lblTitulo.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 20, 882, 20);
		frame.getContentPane().add(lblTitulo);
		
		JLabel lblArtista = new JLabel("ARTISTA");
		lblArtista.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblArtista.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtista.setBounds(0, 65, 882, 16);
		frame.getContentPane().add(lblArtista);
		
		JLabel lblEndereco = new JLabel("Rua Lorem Ipsum, 6669 - Centro - Florian\u00F3polis");
		lblEndereco.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblEndereco.setHorizontalAlignment(SwingConstants.CENTER);
		lblEndereco.setBounds(0, 121, 882, 35);
		frame.getContentPane().add(lblEndereco);
		
		JLabel lblIngressos = new JLabel("Ingressos dispon\u00EDveis: 250");
		lblIngressos.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblIngressos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngressos.setBounds(0, 307, 882, 16);
		frame.getContentPane().add(lblIngressos);
		
		JLabel lblValor = new JLabel("R$100,00");
		lblValor.setHorizontalAlignment(SwingConstants.CENTER);
		lblValor.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 16));
		lblValor.setBounds(0, 336, 882, 16);
		frame.getContentPane().add(lblValor);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnVoltar.setBounds(94, 455, 300, 40);
		frame.getContentPane().add(btnVoltar);
		
		JButton btnComprar = new JButton("COMPRAR INGRESSOS");
		btnComprar.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnComprar.setBackground(new Color(0, 250, 154));
		btnComprar.setBounds(488, 455, 300, 40);
		frame.getContentPane().add(btnComprar);
		
		JLabel lblData = new JLabel("25/05/2020");
		lblData.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setBounds(0, 228, 882, 35);
		frame.getContentPane().add(lblData);
	}
}
