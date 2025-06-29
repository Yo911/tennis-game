package com.exercice.services;

import com.exercice.exceptions.InvalidGamePointsException;
import com.exercice.model.Game;
import com.exercice.model.Player;
import com.exercice.ports.api.IGameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TennisGameService implements IGameService {

    @Override
    public List<String> executeFullGame(String gamePoints) throws InvalidGamePointsException {
        Game game = createGameFromPoints(gamePoints);

        return gamePoints.chars().mapToObj(c -> (char) c).map(point -> {
            game.setPoint(String.valueOf(point));
            String score = game.getScore();
            log.info(score);
            return score;
        }).toList();
    }

    private static Game createGameFromPoints(String gamePoints) throws InvalidGamePointsException {
        Character[] players = gamePoints.chars().mapToObj(c -> (char) c).collect(Collectors.toSet()).toArray(Character[]::new);
        checkValidPoints(players);

        return Game.builder()
                .p1(Player.builder().name(players[0].toString()).build())
                .p2(Player.builder().name(players[1].toString()).build())
                .build();
    }

    private static void checkValidPoints(Character[] players) throws InvalidGamePointsException {
        if (players.length != 2) {
            throw new InvalidGamePointsException();
        }
    }
}
