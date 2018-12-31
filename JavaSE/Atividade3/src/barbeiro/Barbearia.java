package barbeiro;

import java.util.Random;

public class Barbearia implements Runnable {
	private static final int QTD_CADEIRAS = 5;
	private static final int QTD_BARBEIROS = 3;
	
	private Barbeiro[] barbeiros;
	private boolean[] cadeiras;
	private int clientes;

	public Barbearia() {
		this.clientes = new Random().nextInt(10);
		this.barbeiros = new Barbeiro[QTD_BARBEIROS];
		this.cadeiras = new boolean[QTD_CADEIRAS];
	}
	
	public static void main(String[] args) {
		Barbearia barbearia = new Barbearia();
		barbearia.init();
	}
	
	private void init() {
		
	}
	
	

	public static void tempo(long tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		if(estaOcupada()) {
			
		}
	}
	
	
	private boolean estaOcupada() {
		for(int i = 0; i < this.cadeiras.length; i++) 
			if(this.cadeiras[i] == true)
				return true;
		return false;
	}
}
