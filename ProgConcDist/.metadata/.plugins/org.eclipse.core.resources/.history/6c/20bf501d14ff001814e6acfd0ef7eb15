package as09_rmi_banco.servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class BancoRMI extends UnicastRemoteObject implements Conta { 
	private static final long serialVersionUID = 1L;
	private Map<Integer, ContaBancaria> contas;
	private int numeroContaSequencial;
	
	public BancoRMI() throws RemoteException { 
		super();
		this.contas = new HashMap<Integer, ContaBancaria>();
		this.numeroContaSequencial = 1;
	} 

	public ChaveAcesso abrir(String nome) throws RemoteException {
		ChaveAcesso chave = new ChaveAcesso(this.numeroContaSequencial);
		ContaBancaria conta = new ContaBancaria(this.numeroContaSequencial, nome, chave);
		this.contas.put(conta.getNumero(), conta);
		this.numeroContaSequencial++;
		return chave;
	}

	public Integer getNumero(ChaveAcesso chave) throws RemoteException {
		ContaBancaria conta = this.contas.get(Integer.valueOf(chave.getNumero()));
		if ((conta == null) || (!conta.validar(chave)))
			return null;
		return conta.getNumero();
	}

	public boolean depositar(int numero, float valor, ChaveAcesso chave) throws RemoteException {
		ContaBancaria conta = this.contas.get(Integer.valueOf(numero));
		if ((conta == null) || (!conta.validar(chave)))
			return false;
		conta.depositar(valor, chave);
		return true;
	}

	public boolean sacar(int numero, float valor, ChaveAcesso chave) throws RemoteException {
		ContaBancaria conta = this.contas.get(Integer.valueOf(numero));
		if ((conta == null) || (!conta.validar(chave)))
			return false;
		return conta.sacar(valor, chave);
	}

	public Float getSaldo(int numero, ChaveAcesso chave) throws RemoteException {
		ContaBancaria conta = this.contas.get(Integer.valueOf(numero));
		if ((conta == null) || (!conta.validar(chave)))
			return null;
		return conta.getSaldo(chave);
	}

	public boolean fechar(int numero, ChaveAcesso chave) throws RemoteException {
		ContaBancaria conta = this.contas.get(Integer.valueOf(numero));
		if ((conta == null) || (!conta.validar(chave)))
			return false;
		this.contas.remove(Integer.valueOf(numero));
		return true;
	} 

}
