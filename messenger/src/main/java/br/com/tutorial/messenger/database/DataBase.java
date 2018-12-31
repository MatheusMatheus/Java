package br.com.tutorial.messenger.database;

import java.util.HashMap;
import java.util.Map;

import br.com.tutorial.messenger.model.Message;
import br.com.tutorial.messenger.model.Profile;

public class DataBase {
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
}
