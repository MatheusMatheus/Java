package exceptions_assertions;

public class SuppressedFinally {
	public static void main(String[] args) {
		try (TurkeyCage t = new TurkeyCage()) {
			throw new IllegalStateException();
		} finally {
			throw new RuntimeException("and we couldn't find them");
		}
	}
}

class TurkeyCage implements AutoCloseable {

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
