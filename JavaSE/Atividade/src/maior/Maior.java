package maior;

public class Maior implements Runnable {
	private int vetor[];
	private int maiorItem;
	
	public Maior(int vetor[]) {
		this.vetor = vetor;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(50);
			System.out.println("Segunda thread começou");
			maiorItem = vetor[0];
			
			for(int i = 0; i < vetor.length; i++) {
				if (vetor[i] > maiorItem) {
					maiorItem = vetor[i];
				}
			}	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public int getMaior() {
		return maiorItem;
	}
}