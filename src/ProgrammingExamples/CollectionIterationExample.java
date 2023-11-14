package ProgrammingExamples;

import java.util.Arrays;
import java.util.List;

public class CollectionIterationExample
 {
	public static void main(String[] args)
	{
		List<Person> personList = Arrays.asList(
		       new Person("Charles", "Dickens", 60),
		       new Person("Joe", "Green", 42),
		       new Person("Lewis", "Carroll", 42),
		       new Person("John", "Doe", 51),
		       new Person("Jane", "Doe", 45),
		       new Person("Michael", "Cain", 68),
		       new Person("Dominic", "Cummings", 49),
		       new Person("Mary", "Groves", 35),
		       new Person("John", "Brown", 45),
		       new Person("Matthew", "Arnold", 39)
			);
				
		System.out.println("\nUsing for loop");
		for (int i = 0; i < personList.size(); i++)
		{
			System.out.println(personList.get(i));
		}
		
		System.out.println("\nUsing enchanced for loop");
		for (Person person : personList)
		{
			System.out.println(person);
		}
		
		System.out.println("\nUsing lambda forEach loop");
		personList.forEach(System.out::println);
	}
}
