package Program4;

import java.util.Scanner;

public class Program4 {

    public static void main (String[] args) {
        Program4 test = new Program4();

        // read data from file to WorldSeriesTracker
        WorldSeriesTracker tracker = new WorldSeriesTracker("program4.txt");

        // get data from WorldSeriesTracker until user enters 0
        test.getWorldSeriesStats(tracker);

    } // end main

    /**
     * takes user input and displays World Series statistics from given WorldSeriesTracker object
     * @param tracker WorldSeriesTracker to get data from
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

} // end Program4
