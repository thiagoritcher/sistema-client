package br.com.ritcher.ui;

import java.text.DateFormat;
import java.text.NumberFormat;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

import br.com.ritcher.model.FormItem;
import br.com.ritcher.model.Input;
import br.com.ritcher.model.Table;
import br.com.ritcher.model.input.DateInput;
import br.com.ritcher.model.input.IntegerInput;
import br.com.ritcher.model.input.SearchItem;
import br.com.ritcher.model.input.SelectItem;
import br.com.ritcher.model.input.Switch;
import br.com.ritcher.model.input.TextLine;
import br.com.ritcher.ui.search.SearchInput;
import br.com.ritcher.ui.search.SearchProvider;

public class CreateComponent {
	
	private SearchProvider provider;

	public CreateComponent(SearchProvider provider) {
		this.provider = provider;
	}

	public JComponent create(FormItem input) {
		if(input instanceof TextLine) {
			return new JTextField();
		}
		if(input instanceof IntegerInput) {
			JFormattedTextField comp = new JFormattedTextField(NumberFormat.getIntegerInstance());
			return comp;
		}
		if(input instanceof DateInput) {
			JFormattedTextField comp = new JFormattedTextField(DateFormat.getDateInstance(DateFormat.SHORT));
			return comp;
		}
		if(input instanceof SelectItem) {
			JComboBox<String> comp = new JComboBox<String>();
			return comp;
		}
		if(input instanceof SearchItem) {
			SearchInput comp = new SearchInput((SearchItem) input, provider); 
			return comp;
		}
		if(input instanceof Switch) {
			JCheckBox comp = new JCheckBox();
			comp.setText(((Switch)input).getLabel());
			return comp;
		}
		if(input instanceof Table) {
			UITable comp = new UITable((Table) input);
			return comp;
		}

		throw new IllegalArgumentException("Undefined input type" + input);
	}
}
