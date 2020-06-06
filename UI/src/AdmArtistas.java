import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import java.awt.Color;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdmArtistas {

	private JFrame frame;
	private JTextField inputNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdmArtistas window = new AdmArtistas();
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
	public AdmArtistas() {
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
		
		JList listaArtistas = new JList();
		listaArtistas.setBackground(Color.LIGHT_GRAY);
		listaArtistas.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 16));
		listaArtistas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaArtistas.setModel(new AbstractListModel() {
			String[] values = new String[] {"Artista 01", "Artista 02", "Artista 03", "Artista 04", "Artista 05", "Artista 06"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listaArtistas.setBounds(54, 101, 258, 251);
		frame.getContentPane().add(listaArtistas);
		
		JLabel lblTitulo = new JLabel("ARTISTAS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 20));
		lblTitulo.setBounds(0, 20, 882, 30);
		frame.getContentPane().add(lblTitulo);
		
		JButton btnDeletarArtista = new JButton("DELETAR ARTISTA");
		btnDeletarArtista.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnDeletarArtista.setBounds(54, 365, 255, 40);
		frame.getContentPane().add(btnDeletarArtista);
		
		JButton btnEditarArtista = new JButton("EDITAR ARTISTA");
		btnEditarArtista.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnEditarArtista.setBounds(54, 424, 255, 40);
		frame.getContentPane().add(btnEditarArtista);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnVoltar.setBounds(54, 479, 255, 40);
		frame.getContentPane().add(btnVoltar);
		
		JButton btnCriarArtista = new JButton("CRIAR ARTISTA");
		btnCriarArtista.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btnCriarArtista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCriarArtista.setBackground(new Color(0, 250, 154));
		btnCriarArtista.setBounds(332, 479, 515, 40);
		frame.getContentPane().add(btnCriarArtista);
		
		JLabel lblSelecioneArtista = new JLabel("SELECIONE OU CRIE UM ARTISTA");
		lblSelecioneArtista.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblSelecioneArtista.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelecioneArtista.setBounds(54, 79, 258, 16);
		frame.getContentPane().add(lblSelecioneArtista);
		
		inputNome = new JTextField();
		inputNome.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		inputNome.setBounds(332, 101, 515, 40);
		frame.getContentPane().add(inputNome);
		inputNome.setColumns(10);
		
		JEditorPane txtBoxDescrição = new JEditorPane();
		txtBoxDescrição.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		txtBoxDescrição.setBounds(332, 188, 515, 276);
		frame.getContentPane().add(txtBoxDescrição);
		
		JLabel lblNome = new JLabel("NOME");
		lblNome.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setBounds(460, 79, 258, 16);
		frame.getContentPane().add(lblNome);
		
		JLabel lblDescricao = new JLabel("DESCRI\u00C7\u00C3O");
		lblDescricao.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblDescricao.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescricao.setBounds(460, 159, 258, 16);
		frame.getContentPane().add(lblDescricao);
	}
}
