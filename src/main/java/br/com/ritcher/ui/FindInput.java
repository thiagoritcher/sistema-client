package br.com.ritcher.ui;

import java.util.ArrayList;
import java.util.List;

import br.com.ritcher.model.Form;
import br.com.ritcher.model.Input;
import br.com.ritcher.model.Line;
import br.com.ritcher.model.Table;

public class FindInput {

	public List<Input> find(Form form) {
		List<Input> result = new ArrayList<Input>();
		form.getFormItems().forEach(i -> {
			if(i instanceof Table) {
				return;
			}
			if(i instanceof Line) {
				result.addAll(find((Line) i));
			}
			else {
				result.add((Input) i);
			}
		});
		return result;
	}

	public List<Input> find(Line line) {
		return line.getInputs();
	}
}
