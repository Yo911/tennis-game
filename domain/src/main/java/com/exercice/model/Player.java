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
        return "";
    }
}
