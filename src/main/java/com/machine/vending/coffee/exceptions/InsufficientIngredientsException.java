package com.machine.vending.coffee.exceptions;

public class InsufficientIngredientsException extends Exception {

    public InsufficientIngredientsException(String message) {
        super(message);
    }
}
