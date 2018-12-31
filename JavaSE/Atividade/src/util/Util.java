package util;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {
	private static Scanner scanner;

	public static int lerInteiro() {
		scanner = new Scanner(System.in);
		return scanner.nextInt();
		
	}
	
	public static int lerInteiro(String titulo, String msgErro) {
		try {
			System.out.print(titulo);
			return lerInteiro();
		} catch (InputMismatchException | NumberFormatException e) {
			System.out.println(msgErro);
			return lerInteiro(titulo, msgErro);
		}
	}
}
