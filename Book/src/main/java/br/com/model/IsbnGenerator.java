package br.com.model;

import java.util.Random;
import java.util.logging.Logger;

import javax.inject.Inject;

import br.com.util.log.Loggable;
import br.com.util.qualifiers.ThirteenDigits;

@ThirteenDigits
@Loggable
public class IsbnGenerator implements NumberGenerator {

	@Inject
	private Logger logger;
	
	public String generateNumber() {
		String isbn = "13-84356-" + Math.abs(new Random().nextInt());
		logger.info("Generated ISBN : " + isbn);
		return isbn;
	}

}
