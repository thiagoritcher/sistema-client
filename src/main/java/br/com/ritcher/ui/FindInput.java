package br.com.ritcher.ui;

import java.util.ArrayList;
import java.util.List;

import br.com.ritcher.model.Form;
import br.com.ritcher.model.FormItem;
import br.com.ritcher.model.Input;
import br.com.ritcher.model.Line;

public class FindInput {

	public List<Input> find(Form form) {
		List<Input> result = new ArrayList<Input>();
		form.getFormItems().forEach(i -> find(i, result));
		return result;
	}

	public void find(FormItem line, List<Input> out) {
		find(line, out);
	}

	public void find(Line line, List<Input> out) {
		out.addAll(line.getInputs());
	}

	public void find(Input item, List<Input> out) {
		out.add(item);
	}
	
	
}
