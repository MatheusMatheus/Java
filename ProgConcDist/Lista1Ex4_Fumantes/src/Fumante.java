import java.util.Random;
import java.util.concurrent.locks.Lock;

public class Fumante extends Thread {
	private Lock fosforo;
	private Lock fumo;
	private Lock palha;

	public Fumante(String nome, Lock fosforo, Lock fumo, Lock palha) {
		super(nome);
		this.fosforo = fosforo;
		this.fumo = fumo;
		this.palha = palha;
	}

	public void run() {
		while (true) {
			try {
				this.fosforo.lock();
				this.fumo.lock();
				this.palha.lock();
				System.out.println("     "+ this.getName() +" comecando a fumar...");
				Thread.sleep((new Random()).nextInt(10000)); // Fumando...
				System.out.println("     "+ this.getName() +" terminou de fumar!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				this.fosforo.unlock();
				this.fumo.unlock();
				this.palha.unlock();
			}
			try {
				Thread.sleep((new Random()).nextInt(5000)); // Esperando...
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
