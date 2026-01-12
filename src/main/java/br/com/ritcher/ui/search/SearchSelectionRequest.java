package br.com.ritcher.ui.search;

public interface SearchSelectionRequest {

	void cancelSelection();

	void commitSelection(SearchSelection searchSelectionImpl);

}
