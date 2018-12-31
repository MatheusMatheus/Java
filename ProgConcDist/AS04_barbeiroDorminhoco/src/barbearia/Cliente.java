package barbearia;

public class Cliente extends Thread {
	private Cabelo cabelo;
	private boolean sentado;
	private Barbearia barbearia;

	public Cliente(String nome, int tamanhoCabelo, Barbearia barbearia) {
		super(nome);
		this.cabelo = new Cabelo(tamanhoCabelo);
		this.sentado = false;
		this.barbearia = barbearia;
	}

	public synchronized void run() {
		System.out.println("     "+ this.getName() +" gostaria de entrar na barbearia[[["+ this.barbearia.getClientesDentro() +"]]]");
		try {
			this.barbearia.getSemaforo().acquire();
			this.barbearia.entrar();
			System.out.println("     "+ this.getName() +" entrou na barbearia[[["+ this.barbearia.getClientesDentro() +"]]]");
			synchronized (this.barbearia.getCadeirasEspera()) {
				do {
					if (this.barbearia.getCadeirasEspera().size() == Barbearia.QTDCADEIRASESPERA) {
						System.out.println("     "+ this.getName() +" esperando cadeira["+ this.barbearia.getCadeirasEspera().size()  +"] de espera...");
						this.barbearia.getCadeirasEspera().wait();
					}
					if (this.barbearia.getCadeirasEspera().size() < Barbearia.QTDCADEIRASESPERA)
						this.sentar();
				} while (!this.sentado);
			}
			synchronized (this.cabelo) {
				this.cabelo.wait();
			}
		} catch (InterruptedException e){ 
			e.printStackTrace();
		} finally {
			this.barbearia.getSemaforo().release();
			this.barbearia.sair();
			System.out.println("     "+ this.getName() +" saiu da barbearia[[["+ this.barbearia.getClientesDentro() +"]]]");
		}
	}

	public void sentar() {
		this.barbearia.getCadeirasEspera().add(this);
		this.sentado = true;
		this.barbearia.getCadeirasEspera().notifyAll();
		System.out.println("     "+ this.getName() +" sentou na cadeira["+ this.barbearia.getCadeirasEspera().size() +"] de espera...");
	}

	public void levantar() {
		this.sentado = false;
	}
	
	public Cabelo getCabelo() {
		return this.cabelo;
	}

}
