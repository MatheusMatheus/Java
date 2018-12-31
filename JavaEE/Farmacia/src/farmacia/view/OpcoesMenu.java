package farmacia.view;

public enum OpcoesMenu {
	INSERIR(1), LISTAR(2), ALTERAR(3), EXCLUIR(4), SAIR(5);

	private final int opcao;

	private OpcoesMenu(int opcao) {
		this.opcao = opcao;
	}

	public int getOpcao() {
		return opcao;
	}

}
