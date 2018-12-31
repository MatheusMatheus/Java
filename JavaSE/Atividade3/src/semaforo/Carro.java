package semaforo;

import java.util.concurrent.Semaphore;

public class Carro extends Thread {
	private static Semaphore estacionamento = new Semaphore(10, true);

	public Carro(String nome) {
		super(nome);
	}

	public void run() {
		try {
			estacionamento.acquire();
			System.out.println("--> " + this.getName() + " entrou");
			sleep((long) (Math.random() * 10000));
			System.out.println(this.getName() + " saiu");
			estacionamento.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		for (int i = 1; i <= 20; i++)
			new Carro("Carro " + i).start();
	}
}
