package br.com.ritcher.model;

import java.util.List;

public interface Tab extends Fill {

	String getLabel();
	
	List<FormItem> getFormItems();
}
