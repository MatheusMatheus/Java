package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemInSample {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Type something: ");
		String userInput = reader.readLine();
		System.out.println("You entered the following: " + userInput);
	}
}
