package com.scoreboard.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Scoreboard {
    private List<FootballMatch> matches;

    public Scoreboard() {
        this.matches = new ArrayList<>();
    }

    public void startMatch(String homeTeam, String awayTeam) {
        matches.add(new FootballMatch(homeTeam, awayTeam));
    }

    public List<FootballMatch> getMatches() {
        return matches;
    }

    public void updateScore(int matchIndex, int homeScore, int awayScore) {
        try {
            FootballMatch match = matches.get(matchIndex);
            match.updateScore(homeScore, awayScore);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Invalid match index: " + e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("Match at the given index does not exist: " + e.getMessage());
        }
    }

    public void removeMatch(int matchIndex) {
        try {
            matches.remove(matchIndex);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Invalid match index: " + e.getMessage());
        }
    }

    public List<FootballMatch> getSummary() {
        List<FootballMatch> sortedMatches = new ArrayList<>(matches);
        sortedMatches.sort(Comparator.comparing(FootballMatch::getTotalScore).reversed());
        return sortedMatches;
    }
}