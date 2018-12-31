package generics;

public class Exemplo7<T> {
	public void metodo(T t){}
	
	public static void main(String[] args) {
		Exemplo7<Integer> a = new Exemplo7<>();
		a.metodo(10);
		
		OutroExemplo.<Integer>metodo(5);
	}
}

class OutroExemplo {
	public static <T> void metodo(T t){}
}
