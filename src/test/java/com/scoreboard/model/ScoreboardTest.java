package com.scoreboard.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ScoreboardTest {
    @Test
    void testStartMatch() {
        // given
        Scoreboard scoreboard = new Scoreboard();

        // when
        scoreboard.startMatch("Home", "Away");

        // then
        assertEquals(1, scoreboard.getMatches().size());
    }

    @Test
    void testUpdateScore() {
        // given
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.startMatch("Home", "Away");

        // when
        scoreboard.updateScore(0, 2, 1);

        // then
        assertEquals(2, scoreboard.getMatches().get(0).getHomeScore());
        assertEquals(1, scoreboard.getMatches().get(0).getAwayScore());
    }

    @Test
    void testRemoveMatch() {
        // given
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.startMatch("Home", "Away");

        // when
        scoreboard.removeMatch(0);

        // then
        assertEquals(0, scoreboard.getMatches().size());
    }

}