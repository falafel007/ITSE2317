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

import java.text.NumberFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class Program9 {

   private static final int SIZE = 15000000; //Change the array size to 15,000,000.
   final int AVAILABLE_CORES = Runtime.getRuntime().availableProcessors();

   public static void main(String[] arg) {
      Program9 test = new Program9();
      test.developerInfo();

      ExecutorService executorService = Executors.newSingleThreadExecutor();
      SimpleArray multi_threaded_array = test.multiThreadExecutor();
      SimpleArray single_threaded_array = test.singleThreadExecutor();
      executorService.shutdown();

      try {
         // wait 1 minute for both writers to finish executing
         boolean tasksEnded =                                     
            executorService.awaitTermination(1, TimeUnit.MINUTES);

         if (tasksEnded) {

            System.out.printf("Multithreaded Array Total Sum: %,d%n", multi_threaded_array.getTotalArray());
            System.out.printf("Single-Threaded Array Total Sum: %,d%n", single_threaded_array.getTotalArray());

            test.compareTimes(single_threaded_array.getTimeToWrite(), multi_threaded_array.getTimeToWrite());

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
   Method: singleThreadExecutor
   Parameters: ExecutorService
   Return: Simple Array
   Description: uses a single thread to populate a shared array with random numbers
    */
   public SimpleArray singleThreadExecutor() {
      // Start Timer
      Instant start_time = Instant.now();
      // Initialize ExecutorService with SingleThreadPool to build array
      ExecutorService executorService = Executors.newSingleThreadExecutor();
      // Build Array
      SimpleArray single_threaded_array = this.threadExecutor(executorService);
      //Shutdown Executor
      executorService.shutdown();

      // wait for executor to finish tasks before ending timer
      while(!executorService.isTerminated());
      Instant end_time = Instant.now();

      single_threaded_array.setTimeToWrite(Duration.between(start_time, end_time).toMillis());

      return single_threaded_array;

   }
   /*
      Method: singleThreadExecutor
      Parameters: ExecutorService
      Return: Simple Array
      Description: uses multiple threads to populate a shared array with random numbers
       */
   public SimpleArray multiThreadExecutor() {

      Instant start_time = Instant.now();
      // Initialize ExecutorService with fixedThreadPool to build array
      ExecutorService executorService = Executors.newFixedThreadPool(this.AVAILABLE_CORES);
      // Build Array
      SimpleArray multi_threaded_array = this.threadExecutor(executorService);
      // Shutdown Executor
      executorService.shutdown();

      // wait for executor to finish tasks before ending timer
      while(!executorService.isTerminated());
      Instant end_time = Instant.now();
      multi_threaded_array.setTimeToWrite(Duration.between(start_time, end_time).toMillis());

      return multi_threaded_array;
   }

   /*
     Method: threadExecutor
     Parameters: ExecutorService
     Return: Simple Array
     Description: uses ThreadExecutor to run ArrayWriter to construct a SimpleArray
    */
   public SimpleArray threadExecutor(ExecutorService executorService) {

      // construct the shared object
      SimpleArray sharedSimpleArray = new SimpleArray(this.SIZE);
      executorService.execute(new ArrayWriter(sharedSimpleArray));

      return sharedSimpleArray;
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

