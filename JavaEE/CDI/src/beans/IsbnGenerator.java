package beans;

import java.util.Random;

import service.NumberGenerator;

@ThirteenDigits
public class IsbnGenerator implements NumberGenerator {

	@Override
	public String generateNumber() {
		return "13-84356-" + Math.abs(new Random().nextInt());
	}

}
