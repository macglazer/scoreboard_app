package com.scoreboard;

import com.scoreboard.model.FootballMatch;
import com.scoreboard.model.Scoreboard;

import java.util.List;
import java.util.logging.Logger;

/**
 * Hello Scoreboard!
 */
public class App {
    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        Scoreboard scoreboard = new Scoreboard();

        scoreboard.startMatch("Mexico", "Canada");
        scoreboard.updateScore(0, 0, 5);

        scoreboard.startMatch("Spain", "Brazil");
        scoreboard.updateScore(1, 10, 2);

        scoreboard.startMatch("Germany", "France");
        scoreboard.updateScore(2, 2, 2);

        scoreboard.startMatch("Uruguay", "Italy");
        scoreboard.updateScore(3, 6, 6);

        scoreboard.startMatch("Argentina", "Australia");
        scoreboard.updateScore(4, 3, 1);

        scoreboard.removeMatch(0); // Usunięcie pierwszego meczu

        List<FootballMatch> summary = scoreboard.getSummary();
        for (FootballMatch match : summary) {
            logger.info(match.toString());
        }
    }
}
