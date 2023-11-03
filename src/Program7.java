//********************************************************************
//
//  Developer:     Instructor
//
//  Program #:     Seven
//
//  File Name:     Program7.java
//
//  Course:        ITSE 2317 Intermediate Java Programming
//
//  Due Date:        
//
//  Instructor:    Fred Kumi 
//
//  Chapter:       20
//
//  Description:   Printing array elements using generic
//                 method printArray.
//
//********************************************************************

import java.util.Arrays;

public class Program7
{
   //***************************************************************
   //
   //  Method:       main
   // 
   //  Description:  The main method of the program
   //
   //  Parameters:   String array
   //
   //  Returns:      N/A 
   //
   //**************************************************************
   public static void main(String[] args)
   {
      Program7 test = new Program7();
      // create arrays of Integer, Double and Character
      Integer[] integerArray = {1, 2, 3, 4, 5};
      Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
      Character[] characterArray = {'H', 'E', 'L', 'L', 'O'};

      System.out.printf("Array integerArray contains: ");
      printArray(integerArray); // pass an Integer array
      test.printArray(integerArray, 2, 4); //valid
      System.out.println(test.printArray(integerArray, 2, 6)); //error

	  
      System.out.printf("Array doubleArray contains: ");
      printArray(doubleArray); // pass a Double array
      test.printArray(doubleArray, 0, 0); // valid
      // test.printArray(doubleArray, -1, 6); //error

	  
      System.out.printf("Array characterArray contains: ");
      printArray(characterArray); // pass a Character array
      test.printArray(characterArray, 0, 4); //valid
      // test.printArray(characterArray, 6, 2); // error
   }

   // generic method printArray                     
   public static <T> void printArray(T[] inputArray)
   {
      // display array elements            
      for (T element : inputArray)
	  {       
         System.out.printf("%s ", element);
      }                                    

      System.out.println();
   }

   public <T> int printArray(T[] inputArray, int lowSubscript, int highSubscript) {

      int itemsPrinted = 0;

      try {
         isLowSubscriptValid(lowSubscript, highSubscript);
         isHighSubscriptValid(inputArray, highSubscript);

         for (int i = lowSubscript; i <= highSubscript; i++) {
            System.out.printf("%s ", inputArray[i]);
         }

         System.out.println();
         itemsPrinted = highSubscript - lowSubscript;
      }
      catch(RuntimeException e) {
         System.err.println(e);
      }

      return itemsPrinted;

   }

   private <T> Boolean isLowSubscriptValid (int lowSubscript, int highSubscript) {
      if (lowSubscript >= 0 && lowSubscript <= highSubscript) return true;
      else throw InvalidSubscriptException;
   }

   private  <T> Boolean isHighSubscriptValid (T[] inputArray, int highSubscript) {
      if (highSubscript < inputArray.length) return true;
      else throw InvalidSubscriptException;
   }

   RuntimeException InvalidSubscriptException = new RuntimeException("Invalid Subscript Index.");
} 
