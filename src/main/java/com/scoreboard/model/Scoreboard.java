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
        FootballMatch match = matches.get(matchIndex);
        match.updateScore(homeScore, awayScore);
    }

    public void removeMatch(int matchIndex) {
        matches.remove(matchIndex);
    }

    public List<FootballMatch> getSummary() {
        List<FootballMatch> sortedMatches = new ArrayList<>(matches);
        Collections.sort(sortedMatches, Comparator.comparing(FootballMatch::getTotalScore).reversed());
        return sortedMatches;
    }
}