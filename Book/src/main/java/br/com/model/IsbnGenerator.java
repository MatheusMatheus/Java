package br.com.model;

import java.util.logging.Logger;

import javax.inject.Inject;

import br.com.util.log.Loggable;
import br.com.util.qualifiers.Digits;
import br.com.util.qualifiers.NumberOfDigits;
import br.com.util.qualifiers.Random;
import br.com.util.qualifiers.ThirteenDigits;


@NumberOfDigits(value = Digits.THIRTEEN, odd = false)
public class IsbnGenerator implements NumberGenerator {

	@Inject
	private Logger logger;

	@Inject
	@ThirteenDigits
	private String prefix;

	@Inject
	@ThirteenDigits
	private int editorNumber;

	@Inject
	@Random
	private double posfix;

	@Loggable
	public String generateNumber() {
		String isbn = prefix + editorNumber + posfix;
		logger.info("Generated ISBN : " + isbn);
		return isbn;
	}

}
