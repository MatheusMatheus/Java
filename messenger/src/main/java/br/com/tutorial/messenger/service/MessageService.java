package br.com.tutorial.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.tutorial.messenger.database.DataBase;
import br.com.tutorial.messenger.model.Message;

public class MessageService {
	private Map<Long, Message> messages = DataBase.getMessages();

	public MessageService() {
		messages.put(1L, new Message(1, "Hello World", "Matheus"));
		messages.put(2L, new Message(2, "Hello World", "Matheus"));
	}

	public List<Message> getAllMessages() {
		return new ArrayList<>(messages.values());
	}

	public Message getMessage(long id) {
		return messages.get(id);
	}

	public Message addMessage(Message m) {
		m.setId(messages.size() + 1);
		messages.put(m.getId(), m);
		return m;
	}

	public Message updateMessage(Message m) {
		if (m.getId() <= 0)
			return null;
		messages.put(m.getId(), m);
		return m;
	}

	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}
