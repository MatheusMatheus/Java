package parallel_stream;

import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelCollect {
	public static void main(String[] args) {
		metodo2();
	

	}
	
	static void metodo1() {
		Stream<String> stream = Stream.of("w", "o", "l", "f").parallel();
		SortedSet<String> set = stream.collect(ConcurrentSkipListSet::new, Set::add, Set::addAll);
		System.out.println(set); // [f, l, o, w]
		System.out.println(set.getClass());
		
		String string = Stream.of("a", "m", "o", "r")
				.parallel()
				.collect(StringBuilder::new, 
						(a, b) -> {
							System.out.println(a + " + " + b + " = " + a.append(b));
						}, 
						StringBuilder::append)
				.toString();
		System.out.println(string);
		
	}
	
	static void metodo2() {
		Stream<String> stream1 = Stream.of("lions", "tigers", "bears").parallel();
		ConcurrentMap<Integer, String> map1 = stream1
				.collect(Collectors.toConcurrentMap(
						String::length, 
						k ->  k, 
						(s1, s2) -> {
							
							return s1 + "-" + s2;
						}, 
						ConcurrentHashMap::new));
		
		System.out.println(map1); // {5=lions,bears, 6=tigers}
		System.out.println(map1.getClass()); // java.util.concurrent.ConcurrentHashMap
	}
	
	static void metodo3() {
		Stream<String> stream2 = Stream.of("lions", "tigers", "bears").parallel();
		ConcurrentMap<Integer, List<String>> map2 = stream2.collect(Collectors.groupingByConcurrent(String::length));
		System.out.println(map2); // {5=[lions, bears], 6=[tigers]}
	}
}
