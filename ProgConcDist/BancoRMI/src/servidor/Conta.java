package servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Conta extends Remote {
	public ChaveAcesso abrir(String nome) throws RemoteException;
	public Integer getNumero(ChaveAcesso chave) throws RemoteException; 
	public boolean depositar(int conta, float valor, ChaveAcesso chave) throws RemoteException;
	public boolean sacar(int conta, float valor, ChaveAcesso chave) throws RemoteException;
	public Float getSaldo(int conta, ChaveAcesso chave) throws RemoteException;
	public boolean fechar(int conta, ChaveAcesso chave) throws RemoteException;
}