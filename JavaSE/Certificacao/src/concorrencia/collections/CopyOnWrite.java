package concorrencia.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWrite {
	public static void main(String[] args) {
		List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(4, 3, 52));
		
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()) {
			list.add(20);
			System.out.print(iterator.next() + " ");
		}
			
		
		System.out.println();
		Iterator<Integer> iterator2 = list.iterator();
		while(iterator2.hasNext()) {
			//iterator2.remove();
			System.out.print(iterator2.next() + " ");
		}

	}
	
	
}
