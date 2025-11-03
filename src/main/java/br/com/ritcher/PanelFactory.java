package br.com.ritcher;

import javax.swing.JPanel;

public class PanelFactory {

	public JPanel createPanel(String id) {
		if("Listagem".equals(id))
			return new Listagem();

		if("Form".equals(id))
			return new Form();
		
		return new JPanel();
	}

}
