// Fig. 23.8: SimpleArray.java
// Class that manages an integer array to be shared by multiple
// threads with synchronization.
import java.security.SecureRandom;
import java.util.Arrays;

public class SimpleArray {
   private static final SecureRandom generator = new SecureRandom();
   private final int[] array; // the shared integer array
   private int writeIndex = 0; // index of next element to be written
   public long totalArray;
   private final int size;


   // construct a SimpleArray of a given size
   public SimpleArray(int size) {
      this.size = size;
      this.array = new int[size];
   } 

   /*
   Method: add()
   Parameter: int value
   Return: void
   Description: sets the element of array at the writeIndex to the given value
    */
   public synchronized void add(int value) {

      if (writeIndex < this.size) {
         int position = writeIndex; // store the write index

         // put value in the appropriate element
         array[position] = value;
         this.totalArray += value;

         //System.out.printf("%s wrote %2d to element %d.%n", Thread.currentThread().getName(), value, position);
         //System.out.printf("Current Value: %,d%n", this.getTotalArray());

         ++writeIndex; // increment index of element to be written next
         //System.out.printf("Next write index: %d%n", writeIndex);
      }
   }

   /*
   Method add()
   Parameters: none
   Return: void
   Description: sets the element of the array at the writeIndex to a SecureRandom using generator attribute
    */
   public synchronized void add() {

      if (writeIndex < this.size) {
         int position = writeIndex; // store the write index

         // put value in the appropriate element
         array[position] = generator.nextInt(1, 21);
         this.totalArray += array[position];

         // System.out.printf("%s wrote %2d to element %d.%n", Thread.currentThread().getName(), value, position);
         ++writeIndex; // increment index of element to be written next
         // System.out.printf("Next write index: %d%n", writeIndex);
      }
   }

   // Method: getTotalArray
   // Parameters: none
   // Return long totalArray
   // Description: returns the value of totalArray attribute
   public long getTotalArray() {
      return this.totalArray;
   }

   // Method: setTotalArray
   // Parameters: none
   // Return: none
   // Description: sets totalArray attribute
   private void setTotalArray(){
      this.totalArray = Arrays.stream(this.array).sum();
   }

   /*
   Method: getSize()
   Parameters: none
   Return: size of array
   Description: returns the size of the array
    */

   public int getSize() {
      return this.size;
   }
   
   // used for outputting the contents of the shared integer array
   @Override
   public synchronized String toString() {
      return Arrays.toString(array);
   } 
}


