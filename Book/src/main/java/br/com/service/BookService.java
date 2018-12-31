package br.com.service;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import br.com.model.Book;
import br.com.model.NumberGenerator;
import br.com.util.log.Loggable;
import br.com.util.qualifiers.Added;
import br.com.util.qualifiers.Digits;
import br.com.util.qualifiers.NumberOfDigits;
import br.com.util.qualifiers.Removed;

public class BookService {
	@Inject
	@NumberOfDigits(value = Digits.THIRTEEN, odd = false)
	private NumberGenerator numberGenerator;
	
	@Inject @Added
	private Event<Book> bookAddedEvent;
	
	@Inject @Removed
	private Event<Book> bookRemovedEvent;
	
	public Book createBook(String title, Float price, String description) {
		Book book = new Book(title, price, description);
		book.setNumber(numberGenerator.generateNumber());
		bookAddedEvent.fire(book);
		return book;
	}
	
	public void deleteBook(Book book) {
		bookRemovedEvent.fire(book);
	}
}
