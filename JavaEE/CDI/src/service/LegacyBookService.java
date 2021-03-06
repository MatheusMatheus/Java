package service;

import javax.inject.Inject;

import beans.Digits;
import beans.NumberOfDigits;
import model.Book;

public class LegacyBookService {

	@Inject @NumberOfDigits(value = Digits.EIGHT, odd = true)
	private NumberGenerator numberGenerator;
	
	public Book createBook(String title, Float price, String description) {
		Book book = new Book(title, price, description);
		book.setIsbn(numberGenerator.generateNumber());
		return book;
	}
}