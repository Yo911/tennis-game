package com.exercice.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @Test
    void should_get_score() {
        Player playerA = Player.builder()
                .name("A")
                .score(15)
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
                .score(30)
                .build();

        Player playerB = Player.builder()
                .name("B")
                .score(30)
                .build();

        String score = playerA.getScore(playerB);

        assertThat(score).isEqualTo("DEUCE");
    }

    @Test
    void should_get_score_deuce() {
        Player playerA = Player.builder()
                .name("A")
                .score(40)
                .build();

        Player playerB = Player.builder()
                .name("B")
                .score(30)
                .build();

        String score = playerA.getScore(playerB);

        assertThat(score).isEqualTo("Avantage");
    }

}