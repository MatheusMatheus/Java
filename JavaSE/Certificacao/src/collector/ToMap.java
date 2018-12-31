package collector;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToMap {
	public static void main(String[] args) {
		Stream<String> stream1 = Stream.of("lions", "tigers", "bears");
		Map<String, Integer> map1 = stream1.collect(Collectors.toMap(Function.identity(), String::length));
		System.out.println(map1); // {lions=5, bears=5, tigers=6}

		Stream<String> stream2 = Stream.of("lions", "tigers", "bears");
		Map<Integer, String> map2 = stream2
				.collect(Collectors.toMap(String::length, k -> k, (s1, s2) -> s1 + "-" + s2)); 	
		System.out.println(map2);
		System.out.println(map2.getClass());

		Stream<String> stream3 = Stream.of("lions", "tigers", "bears");
		Map<Integer, String> map3 = stream3
				.collect(Collectors.toMap(String::length, k -> k, (s1, s2) -> s1 + "," + s2, TreeMap::new));
		System.out.println(map3); // // {5=lions,bears, 6=tigers}
		System.out.println(map3.getClass()); // class. java.util.TreeMap
	}
}
