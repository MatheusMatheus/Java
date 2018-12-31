package banheiro;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Pessoa implements Runnable {
	private Banheiro banheiro;
	private ReentrantLock lock;
	private AtomicInteger qtdPessoas;
	private AtomicReference<String> string;
	private Condition condicao;

	public Pessoa(Banheiro banheiro, int qtdPessoas) {
		this.banheiro = banheiro;
		this.lock = (ReentrantLock) banheiro.getUso();
		this.qtdPessoas = new AtomicInteger(qtdPessoas);
		this.string = new AtomicReference<>("Uma pessoa está usando o banheiro");
		this.condicao = lock.newCondition();
	}

	@Override
	public void run() {
		while (qtdPessoas.get() >= 0) {
			System.out.println(qtdPessoas.get());
			if (this.lock.tryLock()) {
				String texto = this.string.get();
				System.out.print(texto);
				switch (new Random().nextInt(3)) {
				case 1:
					System.out.println(texto + " para fazer o número 1");
					usarBanheiro(500);
					liberarBanheiro();
					break;
				case 2:
					System.out.println(texto + " para fazer o número 2");
					usarBanheiro(1000);
					liberarBanheiro();
					break;
					default:
						this.lock.unlock();
				}
			} else {
				esperar();
			}
		}
		System.out.println("Fim do loop");
	}

	private void liberarBanheiro() {
		System.out.println("Uma pessoa saiu do banheiro");
		this.lock.unlock();
		this.qtdPessoas.decrementAndGet();
	}

	private synchronized void esperar() {
		try {
			System.out.println("Banheiro ocupado");
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void usarBanheiro(long tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}