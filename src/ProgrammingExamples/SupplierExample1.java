package ProgrammingExamples;// Represents a no-parameter method that returns a result. Often used
// to create a collection object in which a stream operation’s results
// are placed. You’ll see several examples of Suppliers starting in
// Section 17.13.

// https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html

import java.util.function.Supplier;

public class SupplierExample1
{
   public static void main(String[] args)
   {
      System.out.println("Without Supplier");
	  System.out.println(getConnectionUrl());
		  
	  System.out.println("\nWith Supplier");
	  System.out.println(getConnectionUrlSupplier.get());
   }
    
   public static Supplier<String> getConnectionUrlSupplier = ()-> 
      "jdbc:oracle:thin:@coisor.austincc.edu:1527:CSOR";

   public static String getConnectionUrl()
   {
      return "jdbc:oracle:thin:@coisor.austincc.edu:1527:CSOR";
   }
}
