package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MarkStream {
	public static void main(String[] args) {
		try (InputStream is = new FileInputStream(new File("/home/matheus/Documentos/teste"));) {
			System.out.println((char) is.read());
			if (is.markSupported()) {
				is.mark(100);
				System.out.println((char) is.read());
				System.out.println((char) is.read());
				is.reset();
			} else
				System.out.println(false);

		} catch (IOException e) {
			// TODO: handle exception
		}

	}
}
