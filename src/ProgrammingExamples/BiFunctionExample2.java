package ProgrammingExamples;// import java.util.function.Function;

public class BiFunctionExample2
{
   public static void main(String[] args)
   {
      int value1 = incrementByOneAndMultiply(4, 100);
	  System.out.println(value1);
	  
      int value2 = incrementByOneAndMultiplyBiFunction.apply(4, 100);
	  System.out.println(value2);
 
      System.out.println(incrementByOneAndMultiplyBiFunction.apply(4, 100)); 
   }
   
   static BiFunctionsInterface incrementByOneAndMultiplyBiFunction = 
   (numberToIncrementByOne, numberToMultiplyBy)  -> (numberToIncrementByOne + 1) * numberToMultiplyBy;
 
   public static int incrementByOneAndMultiply(int numberToIncrementByOne, int numberToMultiplyBy)
   {
      return (numberToIncrementByOne + 1) * numberToMultiplyBy;
   }
}
