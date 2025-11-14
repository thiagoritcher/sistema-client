package br.com.ritcher.impl.model;

import br.com.ritcher.model.input.Switch;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SwitchImpl implements Switch {
	String label;
}
