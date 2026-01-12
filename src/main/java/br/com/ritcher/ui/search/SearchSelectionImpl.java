package br.com.ritcher.ui.search;

public class SearchSelectionImpl implements SearchSelection {

	private final Object[] names;
	private final Object[] data;

	public SearchSelectionImpl(Object[] names, Object[] data) {
		this.names = names;
		this.data = data;
	}
	
	@Override
	public String getText() {
		return data[0].toString();
	}

	@Override
	public Object[] getData() {
		return data;
	}
	
}
