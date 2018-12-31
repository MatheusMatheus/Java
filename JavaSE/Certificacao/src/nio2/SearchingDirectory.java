package nio2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class SearchingDirectory {
	public static void main(String[] args) {
		Path path = Paths.get("/home/matheus/Documentos/Programacao");
		long dateFilter = 1420070400000l;
		try {
			Stream<Path> stream = Files.find(path, 10,
					(p, bfa) -> p.toString().endsWith(".java") 
					&& bfa.lastModifiedTime().toMillis() > dateFilter);
			stream.forEach(System.out::println);
		} catch (Exception e) {
			// Handle file I/O exception...
		}
	}
}
