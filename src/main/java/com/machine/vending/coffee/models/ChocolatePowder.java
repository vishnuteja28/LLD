package com.machine.vending.coffee.models;

import lombok.Getter;

@Getter
public class ChocolatePowder extends Ingredient {

    public ChocolatePowder(double quantity) {
        super(IngredientMetadata.CHOCOLATE_POWDER, quantity);
    }
}
