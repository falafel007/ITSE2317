package Program8;
//********************************************************************
//
//  Developer:     Textbook Authors
//
//  Program #:     Eight
//
//  File Name:     Program8.Stack.java
//
//  Course:        ITSE 2317 Intermediate Java Programming
//
//  Due Date:           
//
//  Instructor:    Fred Kumi 
//
//  Chapter:       21
//
//  Description:   Program8.Stack uses a composed Program8.List object.
//
//********************************************************************

import java.util.NoSuchElementException;

public class Stack<T>
{
   private final List<T> stackList;

   // no-argument constructor
   public Stack()
   { 
      stackList = new List<>("stack"); 
   }

   // add object to stack
   public void push(T object)
   { 
      stackList.insertAtFront(object); 
   }

   // remove object from stack
   public T pop() throws NoSuchElementException
   { 
      return stackList.removeFromFront(); 
   }

   /*
    Method: peek
    Parameters:
    Return: T
    Description: returns the top value of the stack without popping the stack
     */
   public T peek() {
      T firstElement = this.pop();
      this.push(firstElement);
      return firstElement;
   }

   // determine if stack is empty
   public boolean isEmpty()
   { 
      return stackList.isEmpty(); 
   }

   // output stack contents
   public void print()
   { 
      stackList.print(); 
   }
}
