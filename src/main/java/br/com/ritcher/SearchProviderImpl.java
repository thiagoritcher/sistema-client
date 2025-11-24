package br.com.ritcher;

import java.awt.event.ActionListener;

import br.com.ritcher.model.input.SearchItem;
import br.com.ritcher.ui.SearchInput;
import br.com.ritcher.ui.SearchProvider;
import br.com.ritcher.ui.SearchSelection;

public class SearchProviderImpl implements SearchProvider {
	
	public SearchProviderImpl() {
	}

	@Override
	public void startSearch(SearchItem input, ActionListener listener) {
		//TODO: Implement
	}

	@Override
	public void startEdit(SearchItem input, SearchSelection selection, SearchInput searchInput) {
		//TODO: Implement
		
	}

	@Override
	public SearchSelection lastSelection() {
		return null;
		//TODO: Implement
	}

}
