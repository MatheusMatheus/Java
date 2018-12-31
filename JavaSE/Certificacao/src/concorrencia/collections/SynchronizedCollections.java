package concorrencia.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedCollections {
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		
		service.submit(SynchronizedCollections::list);

		list();
		map();
	}

	static void list() {
		List<Integer> list = Collections.synchronizedList(new ArrayList<>(Arrays.asList(4, 3, 52)));
		synchronized (list) {
			for (int data : list)
				System.out.print(data + " ");
			System.out.println();
		}
	}

	static void map() {
		Map<String, Object> foodData = new HashMap<String, Object>();
		foodData.put("penguin", 1);
		foodData.put("flamingo", 2);
		Map<String, Object> synchronizedFoodData = Collections.synchronizedMap(foodData);
		synchronized (synchronizedFoodData) {
			//for (String key : synchronizedFoodData.keySet())
				//synchronizedFoodData.remove(key);	
		}
		
	}
}
