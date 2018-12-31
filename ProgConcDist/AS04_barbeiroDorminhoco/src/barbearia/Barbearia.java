package barbearia;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Barbearia {
	public static final int QTDCLIENTESBARBEARIA=6;
	public static final int QTDCADEIRASESPERA=4;
	private Semaphore semaforo;
	private List<Cliente> cadeirasEspera;
	private int clientesDentro;
	
	public Barbearia() {
		this.semaforo = new Semaphore(Barbearia.QTDCLIENTESBARBEARIA, true);
		this.cadeirasEspera = new ArrayList<Cliente>();
	}
	
	public synchronized void entrar() {
		this.clientesDentro++;
	}
	
	public synchronized void sair() {
		this.clientesDentro--;
	}
	
	public Cliente levantar() {
		synchronized (this.cadeirasEspera) {
			if (this.cadeirasEspera.size() > 0) {
				this.cadeirasEspera.get(0).levantar();
				System.out.println("     "+ cadeirasEspera.get(0).getName() +" levantou da cadeira["+ (this.cadeirasEspera.size()-1)  +"] de espera");
				return this.cadeirasEspera.remove(0);
			}
		}
		return null;
	}
	
	public Semaphore getSemaforo() {
		return this.semaforo;
	}
	
	public List<Cliente> getCadeirasEspera() {
		return this.cadeirasEspera;
	}
	
	public int getClientesDentro() {
		return this.clientesDentro;
	}
	
}
