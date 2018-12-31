package ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableExemplo implements Comparable<ComparableExemplo>{
	
	private String name;
	

	public ComparableExemplo(String name) {
		super();
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}


	@Override
	public int compareTo(ComparableExemplo o) {
		return name.compareTo(o.name);
	}
	
	public static void main(String[] args) {
		List<ComparableExemplo> ducks = new ArrayList<>();
		ducks.add(new ComparableExemplo("Quack"));
		ducks.add(new ComparableExemplo("Puddles"));
		Collections.sort(ducks);
		System.out.println(ducks);
	}

}
