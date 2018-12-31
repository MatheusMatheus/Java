import java.util.ArrayList;
import java.util.List;

public class Pombo extends Thread {
	public static final int QTDCARTAS = 5;
	private Cidade cidadeOrigem;
	private Cidade cidadeDestino;
	private List<Carta> bolsa;

	public Pombo(String nome, Cidade cidadeOrigem, Cidade cidadeDestino) {
		super(nome);
		this.cidadeOrigem = cidadeOrigem;
		this.cidadeDestino = cidadeDestino;
		this.bolsa = new ArrayList<Carta>();
	}

	public void run() {
		while (true)
			this.levarCarta(this.cidadeOrigem, this.cidadeDestino);
	}

	public void levarCarta(Cidade cidadeOrigem, Cidade cidadeDestino) {
		List<Carta> caixaPostal = cidadeOrigem.getCaixaPostal();
		System.out.println(this.getName() +"["+ this.bolsa.size() +"] pronto para levar. Caixa Postal["+ caixaPostal.size() +"]");
		synchronized (caixaPostal) {
			do {
				if (caixaPostal.size() < Pombo.QTDCARTAS)
					try {
						caixaPostal.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				System.out.println(this.getName() +"["+ this.bolsa.size() +"] vai pegar cartas. Caixa Postal["+ caixaPostal.size() +"]");
				if (caixaPostal.size() >= Pombo.QTDCARTAS)
					for (int i=0; i<Pombo.QTDCARTAS; i++)
						this.bolsa.add(caixaPostal.remove(0));
			} while (this.bolsa.size() < Pombo.QTDCARTAS);
		}
		System.out.println(this.getName() +"["+ this.bolsa.size()  +"] ---VOANDO--- para destino. Caixa Postal["+ caixaPostal.size() +"]");
		// Voa para o destino
		cidadeDestino.receberCarta(this.bolsa);
		this.entrarGaiola();
		System.out.println(this.getName() +"["+ this.bolsa.size() +"] ***VOLTANDO*** para casa");
	}
	
	private void entrarGaiola() {
		Gaiola gaiola=this.cidadeDestino.getGaiola();
		System.out.println(this.getName() +"["+ this.getBolsa().size() +"] entrou na gaiola. Gaiola["+ gaiola.getQtdPombos() +"]");
		synchronized (gaiola) {
			gaiola.entrar();
			try {
				gaiola.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Carta> getBolsa() {
		return bolsa;
	}

}