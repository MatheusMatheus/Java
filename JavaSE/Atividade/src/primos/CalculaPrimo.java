package primos;

public class CalculaPrimo {
	private int vetor[];
	private int qtdThreads;
	private Thread threads[];
	private long somasParciais[];

	public CalculaPrimo(int vetor[], int qtdThreads) {
		this.vetor = vetor;
		this.qtdThreads = (vetor.length / qtdThreads % 2 != 0) ? qtdThreads + 1 : qtdThreads;
		this.threads = new Thread[qtdThreads];
		this.somasParciais = new long[qtdThreads];
		fatiaVetor();
	}

	private void fatiaVetor() {
		int porcoes = vetor.length / qtdThreads; // 4
		int fim = vetor.length; // 19
		for (int i = 0; i < threads.length; i++) { // -> 0 -> 1 -> 2 -> 3
			int fatiaVetor = fim - porcoes; // 15 -> 11 -> 7 -> 3 -> -1
			SomaParcial somaParcial = new SomaParcial(fatiaVetor, fim);
			threads[i] = new Thread(somaParcial);
			fim = fatiaVetor; // 15 -> 11 -> 7 -> 3
			threads[i].start();
			somasParciais[i] = somaParcial.getSoma();
		}
	}

	public long getSoma() {
		esperaThreads();
		long soma = 0;
		for (int i = 0; i < somasParciais.length; i++)
			soma += somasParciais[i];
		return soma;
	}

	private void esperaThreads() {
		try {
			for (int i = 0; i < threads.length; i++)
				threads[i].join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
