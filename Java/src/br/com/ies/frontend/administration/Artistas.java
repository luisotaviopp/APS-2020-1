package br.com.ies.frontend.administration;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import br.com.ies.frontend.builder.ComponentBuilder;

public class Artistas {

	private JFrame frame;
	private JTextField inputNome;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Artistas() {
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
		
		frame.getContentPane().add(ComponentBuilder.buildLabel("ARTISTAS", "Franklin Gothic Medium", Font.BOLD, 20, SwingConstants.CENTER, null, null, null, 0, 20, 882, 30, null));
		frame.getContentPane().add(ComponentBuilder.buildButton("DELETAR ARTISTA", "Franklin Gothic Medium", Font.PLAIN, 13, 54, 365, 255, 40, null, null,
				 () -> {
						
					}));
		frame.getContentPane().add(ComponentBuilder.buildButton("EDITAR ARTISTA", "Franklin Gothic Medium", Font.PLAIN, 13, 54, 424, 255, 40, null, null,
				 () -> {
						
					}));
		
		frame.getContentPane().add(ComponentBuilder.buildButton("VOLTAR", "Franklin Gothic Medium", Font.PLAIN, 13, 54, 479, 255, 40, null, null,
				 () -> {
						
					}));
		frame.getContentPane().add(ComponentBuilder.buildButton("CRIAR ARTISTA", "Franklin Gothic Medium", Font.PLAIN, 13, 332, 479, 515, 40, new Color(0, 250, 154), null,
				 () -> {
						
					}));
		frame.getContentPane().add(ComponentBuilder.buildLabel("SELECIONE OU CRIE UM ARTISTA", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.CENTER, null, null, null, 54, 79, 258, 16, null));
		// input nome
		frame.getContentPane().add(ComponentBuilder.buildTextField("Franklin Gothic Medium", Font.PLAIN, 13, 332, 101, 515, 40, 10));
		
		JEditorPane txtBoxDescrição = new JEditorPane();
		txtBoxDescrição.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		txtBoxDescrição.setBounds(332, 188, 515, 276);
		frame.getContentPane().add(txtBoxDescrição);
		
		frame.getContentPane().add(ComponentBuilder.buildLabel("NOME", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.CENTER, null, null, null, 460, 79, 258, 16, null));
		frame.getContentPane().add(ComponentBuilder.buildLabel("DESCRIÇÃO", "Franklin Gothic Medium", Font.PLAIN, 13, SwingConstants.CENTER, null, null, null, 460, 159, 258, 16, null));
	}

	public JFrame getFrame() {
		return frame;
	}
	public void toggleFrame() {
		frame.setVisible(!frame.isVisible());
	}

}
