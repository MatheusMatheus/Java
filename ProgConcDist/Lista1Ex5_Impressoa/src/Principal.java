import java.util.Random;

public class Principal {
	public static final int QTDPROCESSOS = 10;

	public static void main(String args[]) {
		System.out.println("............................................................");
		System.out.println("INICIANDO AS IMPRESSOES.....................................");
		System.out.println("............................................................");
		Impressora impressoraA = new Impressora("ImpressoraA", Impressora.TIPOA);
		Impressora impressoraB = new Impressora("ImpressoraB", Impressora.TIPOB);
		for (int i=1; i<=Principal.QTDPROCESSOS; i++) {
			int tipo=(new Random()).nextInt(3);
			Processo processo = new Processo("Processo"+i, tipo);
			if ((tipo==Processo.TIPOA) || (tipo==Processo.TIPOAB)) processo.adicionarImpressora(impressoraA);
			if ((tipo==Processo.TIPOB) || (tipo==Processo.TIPOAB)) processo.adicionarImpressora(impressoraB);
//			if (tipo==Processo.TIPOAB)
//				processo.setPriority(Thread.MAX_PRIORITY);
//			else
//				processo.setPriority(Thread.MIN_PRIORITY);
			processo.start();
		}
	}
	
	public static String tipo(int n) {
		switch (n) {
		case 1: return "A";
		case 2: return "B";
		default: return "AB";
		}
	}

}