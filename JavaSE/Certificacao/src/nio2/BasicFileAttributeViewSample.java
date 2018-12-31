package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class BasicFileAttributeViewSample {
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("/home/matheus/Documentos/criar");
		BasicFileAttributeView view = Files.getFileAttributeView(path, BasicFileAttributeView.class);
		BasicFileAttributes data = view.readAttributes();
		System.out.println("Is path a directory? " + data.isDirectory());
		System.out.println("Is path a regular file? " + data.isRegularFile());
		System.out.println("Is path a symbolic link? " + data.isSymbolicLink());
		System.out.println("Path not a file, directory, nor symbolic link? " + data.isOther());
		System.out.println("Size (in bytes): " + data.size());
		System.out.println("Creation date/time: " + data.creationTime());
		System.out.println("Last modified date/time: " + data.lastModifiedTime());
		System.out.println("Last accessed date/time: " + data.lastAccessTime());
		System.out.println("Unique file identifier (if available): " + data.fileKey());
		FileTime lastModifiedTime = FileTime.fromMillis(data.lastModifiedTime().toMillis() + 10_000_000);
		view.setTimes(lastModifiedTime, null, null);
		System.out.println("Last modified date/time: " + data.lastModifiedTime());
	}
}
