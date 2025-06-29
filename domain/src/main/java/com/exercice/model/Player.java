package com.exercice.model;

import lombok.*;

import java.util.Optional;

import static com.exercice.model.Game.ADVENTAGE;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Player {

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

    public boolean hasAdventage(int concurrentScore) {
        return scoreIndex >= 3 && scoreIndex > concurrentScore && Math.abs(scoreIndex - concurrentScore) == 1;
    }

    public boolean hasWin(int concurrentScore) {
        return scoreIndex >= 4 && scoreIndex > concurrentScore && Math.abs(scoreIndex - concurrentScore) >= 2;
    }

    public String adventage() {
        return String.format("Player %s %s", name, ADVENTAGE);
    }

    public String win() {
        return String.format("Player %s WIN !", name);
    }
}
