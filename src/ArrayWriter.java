// Fig. 23.6: ArrayWriter.java
// Adds integers to an array shared with other Runnables

//********************************************************************
//
//  Developer:     Christopher Felleisen
//
//  Program #:     Nine
//
//  File Name:     ArrayWriter.java
//
//  Course:        ITSE 2317 Intermediate Java Programming
//
//  Due Date:      12/05/2023
//
//  Instructor:    Fred Kumi
//
//  Chapter:       23
//
//  Description: Implements Runnable to write values to an array
//
//********************************************************************

import java.lang.Runnable;
import java.security.SecureRandom;

public class ArrayWriter implements Runnable {
   private final SimpleArray sharedSimpleArray;

//   private final int startValue;

//   public ArrayWriter(int value, SimpleArray array) {
//      this.startValue = value;
//      this.sharedSimpleArray = array;
//   }

   public ArrayWriter(SimpleArray array) {
      //this.startValue = 0;
      this.sharedSimpleArray = array;
   }


   // Modified the run method to add random numbers (between 1-20) to the array.
   @Override
   public void run() {
      SecureRandom rand = new SecureRandom();

      for (int i = 0; i < this.sharedSimpleArray.getSize(); i++) {
         this.sharedSimpleArray.add(rand.nextInt(1,21)); // add an element to the shared array ** Better to use add(value) or add()?**
      }
   }
} 






