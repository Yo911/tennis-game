package com.exercice.ports.api;

import com.exercice.exceptions.InvalidGamePointsException;

import java.util.List;

public interface IGameService {
    List<String> executeFullGame(String gamePoints) throws InvalidGamePointsException;
}
