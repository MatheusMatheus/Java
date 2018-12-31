package maior;

import util.AleatorioLogica;
import util.PopulaVetor;
import util.Util;


public class MaiorDoVetor {
	public static void main(String[] args) {
		int tamanhoVetor = Util.lerInteiro("Quantidade de elementos: ", "Valor inválido\n");
		int qtdThreads = Util.lerInteiro("Quantidade de threads: ", "Quantidade inválida\n");
		int vetor[] = new int[tamanhoVetor];	
		
		long tempoInicial = System.currentTimeMillis();

		PopulaVetor populaVetor = new PopulaVetor(vetor, qtdThreads, new AleatorioLogica());
		populaVetor.popular();
		
		Maior maiorItem = new Maior(vetor);
		
		Thread thread2 = new Thread(maiorItem);
		thread2.start();
		
		// Espera as duas threads morrerem para mostrar os resultados
		try {
			thread2.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("Maior item do vetor: " + maiorItem.getMaior());
		
		long tempoFinal = System.currentTimeMillis() - 50;
		
		System.out.println("Tempo de execução: " + (tempoFinal - tempoInicial) + " milisegundos" );
	}

}

