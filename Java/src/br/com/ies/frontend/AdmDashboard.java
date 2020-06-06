package br.com.ies.frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class AdmDashboard {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public AdmDashboard() {
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
		
		JLabel lblTitulo = new JLabel("ADMINISTRA\u00C7\u00C3O");
		lblTitulo.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 26, 882, 30);
		frame.getContentPane().add(lblTitulo);
		
		JButton btnEventos = new JButton("EVENTOS");
		btnEventos.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnEventos.setBounds(94, 82, 300, 130);
		frame.getContentPane().add(btnEventos);
		
		JButton btnUsuarios = new JButton("USU\u00C1RIOS");
		btnUsuarios.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnUsuarios.setBounds(488, 82, 300, 130);
		frame.getContentPane().add(btnUsuarios);
		
		JButton btnRelatorios = new JButton("RELAT\u00D3RIOS");
		btnRelatorios.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnRelatorios.setBounds(94, 238, 300, 130);
		frame.getContentPane().add(btnRelatorios);
		
		JButton btnArtistas = new JButton("ARTISTAS");
		btnArtistas.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnArtistas.setBounds(488, 238, 300, 130);
		frame.getContentPane().add(btnArtistas);
		
		JButton btnLogs = new JButton("LOGS");
		btnLogs.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnLogs.setBounds(94, 394, 300, 130);
		frame.getContentPane().add(btnLogs);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnSair.setBounds(488, 394, 300, 130);
		frame.getContentPane().add(btnSair);
	}

	public JFrame getFrame() {
		return frame;
	}
	public void toggleFrame() {
		frame.setVisible(!frame.isVisible());
	}

}
