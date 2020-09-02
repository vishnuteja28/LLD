package com.machine.vending.coffee.exceptions;

public class BeverageNotFoundException extends MenuItemNotFoundException {
    public BeverageNotFoundException(String s) {
        super(s);
    }
}
