package exceptions_assertions;

public class SuppressedExceptions {
	public static void main(String[] args) {
		try(JammedTurkeyCage t = new JammedTurkeyCage()) {
			throw new IllegalStateException("IllegalStateException - try");
		} catch (IllegalStateException  e) {
			System.out.println("caught: " + e.getMessage());
			for(Throwable t : e.getSuppressed())
				System.out.println("supressed: " + t.getMessage());
		} 
	}
}

class JammedTurkeyCage implements AutoCloseable {

	@Override
	public void close() throws IllegalStateException{
		System.out.println("close");
		throw new IllegalStateException("IllegalStateException - close");
		
	}
		
}
