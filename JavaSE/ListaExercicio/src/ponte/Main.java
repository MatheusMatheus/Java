package ponte;

import java.util.concurrent.locks.Lock;

public class Main {
	private Lock ponte;
	private Carro[] carrosA = new Carro[10];
	private Carro[] carrosB = new Carro[10];
	
	public Main() {
		for(int i = 0; i < carrosA.length; i++)
			this.carrosA[i] = new Carro();

		for(int i = 0; i < carrosB.length; i++)
			this.carrosB[i] = new Carro();
	}
}
