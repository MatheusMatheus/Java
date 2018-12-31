package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TesteRMI extends UnicastRemoteObject implements Teste{

	protected TesteRMI() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String dizMensagem() {
		return "Hola, que tal";
	}

}
