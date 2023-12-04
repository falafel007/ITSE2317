package Program8;
//********************************************************************
//
//  Developer:     Textbook Authors
//
//  Program #:     Eight
//
//  File Name:     Program8.List.java
//
//  Course:        ITSE 2317 Intermediate Java Programming
//
//  Due Date:      
//
//  Instructor:    Fred Kumi 
//
//  Chapter:       21
//
//  Description:   Fig. 21.3: Program8.List.java
//                 Program8.ListNode and Program8.List class declarations.
//
//********************************************************************

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// class to represent one node in a list
class ListNode<E>
{
   // package access members; Program8.List can access these directly
   E data; // data for this node
   ListNode<E> nextNode; // reference to the next node in the list

   // constructor creates a Program8.ListNode that refers to object
   ListNode(E object)
   {
	   this(object, null);
   }

   // constructor creates Program8.ListNode that refers to the specified
   // object and to the next Program8.ListNode
   ListNode(E object, ListNode<E> node)
   {
      data = object;    
      nextNode = node;  
   } 

   // return reference to data in node
   E getData()
   {
	   return data;
   }

   // return reference to next node in list
   ListNode<E> getNext()
   {
	   return nextNode;
   }
} 

// class Program8.List definition
public class List<E> implements java.util.List<E> {
   private ListNode<E> firstNode;
   private ListNode<E> lastNode; 
   private String name; // string like "list" used in printing

   // constructor creates empty Program8.List with "list" as the name
   public List()
   {
	   this("list");
   }

   // constructor creates an empty Program8.List with a name
   public List(String listName)
   {
      name = listName;
      firstNode = lastNode = null;
   } 

   // insert item at front of Program8.List
   public void insertAtFront(E insertItem)
   {
      if (isEmpty()) { // firstNode and lastNode refer to same object
         firstNode = lastNode = new ListNode<E>(insertItem);
      } 
      else { // firstNode refers to new node
         firstNode = new ListNode<E>(insertItem, firstNode);
      } 
   } 

   // insert item at end of Program8.List
   public void insertAtBack(E insertItem)
   {
      if (isEmpty()) { // firstNode and lastNode refer to same object
         firstNode = lastNode = new ListNode<E>(insertItem);
      } 
      else { // lastNode's nextNode refers to new node
         lastNode = lastNode.nextNode = new ListNode<E>(insertItem);
      } 
   } 

   // remove first node from Program8.List
   public E removeFromFront() throws NoSuchElementException
   {
      if (isEmpty()) // throw exception if Program8.List is empty
	  { 
         throw new NoSuchElementException(name + " is empty");
      }

      E removedItem = firstNode.data; // retrieve data being removed

      // update references firstNode and lastNode 
      if (firstNode == lastNode)
	  {
         firstNode = lastNode = null;
      }
      else
	  {
         firstNode = firstNode.nextNode;
      }

      return removedItem; // return removed node data
   } 

   // remove last node from Program8.List
   public E removeFromBack() throws NoSuchElementException
   {
      if (isEmpty()) // throw exception if Program8.List is empty
	  { 
         throw new NoSuchElementException(name + " is empty");
      }

      E removedItem = lastNode.data; // retrieve data being removed

      // update references firstNode and lastNode
      if (firstNode == lastNode)
	  {
         firstNode = lastNode = null;
      }
      else
	  {  // locate new last node
         ListNode<E> current = firstNode;

         // loop while current node does not refer to lastNode
         while (current.nextNode != lastNode)
		 {
            current = current.nextNode;
         }
   
         lastNode = current; // current is new lastNode
         current.nextNode = null;
      } 

      return removedItem; // return removed node data
   }

   @Override
   public int size() {
      return 0;
   }

   // determine whether list is empty; returns true if so
   public boolean isEmpty()
   {
	   return firstNode == null;
   }

   @Override
   public boolean contains(Object o) {
      return false;
   }

   @Override
   public Iterator<E> iterator() {
      return null;
   }

   @Override
   public Object[] toArray() {
      return new Object[0];
   }

   @Override
   public <T> T[] toArray(T[] a) {
      return null;
   }

   @Override
   public boolean add(E e) {
      return false;
   }

   @Override
   public boolean remove(Object o) {
      return false;
   }

   @Override
   public boolean containsAll(Collection<?> c) {
      return false;
   }

   @Override
   public boolean addAll(Collection<? extends E> c) {
      return false;
   }

   @Override
   public boolean addAll(int index, Collection<? extends E> c) {
      return false;
   }

   @Override
   public boolean removeAll(Collection<?> c) {
      return false;
   }

   @Override
   public boolean retainAll(Collection<?> c) {
      return false;
   }

   @Override
   public void clear() {

   }

   @Override
   public E get(int index) {
      return null;
   }

   @Override
   public E set(int index, E element) {
      return null;
   }

   @Override
   public void add(int index, E element) {

   }

   @Override
   public E remove(int index) {
      return null;
   }

   @Override
   public int indexOf(Object o) {
      return 0;
   }

   @Override
   public int lastIndexOf(Object o) {
      return 0;
   }

   @Override
   public ListIterator<E> listIterator() {
      return null;
   }

   @Override
   public ListIterator<E> listIterator(int index) {
      return null;
   }

   @Override
   public java.util.List<E> subList(int fromIndex, int toIndex) {
      return null;
   }

   // output list contents
   public void print()
   {
      if (isEmpty())
	  {
         System.out.printf("Empty %s%n", name);
         return;
      } 

      System.out.printf("The %s is: ", name);
      ListNode<E> current = firstNode;

      // while not at end of list, output current node's data
      while (current != null)
	  {
         System.out.printf("%s ", current.data);
         current = current.nextNode;
      } 

      System.out.println();
   }

} 
