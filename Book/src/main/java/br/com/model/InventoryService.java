package br.com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import br.com.util.qualifiers.Added;
import br.com.util.qualifiers.Removed;

public class InventoryService {

	@Inject
	private Logger logger;
	
	List<Book> inventory = new ArrayList<>();

	
	public void addBook(@Observes @Added  Book book) {
		logger.info("Adding book " + book.getTitle() + " to inventory");
		inventory.add(book);
	}

	
	public void removeBook(@Observes @Removed Book book) {
		logger.warning("Removing book " + book.getTitle() + " to inventory");
		inventory.remove(book);
	}
}
