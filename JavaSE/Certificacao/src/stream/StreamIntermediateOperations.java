package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamIntermediateOperations {
	public static void main(String[] args) {
		Stream<String> s1 = Stream.of("monkey", "gorilla", "bonobo");
		//s1.map(String::toUpperCase).filter(x -> x.startsWith("M")).forEach(System.out::println); // monkey

		Stream<String> s2 = Stream.of("duck", "duck", "duck", "goose");
		//s2.distinct().forEach(System.out::println); // duckgoose

		Stream<Integer> s3 = Stream.iterate(1, n -> n + 1);
		//s3.skip(5).limit(2).forEach(System.out::print); // 67

		List<String> zero = Arrays.asList();
		List<String> one = Arrays.asList("Bonobo");
		List<String> two = Arrays.asList("Mama Gorilla", "Baby Gorilla");
		Stream<List<String>> animals = Stream.of(zero, one, two);
		//animals.flatMap(l -> l.stream()).forEach(System.out::println);
		
		
		Stream<String> s4 = Stream.of("a-", "B-", "1-");
		s4.sorted(Comparator.reverseOrder()).forEach(System.out::print);
		Stream<String> s5 = Stream.of("black bear", "brown bear", "grizzly"); 
		//long count = s5.filter(s -> s.startsWith("g")).peek(System.out::println).count();
		//System.out.println(count);
		
		
		List<Integer> numbers = new ArrayList<>();
		List<Character> letters = new ArrayList<>();
		numbers.add(1);
		letters.add('a');
		StringBuilder builder = new StringBuilder();
		Stream<List<?>> good = Stream.of(numbers, letters);

		Stream<List<?>> stream = Stream.of(numbers, letters);
	
		Consumer<List<?>> consumer = x -> builder.append(x);
		Consumer<String> consumerString = x -> builder.append(x);
		good.peek(builder::append).map(List::size).forEach(System.out::print); // 11
		System.out.println(builder);
		
		Stream<Integer> infinite = Stream.iterate(1, x -> x + 1);
		infinite
			.filter(x -> x % 2 == 1)
			.limit(5)
			.forEach(System.out::print); // 13579
		
		System.out.println();
		
		Stream<Integer> infinite2 = Stream.iterate(1, x -> x + 1);
		infinite2.filter(x -> x % 2 == 1)
		 .peek(System.out::print)
		 .limit(5)
		 .forEach(System.out::print);
	}
}

