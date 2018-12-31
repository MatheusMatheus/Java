package socket01_C_HW;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JTextArea;

public class Cliente extends Thread {
	private Socket conexao;
	private ObjectOutputStream saida;
	private Cliente clienteRecebe;
	private JTextArea taMensagens;

	public Cliente() {
	}

	private Cliente(Socket conexao, JTextArea taMensagens) {
		this.conexao = conexao;
		this.taMensagens = taMensagens;
	}

	public void run() {
		String mensagem;
		ObjectInputStream entrada = null;
		try {
			entrada = new ObjectInputStream(this.conexao.getInputStream());
			while (true) {
				mensagem = (String) entrada.readObject();
				this.taMensagens.insert(mensagem+"\n", 0);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (ThreadDeath e) {
			try {
				entrada.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public boolean conectar(String host, String nome, JTextArea taMensagens) {
		try {
			this.conexao = new Socket(host, 12345);
			this.saida = new ObjectOutputStream(this.conexao.getOutputStream());
			this.saida.flush();
			this.saida.writeObject(nome);
			this.clienteRecebe = new Cliente(conexao, taMensagens);
			this.clienteRecebe.start();
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	@SuppressWarnings("deprecation")
	public void desconectar() {
		try {
			this.saida.flush();
			this.saida.writeObject("CMD|DESCONECTAR");
			this.clienteRecebe.stop();
			this.saida.close();
			this.conexao.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void enviarMensagem(String mensagem) {
		try {
			this.saida.flush();
			this.saida.writeObject(mensagem);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}