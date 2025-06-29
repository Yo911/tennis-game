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

    Player p1;
    Player p2;

    public String getScore() {
        boolean aboutToHaveAWinner = p1.getScoreIndex() >= 2 && p2.getScoreIndex() >= 2;
        Optional<String> scoreAboutToHaveAWinner = aboutToHaveAWinner ?
                getScoreAboutToHaveAWinner() :
                Optional.empty();

        return scoreAboutToHaveAWinner.orElse(
                String.format("Player %s : %s / Player %s : %s", p1.getName(), p1.getScore(), p2.getName(), p2.getScore()));
    }

    private Optional<String> getScoreAboutToHaveAWinner() {
        if (p1.getScoreIndex() == p2.getScoreIndex()) {
            return Optional.of(DEUCE);
        }

        if (p1.hasAdventage(p2.getScoreIndex())) {
            return Optional.of(p1.adventage());
        }

        if (p2.hasAdventage(p1.getScoreIndex())) {
            return Optional.of(p2.adventage());
        }

        if (p1.hasWin(p2.getScoreIndex())) {
            return Optional.of(p1.win());
        }

        if (p2.hasWin(p1.getScoreIndex())) {
            return Optional.of(p2.win());
        }

        return Optional.empty();
    }

    public void setPoint(String name) {
        if (p1.getName().equals(name))
            p1.incrementScore();
        if (p2.getName().equals(name))
            p2.incrementScore();
    }

}
