package builder;

import builder.NyPizza.Size;
import builder.Pizza.Topping;
public class Main {
	public static void main(String[] args) {
		NyPizza pizza = new NyPizza
				.Builder(Size.SMALL)
				.addTopping(Topping.SAUSAGE)
				.addTopping(Topping.ONION)
				.build();
	
		Calzone calzone = new Calzone
				.Builder()
				.addTopping(Topping.HAM)
				.sauceInside()
				.build();
		
		System.out.println(pizza);
		System.out.println(calzone);
	}
}
