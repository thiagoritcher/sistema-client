package br.com.ritcher;


import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import br.com.ritcher.impl.model.DateImpl;
import br.com.ritcher.impl.model.FormImpl;
import br.com.ritcher.impl.model.IntegerInputImpl;
import br.com.ritcher.impl.model.LineImpl;
import br.com.ritcher.impl.model.SearchItemImpl;
import br.com.ritcher.impl.model.SelectItemImpl;
import br.com.ritcher.impl.model.SwitchImpl;
import br.com.ritcher.impl.model.TextLineImpl;
import br.com.ritcher.model.Form;
import br.com.ritcher.model.Input;
import br.com.ritcher.model.Line;
import br.com.ritcher.model.input.DateInput;
import br.com.ritcher.model.input.IntegerInput;
import br.com.ritcher.model.input.SearchItem;
import br.com.ritcher.model.input.SelectItem;
import br.com.ritcher.model.input.Switch;
import br.com.ritcher.model.input.TextLine;
import br.com.ritcher.ui.UIForm;
import br.com.ritcher.ui.UIListagem;

public class PanelFactory {

	public JPanel createPanel(String id) {
		if("Listagem".equals(id))
			return new UIListagem(createForm(id));

		if("Form".equals(id))
			return new UIForm(createForm(id));
		
		return new JPanel();
	}

	private TextLine input(String id) {
		return TextLineImpl.builder().label(id).build();
	}

	private IntegerInput intinput(String id) {
		return IntegerInputImpl.builder().label(id).build();
	}

	private Switch switchin(String id) {
		return SwitchImpl.builder().label(id).build();
	}

	private DateInput datein(String id) {
		return DateImpl.builder().label(id).build();
	}

	private SelectItem selectin(String id) {
		return SelectItemImpl.builder().label(id).build();
	}

	private SearchItem searchin(String id) {
		return SearchItemImpl.builder().label(id).build();
	}
	
	private Line line(List<Input> inputs) {
		return LineImpl.builder().inputs(inputs).build();
	}
	
	private Form createForm(String id) {
		Form f = FormImpl.builder()
				.formItem( 
						line(List.of( 
								input("nome"), intinput("idade"), selectin("tipo"),switchin("optante"))))
				.formItem(
					line(List.of(input("sobrenome"), input("apelido"), selectin("estado_civil"), searchin("cidade"))))
				.formItem(datein("nascimento"))
				.build();
		return f;
	}

}
