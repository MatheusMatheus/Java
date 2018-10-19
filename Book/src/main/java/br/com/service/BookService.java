package br.com.service;

import javax.inject.Inject;

import br.com.model.Book;
import br.com.model.NumberGenerator;
import br.com.util.log.Loggable;
import br.com.util.qualifiers.ThirteenDigits;

@Loggable
public class BookService {
	@Inject
	@ThirteenDigits
	private NumberGenerator numberGenerator;

	public Book createBook(String title, Float price, String description) {
		Book book = new Book(title, price, description);
		book.setNumber(numberGenerator.generateNumber());
		return book;
	}
}
