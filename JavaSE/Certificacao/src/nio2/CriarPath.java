package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CriarPath {
	public static void main(String[] args) {
		Path path1 = Paths.get("/home/matheus/Documentos/teste");
		Path path2 = Paths.get("/", "matheus", "Documentos", "teste");

		/*try {
			Files.createDirectory(Paths.get("/bison/field"));
			Files.createDirectories(Paths.get("/bison/field/pasture/green"));
		} catch (IOException e) {
			System.out.println(e);
		}*/

		try {
			Files.copy(Paths.get("/panda"), Paths.get("/panda-save"));
			Files.copy(Paths.get("/panda/bamboo.txt"), Paths.get("/panda-save/bamboo.txt"));
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
