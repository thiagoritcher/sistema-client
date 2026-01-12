package br.com.ritcher.ui.search;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.ritcher.Content;

public class SearchSelectionRequestImpl implements SearchSelectionRequest {

	private Content content;
	private ActionListener listener;

	public SearchSelectionRequestImpl(Content content, ActionListener listener) {
		this.content = content;
		this.listener = listener;
	}

	@Override
	public void cancelSelection() {
		content.pop(null);
	}

	@Override
	public void commitSelection(SearchSelection searchSelection) {
		content.pop(null);
		listener.actionPerformed(new ActionEvent(searchSelection, 0, null));
	}

}
