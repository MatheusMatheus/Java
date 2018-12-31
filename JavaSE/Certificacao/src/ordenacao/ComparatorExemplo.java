package ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExemplo {

	public static void main(String[] args) {
		Comparator<Duck> byWeight = new Comparator<Duck>() {
			public int compare(Duck d1, Duck d2) {
				return d1.getWeight() - d2.getWeight();
			}
		};

		Comparator<Duck> byName = (d1, d2) -> d1.getName().compareTo(d2.getName());

		Duck d1 = new Duck("Nayane", 30);
		Duck d2 = new Duck("William", 40);
		Duck d3 = new Duck("Matheus", 50);
		List<Duck> list = new ArrayList<>();
		list.add(d1);
		list.add(d2);
		list.add(d3);

		Collections.sort(list, byName);
		System.out.println(list);
	}
}

class Duck {
	private String name;
	private int weight;

	public Duck(String name, int weight) {
		super();
		this.name = name;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	public String getName() {
		return name;
	}
}