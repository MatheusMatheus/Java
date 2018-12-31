package generics;

import java.io.FileNotFoundException;

public class Exemplo8 {
	public static <U extends Exception> void printException(U u) {
		System.out.println(u.getMessage());
	}

	public static void main(String[] args) {
		Exemplo8.printException(new FileNotFoundException("A"));
		Exemplo8.printException(new Exception("B"));
		Exemplo8.<NullPointerException>printException(new NullPointerException("D"));
	
		metodo("String");
	}
	
	static <T> void metodo(T t){}
}
