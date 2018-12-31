package produtor_consumidor;

public class Consumidor implements Runnable {
	private String nome;
	private Buffer buffer;

	public Consumidor(String nome, Buffer buffer) {
		this.nome = nome;
		this.buffer = buffer;
	}

	@Override
	public void run() {
		while ( !this.buffer.estaVazio() ) {
			if (this.buffer.retirar()) {
				System.out.println(this.nome + " consumiu um dado do buffer.");
			} else
				System.out.println("Buffer vazio, " + this.nome + " irá esperar.");
		}
	}

}
