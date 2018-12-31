import java.util.concurrent.Semaphore;

public class Principal {
	public static final int QTDPESSOAS = 20;

	public static void main(String args[]) {
		Semaphore banheiro = new Semaphore(1, true);
		System.out.println("......................................................");
		System.out.println("INICIANDO A FESTA - Implementado com semaforo ........");
		System.out.println("......................................................");
		for (int i=1; i<=Principal.QTDPESSOAS; i++)
			(new Pessoa("Pessoa"+i, banheiro)).start();
	}

}
