package barbeiro;

public enum Constantes {
	BARBEIROS(3), CADEIRAS(5);
	private int quantidade;

	private Constantes(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getQuantidade() {
		return quantidade;
	}

}
