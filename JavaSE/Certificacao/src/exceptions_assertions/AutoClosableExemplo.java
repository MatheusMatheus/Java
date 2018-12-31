package exceptions_assertions;

public class AutoClosableExemplo {
	public static void main(String[] args) {
		try(Farinha f = new Farinha()) {
			System.out.println("Try with resources");
			
		}
	}
}

class Farinha implements AutoCloseable {

	@Override
	public void close() {
		System.out.println("Fechado");
		
	}
	
}
