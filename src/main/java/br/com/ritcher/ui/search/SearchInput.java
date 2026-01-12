package br.com.ritcher.ui.search;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
	
	public SearchSelection getValue() {
		return this.selection;
	}
	
	public void setValue(SearchSelection o) {
		this.selection = o;
		if(o == null) {
			desc.setText("");
		}
		else {
			desc.setText(Integer.toString((int) this.selection.getData()[0]));
		}
	}

	public String getText() {
		if(this.selection == null) {
			return "";
		}
		
		return Integer.toString((int) this.selection.getData()[0]);
	}

	List<SearchSelectionListener> listeners = new ArrayList<SearchSelectionListener>();

	void addSelectionListener(SearchSelectionListener listener){
		listeners.add(listener);
	}
	
	private void updateSelection(SearchSelection source) {
		this.selection = source;
		listeners.stream().forEach(l -> l.updateSelection(source));
		desc.setText(source.getText());
	}
}
