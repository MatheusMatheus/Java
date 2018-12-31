import java.util.Random;

public class Pessoa extends Thread {
	public static final int TEMPOENTRECARTAS = 15000;
	private Cidade cidade;

	public Pessoa(String nome, Cidade cidade) {
		super(nome);
		this.cidade = cidade;
	}

	public void run() {
		while (true) {
			this.escreverCarta();
			try {
				Thread.sleep((new Random()).nextInt(Pessoa.TEMPOENTRECARTAS));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void escreverCarta() {
		this.cidade.enviarCarta(new Carta());
		System.out.println("     "+ this.getName() +" depositou carta. Caixa Postal["+ this.cidade.getCaixaPostal().size() +"]");
	}
	
}