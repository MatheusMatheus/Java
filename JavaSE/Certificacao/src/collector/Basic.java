package collector;

import java.util.HashSet;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Basic {
	public static void main(String[] args) {
		Stream<String> stream1 = Stream.of("lions", "tigers", "bears");
		String resultString = stream1.collect(Collectors.joining());
		System.out.println(resultString); // lions, tigers, bears
		
		Stream<String> stream2 = Stream.of("lions", "tigers", "bears");
		Double resultDouble = stream2.collect(Collectors.averagingLong(String::length));
		System.out.println(resultDouble); // 5.333333333333333
		
		Stream<String> stream3 = Stream.of("lions", "tigers", "bears");
		OptionalDouble media = stream3.mapToInt(String::length).average();
		System.out.println(media);
		
		Stream<String> stream4 = Stream.of("lions", "tigers", "bears");
		Set<String> resultSet = stream4.filter(s -> s.startsWith("t")).collect(Collectors.toCollection(HashSet::new));
		System.out.println(resultSet); // [tigers]
	}
}
