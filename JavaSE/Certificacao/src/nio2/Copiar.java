package nio2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Copiar {
	public static void main(String[] args) {
		try (InputStream is = new FileInputStream("source-data.txt");
				OutputStream out = new FileOutputStream("output-data.txt")) {
			// Copy stream data to file
			Files.copy(is, Paths.get("c:\\mammals\\wolf.txt"));
			// Copy file data to stream
			Files.copy(Paths.get("c:\\fish\\clown.xsl"), out);
		} catch (IOException e) {
			// Handle file I/O exception...
		}
	}
}
