package functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateExemplo {
	public static void main(String[] args) {
		Predicate<String> p1 = String::isEmpty;
		
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.removeIf(x -> x.startsWith("1"));
		System.out.println(p1.test("asfasfd"));
		
		BiPredicate<String, String> b1 = String::startsWith;
		
		BiPredicate<String, String> b2 = (string, prefix) -> string.startsWith(prefix);
		
		System.out.println(b1.test("chicken", "chick"));
		System.out.println(b1.test("chicken", "chick"));
	}
}
