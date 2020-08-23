package com.machine.vending.coffee.models;

import lombok.Getter;

@Getter
public class Water extends Ingredient {

    public Water(double quantity) {
        super(IngredientMetadata.WATER, quantity);
    }
}
