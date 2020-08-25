package com.machine.vending.coffee.models;

import lombok.Setter;

@Setter
public class Cream extends Ingredient {

    public Cream() {
        super(IngredientMetadata.CREAM);
    }

    public Cream(double quantity) {
        super(IngredientMetadata.CREAM, quantity);
    }
}
