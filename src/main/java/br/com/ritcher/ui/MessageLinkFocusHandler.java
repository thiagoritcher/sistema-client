package br.com.ritcher.ui;

import java.net.URL;
import java.util.List;

import br.com.ritcher.Content;

public class MessageLinkFocusHandler {
	private Content content;

	public MessageLinkFocusHandler(Content content) {
		this.content = content;
	}	

	public void handleLink(URL url) {
		String[] parts = url.getPath().split("/");
		content.add(List.of(url.getHost(), parts[1], parts[2]));
		
		//TODO: Setup loading and focusing on field
	}
}
