package com.exercice.services;

import com.exercice.exceptions.InvalidGamePointsException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TennisGameServiceTest {

    @Test
    void should_have_tennis_game() {
        TennisGameService service = new TennisGameService();

        String result = service.executeFullGame("ABABAA");

        assertThat(result).isEqualTo("Player A WIN !");
    }

    @Test
    void should_have_tennis_game_with_random_letter() {
        TennisGameService service = new TennisGameService();

        String result = service.executeFullGame("JSJSJJ");

        assertThat(result).isEqualTo("Player J WIN !");
    }

    @Test
    void should_have_unfinished_tennis_game() {
        TennisGameService service = new TennisGameService();

        String result = service.executeFullGame("WNN");

        assertThat(result).isEqualTo("Player W : 15 / Player N : 30");
    }

    @Test
    void should_throw_exception_when_have_bad_entry() {
        TennisGameService service = new TennisGameService();

        assertThrows(InvalidGamePointsException.class, () -> service.executeFullGame("ABAZBAA"));
    }

}