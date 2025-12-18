package br.com.ritcher.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Messages {
	List<String> messagesList = new ArrayList<String>();

	public void forEach(Consumer<? super String> action) {
		messagesList.forEach(action);
	}

	public boolean isEmpty() {
		return messagesList.isEmpty();
	}

	public boolean add(String e) {
		return messagesList.add(e);
	}

	public void clear() {
		messagesList.clear();
	}

	public Stream<String> stream() {
		return messagesList.stream();
	}
}
