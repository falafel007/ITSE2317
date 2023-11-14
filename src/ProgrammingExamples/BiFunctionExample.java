package ProgrammingExamples;// Represents a function that accepts two arguments and produces
// a result.
/*
Interface BiFunction<T,U,R>

    Type Parameters:
        T - the type of the first argument to the function
        U - the type of the second argument to the function
        R - the type of the result of the function

    All Known Subinterfaces:
        BinaryOperator<T> 
*/

// https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html

import java.util.function.BiFunction;

public class BiFunctionExample
{
   public static void main(String[] args)
   {
      int value1 = incrementByOneAndMultiply(4, 100);
	  System.out.println(value1);
	  
      int value2 = incrementByOneAndMultiplyBiFunction.apply(4, 100);
	  System.out.println(value2);
 
      System.out.println(incrementByOneAndMultiplyBiFunction.apply(4, 100)); 
   }
   
   static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction = 
   (numberToIncrementByOne, numberToMultiplyBy)  -> (numberToIncrementByOne + 1) * numberToMultiplyBy;
 
   public static int incrementByOneAndMultiply(int numberToIncrementByOne, int numberToMultiplyBy)
   {
      return (numberToIncrementByOne + 1) * numberToMultiplyBy;
   }
}
