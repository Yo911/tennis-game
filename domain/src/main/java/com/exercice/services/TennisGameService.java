package com.exercice.services;

import com.exercice.model.Game;
import com.exercice.model.Player;
import com.exercice.ports.api.IGameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Slf4j
@Service
public class TennisGameService implements IGameService {

    @Override
    public String executeFullGame(String gamePoints) throws Exception {
        Character[] players = gamePoints.chars().mapToObj(c -> (char) c).collect(Collectors.toSet()).toArray(Character[]::new);
        if (players.length != 2) {
            throw new Exception("");
        }

        Game game = Game.builder()
                .p1(Player.builder().name(players[0].toString()).build())
                .p2(Player.builder().name(players[1].toString()).build())
                .build();

        gamePoints.chars().mapToObj(c -> (char) c).forEach(point -> {
            game.setPoint(String.valueOf(point));
            log.info(game.getScore());
        });

        return game.getScore();
    }
}
