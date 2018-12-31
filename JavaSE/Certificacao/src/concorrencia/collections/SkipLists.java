package concorrencia.collections;

import java.util.NavigableSet;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class SkipLists {
	public static void main(String[] args) {
		demo1();
		System.out.println();
		demo2();
	}
	
	static void demo1() {
		NavigableSet<String> citySet = new ConcurrentSkipListSet<String>();
        citySet.add("New Delhi");
        citySet.add("Mumbai");
        citySet.add("Chennai");
        citySet.add("Hyderabad");
        
        System.out.println("---- Traversing the set-----");
        System.out.println(citySet);
	}
	
	static void demo2() {
		NavigableSet<String> citySet = new ConcurrentSkipListSet<String>();
        citySet.add("New Delhi");
        citySet.add("Mumbai");
        citySet.add("Chennai");
        citySet.add("Hyderabad");
        
        System.out.println("---- Traversing the set-----");
        System.out.println(citySet);
        
        System.out.println("Higher - " + citySet.higher("C"));
        
        System.out.println("Lower - " + citySet.lower("Mumbai"));
        
        System.out.println("---- Tail Set -----");
        
        Set<String> set = citySet.tailSet("Hyderabad");
        
        System.out.println(set);
	}
}
