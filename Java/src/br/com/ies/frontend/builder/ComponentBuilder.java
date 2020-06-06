package br.com.ies.frontend.builder;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ComponentBuilder {

	
    /**
     * 
     * @param displayName : Nome botao
     * @param fontName : Fonte nome
     * @param font : Fonte
     * @param fontSize : Fonte tamanho
     * @param xBound : X
     * @param yBound : Y
     * @param widthBound : Largura
     * @param heightBound : Altura
     * @param clickListener : () -> { VOID} 
     * @return : botao a ser adicionado no content panel
     */
	
	public static JButton buildButton(String displayName, String fontName, int font, int fontSize, int xBound, int yBound, int widthBound, int heightBound, Color color,Runnable clickListener) {
		JButton button = new JButton(displayName);
		button.setFont(new Font(fontName, font, fontSize));
		button.setBounds(xBound, yBound, widthBound, heightBound);
		if(color != null)
			button.setBackground(color);
		return (JButton) buildEventComponent(button, clickListener);
	}
	
	/**
	 * 
	 * @param displayName : Nome label
	 * @param fontName : Fonte Nome
	 * @param font : Fonte
	 * @param fontSize : Fonte tamanho
	 * @param horizonalAlignment : Alinhamento Horizontal
	 * @param xBound : X
	 * @param yBound : Y
	 * @param widthBound : Largura
	 * @param heightBound : Altura
	 * @return : retorna o Label a ser adicionado no content panel
	 */
	public static JLabel buildLabel(String displayName,String fontName, int font, int fontSize, int horizonalAlignment, int xBound, int yBound, int widthBound, int heightBound) {
		JLabel label = new JLabel(displayName);
		label.setFont(new Font(fontName, font, fontSize));
		label.setHorizontalAlignment(horizonalAlignment);
		label.setBounds(xBound, yBound, widthBound, heightBound);
		return label;
	}
	
	private static Component buildEventComponent(Component component, Runnable runnable) {
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
