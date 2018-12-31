import java.util.Random;

public class Carro extends Thread {
	private int sentido;
	private Ponte ponte;

	public Carro(String nome, Ponte ponte, int sentido) {
		super(nome);
		this.ponte = ponte;
		this.sentido = sentido;
		System.out.println("     "+ this.getName() +"("+ Principal.sentido(this.sentido) +") criado");
	}

	public void run() {
		this.ponte.atravessar(this);
	}
	
	public void atravessar() {
		int tempo = (new Random()).nextInt(Principal.TEMPOTRAVESSIA);
		System.out.println("     "+ this.getName() +"("+ Principal.sentido(this.sentido) +") inicia a travessia e ira demorar "+ tempo);
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int getSentido() {
		return this.sentido;
	}
	
}