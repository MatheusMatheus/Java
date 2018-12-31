package java8_map_api;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Merge {

	public static void main(String[] args) {
		BiFunction<Integer,Integer, Integer> mapper = (v1, v2) -> null;
		
		Map<Integer, Integer> favorites = new HashMap<>();
		favorites.put(1, 123);
		favorites.put(2, 500);
		
		Integer jenny = favorites.merge(1, 500, mapper);
		Integer tom = favorites.merge(3, 600, mapper);
		
		System.out.println(favorites);
		System.out.println(jenny);
		System.out.println(tom);
		
		BiFunction<Integer, Integer, String> biFunction = (num1, num2) -> "Result: " + (num1 + num2);
		System.out.println(biFunction.apply(50, 50));
		
		System.out.println(metodo(MergeOperate::metodo, 5, 10));
	}
	
	static int metodo(BiFunction<Integer, Integer, Integer> funcao, int t, int u) {
		return funcao.apply(t, u);
	}
}

class MergeOperate {
	static int metodo(int a, int b) {
		return a + b;
	}
}
