public class Principal {
	public static final int QTDPESSOA = 13;
	public static final int QTDPOMBO = 6;
	public static final int QTDTRATADOR = 1;

	public static void main(String args[]) {
		System.out.println("............................................................");
		System.out.println("INICIANDO OS TRABALHOS DOS POMBOS...........................");
		System.out.println("............................................................");
		Cidade cidadeA = new Cidade();
		Cidade cidadeB = new Cidade();
		for (int i=1; i<=Principal.QTDPESSOA; i++)
			(new Pessoa("Pessoa"+i, cidadeA)).start();
		for (int i=1; i<=Principal.QTDPOMBO; i++)
			(new Pombo("Pombo"+i, cidadeA, cidadeB)).start();
		for (int i=1; i<=Principal.QTDTRATADOR; i++)
			(new Tratador("Tratador"+i, cidadeB)).start();
	}

}
