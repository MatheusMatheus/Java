import provaP1.Carro;
import provaP1.Cruzamento;

public class Principal {

	public static void main(String[] args) {
		Cruzamento cruzamento = new Cruzamento(4);
		for (int i=1; i<21; i++)
			(new Carro("Carro"+i, cruzamento)).start();
		cruzamento.executarSemaforos();
	}

}
