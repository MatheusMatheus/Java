package optional;

import java.util.Optional;

import org.omg.CORBA.StringHolder;

public class OptionalExemplo {
	public static void main(String[] args) {
		System.out.println(average(90, 100));
		System.out.println(average());

		Optional<Double> opt = average(50,60);
		if (opt.isPresent())
			System.out.println(opt.get());

		Optional<Double> value = average(100, 10, 1);
		value.ifPresent(System.out::println);

		Optional<?> o = (value == null) ? Optional.empty() : Optional.of(value);
		o.ifPresent(System.out::println);

		Optional<?> o2 = Optional.ofNullable(value);
		System.out.println(o2);

		Optional<Double> opt2 = average(90, 100);
		opt2.ifPresent(System.out::println);

		Optional<Double> opt3 = average();

		//orElse, orElseGet, orElseThrow = Executa alguma coisa quando não há valor presente
		System.out.println("orElse: " + opt3.orElse(Double.NaN));
		System.out.println("orElseGet: " + opt3.orElseGet(() -> Math.random()));
		//System.out.println(opt3.orElseThrow(() -> new IllegalStateException()));
		
		String texto = null;
		String resultado = Optional.ofNullable(texto).orElse("Default text");
		System.out.println("Resultado: " + resultado);
	}

	public static Optional<Double> average(int... scores) {
		if (scores.length == 0)
			return Optional.empty();

		int sum = 0;
		for (int score : scores)
			sum += score;
		return Optional.of((double) sum / scores.length);
	}
}
