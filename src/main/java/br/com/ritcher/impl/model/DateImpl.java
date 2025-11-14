package br.com.ritcher.impl.model;

import br.com.ritcher.model.input.DateInput;
import br.com.ritcher.model.input.TextLine;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DateImpl implements DateInput {
	String label;
}
