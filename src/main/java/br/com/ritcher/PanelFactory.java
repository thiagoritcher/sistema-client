package br.com.ritcher;


import javax.swing.JPanel;

import br.com.ritcher.model.Form;
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

	private Form createForm(String id) {
		return null;
	}

}
