package Program4;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Program4 {


    public static void main (String[] args) {

        readFile();

        // get data

    } // end main


    private static void readFile() {

        try(Scanner input = new Scanner(Paths.get("Program4.txt"))) {

            while (input.hasNext()) {
                String currentTeam = input.nextLine();

                // set TeamWins(currentTeam);
                // set yearlyWinner(currentTeam);
            }
        }

        catch (IOException | NoSuchElementException | IllegalStateException e) {
            e.printStackTrace();
        }

    } // end readFile

    private void getWorldSeriesInfo () {

    }


}
