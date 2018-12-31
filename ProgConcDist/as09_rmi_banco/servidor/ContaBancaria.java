package as09_rmi_banco.servidor;

import java.rmi.RemoteException;

public class ContaBancaria { 
	private int numero;
	private String nome;
	private float saldo;
	private ChaveAcesso chaveAcesso;

	public ContaBancaria(int numero, String nome, ChaveAcesso chave) throws RemoteException { 
		this.numero = numero;
		this.nome = nome;
		this.saldo = 0;
		this.chaveAcesso = chave;
	}
	
	public boolean validar(ChaveAcesso chave) {
		return this.chaveAcesso.validar(chave);
	}

	public void depositar(float valor, ChaveAcesso chave) throws RemoteException {
		if (this.validar(chave))
			this.saldo += valor;
	}

	public boolean sacar(float valor, ChaveAcesso chave) throws RemoteException {
		if ((!this.validar(chave)) || (this.saldo < valor))
			return false;
		this.saldo -= valor;
		return true;
	}

	public int getNumero() {
		return numero;
	}

	public String getNome() {
		return nome;
	}

	public float getSaldo(ChaveAcesso chave) {
		if (this.validar(chave))
			return saldo;
		else
			return 0;
	}

}
