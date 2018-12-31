package collections;

import java.util.HashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExemplos {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		System.out.println(set.add(66));
		System.out.println(set.add(10));
		System.out.println(set.add(66));
		
		NavigableSet<Integer> navSet = new TreeSet<>();
		for (int i = 1; i < 20; i++)
			navSet.add(i);

		System.out.println(navSet.lower(10)); 
		System.out.println(navSet.floor(10)); 
		System.out.println(navSet.ceiling(15)); 
		System.out.println(navSet.higher(18)); 
		
	}
}
