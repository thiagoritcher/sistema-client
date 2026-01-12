package br.com.ritcher;

import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

import br.com.ritcher.model.input.SearchItem;
import br.com.ritcher.ui.search.SearchInput;
import br.com.ritcher.ui.search.SearchProvider;
import br.com.ritcher.ui.search.SearchSelection;
import br.com.ritcher.ui.search.SearchSelectionRequest;
import br.com.ritcher.ui.search.SearchSelectionRequestImpl;

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
		content.push(panelFactory.createPanel(List.of(input.getLabel()) , PanelType.FORM, this), new ContentData(input.getLabel()));
	}


}
