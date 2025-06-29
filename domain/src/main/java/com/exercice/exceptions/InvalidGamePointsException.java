package com.exercice.exceptions;

public class InvalidGamePointsException extends RuntimeException {
    public InvalidGamePointsException() {
        super("Invalid game points entered, you should have just two letters exemple 'AABBABAA'");
    }
}
