package com.machine.vending.coffee.models;

import lombok.Setter;

@Setter
public class CoffeePowder extends Ingredient {

    public CoffeePowder() {
        super(IngredientMetadata.COFFEE_POWDER);
    }

    public CoffeePowder(double quantity) {
        super(IngredientMetadata.COFFEE_POWDER, quantity);
    }
}
