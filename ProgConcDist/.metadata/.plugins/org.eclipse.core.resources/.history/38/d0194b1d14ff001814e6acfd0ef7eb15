package as09_rmi_banco.servidor;
import java.rmi.Naming;

public class ServidorBanco { 

	public static void main(String args[]) {
		try { 
			BancoRMI banco = new BancoRMI(); 
			Naming.rebind("Conta", banco); 
			System.out.println("Servido registrado: Conta"); 
		} 
		catch (Exception e) { 
			e.printStackTrace(); 
		} 
	}
}
