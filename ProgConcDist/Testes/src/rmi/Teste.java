package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Teste extends Remote{
	String dizMensagem() throws RemoteException;
}
