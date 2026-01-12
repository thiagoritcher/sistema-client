package br.com.ritcher.ui;

import java.util.List;

import br.com.ritcher.impl.model.DateImpl;
import br.com.ritcher.impl.model.IntegerInputImpl;
import br.com.ritcher.impl.model.LineImpl;
import br.com.ritcher.impl.model.SearchItemImpl;
import br.com.ritcher.impl.model.SelectItemImpl;
import br.com.ritcher.impl.model.SwitchImpl;
import br.com.ritcher.impl.model.TableImpl;
import br.com.ritcher.impl.model.TextLineImpl;
import br.com.ritcher.model.Form;
import br.com.ritcher.model.FormItem;
import br.com.ritcher.model.Input;
import br.com.ritcher.model.Line;
import br.com.ritcher.model.input.DateInput;
import br.com.ritcher.model.input.IntegerInput;
import br.com.ritcher.model.input.SearchItem;
import br.com.ritcher.model.input.SelectItem;
import br.com.ritcher.model.input.Switch;
import br.com.ritcher.model.input.TextLine;

public abstract class PanelFactoryBase {

	protected TextLine input(String id) {
		return TextLineImpl.builder().label(id).build();
	}

	protected IntegerInput intinput(String id) {
		return IntegerInputImpl.builder().label(id).build();
	}

	protected Switch switchin(String id) {
		return SwitchImpl.builder().label(id).build();
	}

	protected DateInput datein(String id) {
		return DateImpl.builder().label(id).build();
	}

	protected SelectItem selectin(String id) {
		return SelectItemImpl.builder().label(id).build();
	}

	protected SearchItem searchin(String id) {
		return SearchItemImpl.builder().label(id).build();
	}
	
	protected Line line(List<Input> inputs) {
		return LineImpl.builder().inputs(inputs).build();
	}

	protected FormItem table(List<Input> of) {
		return TableImpl.builder().inputs(of).build();
	}

	public abstract Form create(String id);
}
