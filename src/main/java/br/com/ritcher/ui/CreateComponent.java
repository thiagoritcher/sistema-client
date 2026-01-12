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
import br.com.ritcher.ui.search.SearchSelection;

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
			UITable comp = new UITable((Table) input, this);
			return comp;
		}

		throw new IllegalArgumentException("Undefined input type" + input);
	}

	public Object getValue(JComponent currentEditor) {
		if(currentEditor instanceof SearchInput) {
			return ((SearchInput) currentEditor).getValue();
		}
		else if(currentEditor instanceof JCheckBox) {
			return ((JCheckBox) currentEditor).isSelected();
		}
		else if(currentEditor instanceof JTextField) {
			return ((JTextField) currentEditor).getText();
		}
		else {
			throw new IllegalArgumentException();
		}
	}

	public void setValue(JComponent currentEditor, Object value) {
		if(currentEditor instanceof SearchInput) {
			((SearchInput) currentEditor).setValue((SearchSelection) value);
		}
		else if(currentEditor instanceof JCheckBox) {
			((JCheckBox) currentEditor).setSelected(value == null ? false: (boolean) value);
		}
		else if(currentEditor instanceof JTextField) {
			((JTextField) currentEditor).setText((String) value);
		}
		else {
			throw new IllegalArgumentException();
		}
	}

	public String getText(JComponent currentEditor) {
		if(currentEditor instanceof SearchInput) {
			return ((SearchInput) currentEditor).getText();
		}
		if(currentEditor instanceof JCheckBox) {
			return ((JCheckBox) currentEditor).isSelected() ? "yes": "no";
		}
		if(currentEditor instanceof JTextField) {
			return ((JTextField) currentEditor).getText();
		}
		else {
			throw new IllegalArgumentException();
		}
	}
}
