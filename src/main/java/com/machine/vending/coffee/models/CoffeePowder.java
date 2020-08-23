package com.machine.vending.coffee.models;

import lombok.Getter;

@Getter
public class CoffeePowder extends Ingredient {

    public CoffeePowder(double quantity) {
        super(IngredientMetadata.COFFEE_POWDER, quantity);
    }
}
