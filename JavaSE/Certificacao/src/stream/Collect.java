package stream;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//O método collect também é um 'terminate operation', exceto para streams infinitos
public class Collect {
	public static void main(String[] args) {
		Stream<String> stream1 = Stream.of("w", "o", "l", "f");

		// <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T>accumulator, BiConsumer<R, R> combiner)
		StringBuilder word = stream1.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
		System.out.println(word);

		Stream<String> stream2 = Stream.of("w", "o", "l", "f");
		TreeSet<String> set1 = stream2.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
		System.out.println(set1); // [f, l, o, w]

		Stream<String> stream3 = Stream.of("w", "o", "l", "f");
		//<R,A> R collect(Collector<? super T, A,R> collector)
		TreeSet<String> set2 = stream3.collect(Collectors.toCollection(TreeSet::new));
		System.out.println(set2); // [f, l, o, w]

		Stream<String> stream4 = Stream.of("w", "o", "l", "f");
		//<R,A> R collect(Collector<? super T, A,R> collector)
		Set<String> set3 = stream4.collect(Collectors.toSet());
		System.out.println(set3); // [f, w, l, o]
		
	}
}
