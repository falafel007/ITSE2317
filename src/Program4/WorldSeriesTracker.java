package Program4;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class WorldSeriesTracker {

    private Map<Integer, String> yearlyWinner = new HashMap<>();
    private Map<String, Integer> teamWins = new HashMap<>();

    /**
     * Constructor creates WorldSeriesTracker with file of winning teams
     * @param filename of file that lists World Series winners
     */
    WorldSeriesTracker(String filename) {

        try(Scanner input = new Scanner(Paths.get(filename))) {

            int currentYear = 1903;

            while (input.hasNext()) {

                String currentTeam = input.nextLine().strip();

                // World Series was not played in 1904 or 1994; there were no winners
                if (currentYear == 1904 || currentYear == 1994) {
                    currentYear++;
                }

                this.addTeamWins(currentTeam);
                this.addYearlyWinner(currentYear, currentTeam);

                currentYear++;
            } // end loop

        } // end try with resources

        catch (IOException | NoSuchElementException | IllegalStateException e) {
            e.printStackTrace();
        } // end exception handling

    } // end constructor

    /**
     * counts the team wins in TeamWins HashMap
     * @param team winning team's name
     */
    public void addTeamWins(String team) {

        if (this.teamWins.containsKey(team)) {
            int addWin = this.teamWins.get(team) + 1;
            this.teamWins.put(team, addWin);
        }

        else {
            this.teamWins.put(team, 1);
        }
    } // end setTeamWins

    /**
     * adds year and winner to YearlyWinner HashMap
     * @param year World Series was played
     * @param team winning team's name
     */
    public void addYearlyWinner(int year, String team) {
        this.yearlyWinner.put(year, team);
    } // end addYearlyWinner

    public String displayData(int year) {
        String output;

        if (this.yearlyWinner.containsKey(year)) {
            String winner = this.yearlyWinner.get(year);
            int wins = this.teamWins.get(winner);

            String grammar = "time";
            if (wins > 1) grammar = "times";

            output = String.format("The World Series was won by the %s in %d. The %s have won the World Series %d %s.%n",
                    winner, year, winner, wins, grammar);
        }

        else {
            output = String.format("The world series was not played in %d.%n", year);
        }

        return output;
    } // end displayData

} // end WorldSeriesTracker
