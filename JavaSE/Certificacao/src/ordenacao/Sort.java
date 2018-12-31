package ordenacao;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {
	public static void main(String[] args) {
		Comparator<Integer> c = (o1, o2) -> o2 - o1;
		List<Integer> list = Arrays.asList(5, 4, 7, 1);
		Collections.sort(list, c);
		System.out.println(list);
		System.out.println(Collections.binarySearch(list, 1));
	}
}
