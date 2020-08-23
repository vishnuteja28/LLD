package com.machine.vending.coffee.models;

import lombok.Getter;

@Getter
public class TeaPowder extends Ingredient {

    public TeaPowder(double quantity) {
        super(IngredientMetadata.TEA_POWDER, quantity);
    }
}
