package barbearia;

public class Cabelo {
	private int tamanho;
	
	public Cabelo(int tamanho) {
		this.tamanho = tamanho;
	}
	
	public synchronized void cortar(int qtd) {
		this.tamanho -= qtd;
		this.notify();
	}

	public int getTamanho() {
		return tamanho;
	}

}
