package provaP1;

public class Semaforo {
	public static final int VERDE=0;
	public static final int AMARELO=1;
	public static final int VERMELHO=2;
	public static final int TEMPOVERDE=15000;
	public static final int TEMPOAMARELO=3000;
	private int cor;
	
	public Semaforo() {
		this.cor = Semaforo.VERMELHO;
	}
	
	public synchronized void mudar() {
		this.cor = (this.cor + 1) % 3;
		if (this.cor == Semaforo.VERDE)
			this.notifyAll();
	}

	public int getCor() {
		return cor;
	}
	
	public String getCorStr() {
		switch (this.cor) {
			case Semaforo.AMARELO : return "AM";
			case Semaforo.VERDE : return "VD";
			default : return "VM";
		}
	}
	
	

}
