package com.machine.vending.coffee.models;

import lombok.Setter;

@Setter
public class ChocolatePowder extends Ingredient {

    public ChocolatePowder() {
        super(IngredientMetadata.CHOCOLATE_POWDER);
    }

    public ChocolatePowder(double quantity) {
        super(IngredientMetadata.CHOCOLATE_POWDER, quantity);
    }
}
