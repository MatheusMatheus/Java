package as09_rmi_banco.rmi;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

public class RMIRegistry {
	public static void main (String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
			System.out.println("RMIRegistry iniciado"); 
			(new Scanner(System.in)).nextLine();
			System.out.println("RMIRegistry desativado"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
