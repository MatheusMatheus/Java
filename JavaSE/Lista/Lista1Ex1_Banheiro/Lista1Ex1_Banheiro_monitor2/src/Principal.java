import java.util.Random;

public class Principal {
	public static final int QTDPESSOAS = 20;

	public static void main(String args[]) {
		Banheiro banheiroM = new Banheiro('M');
		Banheiro banheiroF = new Banheiro('F');
		System.out.println("........................................................");
		System.out.println("INICIANDO A FESTA - Implementado com monitor 2 Banheiros");
		System.out.println("........................................................");
		for (int i=1; i<=Principal.QTDPESSOAS; i++) {
			switch ((new Random()).nextInt(2)) {
			case 0: (new Pessoa("Homem"+i, banheiroM)).start(); break;
			case 1: (new Pessoa("Mulher"+i, banheiroF)).start();
			}			
		}
	}

}
