package br.com.ritcher.impl.model;

import java.util.List;

import br.com.ritcher.model.FormItem;
import br.com.ritcher.model.Input;
import br.com.ritcher.model.Tab;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TabImpl implements Tab {

	List<FormItem> formItems;

	String label;
}
