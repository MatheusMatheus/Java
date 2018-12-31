package primos;

public class SomaParcial implements Runnable {
	private int inicio;
	private int fim;
	private long soma;

	public SomaParcial(int inicio, int fim) {
		super();
		this.inicio = inicio;
		this.fim = fim;
		this.soma = 0;
	}
	
	@Override
	public void run() {
		for (int i = inicio; i < fim; i++)
			if (isPrimo(i))
				this.soma += i;
	}
	
	public static boolean isPrimo(int n) {
		if (n < 2)
			return false;
		for (int j = 2; j < n; j++)
			if (n % j == 0)
				return false;
		return true;
	}

	public long getSoma() {
		return soma;
	}

}