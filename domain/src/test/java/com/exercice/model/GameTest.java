package com.exercice.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void should_get_score() {
        Player playerA = Player.builder()
                .name("A")
                .scoreIndex(1)
                .build();

        Player playerB = Player.builder()
                .name("B")
                .build();

        Game game = Game.builder()
                .p1(playerA)
                .p2(playerB)
                .build();

        String score = game.getScore();

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

        Game game = Game.builder()
                .p1(playerA)
                .p2(playerB)
                .build();

        String score = game.getScore();

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

        Game game = Game.builder()
                .p1(playerA)
                .p2(playerB)
                .build();

        String score = game.getScore();

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

        Game game = Game.builder()
                .p1(playerA)
                .p2(playerB)
                .build();

        String score1 = game.getScore();
        playerB.incrementScore();
        String score2 = game.getScore();


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

        Game game = Game.builder()
                .p1(playerA)
                .p2(playerB)
                .build();

        String score1 = game.getScore(); // avantage A

        playerB.incrementScore();
        String score2 = game.getScore(); // DEUCE

        playerB.incrementScore();
        String score3 = game.getScore(); // AVANTAGE B

        playerA.incrementScore();
        String score4 = game.getScore(); // DEUCE

        playerB.incrementScore();
        String score5 = game.getScore(); // AVANTAGE

        playerB.incrementScore();
        String score6 = game.getScore(); // WIN


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

        Game game = Game.builder()
                .p1(playerA)
                .p2(playerB)
                .build();

        String score1 = game.getScore();
        playerA.incrementScore();
        String score2 = game.getScore();


        assertThat(score1).isEqualTo("Player A AVANTAGE");
        assertThat(score2).isEqualTo("Player A WIN !");
    }

}