package java8_map_api;

import java.util.Map;
import java.util.TreeMap;

public class ReplaceAll {
	public static void main(String[] args) {
		Map<String, Integer> tMap = new TreeMap<>();
		tMap.put("ab", 1);
		tMap.put("abc", 2);
		tMap.put("abcd", 3);
		tMap.replaceAll((k, v) -> (int) k.charAt(v));
		System.out.println(tMap);
	}
}
