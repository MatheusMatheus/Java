import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ponte {
	public static final int AB = 0;
	public static final int BA = 1;
	private int sentido;
	private Lock lock;
	private Condition podeAB;
	private Condition podeBA;
	private int qtdCarrosPonte;
	private boolean inverterSentido;

	public Ponte() {
		this.lock = new ReentrantLock();
		this.podeAB = this.lock.newCondition();
		this.podeBA = this.lock.newCondition();
		this.sentido = Ponte.AB;
		this.inverterSentido = false;
	}

	public void atravessar(Carro carro) {
		System.out.println("PONTE("+ Principal.sentido(this.sentido) +")["+ this.qtdCarrosPonte +"]: "+ carro.getName() +"("+ carro.getSentido() +") chegou");
		this.lock.lock();
		try {
			if (carro.getSentido() != this.sentido) {
				this.inverterSentido = true;
				while (carro.getSentido() != this.sentido) {
					System.out.println("PONTE("+ Principal.sentido(this.sentido) +")["+ this.qtdCarrosPonte +"]: "+ carro.getName() +"("+ carro.getSentido() +") entra na fila");
					switch (carro.getSentido()) {
						case Ponte.AB: this.podeAB.await(); break;
						case Ponte.BA: this.podeBA.await();
					}
				}
				System.out.println("PONTE("+ Principal.sentido(this.sentido) +")["+ this.qtdCarrosPonte +"]: "+ carro.getName() +"("+ carro.getSentido() +") sai da fila");
			}
			this.qtdCarrosPonte++;
			System.out.println("PONTE("+ Principal.sentido(this.sentido) +")["+ this.qtdCarrosPonte +"]: "+ carro.getName() +"("+ carro.getSentido() +") entrou na ponte");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			this.lock.unlock();
		}
		carro.atravessar();
		this.lock.lock();
		try {
			this.qtdCarrosPonte--;
			System.out.println("PONTE("+ Principal.sentido(this.sentido) +")["+ this.qtdCarrosPonte +"]: "+ carro.getName() +"("+ carro.getSentido() +") saiu da ponte ----------------");
			if ((this.inverterSentido) && (this.qtdCarrosPonte == 0)) {
				this.inverterSentido();
				this.inverterSentido = false;
				this.podeBA.signalAll();
				this.podeAB.signalAll();
			}
		} finally {
			this.lock.unlock();
		}
	}

	private void inverterSentido() {
		System.out.print("PONTE("+ Principal.sentido(this.sentido) +")["+ this.qtdCarrosPonte +"] ########### VIROU ########### ");
		this.sentido = (this.sentido+1)%2; 
		System.out.println("PONTE("+ Principal.sentido(this.sentido) +")["+ this.qtdCarrosPonte +"]");
	}
	
}
