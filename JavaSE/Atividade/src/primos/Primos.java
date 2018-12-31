package primos;

import java.text.NumberFormat;

import util.PopulaVetor;
import util.SequencialLogica;
import util.Util;


public class Primos {

	public static void main(String[] args) {
		int tamanhoVetor = Util.lerInteiro("Quantidade de elementos: ", "Valor inválido\n");
		int qtdThreads = Util.lerInteiro("Quantidade de threads: ", "Valor inválido\n");
		int vetor[] = new int[tamanhoVetor];
		
		long tempoInicial = System.currentTimeMillis();

		PopulaVetor populaVetor = new PopulaVetor(vetor, qtdThreads, new SequencialLogica());
		populaVetor.popular();
		
		CalculaPrimo primo = new CalculaPrimo(vetor, qtdThreads);
		
		System.out.println("A soma dos números primos é: " +  NumberFormat.getNumberInstance().format(primo.getSoma()));
		
		long tempoFinal = System.currentTimeMillis();
		
		System.out.println("Tempo de execução: " + (tempoFinal - tempoInicial) + " milisegundos" );
	}

}






