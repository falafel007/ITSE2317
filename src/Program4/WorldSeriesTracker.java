package Program4;

import java.util.HashMap;
import java.util.Map;

public class WorldSeriesTracker {

    private Map<Integer, String> yearlyWinner = new HashMap<>();
    private Map<String, Integer> teamWins = new HashMap<>();

    /**
     * counts the team wins in TeamWins HashMap
     *
     * @param team winning team's name
     *
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
     *
     * @param year World Series was played
     * @param team winning team's name
     */
    public void addYearlyWinner(int year, String team) {
        // no winners in 1904 or 1994
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
