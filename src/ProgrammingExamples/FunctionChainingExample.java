package ProgrammingExamples;

import java.util.function.Function;

public class FunctionChainingExample
{
   public static void main(String[] args)
   {
      int increment1 = incrementByOne(1);
	  System.out.println(increment1);
	  
      int increment2 = incrementByOneFunction.apply(1);
	  System.out.println(increment2);
	  
      int increment3 = multiplyByTenFunction.apply(1);
	  System.out.println(increment3);
	  
	  Function<Integer, Integer> addOneAndMultiplyByTen =
	  incrementByOneFunction.andThen(multiplyByTenFunction);
	  
	  System.out.println(addOneAndMultiplyByTen.apply(2));
   }
   
   static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

   static Function<Integer, Integer> multiplyByTenFunction = number -> number * 10;
   
   public static int incrementByOne(int number)
   {
      return number + 1;
   }
}
