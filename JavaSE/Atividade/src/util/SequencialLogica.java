package util;

public class SequencialLogica implements Logica {

	@Override
	public void logica(int[] vetor, int a, int b) {
		for (int i = a; i < b; i++) {
			vetor[i] = i;
		}		
	}
	
}
