package br.com.ritcher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class Menu implements ActionListener {

	private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AppFrame.class.getName());

	public List<JMenu> create() {
		List<JMenu> result = new ArrayList<JMenu>();

		{
			JMenu menu = new JMenu();
			menu.setText("File");

			{
				JMenuItem item = new JMenuItem();
				item.setText("Listagem");
				item.addActionListener(this);

				menu.add(item);
			}

			{
				JMenuItem item = new JMenuItem();
				item.setText("Form");
				item.addActionListener(this);

				menu.add(item);
			}

			result.add(menu);
		}

		{
			JMenu jMenu2 = new JMenu();
			jMenu2.setText("Edit");

			result.add(jMenu2);
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

}
