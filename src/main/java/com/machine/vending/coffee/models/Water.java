package com.machine.vending.coffee.models;

public class Water extends Ingredient {

    public Water() {
        super(IngredientMetadata.WATER);
    }

    public Water(double quantity) {
        super(IngredientMetadata.WATER, quantity);
    }
}
