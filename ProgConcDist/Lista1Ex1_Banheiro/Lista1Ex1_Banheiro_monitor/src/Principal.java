public class Principal {
	public static final int QTDPESSOAS = 20;

	public static void main(String args[]) {
		Banheiro banheiro = new Banheiro();
		System.out.println("......................................................");
		System.out.println("INICIANDO A FESTA - Implementado com monitor .........");
		System.out.println("......................................................");
		for (int i=1; i<=Principal.QTDPESSOAS; i++)
			(new Pessoa("Pessoa"+i, banheiro)).start();
	}

}
