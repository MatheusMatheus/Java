import java.util.Random;

public class Principal {
	public static final int QTDCARROS = 20;
	public static final int TEMPOENTRECARROS = 2000;
	public static final int TEMPOTRAVESSIA = 5000;

	public static void main(String args[]) {
		Random rand = new Random();
		Ponte ponte = new Ponte();
		System.out.println(".......................................................");
		System.out.println("INICIANDO A TRAVESSIA - (sentido) - [qtdCarroPonte]....");
		System.out.println(".......................................................");
		for (int i=1; i<=Principal.QTDCARROS; i++) {
			(new Carro("Carro"+i, ponte, rand.nextInt(2))).start();
			try {
				Thread.sleep(rand.nextInt(Principal.TEMPOENTRECARROS));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(".......................................................");
		System.out.println("FIM DA TRAVESSIA.......................................");
		System.out.println(".......................................................");
	}
	
	public static String sentido(int sentido) {
		if (sentido == 0)
			return "AB";
		return "BA";
	}

}
