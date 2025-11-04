package br.com.ritcher.ui;

import javax.swing.JComponent;
import javax.swing.JTextField;

import br.com.ritcher.model.Line;
import br.com.ritcher.model.input.Date;
import br.com.ritcher.model.input.SearchItem;
import br.com.ritcher.model.input.SelectItem;
import br.com.ritcher.model.input.Switch;
import br.com.ritcher.model.input.TextLine;

public class UIFactory {

	public JComponent create(TextLine input)  {
		JTextField field = new JTextField();
		return field;
	}

	public JComponent create(Integer input)  {
		JTextField field = new JTextField();
		return field;
	}

	public JComponent create(Date input)  {
		JTextField field = new JTextField();
		return field;
	}

	public JComponent create(SearchItem input)  {
		JTextField field = new JTextField();
		return field;
	}

	public JComponent create(SelectItem input)  {
		JTextField field = new JTextField();
		return field;
	}

	public JComponent create(Switch input)  {
		JTextField field = new JTextField();
		return field;
	}

	public JComponent create(Line input)  {
		JTextField field = new JTextField();
		return field;
	}
}
