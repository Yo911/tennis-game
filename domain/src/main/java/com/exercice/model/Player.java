package com.exercice.model;

import lombok.*;

@Builder
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Player {
    String name;
    int score;

    public String getScore(Player p2) {
        if (score == 30 && p2.score == 30) {
            return "DEUCE";
        }
        return String.format("Player %s : %d / Player %s : %d", name, score, p2.name, p2.score);
    }
}
