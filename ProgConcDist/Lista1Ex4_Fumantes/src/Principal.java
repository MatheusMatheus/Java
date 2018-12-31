import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Principal {

	public static void main(String args[]) {
		System.out.println("......................................................");
		System.out.println("INICIANDO A FUMACAO...................................");
		System.out.println("......................................................");
		Lock fosforo = new ReentrantLock();
		Lock fumo = new ReentrantLock();
		Lock palha = new ReentrantLock();
		
		(new Agente("Agente", fosforo, fumo, palha)).start();

		(new Fumante("Fumante1 (falta fosforo)", fosforo, new ReentrantLock(), new ReentrantLock())).start();
		(new Fumante("Fumante2 (falta fumo)", new ReentrantLock(), fumo, new ReentrantLock())).start();
		(new Fumante("Fumante3 (falta palha)", new ReentrantLock(), new ReentrantLock(), palha)).start();
	}

}
