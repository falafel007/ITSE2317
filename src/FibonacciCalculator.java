//********************************************************************
//
//  Developer:    Christopher Felleisen
//
//  Program #:    Six
//
//  File Name:    FibonacciCalculator.java
//
//  Course:       ITSE 2317 Intermediate Java Programming
//
//  Due Date:     11/2/2022
//
//  Instructor:   Prof. Fred Kumi
//
//  Chapter:      18
//
//  Description:  Updated FibonacciCalculator from fig 18.5
//
//********************************************************************
import java.math.BigInteger;

public class FibonacciCalculator {
    private static final BigInteger TWO = BigInteger.valueOf(2);
    private int count = 0; // variable to count

    /*
    Method: timeFibonacci
    Parameters: int end
    Return: double time
    Description: returns the time it takes to compute the fibonacci values between 0 and end (inclusive)
    Effects: prints fibonacci value of each count
     */
    public double timeFibonacci(int startValue, int endValue) {

        double startTime = System.currentTimeMillis(); // Start timer

        // displays fibonacci values from 0- end
        for (int counter = startValue; counter <= endValue; counter++) {
            System.out.printf("Fibonacci of %d is: %d%n", counter, this.fibonacci(BigInteger.valueOf(counter)));
        }

        double endTime = System.currentTimeMillis(); // End timer

        return endTime - startTime;
    }

    /*
    Method: fibonacci
    Parameter: BigInteger number
    Return: BigInteger
    Description: recursive declaration of method fibonacci calculates and returns fibonacci value of given BigInteger
    Effects: increases this.count by 1 for each call.
     */
    private BigInteger fibonacci(BigInteger number) {

        if (number.equals(BigInteger.ZERO) || number.equals(BigInteger.ONE)) {
            this.count += 1;
            return number;
        }
        else {
            this.count += 1;
            return fibonacci(number.subtract(BigInteger.ONE)).add(fibonacci(number.subtract(TWO)));
        }
    }

    /*
    Method: displayCount
    Parameters: none
    Return: void
    Description: displays the number of times method fibonacci has been called
    */
    public void displayCount(){
        System.out.printf("%nNumber of calls to Fibonacci method: %,d%n", this.count);
    }

}
