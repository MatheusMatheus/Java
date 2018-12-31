package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StreamJava8 {
	public static void main(String[] args) {
		Path path = Paths.get("/home/matheus/Documentos/Programacao");

		try {
			Files
			.walk(path, 0)
			.filter(Files::isReadable)
			.filter(p -> p.toString().endsWith(".java"))
			.forEach(System.out::println);
		} catch (IOException e) {
			// Handle file I/O exception...
		}
	}
}
