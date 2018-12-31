package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CopyTextFileSample {
	public static void main(String[] args) throws IOException {
		File source = new File("/home/matheus/Documentos/teste");
		File destination = new File("/home/matheus/Documentos/teste2");
		List<String> data = readFile(source);
		for (String record : data) {
			System.out.println(record);
		}
		writeFile(data, destination);
	}

	public static List<String> readFile(File source) throws IOException {
		List<String> data = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
			String s;
			while ((s = reader.readLine()) != null) {
				s = s.replaceAll("perspiciatis", "Matheus Lindo");
				data.add(s);
			}
		}
		return data;
	}

	public static void writeFile(List<String> data, File destination) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
			for (String s : data) {
				writer.write(s);
				writer.newLine();
			}
		}
	}
}