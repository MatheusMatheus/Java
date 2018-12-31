package parallel_stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NotAssociative {
	public static void main(String[] args) {
		int resultado = Arrays.asList(1,2,3,4,5,6)
				 .parallelStream()
				 .reduce(0,(a,b) -> {
					 System.out.printf("\nX = %d \t Y = %d\nAccumulator: %d", a, b, (a - b));
					 return (a-b);
				 }); // NOT AN ASSOCIATIVE ACCUMULATOR
		System.out.println("\nResultado: " + resultado);
	}
}
