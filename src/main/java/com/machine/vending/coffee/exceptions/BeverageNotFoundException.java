package com.machine.vending.coffee.exceptions;

public class BeverageNotFoundException extends Throwable {
    public BeverageNotFoundException(String s) {
        super(s);
    }
}
