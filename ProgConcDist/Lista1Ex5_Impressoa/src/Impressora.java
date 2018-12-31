public class Impressora {
	public static final int TIPOA = 1;
	public static final int TIPOB = 2;
	private String nome;
	private int tipo;
	private boolean livre;
	private int tamanho;

	public Impressora(String nome, int tipo) {
		this.nome = nome;
		this.tipo = tipo;
		this.livre=true;
	}

	public synchronized void imprimir(Documento documento) {
		System.out.println("     "+ this.nome +"("+ Principal.tipo(this.tipo) +") imprimindo documento["+ documento.getTamanho() +"]>>>");
		this.livre = false;
		this.tamanho = documento.getTamanho();
		try {
			Thread.sleep(documento.getTamanho() * 3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.tamanho = 0;
		this.livre = true;
		System.out.println("     "+ this.nome +"("+ Principal.tipo(this.tipo) +") IMPRESSO documento["+ documento.getTamanho() +"]--<<<");
	}
	
	public String getNome() {
		return this.nome;
	}

	public boolean isLivre() {
		return this.livre;
	}

	public int getTamanho() {
		return this.tamanho;
	}

}