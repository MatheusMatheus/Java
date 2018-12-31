package primitive_stream;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Primitive {
	public static void main(String[] args) {
		Stream<Double> stream1 = Stream.generate(() -> Math.PI);
		// System.out.println(stream1.reduce(0, (s, n) -> s + n));

		 Stream<Integer> stream2 = Stream.of(1, 2, 3);
		IntStream intStream = stream2.mapToInt(x -> x);
		int soma = intStream.sum();
		System.out.println(soma);

		// OptionalDouble avg = intStream.average();
		// System.out.println(avg.getAsDouble());

		// IntStream fractions = IntStream.iterate(5, d -> d / 2);

		IntStream range = IntStream.rangeClosed(1, 6);
		OptionalDouble media = range.average();
		if (media.isPresent())
			System.out.println(media.getAsDouble());

		Stream<String> objStream = Stream.of("penguin", "fish");
		//IntStream intStream = objStream.mapToInt(s -> s.length());
		// intStream.forEach(System.out::println);

		// DoubleStream random = intStream.mapToDouble(x -> (double) x);
		// DoubleStream fractions = DoubleStream.iterate(.5, d -> d / 2);

		LongStream longStream = LongStream.empty();
		stream1 = intStream.mapToObj(Primitive::metodo);

		// System.out.println(stream1.min(Comparator.reverseOrder()));

		// System.out.println(longStream.sum());

		IntStream novoIntStream = IntStream.of(1, 2, 3, 14, 5);
		int rangeStats = range(intStream);
		System.out.println(rangeStats);

		DoubleStream doubleStream = DoubleStream.of(1.1, 2.2, 3.0);
		IntStream doubleToInt = doubleStream.mapToInt(x -> (int)x);

	}

	static int range(IntStream ints) {
		IntSummaryStatistics stats = ints.summaryStatistics();
		if (stats.getCount() == 0)
			throw new RuntimeException();
		return stats.getMax() - stats.getMin();
	}

	static double metodo(int a) {
		return new Double(a);
	}
}
