package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Metadata {
	public static void main(String[] args) {
		System.out.println(Files.isDirectory(Paths.get("/canine/coyote/fur.jpg")));
		System.out.println(Files.isRegularFile(Paths.get("/canine/types.txt")));
		System.out.println(Files.isSymbolicLink(Paths.get("/canine/coyote")));

		try {
			System.out.println(Files.isHidden(Paths.get("/walrus.txt")));
		} catch (IOException e) {
			// Handle file I/O exception...
		}
	}
}
