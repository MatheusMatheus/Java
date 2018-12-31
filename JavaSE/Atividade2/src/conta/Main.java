package conta;

public class Main {
	public static void main(String[] args) {
		Conta conta = new Conta(5000);
		
		Cliente cliente1 = new Cliente(conta);
		
		Cliente cliente2 = new Cliente(conta);
		
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				cliente1.realizarOperacao(Operacao.SAQUE, 200);
			}
		});
		
		
		// Lambdas Java 8, caso o compilador usado seja da versão 7 ou menor, fazer igual à thread1
		Thread thread2 = new Thread(() -> cliente2.realizarOperacao(Operacao.DEPOSITO, 300));
		
		thread1.start();
		thread2.start();
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		System.out.println(conta.getSaldo());
		
	}
}
