package ProgrammingExamples;// Represents a method that takes two parameters of the same type and
// returns a value of that type. Performs a task using the parameters
// (such as a calculation) and returns the result. The lambdas you
// passed to IntStream method reduce (Section 17.7) implemented 
// IntBinaryOperator's specific version of BinaryOperator.


import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class BinaryOperatorExample1
{
    public static void main(String[] args)
	{
        // BiFunction
        BiFunction<Integer, Integer, Integer> func = (x1, x2) -> x1 + x2;
        Integer result = func.apply(2, 3);
        System.out.println(result);      // 5

        // BinaryOperator
        BinaryOperator<Integer> func2 = (x1, x2) -> x1 + x2;
        Integer result2 = func2.apply(2, 3);
        System.out.println(result2);      // 5
    }
}