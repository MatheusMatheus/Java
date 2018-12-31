package barbearia;

import java.util.Random;

public class Barbeiro extends Thread {
	private Barbearia barbearia;

	public Barbeiro(String nome, Barbearia barbearia) {
		super(nome);
		this.barbearia = barbearia;
	}

	public synchronized void run() {
		Cliente cliente;
		System.out.println(this.getName() +" chegou");
		while (true) {
			synchronized (this.barbearia.getCadeirasEspera()) {
				cliente = null;
				do {
					if (this.barbearia.getCadeirasEspera().size() == 0) {
						System.out.println(this.getName() +" dormindo...");
						try {
							this.barbearia.getCadeirasEspera().wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println(this.getName() +" acordou");
					if (this.barbearia.getCadeirasEspera().size() > 0)
						cliente = this.barbearia.levantar();
				} while (cliente == null);
			}
			this.cortarCabelo(cliente);
		}
	}

	public void cortarCabelo(Cliente cliente) {
		System.out.println(this.getName() +" CORTANDO o cabelo do "+ cliente.getName() +"{"+ cliente.getCabelo().getTamanho() +"}");
		try {
			Thread.sleep((new Random().nextInt(5000)));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		cliente.getCabelo().cortar(3);
		System.out.println(this.getName() +" CORTOU o cabelo do "+ cliente.getName() +"{"+ cliente.getCabelo().getTamanho() +"}");
	}

}