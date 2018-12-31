package filosofos;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Mesa {
	private static final int qtdFilosofos = 5;
	private Filosofo[] filosofos;

	public static void main(String[] args) {
		Mesa mesa = new Mesa();
		System.out.println("Os filósofos começaram a jantar");
		mesa.iniciar();
		System.out.println("Acabou o jantar");
		
	}
	
	public Mesa() {
		Lock[] hashis = new Lock[qtdFilosofos];
		for(int i = 0; i < hashis.length; i++)
			hashis[i] = new ReentrantLock();
		
		this.filosofos = new Filosofo[qtdFilosofos];
		
		for(int i = 0; i < this.filosofos.length; i++)
			this.filosofos[i] = new Filosofo("Filósofo " + (i + 1), hashis[i], hashis[(i + 1) % qtdFilosofos]);
		}
	
	public void iniciar() {
		for(int i = 0; i < this.filosofos.length; i++)
			this.filosofos[i].start();
		
		try {
			for(int i = 0; i < this.filosofos.length; i++)
				this.filosofos[i].join();
		} catch (InterruptedException e) {

		}
	}
	
}
