package barbeiro;

public class Barbeiro implements Runnable {
	private boolean dormindo = false;
	private Cadeira cadeira;
	private int[] clientes;
	
	public Barbeiro(boolean dormindo, int[] clientes) {
		super();
		this.dormindo = dormindo;
		this.clientes = clientes;
	}

	public void cortar() {
		Barbearia.tempo(2000);
	}
	
	public synchronized void dormir() {
		System.out.println("Não há cliente para atender");
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(true) {
			
		}
	}
}
