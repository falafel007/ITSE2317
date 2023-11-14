package ProgrammingExamples;// Represents a one-parameter method that returns a boolean result.
// Determines whether the parameter satisfies a condition. The lambda
// you passed to IntStream method filter (Section 17.4) implemented
// interface Int-Predicate—an int-specialized version of Predicate.
// Later sections present several more examples of Predicates.

// https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html

import java.util.function.Predicate;

public class PredicateExample1
{
   public static void main(String[] args)
   {
      System.out.println("Without Predicate");
	  System.out.println(isPhoneNumberValid("5121231234"));
	  System.out.println(isPhoneNumberValid("2101231234"));
		  
	  System.out.println("\nWith Predicate");
	  System.out.println(isPhoneNumberValidPredicate.test("5121231234"));
	  System.out.println(isPhoneNumberValidPredicate.test("2101231234"));
   }
   
   public static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> 
      phoneNumber.startsWith("512") && phoneNumber.length() == 10;


   public static boolean isPhoneNumberValid(String phoneNumber)
   {
      return phoneNumber.startsWith("512") && phoneNumber.length() == 10;
   }
}
