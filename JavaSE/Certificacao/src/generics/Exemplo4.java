package generics;

import java.util.ArrayList;
import java.util.List;

public class Exemplo4 {
	public static void main(String[] args) {
		List<C> inteiros = new ArrayList<>();
		inteiros.add(new C());
		method3(inteiros);
	}

	static <T extends A> B method3(List<? super C> list) {
		list.add(new C());
		System.out.println(list.get(0));
		return new B(); // DOES NOT COMPILE
	}
}

class A {
}

class B extends A {
}

class C extends B {
	
	@Override
	public String toString() {
		return "C";
	}
}
