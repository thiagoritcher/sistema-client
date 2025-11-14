package br.com.ritcher.impl.model;

import br.com.ritcher.model.input.IntegerInput;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class IntegerInputImpl implements IntegerInput {
	String label;
}
