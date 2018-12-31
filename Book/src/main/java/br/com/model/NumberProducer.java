package br.com.model;

import javax.enterprise.inject.Produces;

import br.com.util.qualifiers.Random;
import br.com.util.qualifiers.ThirteenDigits;

public class NumberProducer {
	@Produces @ThirteenDigits
	private String prefix13digits = "13-";
	
	@Produces @ThirteenDigits
	private int editorNumber = 84356;
	
	@Produces @Random
	public double random() {
		return Math.abs(new java.util.Random().nextInt());
	}
}
