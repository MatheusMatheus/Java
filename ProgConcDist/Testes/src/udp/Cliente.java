package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {
	public static void main(String[] args) {
		byte[] mensagem = "Oi, servidor".getBytes();
		
		try {
			DatagramSocket cliente = new DatagramSocket();
			DatagramPacket pacoteSaida = new DatagramPacket(mensagem, mensagem.length, InetAddress.getLocalHost(), 12345);
			
			cliente.send(pacoteSaida);
			
			byte[] mensagemRecebida = new byte[1000];
				
			DatagramPacket pacoteEntrada = new DatagramPacket(mensagemRecebida, mensagemRecebida.length); 
			cliente.receive(pacoteEntrada);
			System.out.println("Mensagem enviada pelo servidor: " + new String(mensagemRecebida));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
