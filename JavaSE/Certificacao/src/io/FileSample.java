package io;

import java.io.File;

public class FileSample {
	public static void main(final String... args) {

		// Recupera o tipo de separador usado pelo S.O.
		System.out.println(System.getProperty("file.separator"));
		System.out.println(java.io.File.separator);

		// Verifica se um arquivo existe
		File file = new File("/home/smith/data/zoo.txt");
		System.out.println(file.exists());
		
		File parent = null;
		File child = new File(parent,"matheus-lindo/zoo.txt");
		System.out.println(child.getName());
		System.out.println(child.exists());
	}
}
