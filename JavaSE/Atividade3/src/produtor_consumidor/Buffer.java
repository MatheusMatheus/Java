package produtor_consumidor;

public class Buffer {
	private static final int TAM_BUFFER = 5;
	private static final int QTD_PRODUTORES = 7;
	private static final int QTD_CONSUMIDORES = 4;
	private static final char TEM_ELEMENTO = 'X';
	private static final char N_TEM_ELEMENTO = '0';

	char[] buffer = new char[TAM_BUFFER];
	Thread[] consumidores = new Thread[QTD_CONSUMIDORES];
	Thread[] produtores = new Thread[QTD_PRODUTORES];

	public static void main(String[] args) {
		Buffer prodCons = new Buffer();
		prodCons.start();
		System.out.println("Estado final do buffer");
		prodCons.mostrar();
	}

	public Buffer() {
		init(consumidores, produtores);
	}

	public synchronized boolean inserir() {

		if (estaCheio()) {
			esperar();
			return false;
		} else
			notifyAll();

		int i = 0;
		while (getBuffer()[i] == TEM_ELEMENTO && i < getBuffer().length - 1)
			i++;

		if (getBuffer()[i] == N_TEM_ELEMENTO) {
			getBuffer()[i] = TEM_ELEMENTO;
			mostrar();
			return true;
		} else
			return false;
	}

	public synchronized boolean retirar() {
		if (estaVazio()) {
			esperar();
			return false;
		} else
			notifyAll();

		int i = 0;
		while (getBuffer()[i] == N_TEM_ELEMENTO && i < getBuffer().length - 1)
			i++;

		if (getBuffer()[i] == TEM_ELEMENTO) {
			getBuffer()[i] = N_TEM_ELEMENTO;
			mostrar();
			return true;
		} else
			return false;
	}

	public synchronized boolean estaCheio() {
		for (int i = 0; i < this.buffer.length; i++)
			if (getBuffer()[i] == N_TEM_ELEMENTO)
				return false;
		return true;
	}

	public synchronized boolean estaVazio() {
		for (int i = 0; i < this.buffer.length; i++)
			if (getBuffer()[i] == TEM_ELEMENTO)
				return false;
		return true;
	}

	public void mostrar() {
		synchronized (this) {
			System.out.print("\nEstado do buffer[ ");
			for (int i = 0; i < getBuffer().length; i++)
				System.out.print(getBuffer()[i] + " ");
			System.out.println("]");
		}
	}

	private void iniciaBuffer(char[] buffer) {
		for (int i = 0; i < getBuffer().length; i++)
			getBuffer()[i] = N_TEM_ELEMENTO;
	}

	private void init(Thread[] consumidores, Thread[] produtores) {
		for (int i = 0; i < consumidores.length; i++)
			this.consumidores[i] = new Thread(new Consumidor("Consumidor " + (i + 1), this));

		for (int i = 0; i < produtores.length; i++)
			this.produtores[i] = new Thread(new Produtor("Produtor " + (i + 1), this));

		iniciaBuffer(this.buffer);
	}

	private void start() {
		for (int i = 0; i < produtores.length; i++)
			this.produtores[i].start();

		for (int i = 0; i < consumidores.length; i++)
			this.consumidores[i].start();

		try {
			for (int i = 0; i < consumidores.length; i++)
				this.consumidores[i].join();

			for (int i = 0; i < produtores.length; i++)
				this.produtores[i].join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}

	public synchronized char[] getBuffer() {
		return buffer;
	}

	public synchronized void esperar() {
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
