package io;

import java.io.Console;
import java.io.IOException;
import java.util.Arrays;

public class PasswordCompareSample {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Console console = System.console();
		if (console == null) {
			throw new RuntimeException("Console not available");
		} else {
			char[] password = console.readPassword("Enter your password: ");
			console.format("Enter your password again: ");
			console.flush();
			char[] verify = console.readPassword();
			boolean match = Arrays.equals(password, verify);
			
			// Immediately clear passwords from memory
			Arrays.fill(password, 'x');
			console.format("Your password was " + (match ? "correct" : "incorrect"));
		}
	}
}
