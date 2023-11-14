package ProgrammingExamples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListExampleJava8 {

	public static void main(String[] args) {
		List<Person> personList = new ArrayList<Person>();

		personList.add(new Person("Charles", "Dickens", 60));
		personList.add(new Person("Joe", "Green", 42));
		personList.add(new Person("Lewis", "Carroll", 42));
		personList.add(new Person("John", "Doe", 51));
		personList.add(new Person("Jane", "Doe", 45));
		personList.add(new Person("Michael", "Cain", 68));
		personList.add(new Person("Dominic", "Cummings", 49));
		personList.add(new Person("Mary", "Groves", 35));
		personList.add(new Person("John", "Brown", 45));
		personList.add(new Person("Matthew", "Arnold", 39));
		
		// Sort list by last name
		Collections.sort(personList, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
		
		// Create a method that prints all elements in the list
		System.out.println("Printing all persons");
		printAll(personList);
	}

	private static void printAll(List<Person> peopleList)
	{
		for (Person person : peopleList)
		{
			System.out.println(person);
		}
	}
}
