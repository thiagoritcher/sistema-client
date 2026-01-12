package br.com.ritcher.ui.search;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.ritcher.model.input.SearchItem;

public class SearchInput extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton list, edit;
	private SearchProvider provider;
	
	private SearchSelection selection;
	private SearchItem input;
	private JTextField desc;
	
	public void setInput(SearchItem input) {
		this.input = input;
	}

	public SearchInput(SearchItem input, SearchProvider provider) {
		this.input = input;
		this.provider = provider;

		setLayout(new GridBagLayout());
		
		GridBagConstraints c;
		
		desc = new JTextField();
		c = new GridBagConstraints();
		c.gridwidth = 1;
		c.weightx = 1.0;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(desc, c);
		
		list = new JButton("/");
		list.addActionListener(this);
		c = new GridBagConstraints();
		c.gridwidth = 1;
		c.weightx = 0.0;
		c.insets = new Insets(0, 5, 0, 0);
		add(list, c);

		edit = new JButton("#");
		c = new GridBagConstraints();
		c.gridwidth = 1;
		c.weightx = 0.0;
		c.insets = new Insets(0, 5, 0, 0);
		add(edit, c);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == list) {
			provider.startSearch(input, this);
		}
		else if(e.getSource() == edit) {
			provider.startEdit(input, selection, this);
		}
		else if(e.getSource() instanceof SearchSelection ) {
			updateSelection((SearchSelection) e.getSource());
		}
	}

	private void updateSelection(SearchSelection source) {
		this.selection = source;
		desc.setText(source.getText());
	}
}
