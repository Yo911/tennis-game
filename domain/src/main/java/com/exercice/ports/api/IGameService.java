package com.exercice.ports.api;

import com.exercice.exceptions.InvalidGamePointsException;

public interface IGameService {
    String executeFullGame(String gamePoints) throws InvalidGamePointsException;
}
