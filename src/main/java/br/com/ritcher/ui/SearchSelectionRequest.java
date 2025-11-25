package br.com.ritcher.ui;

public interface SearchSelectionRequest {

	void cancelSelection();

	void commitSelection(SearchSelection searchSelectionImpl);

}
