package br.com.ritcher.ui;

import java.util.List;


import br.com.ritcher.model.Input;
import br.com.ritcher.model.input.Date;
import br.com.ritcher.model.input.SearchItem;
import br.com.ritcher.model.input.SelectItem;
import br.com.ritcher.model.input.Switch;
import br.com.ritcher.model.input.TextLine;

public class UIInputOperation {

	public List<String> operations(Input input){
		return operations(input);
	}

	public List<String> operations(Date input){
		return List.of();
	}

	public List<String> operations(Integer input){
		return List.of();
	}

	public List<String> operations(SearchItem input){
		return List.of();
	}

	public List<String> operations(SelectItem input){
		return List.of();
	}

	public List<String> operations(Switch input){
		return List.of();
	}

	public List<String> operations(TextLine input){
		return List.of();
	}
	
	
	
}
