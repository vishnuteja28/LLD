package com.machine.vending.coffee.models;

public class Cream extends Ingredient {

    public Cream() {
        super(IngredientMetadata.CREAM);
    }

    public Cream(double quantity) {
        super(IngredientMetadata.CREAM, quantity);
    }
}
