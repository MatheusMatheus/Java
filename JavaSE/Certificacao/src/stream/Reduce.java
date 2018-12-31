package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

// O método reduce também é um 'terminate operation', exceto para streams infinitos
public class Reduce {
	public static void main(String[] args) {
		List<String> list1 = Arrays.asList("w", "o", "l", "f");
		Stream<String> stream1 = list1.stream();

		String word1 = stream1.reduce("",(c,s1) -> c + s1,
				 (s2,s3) -> s2 + s3); 
		System.out.println(word1);

		//T reduce(T identity, BinaryOperator<T> accumulator) 
		//String word2 = stream1.reduce("", String::concat);
		//System.out.println(word2);

		Stream<Integer> inteiros = Stream.of(1, 2, 3);
		
		// T reduce(T identity, BinaryOperator<T> accumulator) 
		int resultado = inteiros.reduce(1, Integer::sum);
		System.out.println(resultado);

		BinaryOperator<Integer> op = (a, b) -> a * b;
		Stream<Integer> empty = Stream.empty();
		Stream<Integer> oneElement = Stream.of(3);
		Stream<Integer> threeElements = Stream.of(3, 5, 6);

		//Optional<T> reduce(BinaryOperator<T> accumulator) 
		empty.reduce(op).ifPresent(System.out::println); // no output
		oneElement.reduce(op).ifPresent(System.out::println); // 3
		threeElements.reduce(op).ifPresent(System.out::println); // 90

		BinaryOperator<Integer> operacao = (a, b) -> a * b;
		Stream<Integer> streamInt = Stream.of(3, 5, 6);
		
		//<U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner) 
		System.out.println(streamInt.reduce(3, operacao, operacao));
	}
}
