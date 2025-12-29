package br.com.ritcher;

import java.awt.event.ActionListener;
import java.util.Optional;

import br.com.ritcher.model.input.SearchItem;
import br.com.ritcher.ui.SearchInput;
import br.com.ritcher.ui.SearchProvider;
import br.com.ritcher.ui.SearchSelection;
import br.com.ritcher.ui.SearchSelectionRequest;
import br.com.ritcher.ui.SearchSelectionRequestImpl;

public class SearchProviderImpl implements SearchProvider {
	
	private final PanelFactory panelFactory;
	private Content content;

	public SearchProviderImpl(PanelFactory panelFactory, Content content) {
		this.panelFactory = panelFactory;
		this.content = content;
	}

	@Override
	public void startSearch(SearchItem input, ActionListener listener) {
		System.out.println("Start search");
		SearchSelectionRequest request = new SearchSelectionRequestImpl(content, listener);
		content.push(panelFactory.createSearch(input.getLabel(), this, Optional.of(request)), new ContentData(input.getLabel()));
	}

	@Override
	public void startEdit(SearchItem input, SearchSelection selection, SearchInput searchInput) {
		content.push(panelFactory.createPanel(input.getLabel(), PanelType.FORM, this), new ContentData(input.getLabel()));
	}


}
