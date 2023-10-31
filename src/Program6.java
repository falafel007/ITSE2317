//********************************************************************
//
//  Developer:    Christopher Felleisen
//
//  Program #:    Six
//
//  File Name:    Program6.java
//
//  Course:       ITSE 2317 Intermediate Java Programming
//
//  Due Date:     10/25/2022
//
//  Instructor:   Prof. Fred Kumi
//
//  Chapter:      18
//
//  Description:  Recursion: Fibonacci Timing and Counting
//
//********************************************************************

import java.math.BigInteger;
import java.util.stream.IntStream;

public class Program6 { //FibonacciCalculator Class from fig 18.5
    private static final BigInteger TWO = BigInteger.valueOf(2);
    private static int count = 0;
    
    public static void main(String[] args) {

        double startTime = System.currentTimeMillis();

        // as a stream for practoce
        /*
        IntStream.rangeClosed(0, 40)
                .mapToObj(i -> String.format("Fibonacci of %d is %d%n", i, fibonacci(BigInteger.valueOf(i))))
                .forEach(System.out::println);
        */

        for (int counter = 0; counter <= 40; counter++) {
            System.out.printf("Fibonacci of %d is: %d%n", counter, fibonacci(BigInteger.valueOf(counter)));
        }

        double endTime = System.currentTimeMillis();
        System.out.printf("Computation Time: %.2f milliseconds.%n", (endTime - startTime));
        System.out.printf("Number of calls to fibonacci method: %,d", count);
    }

    // recursive declaration of method fibonacci
    public static BigInteger fibonacci(BigInteger number) {

        if (number.equals(BigInteger.ZERO) || number.equals(BigInteger.ONE)) {
            count += 1;
            return number;
        }
        else {
            count += 1;
            return fibonacci(number.subtract(BigInteger.ONE)).add(fibonacci(number.subtract(TWO)));
        }
    }

}
