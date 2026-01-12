package br.com.ritcher;


import java.util.List;
import java.util.Optional;

import br.com.ritcher.model.Form;
import br.com.ritcher.panel.Seguranca;
import br.com.ritcher.ui.CreateComponent;
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

			UXConfig uxconfig = new UXConfig();
			FormActionPanel actionPanel = new FormActionPanel(uxconfig);
			CreateComponent createComponent = new CreateComponent(provider, uxconfig);

			UIForm form = new UIForm(findForm(id), actionPanel, createComponent, uxconfig);
			
			if(path.size() > 1) {
				form.load(path.subList(1, path.size()));
			}
			return form;
		}
		else if(type == PanelType.LIST) {
			return new UIListing(findForm(id), provider, Optional.empty());
		}
		else {
			throw new IllegalArgumentException(type +" is undefined");
		}
	}


	public UI createSearch(String id, SearchProviderImpl searchProviderImpl,
			Optional<SearchSelectionRequest> selectionRequest) {
		return new UIListing(findForm(id), searchProviderImpl, selectionRequest);
	}
	
	private Form findForm(String id) {
		Seguranca seguranca = new Seguranca();
		return seguranca.create(id);
	}
}
