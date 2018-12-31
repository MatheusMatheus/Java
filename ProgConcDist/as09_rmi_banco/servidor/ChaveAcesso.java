package as09_rmi_banco.servidor;

import java.io.Serializable;
import java.util.Random;

public class ChaveAcesso implements Serializable {
	private static final long serialVersionUID = 1L;
	private int numero;
	private int chave;

	public ChaveAcesso(int numero) { 
		this.numero = numero;
		this.chave = (new Random()).nextInt(this.numero * 7);
	}
	
	public boolean validar(ChaveAcesso chaveAcesso) {
		return this.chave == chaveAcesso.chave;
	}

	public int getNumero() {
		return numero;
	}

}
