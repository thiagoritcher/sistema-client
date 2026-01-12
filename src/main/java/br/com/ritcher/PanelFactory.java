package br.com.ritcher;


import java.util.List;
import java.util.Optional;

import javax.swing.JPanel;

import br.com.ritcher.impl.model.DateImpl;
import br.com.ritcher.impl.model.FormImpl;
import br.com.ritcher.impl.model.IntegerInputImpl;
import br.com.ritcher.impl.model.LineImpl;
import br.com.ritcher.impl.model.SearchItemImpl;
import br.com.ritcher.impl.model.SelectItemImpl;
import br.com.ritcher.impl.model.SwitchImpl;
import br.com.ritcher.impl.model.TextLineImpl;
import br.com.ritcher.model.Form;
import br.com.ritcher.model.Input;
import br.com.ritcher.model.Line;
import br.com.ritcher.model.input.DateInput;
import br.com.ritcher.model.input.IntegerInput;
import br.com.ritcher.model.input.SearchItem;
import br.com.ritcher.model.input.SelectItem;
import br.com.ritcher.model.input.Switch;
import br.com.ritcher.model.input.TextLine;
import br.com.ritcher.ui.FormActionPanel;
import br.com.ritcher.ui.UIForm;
import br.com.ritcher.ui.UIListing;
import br.com.ritcher.ui.UXConfig;
import br.com.ritcher.ui.search.SearchProvider;
import br.com.ritcher.ui.search.SearchSelectionRequest;

public class PanelFactory {

	public UI createPanel(List<String> path, PanelType type, SearchProvider provider) {
		String id = path.get(0);
		if(type == PanelType.FORM) {

			UIForm form = new UIForm(usuario(id), provider, new FormActionPanel(new UXConfig()));
			
			if(path.size() > 1) {
				form.load(path.subList(1, path.size()));
			}
			return form;
		}
		else if(type == PanelType.LIST) {
			return new UIListing(usuario(id), provider, Optional.empty());
		}
		else {
			throw new IllegalArgumentException(type +" is undefined");
		}
	}

	public UI createSearch(String id, SearchProviderImpl searchProviderImpl,
			Optional<SearchSelectionRequest> selectionRequest) {
		return new UIListing(usuario(id), searchProviderImpl, selectionRequest);
	}
	
	public UI createPanel(String id, PanelType type, SearchProvider provider) {
		if(type == PanelType.FORM) {
			return new UIForm(usuario(id), provider, new FormActionPanel(new UXConfig()));
		}
		else if(type == PanelType.LIST) {
			return new UIListing(usuario(id), provider, Optional.empty());
		}
		else {
			throw new IllegalArgumentException(type +" is undefined");
		}
	}


	private TextLine input(String id) {
		return TextLineImpl.builder().label(id).build();
	}

	private IntegerInput intinput(String id) {
		return IntegerInputImpl.builder().label(id).build();
	}

	private Switch switchin(String id) {
		return SwitchImpl.builder().label(id).build();
	}

	private DateInput datein(String id) {
		return DateImpl.builder().label(id).build();
	}

	private SelectItem selectin(String id) {
		return SelectItemImpl.builder().label(id).build();
	}

	private SearchItem searchin(String id) {
		return SearchItemImpl.builder().label(id).build();
	}
	
	private Line line(List<Input> inputs) {
		return LineImpl.builder().inputs(inputs).build();
	}
	
	private Form usuario(String id) {
		if("usuario".equals(id)) {
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
		if("cidade".equals(id)) {
			return FormImpl.builder()
				.formItem(input("nome"))
				.formItem(selectin("estado"))
				.build();	
		}
		
		throw new IllegalArgumentException(id +" is undefined");
	}
}
