package ProgrammingExamples;

import java.util.function.Consumer;

public class ConsumerExample1
{
   public static void main(String[] args)
   {
	  Customer John = new Customer("John Doe", "5125551212");

 	  System.out.println("Without Consumer");
      thankCustomer(John);
		  
	  System.out.println("\nWith Consumer");
	  thankCustomerConsumer.accept(John);
   }
   
   public static Consumer<Customer> thankCustomerConsumer = customer -> 
       System.out.println("Thanks " + customer.getCusName() + " for validating your " +
	                     "phone number " + customer.getCusPhoneNo());


   public static void thankCustomer(Customer customer)
   {
      System.out.println("Thanks " + customer.getCusName() + " for validating your " +
	                     "phone number " + customer.getCusPhoneNo());
   }
}
