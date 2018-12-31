package br.com.sessionsbeans;

import java.util.Random;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(LancadorDeDado.class)
public class LancadorDeDadoBean implements LancadorDeDado {

	private Random gerador = new Random();
	
	public int lanca() {
		return this.gerador.nextInt(6) + 1;
	}
}
