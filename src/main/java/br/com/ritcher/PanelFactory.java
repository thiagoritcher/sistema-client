package br.com.ritcher;


import javax.swing.JPanel;

import br.com.ritcher.impl.model.FormImpl;
import br.com.ritcher.impl.model.IntegerInputImpl;
import br.com.ritcher.impl.model.TextLineImpl;
import br.com.ritcher.model.Form;
import br.com.ritcher.model.input.IntegerInput;
import br.com.ritcher.model.input.TextLine;
import br.com.ritcher.ui.UIForm;
import br.com.ritcher.ui.UIListagem;

public class PanelFactory {

	public JPanel createPanel(String id) {
		if("Listagem".equals(id))
			return new UIListagem(createForm(id));

		if("Form".equals(id))
			return new UIForm();
		
		return new JPanel();
	}

	private TextLine input(String id) {
		return TextLineImpl.builder().label(id).build();
	}

	private IntegerInput intinput(String id) {
		return IntegerInputImpl.builder().label(id).build();
	}
	
	private Form createForm(String id) {
		Form f = FormImpl.builder()
				.formItem(input("nome"))
				.formItem(intinput("idade"))
				.build();
		return f;
	}

}
