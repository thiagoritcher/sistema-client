package br.com.ritcher.impl.model;

import java.util.ArrayList;
import java.util.List;

import br.com.ritcher.model.Form;
import br.com.ritcher.model.FormItem;
import lombok.Builder;
import lombok.Singular;

@Builder
public class FormImpl implements Form {

	@Singular
	List<FormItem> formItems;

	@Override
	public List<FormItem> getFormItems() {
		return formItems;
	}
}
