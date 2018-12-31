package produtor_consumidor;

public class Produtor implements Runnable {
	private String nome;
	private Buffer buffer;

	public Produtor(String nome, Buffer buffer) {
		this.nome = nome;
		this.buffer = buffer;
	}

	@Override
	public void run() {
		while (!this.buffer.estaCheio()) {
			if (this.buffer.inserir()) {
				System.out.println(this.nome + " produziu um dado no buffer.");
			} else
				System.out.println("Buffer cheio, " + this.nome + " irá esperar.");
		}

	}

}
