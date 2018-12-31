package jantar;

public class Tijela {
	private int arroz;
	
	public Tijela() {
		this.arroz = 100;
	}
	
	
	public boolean comer() {
		if(arroz <= 0)
			return false;
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		
		this.arroz -= 20;
		return true;
	}
	
	public boolean isVazia() {
		return this.arroz <= 0 ? true : false;
	}

	public int getArroz() {
		return arroz;
	}
}
