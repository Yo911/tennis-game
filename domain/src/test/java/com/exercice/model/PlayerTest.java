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