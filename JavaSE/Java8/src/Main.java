import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

public class Main {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(12, 5, 45, 18, 33, 24, 40);

		// Using an anonymous class
		List<Integer> newList = Numbers.findNumbers(list, new BiPredicate<Integer, Integer>() {
			public boolean test(Integer i1, Integer i2) {
				return Numbers.isMoreThanFifty(i1, i2);
			}
		});

		// Using a lambda expression
		Numbers.findNumbers(list, (i1, i2) -> Numbers.isMoreThanFifty(i1, i2));
		Numbers.findNumbers(list, (i1, i2) -> (i1 + i2) > 50);
		Numbers.findNumbers(list, new Classe());

		// Using a method reference
		Numbers.findNumbers(list, Numbers::isMoreThanFifty);

		System.out.println(newList);
	}
}

class Numbers {
	public static boolean isMoreThanFifty(int n1, int n2) {
		return (n1 + n2) > 50;
	}

	public static List<Integer> findNumbers(List<Integer> l, BiPredicate<Integer, Integer> p) {
		List<Integer> newList = new ArrayList<>();
		
		for (Integer i : l) {
			if (p.test(i, i + 10)) {
				newList.add(i);
			}
		}

		return newList;
	}
}

class Classe implements BiPredicate<Integer, Integer> {

	@Override
	public boolean test(Integer t, Integer u) {
		return (t + u) > 50;
		//return Numbers.isMoreThanFifty(t, u);
	}
	
}
