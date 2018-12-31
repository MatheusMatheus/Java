package jantar;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Mesa {
	private static final int qtdFilosofos = 5;
	Filosofo[] filosofos = new Filosofo[qtdFilosofos];
	Lock[] hashis = new Lock[qtdFilosofos]; 
	
	public Mesa() {
		for(int i = 0; i < qtdFilosofos; i++)
			this.hashis[i] = new ReentrantLock();
			
		for(int i = 0; i < qtdFilosofos; i++)
			this.filosofos[i] = new Filosofo("Filosofo " + (i + 1), this.hashis[i], this.hashis[(i + 1) % qtdFilosofos]);
	
	}
	
	public static void main(String[] args) {
		Mesa mesa = new Mesa();
		System.out.println("O jantar vai começar");
		mesa.iniciar();
		System.out.println("O jantar terminou");
	}
	
	public void iniciar() {
		Thread[] pupiloFilosofo = new Thread[qtdFilosofos];
		for(int i = 0; i < qtdFilosofos; i++)
			pupiloFilosofo[i] = new Thread(this.filosofos[i]);

	
		for(int i = 0; i < qtdFilosofos; i++)
			pupiloFilosofo[i].start();
		
		for(int i = 0; i < qtdFilosofos; i++) {
			try {
				pupiloFilosofo[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
	
	
}


