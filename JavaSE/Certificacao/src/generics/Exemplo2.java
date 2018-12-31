package generics;

import java.util.ArrayList;
import java.util.List;

public class Exemplo2<T> {
	public <T> void metodo(T t) {
		
	}
	
	public static void main(String[] args) {
		//Exemplo<Integer> exemplo = new Exemplo2<>();
		List box = new ArrayList();
		box.add(5);
		box.add(new Double(1.1));
		box.add(new String("a"));
		
		List<String> strings = new ArrayList<>();
		strings = box;
		
		for(String s : strings) {
			System.out.println(s);
		}
	}
}


class Exemplo<T> extends Exemplo2{
	
	
}

class Box<T> {
	
}