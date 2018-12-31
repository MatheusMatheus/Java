package concorrencia.synchronizing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SheepManagerSynchronized {
	private int sheepCount = 0;
	
	/*private final Object lock = new Object();
	private void incrementAndReport() {
		synchronized (lock) {
			System.out.print((++sheepCount) + " ");
		}
	}*/

	private void incrementAndReport() {
		synchronized (this) {
			System.out.print((++sheepCount) + " ");
		}
	}
	
	/*private void incrementAndReport() {
		synchronized (SheepManagerSynchronized.class) {
			System.out.print((++sheepCount) + " ");
		}
	}*/

/*	private synchronized void incrementAndReport() {
		System.out.print((++sheepCount) + " ");
	}
*/
	
	// Pode-se usar quaisquer da maneiras acima para sincronizar a operação de soma, não há diferenças
	
	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(20);
			SheepManagerSynchronized manager = new SheepManagerSynchronized();
			for (int i = 0; i < 10; i++)
				service.submit(() -> manager.incrementAndReport());
		} finally {
			if (service != null)
				service.shutdown();
		}
	}
}
