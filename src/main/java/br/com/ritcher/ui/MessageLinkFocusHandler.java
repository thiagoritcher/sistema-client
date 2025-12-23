package br.com.ritcher.ui;

import java.net.URL;
import java.util.List;

import br.com.ritcher.Content;
import br.com.ritcher.PanelFactory;
import br.com.ritcher.PanelType;

public class MessageLinkFocusHandler {
	private Content content;
	private PanelFactory panelFactory;
	private SearchProvider searchProvider;

	public MessageLinkFocusHandler(Content content, PanelFactory panelFactory, SearchProvider searchProvider) {
		this.content = content;
		this.panelFactory = panelFactory;
		this.searchProvider = searchProvider;
	}	

	public void handleLink(URL url) {
		String[] parts = url.getPath().split("/");
		if(parts.length > 2) {
			content.push(panelFactory.createPanel(List.of(url.getHost(), parts[1], parts[2]), PanelType.FORM, searchProvider));
		}
		else {
			content.push(panelFactory.createPanel(List.of(url.getHost()), PanelType.LIST, searchProvider));
		}
	}
}
