package br.com.ritcher;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JPanel;

public class Content extends JPanel {

	private static final long serialVersionUID = 1L;

	private final PanelFactory panelFactory;

	private CardLayout cardLayout;

	public Content(PanelFactory panelFactory) {
		this.panelFactory = panelFactory;
		cardLayout = new CardLayout();
		this.setLayout(cardLayout);
	}

	public void add(String id) {
		JPanel panel = panelFactory.createPanel(id);
		EventQueue.invokeLater(() -> {
			System.out.println("Add " + id);
			add(panel, 0);
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
