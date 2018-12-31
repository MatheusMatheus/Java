public class Tratador extends Thread {
	public static final int TEMPOVERIFICACAO = 20000;
	public static final int QTDPOMBOLIBERAR = 2;
	private Cidade cidade;

	public Tratador(String nome, Cidade cidade) {
		super(nome);
		this.cidade = cidade;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(Tratador.TEMPOVERIFICACAO);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.libertarPombos();
		}
	}
	
	public void libertarPombos() {
		Gaiola gaiola=this.cidade.getGaiola();
		synchronized (gaiola) {
			System.out.println("----->"+ this.getName() +" passando para libertar pombos. Gaiola["+ gaiola.getQtdPombos() +"]---");
			if (gaiola.getQtdPombos() >= Tratador.QTDPOMBOLIBERAR) {
				gaiola.libertar();
				gaiola.notifyAll();;
				System.out.println("----->"+ this.getName() +" LIBERTANDO pombos. Gaiola["+ gaiola.getQtdPombos() +"]---------------");
			}
		}
	}
	
}