package tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) {
		try {
			ServerSocket servidor = new ServerSocket(12345);
			Socket conexao = servidor.accept();
			ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream());
			ObjectOutputStream saida = new ObjectOutputStream(conexao.getOutputStream());
			
			String msgRecebida = (String)entrada.readObject();
			System.out.println("Mensagem enviada pelo cliente: " + msgRecebida);
			
			System.out.println("Mandando mensagem para o cliente...");
			Thread.sleep(1000);
			saida.writeObject("E aí seu otário");
			
		} catch (IOException | ClassNotFoundException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
