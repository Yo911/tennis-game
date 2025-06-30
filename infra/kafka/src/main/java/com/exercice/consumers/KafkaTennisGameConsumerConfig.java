package com.exercice.consumers;

import com.exercice.ports.api.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class KafkaTennisGameConsumerConfig {

    @Autowired
    public IGameService gameService;

    @Bean
    public Consumer<String> fullTennisGame() {
        return event -> gameService.executeFullGame(event);
    }

}
