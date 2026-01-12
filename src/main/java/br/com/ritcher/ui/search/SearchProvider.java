package br.com.ritcher.ui.search;

import java.awt.event.ActionListener;

import br.com.ritcher.model.input.SearchItem;

public interface SearchProvider {

	void startSearch(SearchItem input, ActionListener listener);

	void startEdit(SearchItem input, SearchSelection selection, SearchInput searchInput);
}
