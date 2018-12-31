package util;

public class PopulaVetor {
	private int vetor[];
	private int nThreads;
	private Logica logica;
	
	public PopulaVetor(int vetor[], int nThreads, Logica logica) {
		this.logica = logica;
		this.vetor = vetor;
		this.nThreads = (vetor.length / nThreads % 2 != 0) ? nThreads + 1 : nThreads;
	}
	
	public void popular() {
		int porcoes = vetor.length / nThreads; // 4
		Thread threads[] = new Thread[nThreads];
		int fim = vetor.length; // 19

		for(int i = 0; i < threads.length; i++) { // -> 0 -> 1 -> 2 -> 3
			int fatiaVetor = fim - porcoes; // 15 -> 11 -> 7 -> 3 -> -1
			threads[i] = new Thread(new Popula(vetor, fatiaVetor, fim, this.logica));
			fim = fatiaVetor; // 15 -> 11 -> 7 -> 3
			threads[i].start();
		}
		
		
		for(int t = 0; t < threads.length; t++) {
			try {
				threads[t].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			};
		}
	}
}

class Popula implements Runnable {

	private int vetor[];
	private int inicio;
	private int fim;
	private Logica logica;

	public Popula(int vetor[], int inicio, int fim, Logica logica) {
		this.logica = logica;
		this.vetor = vetor;
		this.inicio = (inicio < 0) ? 0 : inicio;
		this.fim = fim;
	}
	
	@Override
	public void run() {
		this.logica.logica(vetor, inicio, fim);
	}
	
}

