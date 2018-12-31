package rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

public class RMIResgistry {
	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			LocateRegistry.createRegistry(1099);
			System.out.println("Iniciado");
			scanner = new Scanner(System.in);
			scanner.nextLine();
			System.out.println("Finalizado");

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}
}
