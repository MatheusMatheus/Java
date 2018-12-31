package generics;

import java.util.ArrayList;
import java.util.List;

class Dragon {
}

class Unicorn {
}

public class Exemplo1 {
	public static void main(String[] args) {
		List unicorns = new ArrayList();
		unicorns.add(new Unicorn());
		printDragons(unicorns);
		
		List objetos = new ArrayList<>();;
		List<Dragon> dragons = new ArrayList<>();
		//dragons = objetos;
		objetos = dragons;
	}

	private static void printDragons(List<Dragon> dragons) {
		for (Dragon dragon : dragons) { // ClassCastException
			System.out.println(dragon);
		}
	}
}