package exceptions_assertions;

import java.io.Closeable;

public class AutocloseableFlow {
	static class Door implements AutoCloseable {
		public void close() {
			System.out.print("D");
		}
	}

	static class Window implements Closeable {
		public void close() {
			System.out.print("W");
			throw new RuntimeException("R");
		}
	}

	public static void main(String[] args) {
		try (Door d = new Door(); Window w = new Window()) {
			System.out.print("T");
			throw new RuntimeException("X");
		} catch (Exception e) {
			System.out.print("E");
			for(Throwable t : e.getSuppressed())
				System.out.println("\nsupressed: " + t.getMessage());
		} finally {
			System.out.print("F");
		}
	}
}