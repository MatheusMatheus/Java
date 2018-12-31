import java.util.Random;
import java.util.concurrent.Semaphore;

public class Pessoa extends Thread {
	public static final int TEMPON1 = 2000;
	public static final int TEMPON2 = 10000;
	public static final int TEMPOVOLTAR = 50000;
	private Semaphore banheiro;
	
	public Pessoa(String nome, Semaphore banheiro) {
		super(nome);
		this.banheiro = banheiro;
	}

	public void run() {
		while (true) {
			System.out.println(this.getName() +" quer usar o banheiro");
			switch ((new Random()).nextInt(2)) {
			case 0: this.fazerNumero1(); break;
			case 1: this.fazerNumero2();
			}
			try {
				Thread.sleep((new Random()).nextInt(Pessoa.TEMPOVOLTAR));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void fazerNumero1() {
		try {
			this.banheiro.acquire();
			System.out.println(this.getName() +" fazendo o numero 1 ++++++++++");
			try {
				Thread.sleep((new Random()).nextInt(Pessoa.TEMPON1));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(this.getName() +" terminou o numero 1 ---------");
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} finally {
			this.banheiro.release();
		}
	}

	public void fazerNumero2() {
		try {
			this.banheiro.acquire();
			System.out.println(this.getName() +" fazendo o numero 2 ++++++++++");
			try {
				Thread.sleep((new Random()).nextInt(Pessoa.TEMPON2));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(this.getName() +" terminou o numero 2 ---------");
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} finally {
			this.banheiro.release();
		}
	}

}
