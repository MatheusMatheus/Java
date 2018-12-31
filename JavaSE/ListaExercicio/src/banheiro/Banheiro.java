package banheiro;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banheiro {
	private Lock uso;
	
	public Banheiro() {
		this.uso = new ReentrantLock();
	}

	public Lock getUso() {
		return uso;
	}

	public void setUso(Lock uso) {
		this.uso = uso;
	}
	
	
}
