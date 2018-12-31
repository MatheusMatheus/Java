package filosofos;

import java.util.concurrent.locks.Lock;

public class Filosofo extends Thread {
	private Tijela tijela;
	private Lock hashiDireita;
	private Lock hashiEsquerda;

	public Filosofo(String nome, Lock hashiDireita, Lock hashiEsquerda) {
		super(nome);
		this.tijela = new Tijela();
		this.hashiDireita = hashiDireita;
		this.hashiEsquerda = hashiEsquerda;
	}

	@Override
	public void run() {
		while(!this.tijela.vazia()) {
			while(!this.hashiEsquerda.tryLock());
			while(!this.hashiDireita.tryLock());
			this.tijela.comer();
			System.out.println(getName() + " comeu! Sobrou " + tijela.getArroz());
			this.hashiEsquerda.unlock();
			this.hashiDireita.unlock();
			this.esperar(3000);
		}
		
		System.out.println(this.getName() + " acabou de comer");
	}
	
	private void esperar(long tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
}
