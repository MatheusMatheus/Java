import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Agente extends Thread {
	private Lock fosforo;
	private Lock fumo;
	private Lock palha;

	public Agente(String nome, Lock fosforo, Lock fumo, Lock palha) {
		super(nome);
		this.fosforo = fosforo;
		this.fumo = fumo;
		this.palha = palha;
		System.out.println("Agente criado");
	}

	public void run() {
		this.fosforo.lock();
		this.fumo.lock();
		this.palha.lock();
		while (true) {
			switch ((new Random()).nextInt(3)) {
			case 0: 
				System.out.println("Sorteou FOSFORO");
				if (((ReentrantLock)this.fosforo).isHeldByCurrentThread())
					this.fosforo.unlock();
				break;
			case 1:
				System.out.println("Sorteou FUMO   ");
				if (((ReentrantLock)this.fumo).isHeldByCurrentThread())
					this.fumo.unlock();
				break;
			case 2:
				System.out.println("Sorteou PALHA  ");
				if (((ReentrantLock)this.palha).isHeldByCurrentThread())
					this.palha.unlock();
			}
			try {
				Thread.sleep((new Random()).nextInt(5000)); // Esperando...
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (!((ReentrantLock)this.fosforo).isHeldByCurrentThread()) this.fosforo.lock();
			if (!((ReentrantLock)this.fumo).isHeldByCurrentThread()) this.fumo.lock();
			if (!((ReentrantLock)this.palha).isHeldByCurrentThread()) this.palha.lock();
		}
	}

}
