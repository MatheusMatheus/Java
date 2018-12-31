package provaP1;

import java.util.Random;

public class Carro extends Thread {
	private Cruzamento cruzamento;

	public Carro(String nome, Cruzamento cruzamento) {
		super(nome);
		this.cruzamento = cruzamento;
	}

	public void run() {
		int sentido;
		try {
			while (true) {
				sentido = (new Random()).nextInt(4);
				System.out.println(this.getName() +" ---deseja cruzar--- no sentido "+ sentido);
				do {
					synchronized (cruzamento.getSemaforos()[sentido]) {
						if (cruzamento.getSemaforos()[sentido].getCor() != Semaforo.VERDE) {
							System.out.println(this.getName() +" [[[parado]]]] no sentido "+ sentido);
							cruzamento.getSemaforos()[sentido].wait();
						}
					}
				} while (cruzamento.getSemaforos()[sentido].getCor() != Semaforo.VERDE);
				System.out.println(this.getName() +" ...CRUZOU... no sentido "+ sentido +" .......................");
				Thread.sleep(5000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
