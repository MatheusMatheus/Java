package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class ReaderWriter {
	public static void main(final String... args) throws IOException{
		File source = new File("/home/matheus/Documentos/teste");
		File destination = new File("/home/matheus/Documentos/teste2");
		copy(source, destination);
	}
	
	public static void copy(File source, File destination) throws IOException {
		try(
			Reader in = new BufferedReader(new FileReader(source));
			Writer out = new BufferedWriter(new FileWriter(destination))) {
				char[] buffer = new char[1024];
				int tam;
				while((tam = in.read(buffer)) > 0) {
					out.write(buffer, 0, tam);
					out.flush();
				}
		}
	}
}
