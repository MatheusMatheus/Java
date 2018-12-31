package socket01_S_HW;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Servidor extends Thread {
	private Socket conexao;
	private List<ObjectOutputStream> saidas;

	private Servidor(Socket conexao, List<ObjectOutputStream> saidas) {
		System.out.println("Cliente conectado: "+ conexao.getInetAddress().getHostAddress());
		this.conexao = conexao;
		this.saidas = saidas;
	}

	public static void main(String[] args) {
		System.out.println("Servidor levantado...");
		List<ObjectOutputStream> saidas = new ArrayList<ObjectOutputStream>();
		try {
			@SuppressWarnings("resource")
			ServerSocket servidor = new ServerSocket(12345);
			while (true) {
				Socket conexao = servidor.accept();
				(new Servidor(conexao, saidas)).start();
			}
			//servidor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		DateFormat formato = new SimpleDateFormat("HH:mm");
		try {
			ObjectInputStream entrada = new ObjectInputStream(this.conexao.getInputStream());
			ObjectOutputStream saida = new ObjectOutputStream(this.conexao.getOutputStream());
			synchronized (this.saidas) {
				this.saidas.add(saida);
			}
			String mensagem = (String) entrada.readObject();
			super.setName(mensagem);
			while (!(mensagem = (String) entrada.readObject()).equals("CMD|DESCONECTAR")) {
				synchronized (this.saidas) {
					for (ObjectOutputStream saida2 : this.saidas) {
						saida2.flush();
						saida2.writeObject(this.getName() +"("+ formato.format(new Date()) +"): "+ mensagem);
					}
				}
			}
			synchronized (this.saidas) {
				this.saidas.remove(saida);
			}
			saida.close();
			entrada.close();
			System.out.println("Cliente desconectado: "+ conexao.getInetAddress().getHostAddress());
			this.conexao.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}