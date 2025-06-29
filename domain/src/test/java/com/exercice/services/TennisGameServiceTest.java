package com.exercice.services;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TennisGameServiceTest {

    @Test
    void should_have_tennis_game() throws Exception {
        TennisGameService service = new TennisGameService();

        String result = service.executeFullGame("ABABAA");

        assertThat(result).isEqualTo("Player A WIN !");
    }

}