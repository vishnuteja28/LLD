package com.machine.vending.coffee.models;

public class TeaPowder extends Ingredient {

    public TeaPowder() {
        super(IngredientMetadata.TEA_POWDER);
    }

    public TeaPowder(double quantity) {
        super(IngredientMetadata.TEA_POWDER, quantity);
    }
}
