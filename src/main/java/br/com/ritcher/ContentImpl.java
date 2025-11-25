package br.com.ritcher;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JPanel;

public class ContentImpl extends JPanel implements Content {

	private static final long serialVersionUID = 1L;

	private CardLayout cardLayout;

	public ContentImpl() {
		cardLayout = new CardLayout();
		this.setLayout(cardLayout);
	}

	public void push(UI panel) {
		EventQueue.invokeLater(() -> {
			add((Component) panel, 0);
			cardLayout.first(this);
			revalidate();
			repaint();
		});
	}

	public void pop() {
		EventQueue.invokeLater(() -> {
			remove(0);
			cardLayout.first(this);
			revalidate();
			repaint();
		});
	}

}
