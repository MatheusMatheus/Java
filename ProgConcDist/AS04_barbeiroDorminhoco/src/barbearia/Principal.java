package barbearia;

public class Principal {
	public static final int QTDBARBEIROS=2;
	public static final int QTDCLIENTES=12;

	public static void main(String args[]) {
		Barbearia barbearia = new Barbearia();
		for (int i=1; i<=Principal.QTDBARBEIROS; i++)
			(new Barbeiro("Barbeiro"+i, barbearia)).start();
		for (int i=1; i<=Principal.QTDCLIENTES; i++)
			new Cliente("Cliente"+i, 10, barbearia).start();
	}

}
