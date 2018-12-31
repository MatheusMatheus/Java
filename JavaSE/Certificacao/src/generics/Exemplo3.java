package generics;

import java.util.ArrayList;
import java.util.List;

public class Exemplo3 {
	static class Sparrow extends Bird {
	}

	static class Bird {
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Um pássaro";
		}
	}

	public static void main(String[] args) {
		List<? extends Number> birds = new ArrayList<>();
		//birds.add(10);

		//Bird b = method1(birds);

		//System.out.println(b);
		
	}

	static long method1(List<? extends Number> list) {
		return list.get(0).longValue();
	}
}
