package builder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {
	public enum Topping {
		HAM, MUSHROOM, ONION, PEPPER, SAUSAGE
	}

	private final Set<Topping> toppings;

	abstract static class Builder<T extends Builder<T>> {
		EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

		public T addTopping(Topping topping) {
			this.toppings.add(Objects.requireNonNull(topping));
			return self();
		}

		protected abstract Pizza build();

		protected abstract T self();
	}

	protected Pizza(Builder<?> builder) {
		this.toppings = builder.toppings.clone();
	}
}
