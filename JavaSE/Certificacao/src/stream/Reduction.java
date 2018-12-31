package stream;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;

import stream.Person.Sex;


public class Reduction {
	public static void main(String[] args) {
		List<Person> roster = new ArrayList<>();
		roster.add(new Person("Joao", LocalDate.of(1995, 10, 5), Sex.MALE));
		roster.add(new Person("Maria", LocalDate.of(2000, 7, 8), Sex.FEMALE));
		roster.add(new Person("Jose", LocalDate.of(1980, 8, 9), Sex.MALE));
		roster.add(new Person("Joana", LocalDate.of(1995, 10, 5), Sex.FEMALE));

		Averager averageCollect = roster.stream()
				.filter(p -> p.getGender() == Person.Sex.MALE)
				.map(Person::getAge)
				.collect(Averager::new, Averager::accept, Averager::combine);

		System.out.println("Average age of male members: " + averageCollect.average());

		List<String> namesOfMaleMembersCollect = roster.stream()
				.filter(p -> p.getGender() == Person.Sex.MALE)
				.map(p -> p.getName())
				.collect(Collectors.toList());
		
		System.out.println(namesOfMaleMembersCollect);

		Map<Person.Sex, List<Person>> byGender = roster.stream()
				.collect(Collectors.groupingBy(Person::getGender));
		System.out.println(byGender);

		Map<Person.Sex, List<String>> namesByGender = roster.stream()
				.collect(
				Collectors.groupingBy(
						Person::getGender, 
						Collectors.mapping(
								Person::getName, 
								Collectors.toList())));

		System.out.println(namesByGender);
	}
}

class Averager implements IntConsumer {
	private int total = 0;
	private int count = 0;

	public double average() {
		return count > 0 ? ((double) total) / count : 0;
	}

	public void accept(int i) {
		total += i;
		count++;
	}

	public void combine(Averager other) {
		total += other.total;
		count += other.count;
	}
}

class Person {

	public enum Sex {
		MALE, FEMALE
	}

	public Person(String name, LocalDate birthday, Sex gender) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.emailAddress = name + "@email.com";
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Name: " + getName());
		str.append(", Gender: " + getGender());
		str.append(", Birthday: " + getBirthday());
		str.append(", Email: " + getEmailAddress());
		
		return str.toString();
	}

	String name;
	LocalDate birthday;
	Sex gender;
	String emailAddress;

	public int getAge() {
		return Period.between(birthday, LocalDate.now()).getYears();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public Sex getGender() {
		return gender;
	}

	public void setGender(Sex gender) {
		this.gender = gender;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

}
