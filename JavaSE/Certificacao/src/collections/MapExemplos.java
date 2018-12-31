package collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapExemplos {
	public static void main(String[] args) {
		/*
		 * Map<String, String> map = new HashMap<>();
		 * System.out.println(map.put("1", "Teste1"));
		 * System.out.println(map.put("2", "Teste2"));
		 * System.out.println(map.put("1", "Teste2"));
		 * System.out.println(map.containsKey("3"));
		 * System.out.println(map.containsValue("Teste2"));
		 * System.out.println(map.keySet()); System.out.println(map.values());
		 */

		Map<String, String> map = new HashMap<>();
		map.put("koala", "bamboo");
		map.put("lion", "meat");
		map.put("giraffe", "leaf");
		String food = map.get("koala"); // bamboo
		for (String key : map.keySet())
			System.out.print(key + ","); // koala,giraffe,lion,

		System.out.println();

		Map<String, String> treeMap = new TreeMap<>();
		treeMap.put("koala", "bamboo");
		treeMap.put("lion", "meat");
		treeMap.put("giraffe", "leaf");
		String comida = treeMap.get("koala"); // bamboo
		for (String key : treeMap.keySet())
			System.out.print(key + ","); // giraffe,koala,lion,
		
		System.out.println(map.containsValue("lion"));

	}
}
