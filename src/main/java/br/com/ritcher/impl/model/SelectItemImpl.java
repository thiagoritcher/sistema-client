package br.com.ritcher.impl.model;

import br.com.ritcher.model.input.SelectItem;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SelectItemImpl implements SelectItem {
	String label;
}
