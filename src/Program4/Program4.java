package Program4;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Program4 {

    public static void main (String[] args) {
        Program4 test = new Program4();
        WorldSeriesTracker tracker = new WorldSeriesTracker();

        // read data from file to WorldSeriesTracker
        test.readFileToWorldSeriesTracker(tracker);

        // get data from WorldSeriesTracker until user enters 0
        test.getWorldSeriesStats(tracker);

    } // end main

    /**
     * reads a file containing a list of teams and records the data in a WorldSeriesTracker object
     * @param tracker WorldSeriesTracker to be populated
     */
    private void readFileToWorldSeriesTracker(WorldSeriesTracker tracker) {

        try(Scanner input = new Scanner(Paths.get("Program4.txt"))) {

            int currentYear = 1903;

            while (input.hasNext()) {

                String currentTeam = input.nextLine().strip();

                if (currentYear == 1904 || currentYear == 1994) {
                    currentYear++;
                }

                tracker.addTeamWins(currentTeam);
                tracker.addYearlyWinner(currentYear, currentTeam);

                currentYear++;
            } // end loop

        } // end try with resources

        catch (IOException | NoSuchElementException | IllegalStateException e) {
            e.printStackTrace();
        } // end exception handling

    } // end readFile

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
