package builder;

import java.util.Arrays;
import java.util.List;

import immutable.Animal;

public class AnimalBuilder {
	public static void main(String[] args) {
		Builder duckBuilder = new Builder();
		duckBuilder
			.setAge(4)
			.setFavoriteFoods(Arrays.asList("grass", "fish"))
			.setSpecies("duck");
		
		Animal duck = duckBuilder.build();
		System.out.println(duck);
		
		Animal flamingo = new Builder()
				.setFavoriteFoods(Arrays.asList("algae", "insects"))
				.setSpecies("flamingo").build();
		System.out.println(flamingo);
		
		
	}
}

class Builder {
	private String species;
	private int age;
	private List<String> favoriteFoods;

	public Animal build() {
		return new Animal(species,age,favoriteFoods);
	}
	
	public Builder setAge(int age) {
		this.age = age;
		return this;
	}

	public Builder setSpecies(String species) {
		this.species = species;
		return this;
	}

	public Builder setFavoriteFoods(List<String> favoriteFoods) {
		this.favoriteFoods = favoriteFoods;
		return this;
	}
}
