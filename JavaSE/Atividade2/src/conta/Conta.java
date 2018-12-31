package conta;

public class Conta {
	private double saldo;
	
	public Conta(double saldo) {
		super();
		this.saldo = saldo;
	}
	
	public void saque(double valor) {
		synchronized (this) {
			if (valor <= this.saldo)
				this.saldo -= valor;
		}
	}
	
	public synchronized void deposito(double valor) {
		synchronized (this) {
			this.saldo += valor;
		}
	}
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
