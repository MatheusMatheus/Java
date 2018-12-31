package provaP1;

public class Cruzamento {
	private int qtdSemaforos; 
	private Semaforo semaforos[];

	public Cruzamento(int qtdSemaforos) {
		this.qtdSemaforos = qtdSemaforos;
		this.semaforos = new Semaforo[qtdSemaforos];
		for (int i=0; i<qtdSemaforos; i++)
			this.semaforos[i] = new Semaforo();
	}

	public void executarSemaforos() {
		try {
			int semaforo = 0;
			this.desenhar();
			while (true) {
				this.semaforos[semaforo].mudar(); // Verde
				this.desenhar();
				Thread.sleep(Semaforo.TEMPOVERDE);
				this.semaforos[semaforo].mudar(); // Amarelo
				this.desenhar();
				Thread.sleep(Semaforo.TEMPOAMARELO);
				this.semaforos[semaforo].mudar(); // Vermelho
				this.desenhar();
				semaforo = (semaforo + 1) % this.qtdSemaforos;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void desenhar() {
		System.out.println("       |    |");
		System.out.println("       | 0  |");
		System.out.println("       |("+ this.semaforos[0].getCorStr() +")|");
		System.out.println("-------+    +-------");
		System.out.println("  3 ("+ this.semaforos[3].getCorStr() +")    ("+ this.semaforos[1].getCorStr() +") 1");
		System.out.println("-------+    +-------");
		System.out.println("       |("+ this.semaforos[2].getCorStr() +")|");
		System.out.println("       |  2 |");
		System.out.println("       |    |");
	}

	public Semaforo[] getSemaforos() {
		return semaforos;
	}

}
