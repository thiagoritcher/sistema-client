package br.com.ritcher.ui;

import java.util.List;

import br.com.ritcher.model.Input;
import br.com.ritcher.model.input.DateInput;
import br.com.ritcher.model.input.IntegerInput;
import br.com.ritcher.model.input.SearchItem;
import br.com.ritcher.model.input.SelectItem;
import br.com.ritcher.model.input.TextLine;

public class OperationList {

	private static final List<Operation> numeric = List.of(Operation.SMALLER, Operation.BIGGER, Operation.BETWEN,
			Operation.EQUALS);

	private static final List<Operation> item = List.of(Operation.SMALLER, Operation.BIGGER, Operation.BETWEN,
			Operation.EQUALS);

	private static final List<Operation> text = List.of(Operation.CONTAINS, Operation.STARTWITH, Operation.ENDWITH,
			Operation.EQUALS);

	List<Operation> getOperations(Input i){
		if(i instanceof TextLine) {
			return text;
		}
		else if(i instanceof IntegerInput || i instanceof DateInput) {
			return numeric;
		}
		else if(i instanceof SearchItem || i instanceof SelectItem) {
			return item;
		}
		throw new IllegalArgumentException("Undefined input " + i);
	}
}
