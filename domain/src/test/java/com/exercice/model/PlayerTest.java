package com.exercice.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @Test
    void should_get_score() {
        Player playerA = Player.builder()
                .name("A")
                .scoreIndex(1)
                .build();

        Player playerB = Player.builder()
                .name("B")
                .build();

        String score = playerA.getScore(playerB);

        assertThat(score).isEqualTo("Player A : 15 / Player B : 0");
    }

    @Test
    void should_get_score_deuce() {
        Player playerA = Player.builder()
                .name("A")
                .scoreIndex(2)
                .build();

        Player playerB = Player.builder()
                .name("B")
                .scoreIndex(2)
                .build();

        String score = playerA.getScore(playerB);

        assertThat(score).isEqualTo("DEUCE");
    }

    @Test
    void should_get_score_adventage() {
        Player playerA = Player.builder()
                .name("A")
                .scoreIndex(3)
                .build();

        Player playerB = Player.builder()
                .name("B")
                .scoreIndex(2)
                .build();

        String score = playerA.getScore(playerB);

        assertThat(score).isEqualTo("Player A AVANTAGE");
    }

    @Test
    void should_get_score_adventage_then_deuce() {
        Player playerA = Player.builder()
                .name("A")
                .scoreIndex(3)
                .build();

        Player playerB = Player.builder()
                .name("B")
                .scoreIndex(2)
                .build();

        String score1 = playerA.getScore(playerB);
        playerB.setScoreIndex(3);
        String score2 = playerA.getScore(playerB);


        assertThat(score1).isEqualTo("Player A AVANTAGE");
        assertThat(score2).isEqualTo("DEUCE");
    }

    @Test
    void should_get_score_adventage_then_deuce_then_adventage_then_deuce_then_adventage_then_win() {
        Player playerA = Player.builder()
                .name("A")
                .scoreIndex(3)
                .build();

        Player playerB = Player.builder()
                .name("B")
                .scoreIndex(2)
                .build();

        String score1 = playerA.getScore(playerB); // avantage A

        playerB.setScoreIndex(3);
        String score2 = playerA.getScore(playerB); // DEUCE

        playerB.setScoreIndex(4);
        String score3 = playerA.getScore(playerB); // AVANTAGE B

        playerA.setScoreIndex(4);
        String score4 = playerA.getScore(playerB); // DEUCE

        playerB.setScoreIndex(5);
        String score5 = playerA.getScore(playerB); // AVANTAGE

        playerB.setScoreIndex(6);
        String score6 = playerA.getScore(playerB); // WIN


        assertThat(score1).isEqualTo("Player A AVANTAGE");
        assertThat(score2).isEqualTo("DEUCE");
        assertThat(score3).isEqualTo("Player B AVANTAGE");
        assertThat(score4).isEqualTo("DEUCE");
        assertThat(score5).isEqualTo("Player B AVANTAGE");
        assertThat(score6).isEqualTo("Player B WIN !");
    }

    @Test
    void should_get_score_adventage_then_win() {
        Player playerA = Player.builder()
                .name("A")
                .scoreIndex(3)
                .build();

        Player playerB = Player.builder()
                .name("B")
                .scoreIndex(2)
                .build();

        String score1 = playerA.getScore(playerB);
        playerA.setScoreIndex(4);
        String score2 = playerA.getScore(playerB);


        assertThat(score1).isEqualTo("Player A AVANTAGE");
        assertThat(score2).isEqualTo("Player A WIN !");
    }

}