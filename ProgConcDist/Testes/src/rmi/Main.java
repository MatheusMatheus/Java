package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class Main {
	public static void main(String[] args) {
		try {
			TesteRMI rmi = new TesteRMI();
			Naming.rebind("teste", rmi);
		} catch (RemoteException | MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
