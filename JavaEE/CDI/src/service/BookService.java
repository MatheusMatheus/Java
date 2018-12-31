package service;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

import beans.Digits;
import beans.NumberOfDigits;
import model.Book;

public class BookService {

	@Inject @NumberOfDigits(value = Digits.THIRTEEN, odd = false)
	private NumberGenerator numberGenerator;
	
	@Inject 
	private Logger logger;
	
	@Inject
	private EntityManager em;
	
	public Book createBook(String title, Float price, String description) {
		Book book = new Book(title, price, description);
		book.setIsbn(numberGenerator.generateNumber());
		return book;
	}
	
	public void createCostumer(Book book) {
		em.persist(book);
	}
	
	public Book findBook(Long id) {
		return em.find(Book.class, id);
	}
	
	@AroundInvoke
	private Object logMethod(InvocationContext ic) throws Exception {
		logger.entering(ic.getTarget().toString(), ic.getMethod().getName());
		try {
			return ic.proceed();
		} finally {
			logger.exiting(ic.getTarget().toString(), ic.getMethod().getName());
		}
	}
}
