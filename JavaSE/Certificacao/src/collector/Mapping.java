package collector;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.minBy;

import java.util.Arrays;
import java.util.stream.Stream;

public class Mapping {
	public static void main(String[] args) {
		Stream<String> stream1 = Stream.of("lions", "tigers", "bears", "aaaaaa");
		Map<Integer, Optional<Character>> map1 = stream1.collect(Collectors.groupingBy(String::length,
				Collectors.mapping(s -> s.charAt(0), Collectors.minBy(Comparator.naturalOrder()))));
		System.out.println(map1); // {5=Optional[b], 6=Optional[t]}

		Stream<String> stream2 = Stream.of("lions", "tigers", "bears");
		Map<Integer, Optional<Character>> map2 = stream2
				.collect(groupingBy(String::length, mapping(s -> s.charAt(0), minBy(Comparator.naturalOrder()))));
		System.out.println(map2); // {5=Optional[b], 6=Optional[t]}


		List<Person> people = Arrays.asList(
				new Person("Maria", "Raimunda", new City("BSB")), 
				new Person("Matheus", "Rodrigues", new City("BSB")),
				new Person("Jose", "Rodrigues", new City("BSB")),
				new Person("John", "Doe", new City("NY")), 
				new Person("Paul", "McCartney", new City("London")));

		Map<City, Set<String>> lastNamesByCity = people.stream().collect(
				Collectors.groupingBy(Person::getCity, Collectors.mapping(Person::getLastName, Collectors.toSet())));

		System.out.println(lastNamesByCity);
	}
}

class City {
	private String name;

	public City(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}

class Person {
	private String firstName;
	private String lastName;
	private City city;

	public Person(String firstName, String lastName, City city) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
	}

	@Override
	public String toString() {
		return getFirstName() + " " + getLastName();
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public City getCity() {
		return city;
	}

}
