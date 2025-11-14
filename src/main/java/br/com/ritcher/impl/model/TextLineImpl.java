package br.com.ritcher.impl.model;

import br.com.ritcher.model.input.TextLine;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TextLineImpl implements TextLine {
	String label;
}
