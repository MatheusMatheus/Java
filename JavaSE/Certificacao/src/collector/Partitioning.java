package collector;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Partitioning {
	public static void main(String[] args) {
		//Stream<String> stream1 = Stream.of("lions", "tigers", "bears");
		Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5);
		Map<Boolean, List<Integer>> map1 = stream1.collect(Collectors.partitioningBy(s -> s.intValue() <= 2));
		System.out.println(map1); // {false=[tigers], true=[lions, bears]}

		Stream<String> stream2 = Stream.of("lions", "tigers", "bears");
		Map<Boolean, List<String>> map2 = stream2.collect(Collectors.partitioningBy(s -> s.length() <= 5));
		System.out.println(map2); // {false=[], true=[lions, tigers, bears]}

		Stream<String> stream3 = Stream.of("lions", "tigers", "bears");
		Map<Boolean, Map<String, Integer>> map3 = stream3
				.collect(Collectors.partitioningBy(s -> s.length() <= 7, Collectors.toMap(Function.identity(), s -> s.length())));
		System.out.println(map3);// {false=[], true=[lions, tigers, bears]}
	}
}
