package farmacia.view;

import java.util.InputMismatchException;
import java.util.Scanner;
import farmacia.util.Leitor;

public class Console implements Leitor {
	public String lerString() {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		return s;
	}

	public String lerString(String titulo, String msgErro) {
		try {
			System.out.print(titulo);
			return lerString();

		} catch (InputMismatchException e) {
			System.out.println(msgErro);
			return lerString(titulo, msgErro);
		}
	}

	public int lerInt() {
		return Integer.parseInt(lerString());
	}

	public int lerInt(String titulo, String msgErro) {
		try {
			System.out.println(titulo);
			return lerInt();
		} catch (NumberFormatException e) {
			System.out.println(msgErro);
			return lerInt(titulo, msgErro);
		}
	}

	public int lerInt(String titulo, String msgErro, int min, int max) {
		int n = Integer.MIN_VALUE;
		do {
			n = lerInt(titulo, msgErro);
			if (n < min || n > max)
				System.out.println(msgErro);
		} while (n < min || n > max);
		return n;
	}

	@Override
	public void mostrarMensagem(String msg) {
		System.out.println(msg);
	}
}
