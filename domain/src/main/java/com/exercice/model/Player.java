package com.exercice.model;

import lombok.*;

import java.util.Optional;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Player {
    public static final String DEUCE = "DEUCE";
    public static final String ADVENTAGE = "AVANTAGE";

    String name;
    int scoreIndex;

    public String getScore() {
        return switch (scoreIndex) {
            case 0 -> "0";
            case 1 -> "15";
            case 2 -> "30";
            case 3 -> "40";
            default -> "";
        };
    }

    public void incrementScore() {
        scoreIndex++;
    }

    public String getScore(Player p2) {
        boolean aboutToHaveAWinner = scoreIndex >= 2 && p2.scoreIndex >= 2;
        Optional<String> scoreAboutToHaveAWinner = aboutToHaveAWinner ?
                getScoreAboutToHaveAWinner(p2) :
                Optional.empty();

        return scoreAboutToHaveAWinner.orElse(
                String.format("Player %s : %s / Player %s : %s", name, getScore(), p2.name, p2.getScore()));
    }

    private void deuceScore(Player p2) {
        this.scoreIndex = 2;
        p2.scoreIndex = 2;
    }

    private Optional<String> getScoreAboutToHaveAWinner(Player p2) {
        if (scoreIndex == p2.scoreIndex) {
            return Optional.of(DEUCE);
        }

        if (hasAdventage(p2)) {
            return Optional.of(adventage());
        }

        if (p2.hasAdventage(this)) {
            return Optional.of(p2.adventage());
        }

        if (hasWin(p2)) {
            return Optional.of(win());
        }

        if (p2.hasWin(this)) {
            return Optional.of(p2.win());
        }

        return Optional.empty();
    }

    private boolean hasAdventage(Player p2) {
        return scoreIndex > p2.getScoreIndex() && Math.abs(scoreIndex - p2.getScoreIndex()) == 1;
    }

    private boolean hasWin(Player p2) {
        return scoreIndex > p2.getScoreIndex() && Math.abs(scoreIndex - p2.getScoreIndex()) == 2;
    }

    public String adventage() {
        return String.format("Player %s %s", name, ADVENTAGE);
    }

    public String win() {
        return String.format("Player %s WIN !", name);
    }
}
