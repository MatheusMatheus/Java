package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamTerminateOperations {
	public static void main(String[] args) {
		Stream<String> s = Stream.of("Lindo", "Gostoso", "Maravilhoso");
		
		// Não termina streams infinitos
		//System.out.println(s.count());

		Optional<String> min = s.min((s1, s2) -> s1.length() - s2.length());
		min.ifPresent(System.out::println);

		Optional<?> minEmpty = Stream.empty().min((s1, s2) -> 0);
		System.out.println(minEmpty.isPresent());

		Stream<String> infinite = Stream.generate(() -> "chimp");
		//infinite.findFirst().ifPresent(System.out::println);
		infinite.findAny().ifPresent(System.out::println);

		List<String> list = Arrays.asList("monkey", "2", "chimp");
		Stream<String> infinito = Stream.generate(() -> "chimp");
		Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
		System.out.println(list.stream().anyMatch(pred)); // true
		System.out.println(list.stream().allMatch(pred)); // false
		System.out.println(list.stream().noneMatch(pred)); // false
		System.out.println(infinito.anyMatch(pred)); // true
		
		list.forEach(System.out::print);
	}
}
