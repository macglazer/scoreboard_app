package com.scoreboard.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Scoreboard {
    private List<FootballMatch> matches;

    public Scoreboard() {
        this.matches = new ArrayList<>();
    }

    public void startMatch(String homeTeam, String awayTeam) {
    }

    public void updateScore(int matchIndex, int homeScore, int awayScore) {

    }

    public List<FootballMatch> getMatches() {
        return matches;
    }

    public void removeMatch(int matchIndex) {
        matches.remove(matchIndex);
    }

    public List<FootballMatch> getSummary() {


        return Collections.emptyList();
    }
}