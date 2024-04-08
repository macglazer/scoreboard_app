package com.scoreboard.model;

import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    void testUpdateScoreInvalidIndex() {
        // given
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.startMatch("Home", "Away");

        // when
        Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            scoreboard.updateScore(1, 2, 1);
        });

        // then
        assertNotNull(exception);
    }

    @Test
    void testRemoveMatchInvalidIndex() {
        // given
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.startMatch("Home", "Away");

        // when
        Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            scoreboard.removeMatch(1);
        });

        // then
        assertNotNull(exception);
    }

    @Test
    void testGetSummaryEmptyMatches() {
        // given
        Scoreboard scoreboard = new Scoreboard();

        // when
        List<FootballMatch> summary = scoreboard.getSummary();

        // then
        assertTrue(summary.isEmpty());
    }

    @Test
    void testGetTotalScoreUninitializedMatch() {
        // given
        FootballMatch match = new FootballMatch("Home", "Away");

        // then
        assertEquals(0, match.getTotalScore());
    }
}