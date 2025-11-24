package br.com.ritcher.impl.model;

import br.com.ritcher.model.input.SearchItem;
import br.com.ritcher.model.input.SelectItem;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SearchItemImpl implements SearchItem {
	String label;
}
