package br.com.ritcher.ui;

import java.awt.Color;

public class UXConfig {

	private Color primaryActionCollor = Color.green;
	
	private Color defaultErrorCollor = new Color(255, 102, 102);

	private Color primarySelectionColor = new Color(220,220,220);
	
	
	public Color getDefaultErrorCollor() {
		return defaultErrorCollor;
	}

	public Color getPrimaryActionCollor() {
		return primaryActionCollor;
	}

	public Color getPrimarySelection() {
		return primarySelectionColor;
	}

}
