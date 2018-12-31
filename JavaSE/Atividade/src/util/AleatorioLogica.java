package util;

import java.util.Random;

public class AleatorioLogica implements Logica {

	@Override
	public void logica(int vetor[], int a, int b) {
		for (int i = a; i < b; i++) {
			vetor[i] = new Random().nextInt(vetor.length);
		}
	}
}