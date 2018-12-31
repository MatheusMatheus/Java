package conta;

public class Cliente  {
	private Conta conta;

	public Cliente(Conta conta) {
		super();
		this.conta = conta;
	}

	@Override
	public String toString() {
		return "[Saldo - " + getConta().getSaldo() + "]";
	}

	public void realizarOperacao(Operacao operacao, double valor) {
		switch (operacao) {
		case SAQUE:
			this.conta.saque(valor);
			break;
		case DEPOSITO:
			this.conta.deposito(valor);
			break;
		default:
			break;
		}
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
}
