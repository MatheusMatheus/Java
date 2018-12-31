package beans;

import java.util.Random;

import service.NumberGenerator;

@EigthDigits
public class IssnGenerator implements NumberGenerator {

	@Override
	public String generateNumber() {
		return "8-" + Math.abs(new Random().nextInt());
	}

}
