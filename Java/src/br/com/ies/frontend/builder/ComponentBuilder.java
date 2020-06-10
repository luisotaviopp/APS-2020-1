package br.com.ies.frontend.builder;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ListModel;

public class ComponentBuilder {

	/**
	 * 
	 * @param displayName   : Nome botao
	 * @param fontName      : Fonte nome
	 * @param font          : Fonte
	 * @param fontSize      : Fonte tamanho
	 * @param xBound        : X
	 * @param yBound        : Y
	 * @param widthBound    : Largura
	 * @param heightBound   : Altura
	 * @param clickListener : () -> { VOID}
	 * @return : botao a ser adicionado no content panel
	 */

	public static JButton buildButton(String displayName, String fontName, int font, int fontSize, int xBound,
			int yBound, int widthBound, int heightBound, Color backgroundColor, Color foregroundColor,
			Runnable clickListener) {
		JButton button = new JButton(displayName);
		button.setFont(new Font(fontName, font, fontSize));
		if(xBound != -1 && yBound != -1 && widthBound != -1 && heightBound != -1)
			button.setBounds(xBound, yBound, widthBound, heightBound);
		if (backgroundColor != null)
			button.setBackground(backgroundColor);
		if (foregroundColor != null)
			button.setForeground(foregroundColor);
		return (JButton) buildEventComponent(button, clickListener);
	}

	/**
	 * 
	 * @param displayName        : Nome label
	 * @param fontName           : Fonte Nome
	 * @param font               : Fonte
	 * @param fontSize           : Fonte tamanho
	 * @param horizonalAlignment : Alinhamento Horizontal
	 * @param xBound             : X
	 * @param yBound             : Y
	 * @param widthBound         : Largura
	 * @param heightBound        : Altura
	 * @return : retorna o Label a ser adicionado no content panel
	 */
	public static JLabel buildLabel(String displayName, String fontName, int font, int fontSize,
			Integer horizontalAlignment, Integer horizontalTextPosition, Integer verticalAlignment, Float alignmentX,
			int xBound, int yBound, int widthBound, int heightBound, Color foregroundColor) {
		JLabel label = new JLabel(displayName);
		label.setFont(new Font(fontName, font, fontSize));
		if (horizontalAlignment != null)
			label.setHorizontalAlignment(horizontalAlignment);
		if (horizontalTextPosition != null)
			label.setHorizontalTextPosition(horizontalTextPosition);
		if (verticalAlignment != null)
			label.setVerticalAlignment(verticalAlignment);
		if (alignmentX != null)
			label.setAlignmentX(alignmentX);

		label.setBounds(xBound, yBound, widthBound, heightBound);
		if (foregroundColor != null)
			label.setForeground(foregroundColor);

		return label;
	}

	public static JTextField buildTextField(String fontName, int font, int fontSize, int xBound, int yBound,
			int widthBound, int heightBound, int columns) {
		JTextField textField = new JTextField();
		textField.setFont(new Font(fontName, font, fontSize));
		textField.setBounds(xBound, yBound, widthBound, heightBound);
		textField.setColumns(columns);
		return textField;
	}

	public static JPasswordField buildPasswordField(String fontName, int font, int fontSize, int xBound, int yBound,
			int widthBound, int heightBound) {
		JPasswordField passwordField = new JPasswordField();
		passwordField.setFont(new Font(fontName, font, fontSize));
		passwordField.setBounds(xBound, yBound, widthBound, heightBound);
		return passwordField;
	}
	public static JList<Object> buildList(String fontName, int font, int fontSize, Color backgroundColor,int xBound, int yBound,int widthBound, int heightBound, int selectionMode, ListModel<Object> listModel){
		JList<Object> list = new JList<>();
		list.setBackground(backgroundColor);
		list.setFont(new Font(fontName, font, fontSize));
		list.setSelectionMode(selectionMode);
		list.setModel(listModel);
		list.setBounds(xBound, yBound, widthBound, heightBound);
		return list;
	}
	

	public static Component buildEventComponent(Component component, Runnable runnable) {
		component.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				runnable.run();
			}
		});
		return component;
	}

}
