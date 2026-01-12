package br.com.ritcher.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import br.com.ritcher.Content;
import br.com.ritcher.ContentData;
import br.com.ritcher.PanelFactory;
import br.com.ritcher.PanelType;
import br.com.ritcher.ui.search.SearchProvider;

public class Menu implements ActionListener {

	private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AppFrame.class.getName());

	public Menu(Content content, PanelFactory panelFactory, SearchProvider provider) {
    	addMenuListener(new MenuSelectionListener() {
			@Override
			public void selected(String id) {
				content.push(panelFactory.createPanel(List.of(id), PanelType.LIST, provider), new ContentData(id));
			}
		});
	}

	public List<JMenu> create() {
		List<JMenu> result = new ArrayList<JMenu>();

		{
			JMenu menu = new JMenu();
			menu.setText("File");
			menu.add(new JMenuItemBuilder().text("usuario").listener(this).build());
			menu.add(new JMenuItemBuilder().text("profile").listener(this).build());
			result.add(menu);
		}
		return result;

	}

	List<MenuSelectionListener> listeners = new ArrayList<MenuSelectionListener>();

	public void addMenuListener(MenuSelectionListener menuListener) {
		listeners.add(menuListener);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		logger.fine("menuSelected " + e.toString());
		listeners.forEach(l -> l.selected(((JMenuItem) e.getSource()).getText()));
	}
	
	static class JMenuItemBuilder {
		JMenuItem result;
		public JMenuItemBuilder() {
			result = new JMenuItem();
		}

		public JMenuItemBuilder text(String text) {
			result.setText(text);
			return this;
		}

		public JMenuItemBuilder listener(ActionListener listener) {
			result.addActionListener(listener);
			return this;
		}
		
		public JMenuItem build() {
			return result;
		}
	}
}
