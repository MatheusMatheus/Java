package exceptions_assertions;

public class Auto implements AutoCloseable {
	int num;

	Auto(int num) {
		this.num = num;
	}

	public void close() throws IllegalStateException {
		System.out.println("Close: " + num);
		throw new IllegalStateException("IllegalStateException - close" + num);
	}

	public static void main(String[] args) {
		try (Auto a1 = new Auto(1); Auto a2 = new Auto(2);) {
			throw new IllegalStateException("IllegalStateException - try");
		} catch (IllegalStateException e) {
			System.out.println("caught: " + e.getMessage());
			for(Throwable t : e.getSuppressed())
				System.out.println(t.getMessage());
		} finally {
			System.out.println("finally");
		}
	}
}