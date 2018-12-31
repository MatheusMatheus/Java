package jantar;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class Filosofo implements Runnable {
	private String nome;
	private Tijela tijela;
	private Lock hashiDireita;
	private Lock hashiEsqueda;

	public Filosofo(String nome, Lock hashiDireita, Lock hashiEsqueda) {
		super();
		this.nome = nome;
		this.hashiDireita = hashiDireita;
		this.hashiEsqueda = hashiEsqueda;
		this.tijela = new Tijela();
	}

	@Override
	public void run() {
		while (!this.tijela.isVazia()) {
			try {
				while (!this.hashiEsqueda.tryLock(300, TimeUnit.MILLISECONDS))
					;
				if (this.hashiDireita.tryLock()) {
					try {
						this.tijela.comer();
					} finally {
						this.hashiDireita.unlock();
					}
					System.out.println(this.nome + " comeu, ainda resta " + this.tijela.getArroz());
				}
				this.hashiEsqueda.unlock();
				this.esperar(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void esperar(long tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}

}
