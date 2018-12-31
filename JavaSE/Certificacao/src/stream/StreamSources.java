package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamSources {
	public static void main(String[] args) {
		Stream<String> empty = Stream.empty();
		Stream<Integer> singleElement = Stream.of(1);
		Stream<Integer> fromArray = Stream.of(1,2,3);
		
		List<String> list = Arrays.asList("a", "b", "c");
		Stream<String> fromList = list.stream();
		Stream<String> fromlistParallel = list.parallelStream();
		
		Stream<Double> randoms = Stream.generate(Math::random);
		Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);
	}
}
