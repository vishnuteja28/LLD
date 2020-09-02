package com.machine.vending.coffee.models;

public class Sugar extends Ingredient {

    public Sugar() {
        super(IngredientMetadata.SUGAR);
    }

    public Sugar(double quantity) {
        super(IngredientMetadata.SUGAR, quantity);
    }
}
