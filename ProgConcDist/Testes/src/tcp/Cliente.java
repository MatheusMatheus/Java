package tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente {
	public static void main(String[] args) {
		try {
			String mensagem = "Teste";
			byte[] buffer = new byte[1024];
			Socket cliente = new Socket("localhost", 12345);
			ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
			ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
				
			saida.writeObject(mensagem);
			
			String msgRecebida = (String)entrada.readObject();
			System.out.println("Mensagem enviada pelo servidor: " + msgRecebida);
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
}
