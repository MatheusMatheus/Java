package parallel_stream;

import java.util.function.BinaryOperator;

public class ReduceExemplo {
	public static void main(String[] args) {
		/*	List<Integer> list2 = Arrays.asList(2, 3, 4);
		// Here result will be 2*2 + 2*3 + 2*4 that is 18.
		int res = list2.parallelStream().reduce(2, (s1, s2) -> s1 * s2, (p, q) -> p + q);
		System.out.println(res);

		List<String> list1 = Arrays.asList("Mohan", "Sohan", "Ramesh");
		String result = list1.parallelStream().reduce("-", (s1, s2) -> s1 + s2, (p, q) -> p + q);
		System.out.println(result);

		Stream.of(1, 2, 3).reduce((x, y) -> x + y).ifPresent(System.out::println);

		Stream.of(10, 20, 22, 12, 14).reduce(Integer::sum).ifPresent(System.out::println);
*/
		Integer identity = 10;
		BinaryOperator<Integer> combiner = (x, y) -> x + y;
		boolean identityRespected = combiner.apply(identity, 1) == 1;
		System.out.println(identityRespected); // prints false
	}
}
