package Program6;//********************************************************************
//
//  Developer:    Christopher Felleisen
//
//  Program #:    Six
//
//  File Name:    Program6.Program6.java
//
//  Course:       ITSE 2317 Intermediate Java Programming
//
//  Due Date:     11/3/2022
//
//  Instructor:   Prof. Fred Kumi
//
//  Chapter:      18
//
//  Description:  Recursion: Fibonacci Timing and Counting
//
//********************************************************************

import Program5.Invoice;

import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.lang.runtime.ObjectMethods;
import java.util.function.*;

public class Program6 {

    
    public static void main(String[] args) {

        Program6 program6 = new Program6(); // instance of Program6.Program6 to access non-static methods
        program6.developerInfo();

        FibonacciCalculator test = new FibonacciCalculator(); // test instance of Program6.FibonacciCalculator

        double time = test.timeFibonacci(0, 40); // record time and display fibonacci values from 0 to 40
        test.displayCount(); // display count of calls to test.fibonacci

        program6.displayRuntime(time); // display time
    }


    /*
    Method: displayRuntime
    Parameters: startTime endTime
    Return: void
    Description: displays the total runtime in milliseconds given a start and an end time in
     */
    private void displayRuntime(double time) {
        System.out.printf("%nComputation Time: %.2f milliseconds.%n", time);
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
        System.out.println("Program: Six\n\n");

    } // End of the developerInfo method

}
