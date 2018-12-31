import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Principal {
	public static final int QTDPESSOAS = 20;

	public static void main(String args[]) {
		Lock banheiro = new ReentrantLock();
		System.out.println("......................................................");
		System.out.println("INICIANDO A FESTA - Implementado com lock ............");
		System.out.println("......................................................");
		for (int i=1; i<=Principal.QTDPESSOAS; i++)
			(new Pessoa("Pessoa"+i, banheiro)).start();
	}

}
