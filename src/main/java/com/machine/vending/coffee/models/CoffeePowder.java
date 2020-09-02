package com.machine.vending.coffee.models;

public class CoffeePowder extends Ingredient {

    public CoffeePowder() {
        super(IngredientMetadata.COFFEE_POWDER);
    }

    public CoffeePowder(double quantity) {
        super(IngredientMetadata.COFFEE_POWDER, quantity);
    }
}
