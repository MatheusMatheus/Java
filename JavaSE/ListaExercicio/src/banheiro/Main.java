package banheiro;

public class Main {
	private static int QTD_PESSOAS = 5;
	public static void main(String[] args) {
		
		Banheiro banheiro = new Banheiro();
		Thread[] threads = new Thread[QTD_PESSOAS];

		for(int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new Pessoa(banheiro, QTD_PESSOAS));
			threads[i].start();
		}
		
		for(int i = 0; i < threads.length; i++)
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("Todo mundo terminou de mijar ou cagar");
	}
}