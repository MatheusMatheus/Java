package exceptions_assertions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class MultiCatch {
	public static void main(String[] args) {
		try {
			Path path = Paths.get("aslfjaçslfa.txt");
			String text = new String(Files.readAllBytes(path));
			LocalDate date = LocalDate.parse(text);
		} catch (DateTimeParseException e) {
			e.getMessage();
			throw new RuntimeException();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
