package br.com.ritcher;

public interface Content {

	abstract void push(UI panel, ContentData data);

	void pop(UI panel);
	
}
