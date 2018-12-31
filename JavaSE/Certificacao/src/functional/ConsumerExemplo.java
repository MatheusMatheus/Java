package functional;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerExemplo {
	public static void main(String[] args) {
		Consumer<String> c1 = System.out::println;
		Consumer<String> c2 = x -> System.out.println(x);
		
		c1.accept("Matheus Lindo");
		c2.accept("Matheus lindão");
		
		Map<String, Integer> map = new HashMap<>();
		BiConsumer<String, Integer> b1 = map::put;
		BiConsumer<String, Integer> b2 = (k, v) -> map.put(k, v);

		b1.accept("chicken", 7);
		b2.accept("chick", 1);

		System.out.println(map);

		Map<String, String> map2 = new HashMap<>();
		BiConsumer<String, String> bb1 = map2::put;
		BiConsumer<String, String> bb2 = (x, y) -> map2.put(x, y);
		
		bb1.accept("chicken", "Cluck"); 
		bb2.accept("chick", "Tweep"); 
	
		System.out.println(map2);
	}
}


