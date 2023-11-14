package ProgrammingExamples;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReferenceExample2
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
		       new Person("John", "Brown", 45));

		System.out.println("Printing all persons");
		performConditionally(personList, p -> true, System.out::println); // p -> method(p)
	}

	private static void performConditionally(List<Person> personList, Predicate<Person> predicate, Consumer<Person> consumer)
	{
		for (Person person : personList)
		{
			if (predicate.test(person))
			{
				consumer.accept(person);
			}
		}
	}
}
