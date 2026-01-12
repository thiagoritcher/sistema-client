package br.com.ritcher.panel;

import java.util.List;

import br.com.ritcher.impl.model.FormImpl;
import br.com.ritcher.model.Form;
import br.com.ritcher.model.FormItem;
import br.com.ritcher.model.input.SelectItem;
import br.com.ritcher.ui.PanelFactoryBase;

public class Seguranca extends PanelFactoryBase {

	public Form create(String id) {
		switch(id) {
			case "usuario":
				return usuario();

			case "function":
				return function();

			case "profile":
				return profile();

			case "cidade":
				return cidade();
		}
		throw new IllegalArgumentException(id +" is undefined");
	}

	private Form profile() {
		return FormImpl.builder()
			.formItem(input("name"))
			.formItem(selectin("description"))
			.build();	
	}

	private Form function() {
		return FormImpl.builder()
			.formItem(input("name"))
			.formItem(selectin("description"))
			.build();	
	}

	private Form cidade() {
		return FormImpl.builder()
			.formItem(input("nome"))
			.formItem(selectin("estado"))
			.build();	
	}

	private Form usuario() {
		return FormImpl.builder()
			.formItem( 
				line(List.of( 
					input("username"), 
					input("password"),
					input("description")))
			)
			.formItem(
				table(List.of(
						searchin("profile"), 
						switchin("active"), 
						input("observation") 
						)))
			.build();
	}


	private Form usuariop() {
		return FormImpl.builder()
			.formItem( 
				line(List.of( 
					input("nome"), 
					intinput("idade"), 
					selectin("tipo"),
					switchin("optante"))))
			.formItem(
				line(List.of(
					input("sobrenome"), 
					input("apelido"), 
					selectin("estado_civil"), 
					searchin("cidade"))))
			.formItem(datein("nascimento"))
			.build();
	}
}
