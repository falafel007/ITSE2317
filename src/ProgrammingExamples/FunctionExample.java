package ProgrammingExamples;// Represents a one-parameter method that performs a task on the
// parameter and returns a result—possibly of a different type
// than the parameter. The lambda you passed to IntStream method
// mapToObj (Section 17.6) implemented interface IntFunction—an
// int-specialized version of Function. Later sections present
// several more examples of Functions.

import java.util.function.Function;

public class FunctionExample
{
   public static void main(String[] args)
   {
      int increment1 = incrementByOne(1);
	  System.out.println(increment1);
	  
      int increment2 = incrementByOneFunction.apply(1);
	  System.out.println(increment2);
	  
      int increment3 = multiplyByTenFunction.apply(1);
	  System.out.println(increment3);

   }
   
   static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

   static Function<Integer, Integer> multiplyByTenFunction = number -> number * 10;
   
   public static int incrementByOne(int number)
   {
      return number + 1;
   }
}
