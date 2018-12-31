package nio2;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserPrincipal;

public class Ownership {
	public static void main(String[] args) {
		metodo1();
	}

	static void metodo1() {
		UserPrincipal owner;
		try {
			owner = FileSystems
					.getDefault()
					.getUserPrincipalLookupService()
					.lookupPrincipalByName("root");

			System.out.println(owner);

			Path path = Paths.get("/home/matheus/Documentos/criar");
			owner = path
					.getFileSystem()
					.getUserPrincipalLookupService()
					.lookupPrincipalByName("root");

			System.out.println(owner);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static void metodo2() {
		try {
			// Read owner of file
			Path path = Paths.get("/home/matheus/Documentos/criar");
			System.out.println(Files.getOwner(path).getName());
			// Change owner of file
			UserPrincipal owner = path
					.getFileSystem()
					.getUserPrincipalLookupService()
					.lookupPrincipalByName("root");
			Files.setOwner(path, owner);
			// Output the updated owner information
			System.out.println(Files.getOwner(path).getName());
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
