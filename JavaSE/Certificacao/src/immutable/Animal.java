package immutable;

import java.util.ArrayList;
import java.util.List;

public final class Animal {
	private final String species;
	private final int age;
	private final List<String> favoriteFoods;

	public Animal(String species, int age, List<String> favoriteFoods) {
		super();
		this.species = species;
		this.age = age;
		this.favoriteFoods = new ArrayList<>(favoriteFoods);
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("Age: ").append(getAge());
		s.append("\nSpecies: ").append(getSpecies());
		return s.toString();
	}

	public String getSpecies() {
		return species;
	}

	public int getAge() {
		return age;
	}

	public int getFavoriteFoodsCount() {
		return favoriteFoods.size();
	}

	public String getFavoriteFood(int index) {
		return favoriteFoods.get(index);
	}

}
