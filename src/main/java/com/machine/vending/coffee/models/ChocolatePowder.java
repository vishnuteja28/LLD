package com.machine.vending.coffee.models;

public class ChocolatePowder extends Ingredient {

    public ChocolatePowder() {
        super(IngredientMetadata.CHOCOLATE_POWDER);
    }

    public ChocolatePowder(double quantity) {
        super(IngredientMetadata.CHOCOLATE_POWDER, quantity);
    }
}
