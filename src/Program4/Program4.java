package Program4;
//********************************************************************
//
//  Developer:    Christopher Felleisen
//
//  Program #:    Four
//
//  File Name:    Program4.java
//
//  Course:       ITSE 2317 Intermediate Java Programming
//
//  Due Date:     10/15/2022
//
//  Instructor:   Prof. Fred Kumi
//
//  Chapter:      16
//
//  Description:  World Series Data Tracker Main Program
//
//********************************************************************

import java.util.Scanner;

public class Program4 {

    public static void main (String[] args) {
        Program4 test = new Program4();
        test.developerInfo();

        // read data from file to WorldSeriesTracker
        WorldSeriesTracker tracker = new WorldSeriesTracker("program4.txt");

        // get data from WorldSeriesTracker until user enters 0
        test.getWorldSeriesStats(tracker);

    } // end main

    /**
     * Method: getWorldSeriesStats
     * Description: given WorldSeries Data file, takes user input and
     * displays corresponding World Series statistics
     *
     * @param tracker WorldSeriesTracker data file
     * Return: void
     */
    private void getWorldSeriesStats (WorldSeriesTracker tracker) {

        final String prompt = "For which year would you like World Series data?";
        Scanner input = new Scanner(System.in);

        // initial prompt
        System.out.printf("%s ", prompt);
        int year = input.nextInt();

        while (year != 0) {
            System.out.println(tracker.displayData(year));

            // continue prompt
            System.out.printf("%s ", prompt);
            year = input.nextInt();
        } // end loop

        input.close();

    } // end getWorldSeriesStats

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
        System.out.println("Program: Four\n\n");

    } // End of the developerInfo method

} // end Program4
