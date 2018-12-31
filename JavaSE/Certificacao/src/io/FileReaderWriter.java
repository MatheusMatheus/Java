package io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class FileReaderWriter {
	public static void main(String[] args) throws IOException{
		File source = new File("/home/matheus/Documentos/teste");
		File destination = new File("/home/matheus/Documentos/teste2");
		copy(source, destination);
	}
	
	public static void copy(File source, File destination) {
		try (Reader reader = new FileReader(source);
				Writer writer = new FileWriter(destination)){
				int tamLido;
				while((tamLido = reader.read()) != -1) {
					writer.write(tamLido);
				}
			} catch (IOException e) {
				// TODO: handle exception
			}
		
	}
}
