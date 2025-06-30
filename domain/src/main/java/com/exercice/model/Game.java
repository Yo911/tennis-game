package com.exercice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Game {
    public static final String DEUCE = "DEUCE";
    public static final String ADVENTAGE = "AVANTAGE";

    Player playerOne;
    Player playerTwo;

    public String getScore() {
        boolean aboutToHaveAWinner = playerOne.getScoreIndex() >= 2 && playerTwo.getScoreIndex() >= 2;
        Optional<String> scoreAboutToHaveAWinner = aboutToHaveAWinner ?
                getScoreAboutToHaveAWinner() :
                Optional.empty();

        return scoreAboutToHaveAWinner.orElse(
                String.format("Player %s : %s / Player %s : %s", playerOne.getName(), playerOne.getScore(), playerTwo.getName(), playerTwo.getScore()));
    }

    private Optional<String> getScoreAboutToHaveAWinner() {
        if (playerOne.getScoreIndex() == playerTwo.getScoreIndex()) {
            return Optional.of(DEUCE);
        }

        if (playerOne.hasAdventage(playerTwo.getScoreIndex())) {
            return Optional.of(playerOne.adventage());
        }

        if (playerTwo.hasAdventage(playerOne.getScoreIndex())) {
            return Optional.of(playerTwo.adventage());
        }

        if (playerOne.hasWin(playerTwo.getScoreIndex())) {
            return Optional.of(playerOne.win());
        }

        if (playerTwo.hasWin(playerOne.getScoreIndex())) {
            return Optional.of(playerTwo.win());
        }

        return Optional.empty();
    }

    public void setPoint(String name) {
        if (playerOne.getName().equals(name))
            playerOne.incrementScore();
        if (playerTwo.getName().equals(name))
            playerTwo.incrementScore();
    }

}
