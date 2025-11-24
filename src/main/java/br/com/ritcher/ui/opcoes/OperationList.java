package br.com.ritcher.ui.opcoes;

import java.util.List;

import br.com.ritcher.model.Input;
import br.com.ritcher.model.input.DateInput;
import br.com.ritcher.model.input.IntegerInput;
import br.com.ritcher.model.input.SearchItem;
import br.com.ritcher.model.input.SelectItem;
import br.com.ritcher.model.input.Switch;
import br.com.ritcher.model.input.TextLine;

public class OperationList {

	private static final List<Operation> numeric = List.of(Operation.SMALLER, Operation.BIGGER, Operation.BETWEN,
			Operation.EQUALS, Operation.ISEMPTY, Operation.NOTEMPTY);

	private static final List<Operation> item = List.of(Operation.EQUALS, Operation.NOTEQUALS, Operation.ISEMPTY, Operation.NOTEMPTY);

	private static final List<Operation> text = List.of(Operation.CONTAINS, Operation.STARTWITH, Operation.ENDWITH,
			Operation.EQUALS, Operation.ISEMPTY, Operation.NOTEMPTY);

	private static final List<Operation> switchin = List.of(Operation.YES);

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
		else if(i instanceof Switch) {
			return switchin;
		}
		throw new IllegalArgumentException("Undefined input " + i);
	}
}
