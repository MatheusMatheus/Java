package parallel_stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StatefulOperation {

	public static void main(String[] args) {
		List<Integer> data = Collections.synchronizedList(new ArrayList<>());
		
		Arrays.asList(1, 2, 3, 4, 5, 6)
		.parallelStream()
		.map(i -> {	data.add(i); return i; }) // AVOID STATEFUL LAMBDA EXPRESSIONS!
		.forEachOrdered(i -> System.out.print(i + " "));
		
		System.out.println();
		
		for (Integer e : data) {
			System.out.print(e + " ");
		}
		
		System.out.println();
		System.out.print(Arrays.asList(1,2,3,4,5,6).parallelStream().findAny().get());
	}
}
