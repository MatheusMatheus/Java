package br.com.testes;

import javax.naming.InitialContext;

import br.com.sessionsbeans.LancadorDeDado;

public class TesteDeAcesso {
	public static void main(String[] args) throws Exception {
		InitialContext ic = new InitialContext();
		LancadorDeDado lancadorDeDado = (LancadorDeDado) ic.lookup("java:global/dadoWEB/LancadorDeDadoBean");
		
		System.out.println(lancadorDeDado.lanca());
	}
}
