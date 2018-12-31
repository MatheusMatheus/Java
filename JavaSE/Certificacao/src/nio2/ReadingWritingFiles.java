package nio2;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

public class ReadingWritingFiles {
	public static void main(String[] args) {
		SortedMap<String, Charset> charsets = Charset.availableCharsets();
		for (String string : charsets.keySet())
			System.out.println(string);
	}

	private static void lerEscrever() {
		Path origem = Paths.get("/home/matheus/Documentos/criar");
		Path destino = Paths.get("/home/matheus/Documentos/teste2");
		List<String> data = new ArrayList<>();
		try (InputStream stream = new BufferedInputStream(new FileInputStream("/home/matheus/Documentos/criar"))) {
			Files.copy(stream, origem);

			BufferedReader reader = Files.newBufferedReader(origem, Charset.forName("UTF-8"));
			BufferedWriter writer = Files.newBufferedWriter(destino, Charset.forName("UTF-16"));
			String lido = null;
			while ((lido = reader.readLine()) != null)
				writer.write(lido);

		} catch (IOException e) {
			System.out.println(e);
		} finally {
		}

	}

	private static void escrever() {
		Path path = Paths.get("/home/matheus/Documentos/gorilla");
		List<String> data = new ArrayList<>();
		try (BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-16"))) {
			writer.write("Hello World");
		} catch (IOException e) {
			// Handle file I/O exception...
		}
	}

	private static void ler() {
		Path path = Paths.get("/home/matheus/Documentos/teste2");
		try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-16"))) {
			// Read from the stream
			String currentLine = null;
			while ((currentLine = reader.readLine()) != null)
				System.out.println(currentLine);
		} catch (IOException e) {
			System.out.println(e);
		}

	}
}
