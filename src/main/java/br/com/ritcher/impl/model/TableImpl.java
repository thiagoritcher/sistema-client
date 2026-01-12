package br.com.ritcher.impl.model;

import java.util.List;

import br.com.ritcher.model.Input;
import br.com.ritcher.model.Line;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TableImpl implements Line {
	List<Input> inputs;
}
