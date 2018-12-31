package filosofos;

public class Tijela {
	private int arroz;

	public Tijela() {
		this.arroz = 100;
	}

	public boolean comer() {
		if (this.arroz == 0)
			return false;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			return false;
		}

		this.arroz -= 20;
		return true;
	}

	public boolean vazia() {
		return this.arroz <= 0;
	}

	public int getArroz() {
		return arroz;
	}

}
