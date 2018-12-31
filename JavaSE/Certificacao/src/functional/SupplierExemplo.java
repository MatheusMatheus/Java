package functional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Supplier;

public class SupplierExemplo {
	public static void main(String[] args) {

		Supplier<LocalDate> s1 = LocalDate::now;
		Supplier<LocalDate> s2 = () -> LocalDate.now();
		
		LocalDate d1 = s1.get();
		LocalDate d2 = s2.get();
		
		System.out.println(d1);
		System.out.println(d2);
		
		Supplier<ArrayList<String>> array1 = ArrayList<String>::new;
		ArrayList<String> a1 = array1.get();
		System.out.println(a1);
	}
	
	
}
