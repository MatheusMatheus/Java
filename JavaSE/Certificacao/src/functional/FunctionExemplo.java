package functional;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionExemplo {
	public static void main(String[] args) {
		Function<String, Integer> f1 = String::length;
		Function<String, Integer> f2 = x -> x.length();
		
		System.out.println(f1.apply("cluck"));
		System.out.println(f1.apply("cluck"));
		
		BiFunction<String, String, String> b1 = String::concat;
		BiFunction<String, String, String> b2 = (string, toAdd) -> string.concat(toAdd);
		
		System.out.println(b1.apply("Matheus ", "lindo"));
		System.out.println(b2.apply("Matheus ", "lindo"));
	}
}
