package Program4;

import java.util.HashMap;
import java.util.Map;

public class WorldSeriesTracker {

    private Map<Integer, String> yearlyWinner = new HashMap<>();
    private Map<String, Integer> teamWins = new HashMap<>();

    /**
     * counts the team wins in TeamWins HashMap
     *
     * @param team
     *
     */
    private void setTeamWins(String team) {

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
     * @param team
     */
    private void setYearlyWinner(String team) {
        // no winners in 1904 or 1994

    } // end setYearlyWinner

}
