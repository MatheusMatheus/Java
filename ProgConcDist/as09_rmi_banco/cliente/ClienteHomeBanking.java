package as09_rmi_banco.cliente;
import java.rmi.Naming;
import java.util.Random;

import as09_rmi_banco.servidor.ChaveAcesso;
import as09_rmi_banco.servidor.Conta;

public class ClienteHomeBanking { 

	public static void main(String args[]) { 
		try {
			Random rand = new Random();
			Conta banco = (Conta) Naming.lookup("rmi://localhost/Conta");
			ChaveAcesso chave = banco.abrir("Edson Francisco da Fonseca");
			Integer numero = banco.getNumero(chave);
			System.out.println("Conta numero: "+ numero);
			for (int i=0; i<10; i++) {
				if (rand.nextInt(2) == 1)
					System.out.println("Depositando.: "+ banco.depositar(numero, rand.nextInt(100), chave));
				else
					System.out.println("Sacando.....: "+ banco.sacar(numero, rand.nextInt(100), chave));
				System.out.println("SALDO.......: "+ banco.getSaldo(numero, chave));
				Thread.sleep(2000);
			}
			System.out.println("Encerrando..: "+ banco.fechar(numero, chave));
		} 
		catch (Exception e) { 
			e.printStackTrace(); 
		} 
	} 

}
