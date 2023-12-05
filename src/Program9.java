// Fig. 23.7: Program9.java
// Executing two Runnables to add elements to a shared SimpleArray.

//********************************************************************
//
//  Developer:     Christopher Felleisen
//
//  Program #:     Nine
//
//  File Name:     Program9.java
//
//  Course:        ITSE 2317 Intermediate Java Programming
//
//  Due Date:      12/05/2023
//
//  Instructor:    Fred Kumi
//
//  Chapter:       23
//
//  Description: Compares runtime of Multi- and Single- thread array operations
//
//********************************************************************

import java.security.SecureRandom;
import java.text.NumberFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class Program9 {

   private static final int SIZE = 15000000; //Change the array size to 15,000,000.
   final int AVAILABLE_CORES = Runtime.getRuntime().availableProcessors();

   public static void main(String[] arg) {
      Program9 test = new Program9();
      test.developerInfo();

      /*
      MultiThread Implementation
       */

      // execute the tasks with an ExecutorService
      ExecutorService executorService = Executors.newFixedThreadPool(test.AVAILABLE_CORES);

      // Begin timing multithreaded
      Instant multi_threaded_array_start = Instant.now();

      // construct the shared object
      SimpleArray sharedSimpleArray = new SimpleArray(SIZE);
      test.multiThreadArray(executorService, sharedSimpleArray);

      // End timer and calculate elapsed time
      Instant multi_threaded_array_end = Instant.now();
      long multi_threaded_time = Duration.between(multi_threaded_array_start, multi_threaded_array_end).toMillis();

      // Shutdown Executor
      executorService.shutdown();

      /*
      Helper method implementation of multithreading
      Does not work -- returns time, but reports sum = 0
       */
//      ExecutorService executorService = Executors.newCachedThreadPool();
//      long[] multi_threaded_stats = test.multiThreadStats(executorService);
//      executorService.shutdown();

      /*
      Single Thread Implementation
       */
      long[] single_threaded_stats = test.singleThreadStats();

      try {
         // wait 1 minute for both writers to finish executing
         boolean tasksEnded =                                     
            executorService.awaitTermination(1, TimeUnit.MINUTES);

         if (tasksEnded) {

            System.out.printf("Multithreaded Array Total Sum: %,d%n", sharedSimpleArray.getTotalArray());
            //System.out.printf("Multithreaded Array Total Sum: %,d%n", multi_threaded_stats[0]);
            System.out.printf("Single-Threaded Array Total Sum: %,d%n", single_threaded_stats[0]);

            test.compareTimes(single_threaded_stats[1], multi_threaded_time);
            //test.compareTimes(single_threaded_stats[1], multi_threaded_stats[1]);

         }   
         else {
            System.out.println(
               "Timed out while waiting for tasks to finish.");
         } 
      } 
      catch (InterruptedException ex) {
         ex.printStackTrace();
      }
   }

   /*
   Method: singleThreadArray
   Parameters: none
   Return: long sum of elements
   Description:  creates a simple integer array of size SIZE, and populate it with random numbers (between 1-20),
   and return the sum of the members.
    */
   public long singleThreadArray() {
      SecureRandom rand = new SecureRandom();
      int[] a = rand.ints(SIZE, 1, 21).toArray();

      return Arrays.stream(a).sum();

   }
   /*
   Method: singleThreadStats
   Parameters: none
   Return: long[]
   Description: returns long[], [0] is sum of array and [1] is time in milliseconds
    */
   public long[] singleThreadStats(){

      Instant single_threaded_array_start = Instant.now();
      long single_threaded_total = this.singleThreadArray();
      Instant single_threaded_array_end = Instant.now();

      long single_threaded_time = Duration.between(single_threaded_array_start, single_threaded_array_end).toMillis();

      return new long[] {single_threaded_total, single_threaded_time};
   }


   /*
   Method: multiThreadArray()
   Parameters: ExecutorService
   Return: void ** why can't I get this to return the sum properly? **
   Description:  uses multiple threads to populate a sharedSimpleArray with random numbers
    */
   public void multiThreadArray(ExecutorService executorService, SimpleArray sharedSimpleArray) {
      final int AVAILABLE_CORES = Runtime.getRuntime().availableProcessors();

      // execute the tasks with an ExecutorService
      for (int c = 1; c <= AVAILABLE_CORES; c++) {
         executorService.execute(new ArrayWriter(sharedSimpleArray));
      }

   }

   /*
   Method: multiThreadStats
   Parameters: ExecutorService
   Return: array of statistics about multithreaded actions
   Description: returns array size 2 with i[0] as sum of sharedArray and i[1] as time elapsed
    */
   public long[] multiThreadStats(ExecutorService executorService) {
      // Begin timing multithreaded
      Instant multi_threaded_array_start = Instant.now();
      // construct the shared object
      SimpleArray sharedSimpleArray = new SimpleArray(SIZE);
      // execute the tasks with an ExecutorService

      this.multiThreadArray(executorService, sharedSimpleArray);

      Instant multi_threaded_array_end = Instant.now();
      long multi_threaded_time = Duration.between(multi_threaded_array_start, multi_threaded_array_end).toMillis();

      return new long[] {sharedSimpleArray.getTotalArray(), multi_threaded_time};
   }


   /*
   Method: compareTimes
   Parameters: long single_time, long multi_time
   Return: void
   Description: Use the Date/Time API timing techniques to compare the time for both methods to run.
    */
   public void compareTimes(long single_threaded_time, long multi_threaded_time){
      System.out.println();
      System.out.printf("Multithreaded Time: %,d milliseconds%n", multi_threaded_time);
      System.out.printf("Single-Threaded Time: %,d milliseconds%n", single_threaded_time);
      System.out.println();

      double percentDifference;

      if (multi_threaded_time < single_threaded_time) {
         percentDifference = (double) (single_threaded_time - multi_threaded_time) / multi_threaded_time;
         String percentage = NumberFormat.getPercentInstance().format(percentDifference);
         System.out.printf("Single-threaded execution took %s more time than multithreaded execution.%n", percentage);
      }
      else if (multi_threaded_time > single_threaded_time) {
         percentDifference = (double) (multi_threaded_time - single_threaded_time) / single_threaded_time;
         String percentage = NumberFormat.getPercentInstance().format(percentDifference);
         System.out.printf("Multithreaded execution took %s more time than single threaded execution.%n", percentage);
      }
      else {
         System.out.println("The two methods took the same amount of time.");
      }
   }


   //***************************************************************
   //
   //  Method:       developerInfo (Non Static)
   //
   //  Description:  The developer information method of the program
   //
   //  Parameters:   None
   //
   //  Returns:      N/A
   //
   //**************************************************************
   public void developerInfo()
   {
      System.out.println("Name:    Christopher Felleisen");
      System.out.println("Course:  ITSE 2317 Intermediate Java Programming");
      System.out.println("Program: Nine\n\n");

   } // End of the developerInfo method

}

