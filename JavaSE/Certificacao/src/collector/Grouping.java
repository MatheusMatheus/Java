package collector;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Grouping {
	public static void main(String[] args) {
		Stream<String> stream1 = Stream.of("lions", "tigers", "bears", "bears");
		Map<Integer, List<String>> map1 = stream1.collect(Collectors.groupingBy(String::length));
		System.out.println(map1); // {5=[lions, bears], 6=[tigers]}

		Stream<String> stream2 = Stream.of("lions", "tigers", "bears");
		Map<Integer, Set<String>> map2 = stream2.collect(Collectors.groupingBy(String::length, Collectors.toSet()));
		System.out.println(map2); // {5=[lions, bears], 6=[tigers]}

		Stream<String> stream3 = Stream.of("lions", "tigers", "bears", "bears");
		TreeMap<Integer, Set<String>> map3 = stream3
				.collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));
		System.out.println(map3); // {5=[lions, bears], 6=[tigers]}

		Stream<String> stream4 = Stream.of("lions", "tigers", "bears", "bears");
		TreeMap<Integer, List<String>> map4 = stream4
				.collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toList()));
		System.out.println(map4);
	}
}
