package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExemplo {
	public static void main(String[] args) {
		List<String> linkedList = new LinkedList<>();
		linkedList.add("Item1");
		linkedList.add("Item5");
		linkedList.add("Item3");
		linkedList.add("Item6");
		linkedList.add("Item2");

		System.out.println(linkedList);
		
		ArrayList<String> arraylist= new ArrayList<String>();
		arraylist.add("String1");
		arraylist.add("String2");
		
		
		linkedList.addAll(2, arraylist);
		System.out.println(linkedList);
	}
}
