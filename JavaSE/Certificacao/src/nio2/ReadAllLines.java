package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadAllLines {
	public static void main(String[] args) {
		Path path = Paths.get("/home/matheus/Documentos/criar");
		try {
			final List<String> lines = Files.readAllLines(path);
			for (String line : lines) {
				System.out.println(line);
			}
			System.out.println(lines.size());
		} catch (IOException e) {
			// Handle file I/O exception...
		}
	}
}
